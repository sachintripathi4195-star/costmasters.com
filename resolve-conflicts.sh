#!/usr/bin/env bash
set -euo pipefail

# ==============================
# Git Conflict Resolver Script
# ==============================

MAIN_BRANCH="main"

usage() {
  echo "Usage: $0 <branch-name>"
  echo "Example: $0 FEATURES-RJ-Y"
}

# 1) Args check
if [ $# -ne 1 ]; then
  usage
  exit 1
fi
BRANCH="$1"

# 2) Ensure we are inside a git repo and move to repo root
ROOT="$(git rev-parse --show-toplevel 2>/dev/null || true)"
if [ -z "$ROOT" ]; then
  echo "❌ Not a git repository. Open the project root and re-run."
  exit 1
fi
cd "$ROOT"

# 3) Switch to the target branch if not already
CURRENT="$(git rev-parse --abbrev-ref HEAD)"
if [ "$CURRENT" != "$BRANCH" ]; then
  echo "👉 Switching to branch: $BRANCH"
  git checkout "$BRANCH"
else
  echo "👉 Already on branch: $BRANCH"
fi

# 4) Fetch and merge main (no auto-commit so we can resolve before committing)
echo "👉 Fetching from origin and merging ${MAIN_BRANCH} into ${BRANCH} (no auto-commit)..."
git fetch origin
# Keep merge in-progress if there are changes; do not exit on non-zero from merge
set +e
git merge --no-commit origin/"$MAIN_BRANCH"
MERGE_STATUS=$?
set -e

if [ $MERGE_STATUS -eq 0 ]; then
  echo "ℹ️  Merge produced no immediate conflicts."
else
  echo "ℹ️  Merge indicates changes/conflicts to handle."
fi

# 5) Untrack generated artifacts from the index (safe if they do not exist)
echo "👉 Removing generated artifacts from index (if any)..."
git rm -r --cached --ignore-unmatch target logs test-output || true

# 6) Ensure .gitignore entries exist
echo "👉 Ensuring .gitignore entries..."
touch .gitignore
grep -qxF "target/"      .gitignore || echo "target/"      >> .gitignore
grep -qxF "logs/"        .gitignore || echo "logs/"        >> .gitignore
grep -qxF "test-output/" .gitignore || echo "test-output/" >> .gitignore
grep -qxF "*.class"      .gitignore || echo "*.class"      >> .gitignore
git add .gitignore || true

# 7) If there are merge conflicts left in tracked files, stop and ask for manual resolve
if git ls-files -u | grep -q .; then
  echo "⚠️  Merge conflicts are still present."
  echo "   Open each conflicted file, resolve the <<<<<<< ======= >>>>>>> hunks,"
  echo "   then run:  git add <file>   (for all resolved files)"
  echo "               git commit       (to finalize the merge)"
  echo "   After that, push with: git push origin \"$BRANCH\""
  exit 2
fi

# 8) Finalize the merge if there is anything to commit
if ! git diff --cached --quiet || ! git diff --quiet; then
  echo "👉 Committing merge resolution and cleanup..."
  git commit -m "Merge origin/${MAIN_BRANCH}; remove generated artifacts; update .gitignore"
else
  echo "ℹ️  Nothing to commit (already up to date)."
fi

# 9) Push branch
echo "👉 Pushing branch to remote..."
git push origin "$BRANCH"

# 10) Sanity check: confirm no generated folders are tracked
echo "👉 Verifying no generated files are tracked..."
if git ls-files | grep -E '^(target/|logs/|test-output/)' >/dev/null 2>&1; then
  echo "❌ Some generated files are still tracked. Remove them with:"
  echo "   git rm -r --cached target logs test-output"
  echo "   git commit -m \"Stop tracking generated artifacts\" && git push"
else
  echo "✅ Done. Open your PR on GitHub; it should be mergeable without artifact conflicts."
fi
