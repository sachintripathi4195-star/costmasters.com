package com.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DataValidation;
import org.apache.poi.ss.usermodel.DataValidationConstraint;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class ExcelUtil {
	private static Workbook workbook;
	private static Sheet sheet;
     static WebDriver driver;
	public static void setExcelFile(String filePath, String sheetName) throws IOException {
		FileInputStream file = new FileInputStream(new File(filePath));
		workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheet(sheetName);
	}
	
	
	public static String getDataCell(String filePath, int sheetIndex, int rowNum, int colNum) {
	    String cellValue = "";
	    try (FileInputStream fis = new FileInputStream(filePath);
	         Workbook workbook = WorkbookFactory.create(fis)) {

	        Sheet sheet = workbook.getSheetAt(sheetIndex);
	        Row row = sheet.getRow(rowNum);
	        if (row == null) {
	            LoggerUtil.error("Row " + rowNum + " not found in sheet " + sheetIndex);
	            return "";
	        }

	        Cell cell = row.getCell(colNum);
	        if (cell == null) {
	            LoggerUtil.error("Column " + colNum + " not found in row " + rowNum);
	            return "";
	        }

	        switch (cell.getCellType()) {
	            case STRING:
	                cellValue = cell.getStringCellValue().trim();
	                break;
	            case NUMERIC:
	                if (DateUtil.isCellDateFormatted(cell)) {
	                    cellValue = new SimpleDateFormat("dd-MM-yyyy").format(cell.getDateCellValue());
	                } else {
	                    cellValue = String.valueOf(cell.getNumericCellValue());
	                }
	                break;
	            case BOOLEAN:
	                cellValue = String.valueOf(cell.getBooleanCellValue());
	                break;
	            case FORMULA:
	                FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
	                CellValue evaluatedValue = evaluator.evaluate(cell);
	                switch (evaluatedValue.getCellType()) {
	                    case STRING:
	                        cellValue = evaluatedValue.getStringValue().trim();
	                        break;
	                    case NUMERIC:
	                        cellValue = String.valueOf(evaluatedValue.getNumberValue());
	                        break;
	                    case BOOLEAN:
	                        cellValue = String.valueOf(evaluatedValue.getBooleanValue());
	                        break;
	                    default:
	                        cellValue = "";
	                }
	                break;
	            default:
	                cellValue = "";
	        }
	    } catch (Exception e) {
	        LoggerUtil.error("Error reading cell value from Excel: " + e.getMessage());
	    }
	    return cellValue;
	}

	
	
	

	public static String getCellData(int rowNum, int colNum) {
		Cell cell = sheet.getRow(rowNum).getCell(colNum);
		if (cell == null) {
			return "";
		}
		switch (cell.getCellType()) {
		case STRING:
			return cell.getStringCellValue();
		case NUMERIC:
			if(DateUtil.isCellDateFormatted(cell)) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
				return dateFormat.format(cell.getDateCellValue());
			}
			return String.valueOf((int) cell.getNumericCellValue());
		case BOOLEAN:
			return String.valueOf(cell.getBooleanCellValue());
		case FORMULA:
			return cell.getCellFormula();
		default:
			return "";
		}

	}

	public static int getRowCount() {
		return sheet.getLastRowNum();
	}

	public static int getColumnCount() {
		return sheet.getRow(0).getLastCellNum();
	}

	public static Object[][] getExcelData(String filePath, String sheetName) throws IOException {
		setExcelFile(filePath, sheetName);
		int rowCount = getRowCount();
		int colCount = getColumnCount();

		Object[][] data = new Object[rowCount][colCount];

		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				data[i - 1][j] = getCellData(i, j);
			}
		}
		return data;
	}
	
	
	
	public static List<List<String>> readExcel(String filePath) throws IOException {
	    List<List<String>> data = new ArrayList<>();
	    
	   
	    setExcelFile(filePath, sheet.getSheetName());  

	    int rowCount = getRowCount();
	    int colCount = getColumnCount();

	    for (int i = 0; i <= rowCount; i++) {
	        List<String> rowData = new ArrayList<>();
	        for (int j = 0; j < colCount; j++) {
	            rowData.add(getCellData(i, j));  
	        }
	        data.add(rowData);
	    }
	    return data;
	}
	public static List<List<String>> readEntireSheetAsListWithSafeHeaders(String filePath) throws IOException {
	    List<List<String>> data = new ArrayList<>();
	    FileInputStream file = new FileInputStream(new File(filePath));
	    Workbook workbook = new XSSFWorkbook(file);
	    Sheet sheet = workbook.getSheetAt(0);

	    // Read header
	    Row headerRow = sheet.getRow(0);
	    if (headerRow == null) throw new IllegalStateException("Header row missing in Excel.");

	    int colCount = headerRow.getLastCellNum();
	    List<String> headers = new ArrayList<>();
	    for (int j = 0; j < colCount; j++) {
	        Cell cell = headerRow.getCell(j);
	        headers.add(cell != null ? cell.toString().trim() : "Column" + (j + 1));
	    }
	    data.add(headers);

	    // Read data rows up to last physical row (with any non-empty cell)
	    int lastRow = sheet.getLastRowNum();
	    for (int i = 1; i <= lastRow; i++) {
	        Row row = sheet.getRow(i);
	        if (row == null || isRowEmpty(row)) continue;

	        List<String> rowData = new ArrayList<>();
	        for (int j = 0; j < colCount; j++) {
	            Cell cell = row.getCell(j);
	            rowData.add(cell != null ? cell.toString().trim() : "");
	        }
	        data.add(rowData);
	    }

	    workbook.close();
	    return data;
	}

	// Helper to skip completely blank rows
	private static boolean isRowEmpty(Row row) {
	    for (int c = row.getFirstCellNum(); c < row.getLastCellNum(); c++) {
	        Cell cell = row.getCell(c);
	        if (cell != null && cell.getCellType() != CellType.BLANK && !cell.toString().trim().isEmpty()) {
	            return false;
	        }
	    }
	    return true;
	}

	public static int getColumnIndexByName(List<String> headers, String columnName) {
	    return headers.indexOf(columnName.trim());
	}
	public static boolean isRowEmpty(List<String> row) {
	    return row == null || row.stream().allMatch(cell -> cell == null || cell.trim().isEmpty());
	}

	public static double parseDoubleSafe(List<String> row, String columnName, List<String> headers) {
	    int index = getColumnIndexByName(headers, columnName);
	    if (index >= 0 && index < row.size()) {
	        try {
	            return Double.parseDouble(row.get(index).trim());
	        } catch (Exception ignored) {}
	    }
	    return 0.0;
	}

	public static String getCellSafe(List<String> row, int index) {
	    return index >= 0 && index < row.size() ? row.get(index).trim() : "";
	}
	public double getCellValueWithFormula(Sheet sheet, int rowIndex, int colIndex, FormulaEvaluator evaluator) {
	    Row row = sheet.getRow(rowIndex);
	    if (row == null) return 0.0;
	    Cell cell = row.getCell(colIndex);
	    if (cell == null) return 0.0;

	    if (cell.getCellType() == CellType.FORMULA) {
	        CellValue cellValue = evaluator.evaluate(cell);
	        switch (cellValue.getCellType()) {
	            case NUMERIC:
	                return cellValue.getNumberValue();
	            case STRING:
	                try {
	                    return Double.parseDouble(cellValue.getStringValue());
	                } catch (Exception e) {
	                    return 0.0;
	                }
	            default:
	                return 0.0;
	        }
	    } else if (cell.getCellType() == CellType.NUMERIC) {
	        return cell.getNumericCellValue();
	    } else {
	        return 0.0;
	    }}

	public static String getCellValueAsString(Cell cell) {
	    if (cell == null) return "";
	    switch (cell.getCellType()) {
	        case STRING:
	            return cell.getStringCellValue().trim();
	        case NUMERIC:
	            if (DateUtil.isCellDateFormatted(cell)) {
	                return cell.getDateCellValue().toString();
	            } else {
	                return String.valueOf(cell.getNumericCellValue());
	            }
	        case BOOLEAN:
	            return String.valueOf(cell.getBooleanCellValue());
	        case FORMULA:
	            return cell.getCellFormula();
	        case BLANK:
	            return "";
	        default:
	            return "";
	    }
	}

	public static List<String> getHeaderRow(List<List<String>> data) {
	    return data != null && !data.isEmpty() ? data.get(0) : new ArrayList<>();
	}
	public static int getRowIndexByColumnValue(List<List<String>> data, String columnName, String matchValue) {
	    if (data == null || data.size() < 2) return -1;

	    List<String> header = data.get(0);
	    int colIndex = getColumnIndexByName(header, columnName);
	    if (colIndex == -1) return -1;

	    for (int i = 1; i < data.size(); i++) {
	        List<String> row = data.get(i);
	        if (row.size() > colIndex && row.get(colIndex).trim().equalsIgnoreCase(matchValue.trim())) {
	            return i;
	        }
	    }
	    return -1;
	}
	public static int getIntCell(List<String> row, List<String> headers, String columnName) {
	    int index = getColumnIndexByName(headers, columnName);
	    if (index >= 0 && index < row.size()) {
	        try {
	            return (int) Double.parseDouble(row.get(index).trim());
	        } catch (Exception ignored) {}
	    }
	    return 0;
	}
	public static void main(String[] args) {
        String filePath = "C:\\Users\\Admin\\Downloads\\yourExcelFile.xlsx";
        String sheetName = "Sheet1";

        try {
            FileInputStream fis = new FileInputStream(filePath);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet(sheetName);

            // Writing in second row, 11th column (zero-based: row 1, col 10)
            Row row = sheet.getRow(1);
            if (row == null) row = sheet.createRow(1);

            Cell cell = row.getCell(10);
            if (cell == null) cell = row.createCell(10);

            cell.setCellValue("12345");

            fis.close();

            FileOutputStream fos = new FileOutputStream(filePath);
            workbook.write(fos);
            fos.close();
            workbook.close();

            System.out.println("Successfully wrote value into Excel.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	public static void setCellData(String filePath, String sheetName, int rowNum, int colNum, String value) throws IOException {
	    File file = new File(filePath);

	    try (FileInputStream fis = new FileInputStream(file);
	         Workbook workbook = new XSSFWorkbook(fis)) {

	        Sheet sheet = workbook.getSheet(sheetName);
	        if (sheet == null) {
	            throw new IllegalArgumentException("Sheet '" + sheetName + "' not found in file " + filePath);
	        }

	        Row row = sheet.getRow(rowNum);
	        if (row == null) row = sheet.createRow(rowNum);

	        Cell cell = row.getCell(colNum);
	        if (cell == null) cell = row.createCell(colNum);

	        cell.setCellValue(value);

	        fis.close(); // Close input stream before writing

	        try (FileOutputStream fos = new FileOutputStream(file)) {
	            workbook.write(fos);
	        }
	    }
	}


	public static List<List<String>> readSheetWithHeaderRow(String filePath, int headerRowIndex) throws IOException {
	    List<List<String>> data = new ArrayList<>();

	    try (FileInputStream file = new FileInputStream(new File(filePath));
	         Workbook workbook = new XSSFWorkbook(file)) {
	        Sheet sheet = workbook.getSheetAt(0);

	        // Read header row at given index
	        Row headerRow = sheet.getRow(headerRowIndex);
	        if (headerRow == null) {
	            throw new IllegalStateException("Header row missing at index: " + headerRowIndex);
	        }
	        int colCount = headerRow.getLastCellNum();
	        List<String> headers = new ArrayList<>();
	        for (int j = 0; j < colCount; j++) {
	            Cell cell = headerRow.getCell(j);
	            headers.add(cell != null ? cell.toString().trim() : "Column" + (j + 1));
	        }
	        data.add(headers);

	        int lastRow = sheet.getLastRowNum();
	        for (int i = headerRowIndex + 1; i <= lastRow; i++) {
	            Row row = sheet.getRow(i);
	            if (row == null) continue;
	            List<String> rowData = new ArrayList<>();
	            for (int j = 0; j < colCount; j++) {
	                Cell cell = row.getCell(j);
	                rowData.add(cell != null ? cell.toString().trim() : "");
	            }
	            data.add(rowData);
	        }
	    }
	    return data;
	}
	public static double getNumericValueSafe(Cell cell, FormulaEvaluator evaluator) {
	    if (cell == null) return 0.0;

	    try {
	        switch (cell.getCellType()) {
	            case NUMERIC:
	                return cell.getNumericCellValue();

	            case STRING:
	                try {
	                    return Double.parseDouble(cell.getStringCellValue().trim());
	                } catch (NumberFormatException e) {
	                    return 0.0;
	                }

	            case FORMULA:
	                CellValue evaluated = evaluator.evaluate(cell);
	                if (evaluated == null) return 0.0;

	                switch (evaluated.getCellType()) {
	                    case NUMERIC:
	                        return evaluated.getNumberValue();
	                    case STRING:
	                        try {
	                            return Double.parseDouble(evaluated.getStringValue().trim());
	                        } catch (NumberFormatException e) {
	                            return 0.0;
	                        }
	                    default:
	                        return 0.0;
	                }

	            case BOOLEAN:
	                return cell.getBooleanCellValue() ? 1.0 : 0.0;

	            default:
	                return 0.0;
	        }
	    } catch (Exception e) {
	        return 0.0;
	    }
	}
	
	public static List<String> readHeaderRow(String filePath, int rowIndex) {
        List<String> headers = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(new File(filePath));
             Workbook workbook = WorkbookFactory.create(fis)) {

            Sheet sheet = workbook.getSheetAt(0); // First sheet
            Row headerRow = sheet.getRow(rowIndex);

            if (headerRow != null) {
                int totalColumns = 18; // A to R (i.e., index 0 to 17)
                for (int i = 0; i < totalColumns; i++) {
                    Cell cell = headerRow.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    headers.add(cell.toString().trim());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return headers;
    }
	 public static boolean verifyStandardHeader(String filePath) throws IOException {
	        // Read header row (row 0)
	        List<String> headerRow = readHeaderRow(filePath, 0);

	        // Check if the first column contains "BOP Standard Details"
	        if (headerRow != null && headerRow.get(0).equals("BOP Standard Details")) {
	            LoggerUtil.info("✅ File is a BOP Standard file.");
	            return true;
	        } else {
	            LoggerUtil.fail("❌ File is NOT BOP Standard. Header: " + headerRow.get(0));
	            return false;
	        }
	    }

	public static List<String> readColumnAsList(String filePath, String sheetName, int columnIndex) throws IOException {
	    List<String> columnData = new ArrayList<>();
	    FileInputStream fis = new FileInputStream(new File(filePath));
	    Workbook workbook = WorkbookFactory.create(fis);
	    Sheet sheet = workbook.getSheet(sheetName);

	    for (Row row : sheet) {
	        Cell cell = row.getCell(columnIndex);
	        if (cell != null && cell.getCellType() == CellType.STRING) {
	            columnData.add(cell.getStringCellValue().trim());
	        }
	    }

	    workbook.close();
	    return columnData;
	}
	public static List<String> getExcelDataFromColumnB(String filePath, String sheetName) throws IOException {
	    List<String> data = new ArrayList<>();
	    File file = new File(filePath);
	    
	    // Check if the file exists
	    if (!file.exists()) {
	        LoggerUtil.error("❌ The file does not exist at: " + filePath);
	        return data;
	    }

	    FileInputStream fis = new FileInputStream(file);

	    // Open the workbook
	    Workbook workbook = WorkbookFactory.create(fis);

	    // Check if the sheet exists
	    Sheet sheet = workbook.getSheet(sheetName);
	    if (sheet == null) {
	        LoggerUtil.error("❌ Sheet '" + sheetName + "' not found in the Excel file.");
	        workbook.close();
	        return data;  // Return empty list as sheet is missing
	    }

	    // Loop through the rows 3 to 25 (Index 2 to 24, because Excel is 0-based)
	    for (int i = 2; i < 25; i++) {  // Row 3 to Row 25
	        Row row = sheet.getRow(i);
	        if (row != null) {
	            // Get value from Column B (Index 1)
	            Cell cell = row.getCell(1); // Column B (Index 1)
	            if (cell != null && cell.getCellType() == CellType.STRING) {
	                data.add(cell.getStringCellValue().trim());
	            } else {
	                data.add("");  // If empty or not a string
	            }
	        }
	    }

	    workbook.close();  // Always close the workbook to avoid memory leaks
	    return data;
	}

	public static int getLastNonEmptyRow(String filePath) {
	    try (FileInputStream fis = new FileInputStream(filePath);
	         Workbook workbook = new XSSFWorkbook(fis)) {

	        Sheet sheet = workbook.getSheetAt(0);
	        for (int i = sheet.getLastRowNum(); i >= 1; i--) {
	            Row row = sheet.getRow(i);
	            if (row != null && row.getCell(0) != null && !row.getCell(0).toString().trim().isEmpty()) {
	                return i;
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return -1;
	}
	
	public static void readExcelMetaData(String filePath, int headerRowIndex, int columnRowIndex) {
	    try (FileInputStream fis = new FileInputStream(filePath);
	         Workbook workbook = new XSSFWorkbook(fis)) {

	       
	        Sheet sheet = workbook.getSheetAt(0);

	        
	        String sheetName = sheet.getSheetName();
	        LoggerUtil.info(" Sheet Name: " + sheetName);

	        
	        Row headerRow = sheet.getRow(headerRowIndex);
	        if (headerRow != null && headerRow.getCell(0) != null) {
	            String fileHeader = headerRow.getCell(0).toString().trim();
	            LoggerUtil.info(" File Header: " + fileHeader);
	        }

	        
	        Row columnRow = sheet.getRow(columnRowIndex);
	        if (columnRow != null) {
	            int colCount = columnRow.getLastCellNum();
	            LoggerUtil.info(" Total Columns Found: " + colCount);

	            for (int i = 0; i < colCount; i++) {
	                Cell cell = columnRow.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
	                String colName = cell.toString().trim();
	                LoggerUtil.info("Column " + (i + 1) + " → " + colName);
	            }
	        }

	    } catch (Exception e) {
	        LoggerUtil.error("❌ Error reading Excel meta-data: " + e.getMessage());
	        e.printStackTrace();
	    }
	}
	
	
	public static Map<String, String> readColumnsFromLastRow(File excelFile, int rowIndex, int[] columnIndexes) {
	    Map<String, String> values = new HashMap<>();

	    try (FileInputStream fis = new FileInputStream(excelFile);
	         Workbook workbook = new XSSFWorkbook(fis)) {

	        Sheet sheet = workbook.getSheetAt(0);
	        Row row = sheet.getRow(rowIndex);

	        if (row != null) {
	            for (int index : columnIndexes) {
	                Cell cell = row.getCell(index);
	                String value = "";

	                if (cell != null) {
	                    switch (cell.getCellType()) {
	                        case NUMERIC:
	                            value = BigDecimal.valueOf(cell.getNumericCellValue()).toPlainString();
	                            break;
	                        case STRING:
	                            value = cell.getStringCellValue();
	                            break;
	                        case FORMULA:
	                            FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
	                            CellValue evaluated = evaluator.evaluate(cell);
	                            value = evaluated.formatAsString();
	                            break;
	                        default:
	                            value = cell.toString();
	                            break;
	                    }
	                } else {
	                    value = "(empty)";
	                }

	                String columnLetter = CellReference.convertNumToColString(index);
	                values.put(columnLetter, value);
	            }
	        } else {
	            System.out.println("❌ Row is null at index " + rowIndex);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return values;
	}

	public static Map<String, String> readColumnsNtoAHFromLastRow(File excelFile, int lastRowIndex) {
	    Map<String, String> values = new HashMap<>();

	    try (FileInputStream fis = new FileInputStream(excelFile);
	         Workbook workbook = new XSSFWorkbook(fis)) {

	        Sheet sheet = workbook.getSheetAt(0);
	        Row row = sheet.getRow(lastRowIndex);

	        if (row != null) {
	            for (int index = 13; index <= 33; index++) { // Columns N (13) to AH (33)
	                Cell cell = row.getCell(index);
	                String value = "";

	                if (cell != null) {
	                    switch (cell.getCellType()) {
	                        case NUMERIC:
	                            value = BigDecimal.valueOf(cell.getNumericCellValue()).toPlainString();
	                            break;
	                        case STRING:
	                            value = cell.getStringCellValue();
	                            break;
	                        case FORMULA:
	                            FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
	                            CellValue evaluated = evaluator.evaluate(cell);
	                            value = evaluated.formatAsString();
	                            break;
	                        case BLANK:
	                            value = "";  // treat blank as empty string
	                            break;
	                        default:
	                            value = cell.toString();
	                            break;
	                    }
	                } else {
	                    value = "";  // treat null cell as empty
	                }

	                String columnLetter = CellReference.convertNumToColString(index);
	                values.put(columnLetter, value);
	            }
	        } else {
	            System.out.println("❌ Row is null at index " + lastRowIndex);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return values;
	}
	 public static String readHeaderFromExcel(String filePath) {
	        try (FileInputStream fis = new FileInputStream(filePath);
	             Workbook workbook = WorkbookFactory.create(fis)) {

	            Sheet sheet = workbook.getSheetAt(0);
	            Row row = sheet.getRow(0);
	            Cell cell = (row != null) ? row.getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK) : null;
	            return (cell != null) ? cell.toString().trim() : "";
	        } catch (Exception e) {
	            System.out.println("⚠️ Error reading header: " + e.getMessage());
	            return "";
	        }
	    }

	    // DEBUG: first N rows print
	    public static void printAllRows(String filePath, int maxRows) {
	        try (FileInputStream fis = new FileInputStream(filePath);
	             Workbook workbook = WorkbookFactory.create(fis)) {

	            Sheet sheet = workbook.getSheetAt(0);
	            for (int r = 0; r < maxRows; r++) {
	                Row row = sheet.getRow(r);
	                if (row != null) {
	                    List<String> rowValues = new ArrayList<>();
	                    for (int c = 0; c < row.getLastCellNum(); c++) {
	                        Cell cell = row.getCell(c, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
	                        rowValues.add(cell.toString().trim());
	                    }
	                    System.out.println("Row " + r + " → " + rowValues);
	                } else {
	                    System.out.println("Row " + r + " → [null]");
	                }
	            }
	        } catch (Exception e) {
	            System.out.println("⚠️ printAllRows error: " + e.getMessage());
	            e.printStackTrace();
	        }
	    }

	    /**
	     * SAFE: Sheet name verify + given row se column names read.
	     * Error par execution stop nahi hoga; sirf log hoga aur empty list return hogi.
	     */
	    public static List<String> readAndVerifySheetAndColumns(String filePath, String expectedSheetName, int headerRowIndex) {
	        List<String> columnNames = new ArrayList<>();
	        try (FileInputStream fis = new FileInputStream(filePath);
	             Workbook workbook = WorkbookFactory.create(fis)) {

	            Sheet sheet = workbook.getSheet(expectedSheetName);
	            if (sheet == null) {
	                throw new IllegalArgumentException("❌ Sheet not found: " + expectedSheetName);
	            }

	            System.out.println("🔹 Sheet Name Found: " + sheet.getSheetName()); // <-- PRINT ADDED

	            Row headerRow = sheet.getRow(headerRowIndex);
	            if (headerRow != null) {
	                for (int c = 0; c < headerRow.getLastCellNum(); c++) {
	                    Cell cell = headerRow.getCell(c, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
	                    columnNames.add(cell.toString().trim());
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return columnNames;
	    }
	    public static List<String> readRowBC(String filePath, String sheetName, int rowIndex) {
	        List<String> values = new ArrayList<>();
	        try (FileInputStream fis = new FileInputStream(filePath);
	             Workbook workbook = WorkbookFactory.create(fis)) {

	            Sheet sheet = workbook.getSheet(sheetName);
	            if (sheet == null) {
	                throw new IllegalArgumentException("❌ Sheet not found: " + sheetName);
	            }

	            Row row = sheet.getRow(rowIndex);
	            if (row != null) {
	                // Column B → index 1
	                Cell cellB = row.getCell(1, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
	                values.add(cellB.toString().trim());

	                // Column C → index 2
	                Cell cellC = row.getCell(2, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
	                values.add(cellC.toString().trim());
	            } else {
	                System.out.println("⚠️ Row not found at index: " + rowIndex);
	            }

	        } catch (Exception e) {
	            System.out.println("⚠️ Error reading row B & C: " + e.getMessage());
	            e.printStackTrace();
	        }
	        return values;
	    }
	    public static List<String> readLimitedHeaders(String filePath) {
	        List<String> headers = new ArrayList<>();
	        try (FileInputStream fis = new FileInputStream(new File(filePath));
	             Workbook workbook = new XSSFWorkbook(fis)) {

	            Sheet sheet = workbook.getSheetAt(0);

	           
	            Row headerRow0 = sheet.getRow(0);
	            if (headerRow0 != null) {
	                Cell cell = headerRow0.getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
	                String value = cell.toString().trim();
	                if (!value.isEmpty() && !headers.contains(value)) {
	                    headers.add(value);
	                    LoggerUtil.info("Found Header → Row 0, Col A: " + value);
	                }
	            }

	            
	            Row headerRow2 = sheet.getRow(2);
	            if (headerRow2 != null) {
	                for (int c = 0; c <= 4; c++) { 
	                    Cell cell = headerRow2.getCell(c, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
	                    String value = cell.toString().trim();
	                    if (!value.isEmpty() && !headers.contains(value)) {
	                        headers.add(value);
	                        String colLetter = CellReference.convertNumToColString(c);
	                        LoggerUtil.info("Found Header → Row 2, Col " + colLetter + ": " + value);
	                    }
	                }
	            }

	            LoggerUtil.pass("Final Limited Headers (Row 0 Col A + Row 2 A–E) → " + headers);

	        } catch (Exception e) {
	            LoggerUtil.error("Exception in readLimitedHeaders: " + e.getMessage());
	        }
	        return headers;
	    }

	    public static void compareUIvsExcelRow(
	            List<String> uiRow,
	            List<String> excelRow,
	            List<String> headers) {

	        LoggerUtil.info("🔹 Comparing UI vs Excel Row...");

	        for (int i = 0; i < headers.size(); i++) {
	            String header = headers.get(i);
	            String excelValue = (i < excelRow.size()) ? excelRow.get(i).trim() : "";
	            String uiValue = (i < uiRow.size()) ? uiRow.get(i).trim() : "";

	            if (excelValue.equals(uiValue)) {
	                LoggerUtil.pass("| " + header + " | Excel: " + excelValue + " | UI: " + uiValue + " | ✅ MATCH");
	            } else {
	                LoggerUtil.mismatch("| " + header + " | Excel: " + excelValue + " | UI: " + uiValue + " | ❌ MISMATCH");
	            }
	        }
	    }

	 // Helper to log comparison
	    public static void logCompare(String field, Object uiValue, Object excelValue) {
	        try {
	            // Null safety
	            if (uiValue == null) uiValue = "0";
	            if (excelValue == null) excelValue = "0";

	            BigDecimal uiNum = null;
	            BigDecimal excelNum = null;

	            // Convert UI to BigDecimal if possible
	            if (uiValue instanceof BigDecimal) {
	                uiNum = (BigDecimal) uiValue;
	            } else {
	                uiNum = new BigDecimal(uiValue.toString().trim());
	            }

	            // Convert Excel to BigDecimal if possible
	            if (excelValue instanceof BigDecimal) {
	                excelNum = (BigDecimal) excelValue;
	            } else {
	                excelNum = new BigDecimal(excelValue.toString().trim());
	            }

	            // Apply scale (3 decimals, HALF_UP) to both sides
	            uiNum = uiNum.setScale(3, RoundingMode.HALF_UP);
	            excelNum = excelNum.setScale(3, RoundingMode.HALF_UP);

	            // Compare
	            if (uiNum.compareTo(excelNum) == 0) {
	                LoggerUtil.pass("MATCH → [" + field + "] UI: " + uiNum.toPlainString() + " | Excel: " + excelNum.toPlainString());
	            } else {
	                LoggerUtil.mismatch("MISMATCH → [" + field + "] UI: " + uiNum.toPlainString() + " | Excel: " + excelNum.toPlainString());
	            }

	        } catch (Exception e) {
	           
	            String uiStr = (uiValue == null) ? "(null)" : uiValue.toString();
	            String excelStr = (excelValue == null) ? "(null)" : excelValue.toString();

	            if (uiStr.equals(excelStr)) {
	                LoggerUtil.pass("MATCH → [" + field + "] UI: " + uiStr + " | Excel: " + excelStr);
	            } else {
	                LoggerUtil.mismatch("MISMATCH → [" + field + "] UI: " + uiStr + " | Excel: " + excelStr);
	            }
	        }
	    }
	    public static int getLastNonEmptyRowOnlyOHPMasterFile(String filePath) {
	        try (FileInputStream fis = new FileInputStream(filePath);
	             Workbook workbook = new XSSFWorkbook(fis)) {

	            Sheet sheet = workbook.getSheetAt(0);

	            // Start from last row and go upwards
	            for (int i = sheet.getLastRowNum(); i >= 3; i--) { // 3 = 4th row (0-based index)
	                Row row = sheet.getRow(i);
	                if (row != null && row.getCell(0) != null && !row.getCell(0).toString().trim().isEmpty()) {
	                   
	                    return (i - 3) + 1;
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return 0; 
	    }
	    public static HashMap<String, String> getLastNonEmptyRowOnly(String filePath) {
	        HashMap<String, String> rowData = new HashMap<>();

	        try (FileInputStream fis = new FileInputStream(filePath);
	             Workbook workbook = new XSSFWorkbook(fis)) {

	            Sheet sheet = workbook.getSheetAt(0);
	            DataFormatter formatter = new DataFormatter();

	            // ✅ Header row is at index 1 (second row in Excel)
	            Row headerRow = sheet.getRow(1);
	            if (headerRow == null) {
	                System.out.println("❌ Header row not found at index 1!");
	                return rowData;
	            }

	            //  Find last non-empty row (starting from bottom)
	            Row lastRow = null;
	            for (int i = sheet.getLastRowNum(); i > 1; i--) {
	                Row row = sheet.getRow(i);
	                if (row != null && row.getCell(0) != null &&
	                    !formatter.formatCellValue(row.getCell(0)).trim().isEmpty()) {
	                    lastRow = row;
	                    break;
	                }
	            }

	            if (lastRow == null) {
	                System.out.println("❌ No data rows found below header!");
	                return rowData;
	            }

	            //  Map header → last row values
	            for (int col = 0; col < headerRow.getLastCellNum(); col++) {
	                String headerName = formatter.formatCellValue(headerRow.getCell(col)).trim();
	                String cellValue = formatter.formatCellValue(lastRow.getCell(col)).trim();

	                if (!headerName.isEmpty()) {
	                    rowData.put(headerName, cellValue);
	                }
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return rowData;
	    }


	    public static String evaluateCellValue(Cell cell, FormulaEvaluator evaluator) {
	        if (cell == null) return "";

	        CellType cellType = cell.getCellType();
	        if (cellType == CellType.FORMULA) {
	            cellType = evaluator.evaluateFormulaCell(cell);
	        }

	        switch (cellType) {
	            case STRING:
	                return cell.getStringCellValue().trim();
	            case NUMERIC:
	                if (DateUtil.isCellDateFormatted(cell)) {
	                    return new SimpleDateFormat("dd-MM-yyyy").format(cell.getDateCellValue());
	                } else {
	                    return new DecimalFormat("#.###").format(cell.getNumericCellValue());
	                }
	            case BOOLEAN:
	                return String.valueOf(cell.getBooleanCellValue());
	            case BLANK:
	                return "";
	            default:
	                return cell.toString().trim();
	        }
	    }

	   
///////////////////////////////////////////////////////////////////////////////////////////////////////	    
	    public static void openSaveCloseExcelFile(String filePath) throws IOException, InterruptedException {
	        LoggerUtil.info("===== 🧩 Step: Opening, Saving & Closing Excel File Safely =====");
	        LoggerUtil.info("📁 File Path → " + filePath);

	        // Step 1: Open Excel
	        Process process = Runtime.getRuntime().exec("cmd /c start excel \"" + filePath + "\"");
	        LoggerUtil.info("📂 Excel launched successfully.");
	        Thread.sleep(5000);

	        // Step 2: Save File using PowerShell (avoids keyboard shortcuts)
	        String psCommand = "powershell -Command \"$excel = New-Object -ComObject Excel.Application; "
	                + "$wb = $excel.Workbooks.Open('" + filePath.replace("\\", "\\\\") + "'); "
	                + "$wb.Save(); $wb.Close($false); $excel.Quit();\"";
	        Runtime.getRuntime().exec(psCommand);
	        LoggerUtil.pass("💾 File saved and closed safely using PowerShell COM automation.");

	        // Step 3: Kill any remaining Excel processes to ensure cleanup
	        Runtime.getRuntime().exec("taskkill /F /IM excel.exe");
	        LoggerUtil.pass("❎ Excel process terminated successfully.");
	        Thread.sleep(2000);

	        LoggerUtil.info("===== ✅ Excel File Save & Close Operation Completed Without Affecting Eclipse =====");
	    }

	    /**
	     * Reads a single cell's string value from the given Excel file.
	     * @param filePath Path to the Excel file.
	     * @param sheetIndex Index of the sheet (0-based).
	     * @param row Row index (0-based).
	     * @param col Column index (0-based).
	     * @return Cell value as String (empty string if blank or error).
	     */
	    public static String getCellValue(String filePath, int sheetIndex, int row, int col) {
	        try (FileInputStream fis = new FileInputStream(filePath);
	             Workbook workbook = WorkbookFactory.create(fis)) {

	            Sheet sheet = workbook.getSheetAt(sheetIndex);
	            Row r = sheet.getRow(row);
	            if (r == null) return "";

	            Cell c = r.getCell(col);
	            if (c == null) return "";

	            DataFormatter formatter = new DataFormatter();
	            return formatter.formatCellValue(c).trim();

	        } catch (Exception e) {
	            System.err.println("❌ Error reading cell [" + row + "," + col + "] → " + e.getMessage());
	            return "";
	        }
	    }


	    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
	    public static void printSheetSummary(String filePath) {
	        try (FileInputStream fis = new FileInputStream(new File(filePath));
	             Workbook workbook = new XSSFWorkbook(fis)) {

	            // First sheet
	            Sheet sheet = workbook.getSheetAt(0);
	            String sheetName = sheet.getSheetName();
	            LoggerUtil.info(" Sheet Name: " + sheetName);

	            // Row 2 = index 1 (0-based)
	            int headerRowIndex = 1;
	            Row headerRow = sheet.getRow(headerRowIndex);
	            List<String> headers = new ArrayList<>();

	            if (headerRow != null) {
	                for (int c = 0; c < headerRow.getLastCellNum(); c++) {
	                    Cell cell = headerRow.getCell(c, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
	                    headers.add(cell.toString().trim());
	                }
	            }
	            LoggerUtil.info(" Column Names: " + headers);

	            // Count data rows (start after header row)
	            int lastRow = sheet.getLastRowNum();
	            int dataRowCount = 0;
	            for (int r = headerRowIndex + 1; r <= lastRow; r++) {
	                Row row = sheet.getRow(r);
	                if (row != null && row.getCell(0) != null && !row.getCell(0).toString().trim().isEmpty()) {
	                    dataRowCount++;
	                }
	            }
	            LoggerUtil.pass(" Total Data Rows: " + dataRowCount);

	        } catch (Exception e) {
	            LoggerUtil.error(" Error reading sheet summary: " + e.getMessage());
	            e.printStackTrace();
	        }
	    }
	    
	    // New method to handle multiple columns and return a map of column-value pairs
	    public static Map<String, String> getCellValues(String filePath, String sheetName, Map<String, String> columns, int rowNumber) {
	        Map<String, String> result = new HashMap<>();
	        
	        try (FileInputStream fis = new FileInputStream(new File(filePath));
	             Workbook workbook = WorkbookFactory.create(fis)) {
	            Sheet sheet = workbook.getSheet(sheetName);
	            Row row = sheet.getRow(rowNumber - 1); // Excel rows are 1-based

	            for (Map.Entry<String, String> column : columns.entrySet()) {
	                int colIndex = CellReference.convertColStringToIndex(column.getValue());  // Convert column letter to index
	                Cell cell = row.getCell(colIndex);
	                String cellValue = (cell != null) ? cell.toString().trim() : "";
	                result.put(column.getKey(), cellValue);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return result;
	    }
	    
	    /**
	     * Get header map (columnName → columnIndex) from a given sheet and row.
	     *
	     * @param workbook       Opened XSSFWorkbook
	     * @param sheetName      Sheet name (e.g. "Part_Master")
	     * @param headerRowIndex Row index where headers are located (0-based)
	     * @return Map of column names and their column indexes
	     */
	    private static Map<String, Integer> headerMap;
	    public static Map<String, Integer> getHeaderMap(XSSFWorkbook workbook,String sheetName, int headerRowIndex) {
	        headerMap = new HashMap<>();

	          sheet = workbook.getSheet(sheetName);
	        if (sheet == null) {
	            LoggerUtil.fail("Sheet not found: " + sheetName);
	            return headerMap;
	        }

	        Row headerRow = sheet.getRow(headerRowIndex);
	        if (headerRow == null) {
	            LoggerUtil.fail("Header row not found in sheet: " + sheetName + " at index " + headerRowIndex);
	            return headerMap;
	        }

	        for (Cell cell : headerRow) {
	            if (cell != null && cell.getCellType() == CellType.STRING) {
	                headerMap.put(cell.getStringCellValue().trim(), cell.getColumnIndex());
	            }
	        }

	       // LoggerUtil.pass("Extracted headers from sheet: " + sheetName);
	        return headerMap;
	    }

	    public static List<List<String>> readEntireSheetAsList(String filePath, String sheetName) {
	        List<List<String>> sheetData = new ArrayList<>();

	        try (FileInputStream fis = new FileInputStream(new File(filePath));
	             Workbook workbook = WorkbookFactory.create(fis)) {

	            Sheet sheet = workbook.getSheet(sheetName);
	            if (sheet == null) {
	                LoggerUtil.fail("❌ Sheet not found: " + sheetName);
	                return sheetData;
	            }

	            for (Row row : sheet) {
	                List<String> rowData = new ArrayList<>();
	                for (Cell cell : row) {
	                    DataFormatter formatter = new DataFormatter();
	                    String cellValue = formatter.formatCellValue(cell);
	                    rowData.add(cellValue.trim());
	                }
	                sheetData.add(rowData);
	            }

	         //   LoggerUtil.info("✅ Successfully read sheet: " + sheetName + " | Total rows: " + sheetData.size());

	        } catch (FileNotFoundException e) {
	            LoggerUtil.error("❌ Excel file not found: " + filePath);
	            e.printStackTrace();
	        } catch (IOException e) {
	            LoggerUtil.error("❌ Error reading Excel file: " + e.getMessage());
	            e.printStackTrace();
	        } catch (Exception e) {
	            LoggerUtil.error("❌ Unexpected error while reading Excel: " + e.getMessage());
	            e.printStackTrace();
	        }

	        return sheetData;
	    }
	    
	    public static int findHeaderRowIndex(List<List<String>> data, String expectedColumn) {
	        if (data == null || data.isEmpty()) return -1;

	        for (int i = 0; i < Math.min(data.size(), 10); i++) { // scan first 10 rows
	            List<String> row = data.get(i);
	            for (String cell : row) {
	                if (cell != null && cell.trim().equalsIgnoreCase(expectedColumn)) {
	                    return i;
	                }
	            }
	        }
	        return -1;
	    }
	    
	    /**
	     * Finds the header row index in a Sheet where the expected column title appears.
	     * Scans the first 10 rows and returns the row index if found, otherwise -1.
	     */
	    public static int findHeaderRowIndex(Sheet sheet, String expectedColumn) {
	        if (sheet == null) return -1;

	        for (int i = 0; i < Math.min(sheet.getLastRowNum(), 10); i++) {
	            Row row = sheet.getRow(i);
	            if (row == null) continue;

	            for (Cell cell : row) {
	                String value = new DataFormatter().formatCellValue(cell).trim();
	                if (value.equalsIgnoreCase(expectedColumn)) {
	                    return i;
	                }
	            }
	        }
	        return -1;
	    }

	    /*Rajnish created method*/
	    
	    public static XSSFWorkbook openWorkbook(File filePath) {
	        try {
	            return new XSSFWorkbook(new FileInputStream(filePath));
	        } catch (Exception e) {
	            LoggerUtil.fail("Error opening workbook: " + e.getMessage());
	            return null;
	        }
	    }
	    
	    public static void validateMandatorySelections(
	            XSSFWorkbook workbook,
	            Map<String, Integer> headerMap,
	            Map<String, List<String>> expectedMap,
	            SoftAssert softAssert) throws Exception {

	        Sheet sheet = workbook.getSheet("Part_Master");
	        if (sheet == null) {
	            LoggerUtil.error("Sheet 'Part_Master' not found!");
	            softAssert.fail("Sheet 'Part_Master' not found!");
	            return;
	        }

	        Row dataRow = sheet.getRow(2); // assuming data starts from row 2 (index = 2)
	        if (dataRow == null) {
	            LoggerUtil.error("No data found in Part_Master sheet!");
	            softAssert.fail("No data found in Part_Master sheet!");
	            return;
	        }

	        for (Map.Entry<String, List<String>> entry : expectedMap.entrySet()) {
	            String columnName = entry.getKey();
	            List<String> expectedValues = entry.getValue();

	            Integer colIndex = headerMap.get(columnName);
	            if (colIndex == null) {
	                LoggerUtil.error("Column not found: " + columnName);
	                softAssert.fail("Column not found: " + columnName);
	                continue;
	            }

	            Cell cell = dataRow.getCell(colIndex);
	            String actualValue = (cell == null) ? "" : cell.toString().trim();

	            LoggerUtil.info("Validating column: " + columnName);
	            LoggerUtil.info("Expected: " + expectedValues);
	            LoggerUtil.info("Actual:   " + actualValue);

	            boolean match = expectedValues.stream()
	                    .anyMatch(exp -> exp.trim().equalsIgnoreCase(actualValue));

	            if (match) {
	                LoggerUtil.info("PASS: Validation passed for column: " + columnName
	                        + " | Expected=" + expectedValues + " | Actual=" + actualValue);
	            } else {
	                LoggerUtil.error("FAIL: Validation failed for column: " + columnName
	                        + " | Expected=" + expectedValues + " | Actual=" + actualValue);
	            }

	            // Soft assertion so test continues even if fail
	            softAssert.assertTrue(match,
	                    "Mismatch in column [" + columnName + "] | Expected one of "
	                            + expectedValues + " | Actual=" + actualValue);
	        }
	    }

	    public static int getExportedPartRows(String filePath, String sheetName) {
	        try (FileInputStream fis = new FileInputStream(new File(filePath));
	             Workbook workbook = new XSSFWorkbook(fis)) {

	            Sheet sheet = workbook.getSheet(sheetName);
	            if (sheet == null) {
	                System.out.println("❌ Sheet not found: " + sheetName);
	                return -1;
	            }

	            int firstDataRowIndex = 2; // skip title + header
	            int lastRowNum = sheet.getLastRowNum();

	            int dataRowCount = 0;

	            // Check only specific column (e.g. "Company Name - Location*" = col index 14 / O)
	            int checkColumnIndex = 14; 

	            for (int i = firstDataRowIndex; i <= lastRowNum; i++) {
	                Row row = sheet.getRow(i);
	                if (row != null) {
	                    Cell cell = row.getCell(checkColumnIndex);
	                    if (cell != null && cell.getCellType() != CellType.BLANK &&
	                        cell.getStringCellValue().trim().length() > 0) {
	                        dataRowCount++;
	                    }
	                }
	            }
	            return dataRowCount;

	        } catch (Exception e) {
	            e.printStackTrace();
	            return -1;
	        }
	    }

	    public static void setCellDataByHeader(String filePath, String sheetName, int rowNum,
				Map<String, Integer> headerMap, String colHeader, String value) throws IOException {
			if (!headerMap.containsKey(colHeader)) {
				throw new IllegalArgumentException("Column '" + colHeader + "' not found in sheet '" + sheetName + "'");
			}
			int colNum = headerMap.get(colHeader);
			setCellData(filePath, sheetName, rowNum, colNum, value);
		}
	    
	    /**
	     * Verify that the given Excel file contains all the expected sheets.
	     *
	     * @param filePath the downloaded Excel file
	     * @param expectedSheets list of expected sheet names
	     */
	    public static List<String> verifyExcelSheetNames(File filePath, List<String> expectedSheets) {
	        List<String> actualSheets = new ArrayList<>();

	        try (FileInputStream fis = new FileInputStream(filePath);
	             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

	            for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
	                actualSheets.add(workbook.getSheetName(i));
	            }

	            if (new HashSet<>(actualSheets).equals(new HashSet<>(expectedSheets))) {
	                LoggerUtil.pass("Workbook sheet names matched (order independent): " + actualSheets);
	            } else {
	                LoggerUtil.fail("Workbook sheet names mismatch. Expected: "
	                        + expectedSheets + ", Found: " + actualSheets);
	            }

	        } catch (Exception e) {
	            LoggerUtil.fail("Error while verifying Excel sheets: " + e.getMessage());
	        }

	        return actualSheets; // ✅ return kar diya
	    }
	    
	    public static int getRowCount(int dataStartRow, String columnName) {
	        

	        int colIdx = headerMap.get(columnName);
	        int lastRow = sheet.getLastRowNum();
	        int count = 0;

	        for (int r = dataStartRow; r <= lastRow; r++) {
	            Row row = sheet.getRow(r);
	            if (row == null) continue;
	            Cell cell = row.getCell(colIdx);
	            if (cell != null && !cell.toString().trim().isEmpty()) {
	                count++;
	            }
	        }
	        return count;
	    }
	    
	    public static boolean validateDropdownOnRowsReturnBoolean(
	            XSSFWorkbook workbook,
	            String sheetName,
	            String columnName,
	            int[] rowsToCheck) {

	        try {
	            Sheet sheet = workbook.getSheet(sheetName);
	            if (sheet == null) {
	                LoggerUtil.fail("Sheet '" + sheetName + "' not found in workbook!");
	                return false;
	            }

	            // Step 1: Locate column index dynamically from header row
	            Map<String, Integer> headerMap = getHeaderMap(workbook, sheetName, 1);
	            if (!headerMap.containsKey(columnName)) {
	                LoggerUtil.fail("Column '" + columnName + "' not found in sheet '" + sheetName + "'.");
	                return false;
	            }
	            int colIndex = headerMap.get(columnName);

	            // Step 2: Get all data validation rules (dropdown definitions)
	            List<? extends DataValidation> validations = sheet.getDataValidations();
	            if (validations == null || validations.isEmpty()) {
	                LoggerUtil.fail("No data validations found in sheet '" + sheetName + "'.");
	                return false;
	            }

	            boolean allDropdownsPresent = true;

	            // Step 3: Loop through rows dynamically
	            for (int rowIndex : rowsToCheck) {
	                boolean hasDropdown = false;
	                List<String> dropdownValues = new ArrayList<>();

	                for (DataValidation dv : validations) {
	                    for (CellRangeAddress region : dv.getRegions().getCellRangeAddresses()) {
	                        if (region.isInRange(rowIndex, colIndex)) {
	                            hasDropdown = true;

	                            DataValidationConstraint constraint = dv.getValidationConstraint();

	                            // Explicit list (static dropdown values)
	                            if (constraint != null && constraint.getExplicitListValues() != null) {
	                                dropdownValues = Arrays.asList(constraint.getExplicitListValues());
	                            }

	                            // Formula-based dropdown (dynamic range)
	                            else if (constraint != null && constraint.getFormula1() != null) {
	                                dropdownValues.add("Formula-based list: " + constraint.getFormula1());
	                            }
	                            break;
	                        }
	                    }
	                    if (hasDropdown) break;
	                }

	                // Step 4: Logging and assertions
	                if (hasDropdown) {
	                    LoggerUtil.pass("PASS: Dropdown found in '" + columnName + "' at row: " + (rowIndex + 1));
	                    if (!dropdownValues.isEmpty()) {
	                        LoggerUtil.info("→ Dropdown values at row " + (rowIndex + 1) + ": " + dropdownValues);
	                    } else {
	                        LoggerUtil.warn("⚠ No explicit dropdown values found at row " + (rowIndex + 1) +
	                                        " (possibly formula-based).");
	                    }
	                } else {
	                    LoggerUtil.fail("FAIL: No dropdown found in '" + columnName + "' at row: " + (rowIndex + 1));
	                    allDropdownsPresent = false;
	                }
	            }

	            return allDropdownsPresent;

	        } catch (Exception e) {
	            LoggerUtil.error("Exception in validateDropdownOnRowsReturnBoolean: " + e.getMessage());
	            return false;
	        }
	    }

	    /**
	     * Collects dropdown (Data Validation) list values for a specific column and row range.
	     * Supports both explicit lists and formula-based ranges like $DR$1:$DR$9.
	     */
	    public static List<String> collectExplicitDVListForColumns(
	            Sheet sheet,
	            XSSFWorkbook workbook,
	            int colIndex,
	            int startRow,
	            int endRow) {

	        List<String> dropdownValues = new ArrayList<>();
	        try {
	            List<? extends DataValidation> validations = sheet.getDataValidations();

	            for (DataValidation dv : validations) {
	                for (CellRangeAddress region : dv.getRegions().getCellRangeAddresses()) {

	                    // Check if column and row range intersect the validation region
	                    if (colIndex >= region.getFirstColumn() && colIndex <= region.getLastColumn()
	                            && startRow >= region.getFirstRow() && endRow <= region.getLastRow()) {

	                        DataValidationConstraint constraint = dv.getValidationConstraint();

	                        // Case 1: Explicit list of values
	                        if (constraint != null && constraint.getExplicitListValues() != null) {
	                            dropdownValues = Arrays.asList(constraint.getExplicitListValues());
	                        }

	                        // Case 2: Formula-based list (e.g. =$DR$1:$DR$9)
	                        else if (constraint != null && constraint.getFormula1() != null) {
	                            String formula = constraint.getFormula1().trim().replace("=", "");
	                            dropdownValues = extractFormulaRangeValues(workbook, formula);
	                        }
	                        return dropdownValues; // Found relevant validation; return immediately
	                    }
	                }
	            }

	        } catch (Exception e) {
	            LoggerUtil.error("Error while collecting dropdown values for column index " + colIndex + ": " + e.getMessage());
	        }

	        return dropdownValues;
	    }

	    /**
	     * Extracts actual cell values from a formula range like "$DR$1:$DR$9" or "Sheet2!$A$1:$A$8".
	     */
	    private static List<String> extractFormulaRangeValues(XSSFWorkbook workbook, String formula) {
	        List<String> values = new ArrayList<>();
	        try {
	            String sheetName = workbook.getSheetName(0); // default sheet
	            String rangeRef = formula;

	            if (formula.contains("!")) {
	                String[] parts = formula.split("!");
	                sheetName = parts[0].replace("'", "");
	                rangeRef = parts[1];
	            }

	            Sheet refSheet = workbook.getSheet(sheetName);
	            if (refSheet == null) return values;

	            CellRangeAddress range = CellRangeAddress.valueOf(rangeRef);
	            for (int r = range.getFirstRow(); r <= range.getLastRow(); r++) {
	                Row row = refSheet.getRow(r);
	                if (row == null) continue;
	                for (int c = range.getFirstColumn(); c <= range.getLastColumn(); c++) {
	                    Cell cell = row.getCell(c);
	                    if (cell != null && cell.getCellType() == CellType.STRING) {
	                        String val = cell.getStringCellValue().trim();
	                        if (!val.isEmpty()) values.add(val);
	                    }
	                }
	            }

	        } catch (Exception e) {
	            LoggerUtil.error("Error extracting formula range values from formula '" + formula + "': " + e.getMessage());
	        }

	        return values;
	    }

	    private static List<String> extractFormulaRangeValuess(XSSFWorkbook workbook, String formula) {
	        List<String> values = new ArrayList<>();
	        try {
	            String sheetName = workbook.getSheetName(0); // default sheet
	            String rangeRef = formula.trim().replace("=", "");

	            // ✅ Case 1: Formula contains OFFSET/VLOOKUP → extract lookup range
	            if (rangeRef.contains("OFFSET(") && rangeRef.contains("VLOOKUP(")) {
	                Pattern p = Pattern.compile("\\$[A-Z]+\\$?\\d+:\\$[A-Z]+\\$?\\d+");
	                Matcher m = p.matcher(rangeRef);

	                if (m.find()) {
	                    String lookupRange = m.group(); // e.g. $DR$15:$DS$23
	                    Sheet sheet = workbook.getSheet(sheetName);
	                    CellRangeAddress range = CellRangeAddress.valueOf(lookupRange);

	                    for (int r = range.getFirstRow(); r <= range.getLastRow(); r++) {
	                        Row row = sheet.getRow(r);
	                        if (row == null) continue;
	                        Cell cell = row.getCell(range.getLastColumn());
	                        if (cell != null && cell.getCellType() == CellType.STRING) {
	                            String val = cell.getStringCellValue().trim();
	                            if (!val.isEmpty()) values.add(val);
	                        }
	                    }
	                    LoggerUtil.info("Extracted dependent dropdown values from lookup range " + lookupRange + ": " + values);
	                    return values;
	                }
	            }

	            // ✅ Case 2: Direct range (original logic)
	            if (rangeRef.contains("!")) {
	                String[] parts = rangeRef.split("!");
	                sheetName = parts[0].replace("'", "");
	                rangeRef = parts[1];
	            }

	            Sheet refSheet = workbook.getSheet(sheetName);
	            if (refSheet == null) return values;

	            CellRangeAddress range = CellRangeAddress.valueOf(rangeRef);
	            for (int r = range.getFirstRow(); r <= range.getLastRow(); r++) {
	                Row row = refSheet.getRow(r);
	                if (row == null) continue;
	                for (int c = range.getFirstColumn(); c <= range.getLastColumn(); c++) {
	                    Cell cell = row.getCell(c);
	                    if (cell != null && cell.getCellType() == CellType.STRING) {
	                        String val = cell.getStringCellValue().trim();
	                        if (!val.isEmpty()) values.add(val);
	                    }
	                }
	            }

	        } catch (Exception e) {
	            LoggerUtil.error("Error extracting formula range values from formula '" + formula + "': " + e.getMessage());
	        }

	        return values.stream().distinct().collect(Collectors.toList());
	    }
	    
	    public static void validateDependentDropdownForAllRows(
	            XSSFWorkbook workbook,
	            String sheetName,
	            String costingModuleColumn,
	            String rmInputShapeColumn,
	            String expectedCostingModule,
	            String flowType) throws Exception {

	        Sheet sheet = workbook.getSheet(sheetName);

	        // Step 1: Get header map
	        Map<String, Integer> headerMap = getHeaderMap(workbook, sheetName, 1);

	        Assert.assertTrue(headerMap.containsKey(costingModuleColumn),
	                "Column " + costingModuleColumn + " not found in " + sheetName + " sheet!");
	        Assert.assertTrue(headerMap.containsKey(rmInputShapeColumn),
	                "Column " + rmInputShapeColumn + " not found in " + sheetName + " sheet!");

	        int costingModuleColIdx = headerMap.get(costingModuleColumn);
	        int rmInputShapeColIdx = headerMap.get(rmInputShapeColumn);

	        int totalRows = sheet.getLastRowNum();

	        // Step 2: Iterate rows
	        for (int rowIdx = 2; rowIdx <= totalRows; rowIdx++) {
	            Row row = sheet.getRow(rowIdx);
	            if (row == null) continue;

	            Cell costingCell = row.getCell(costingModuleColIdx);
	            if (costingCell != null && costingCell.toString().trim().equalsIgnoreCase(expectedCostingModule)) {

	                // Row index & column index
	                int rowIndex = row.getRowNum();
	                int colIndex = rmInputShapeColIdx;

	                // Step 3: Check Data Validation for dropdown
	                boolean hasDropdown = sheet.getDataValidations()
	                        .stream()
	                        .anyMatch(dv -> {
	                            for (CellRangeAddress addr : dv.getRegions().getCellRangeAddresses()) {
	                                if (addr.isInRange(rowIndex, colIndex)) {
	                                    return true;
	                                }
	                            }
	                            return false;
	                        });

	                if (hasDropdown) {
	                    LoggerUtil.pass("Flow=" + flowType + " | Row " + (rowIdx + 1)
	                            + ": RM Input Shape is a dependent dropdown when Costing Module = " + expectedCostingModule);
	                } else {
	                    LoggerUtil.fail("Flow=" + flowType + " | Row " + (rowIdx + 1)
	                            + ": RM Input Shape is NOT a dropdown (should be).");
	                    Assert.fail("RM Input Shape missing dropdown dependency in row " + (rowIdx + 1));
	                }
	            }
	        }
	    }
	    
	    public static void validateColumnValuesForKeyRows(
	            XSSFWorkbook workbook,
	            String sheetName,
	            String columnName,
	            String expectedValue,
	            String flowType) {

	        Sheet sheet = workbook.getSheet(sheetName);
	        Assert.assertNotNull(sheet, "Sheet '" + sheetName + "' not found in workbook!");

	        // Step 1: Get header map
	        Map<String, Integer> headerMap = getHeaderMap(workbook, sheetName, 1);
	        Assert.assertTrue(headerMap.containsKey(columnName),
	                "Column '" + columnName + "' not found in sheet '" + sheetName + "'.");
	        int colIndex = headerMap.get(columnName);

	        // Step 2: Define first, mid, and last rows
	        int totalRows = sheet.getLastRowNum();
	        int firstRow = 2;
	        int lastRow = totalRows;
	        int midRow = (firstRow + lastRow) / 2;
	        int[] rowsToCheck = { firstRow, midRow, lastRow };

	        LoggerUtil.info("Flow=" + flowType + " | Validating '" + columnName + "' default value on rows: "
	                + Arrays.toString(rowsToCheck) + " | Expected: " + expectedValue);

	        // Step 3: Validate each key row
	        for (int rowIdx : rowsToCheck) {
	            Row row = sheet.getRow(rowIdx);
	            if (row == null) {
	                LoggerUtil.warn("Flow=" + flowType + " | Row " + (rowIdx + 1) + " is empty — skipping.");
	                continue;
	            }

	            Cell cell = row.getCell(colIndex);
	            String actualValue = (cell == null) ? "" : cell.toString().trim();

	            if (!actualValue.isEmpty()) {
	                Assert.assertEquals(actualValue, expectedValue,
	                        "Flow=" + flowType + " | Row " + (rowIdx + 1)
	                        + " | Expected: " + expectedValue + " | Found: " + actualValue);
	                LoggerUtil.pass("Flow=" + flowType + " | Row " + (rowIdx + 1)
	                        + " validated successfully. Value = " + actualValue);
	            } else {
	                LoggerUtil.fail("Flow=" + flowType + " | Row " + (rowIdx + 1)
	                        + " is blank for column '" + columnName + "'. Expected: " + expectedValue);
	            }
	        }
	    }

	    public static Set<String> getDropdownValues(XSSFWorkbook workbook, String sheetName, String columnHeader, int rowIdx) {
	        Set<String> values = new LinkedHashSet<>();
	        try {
	            XSSFSheet sheet = workbook.getSheet(sheetName);
	            if (sheet == null) {
	                LoggerUtil.error("Sheet not found: " + sheetName);
	                return values;
	            }

	            // 1. Find column index by header row (row 2 = index 1)
	            Row headerRow = sheet.getRow(1);
	            int colIndex = -1;
	            for (Cell cell : headerRow) {
	                if (cell != null && cell.getCellType() == CellType.STRING &&
	                    cell.getStringCellValue().trim().equalsIgnoreCase(columnHeader.trim())) {
	                    colIndex = cell.getColumnIndex();
	                    break;
	                }
	            }
	            if (colIndex == -1) {
	                LoggerUtil.error("Column not found: " + columnHeader + " in sheet " + sheetName);
	                return values;
	            }

	            // 2. Loop through validations in this sheet
	            List<? extends DataValidation> validations = sheet.getDataValidations();
	            for (DataValidation validation : validations) {
	                CellRangeAddressList addrList = validation.getRegions();
	                for (CellRangeAddress addr : addrList.getCellRangeAddresses()) {
	                 //   LoggerUtil.info("Checking range: " + addr.formatAsString());
	                    if (addr.getFirstColumn() == colIndex) {
	                        DataValidationConstraint constraint = validation.getValidationConstraint();

	                        // Case A: Explicit dropdown list
	                        if (constraint.getExplicitListValues() != null) {
	                            for (String v : constraint.getExplicitListValues()) {
	                                if (v != null && !v.trim().isEmpty()) {
	                                    values.add(v.trim());
	                                }
	                            }
	                        }

	                        // Case B: Formula-based dropdown
	                        String formula = constraint.getFormula1();
	                        if (formula != null) {
	                          //  LoggerUtil.info("Formula: " + formula);

	                            // Direct range: =Sheet1!A2:A500
	                            if (formula.contains("!") && !formula.toUpperCase().startsWith("OFFSET")) {
	                                String[] parts = formula.split("!");
	                                String targetSheetName = parts[0].replace("=", "").replace("'", "").trim();
	                                String rangeRef = parts[1];

	                                if (rangeRef.contains(":")) {
	                                    String[] rangeSplit = rangeRef.split(":");
	                                    CellReference startRef = new CellReference(rangeSplit[0]);
	                                    CellReference endRef = new CellReference(rangeSplit[1]);

	                                    XSSFSheet targetSheet = workbook.getSheet(targetSheetName);
	                                    if (targetSheet != null) {
	                                        for (int r = startRef.getRow(); r <= endRef.getRow(); r++) {
	                                            Row row = targetSheet.getRow(r);
	                                            if (row == null) continue;
	                                            Cell cell = row.getCell(startRef.getCol());
	                                            if (cell == null) continue;
	                                            String val = cell.toString().trim();
	                                            if (!val.isEmpty()) values.add(val);
	                                        }
	                                    }
	                                }
	                            }

	                            // OFFSET formula: OFFSET(Sheet!StartCell,,,COUNTA(Sheet!Range))
	                            else if (formula.toUpperCase().startsWith("OFFSET")) {
	                                String inner = formula.substring(7, formula.length() - 1); // remove OFFSET(...)
	                                String[] parts = inner.split(",");
	                                if (parts.length >= 4) {
	                                    String ref = parts[0].trim(); // Sheet!StartCell
	                                    String countPart = parts[3].trim(); // COUNTA(...)

	                                    // Parse start reference
	                                    String[] refParts = ref.split("!");
	                                    String targetSheetName = refParts[0].replace("'", "").trim();
	                                    String startCell = refParts[1].trim();
	                                    CellReference startRef = new CellReference(startCell);
	                                    int startRow = startRef.getRow();
	                                    int col = startRef.getCol();

	                                    // Parse COUNTA range
	                                    int rowCount = 0;
	                                    if (countPart.toUpperCase().startsWith("COUNTA")) {
	                                        String countRange = countPart.substring(7, countPart.length() - 1); // DN1:DN2
	                                        String[] crParts = countRange.split(":");
	                                        CellReference crStart = new CellReference(crParts[0]);
	                                        CellReference crEnd = new CellReference(crParts[1]);
	                                        rowCount = crEnd.getRow() - crStart.getRow() + 1;
	                                    }

	                                    XSSFSheet targetSheet = workbook.getSheet(targetSheetName);
	                                    if (targetSheet != null) {
	                                        for (int r = startRow; r < startRow + rowCount; r++) {
	                                            Row row = targetSheet.getRow(r);
	                                            if (row == null) continue;
	                                            Cell cell = row.getCell(col);
	                                            if (cell == null) continue;
	                                            String val = cell.toString().trim();
	                                            if (!val.isEmpty()) values.add(val);
	                                        }
	                                    }
	                                }
	                            }
	                        }
	                    }
	                }
	            }

	            LoggerUtil.info("Dropdown values extracted for [" + columnHeader + "] in sheet [" + sheetName + "]: " + values);

	        } catch (Exception e) {
	            LoggerUtil.error("Error while extracting dropdown values for column: " + columnHeader + " - " + e.getMessage());
	        }
	        return values;
	    }
	    public static void checkDefaultOnSelection(
	            XSSFWorkbook workbook,
	            String sheetName,
	            String triggerColumn,
	            String dependentColumn,
	            String expectedValue,
	            List<String> triggerValues,
	            File filePath) throws Exception {

	        XSSFSheet sheet = workbook.getSheet(sheetName);
	        if (sheet == null) {
	            throw new RuntimeException("Sheet '" + sheetName + "' not found in workbook!");
	        }

	        // ✅ Locate column indexes by header names
	        Row headerRow = sheet.getRow(1);
	        Map<String, Integer> headerMap = new HashMap<>();
	        for (Cell cell : headerRow) {
	            if (cell != null && cell.getCellType() == CellType.STRING) {
	                headerMap.put(cell.getStringCellValue().trim(), cell.getColumnIndex());
	            }
	        }

	        int triggerColIndex = headerMap.getOrDefault(triggerColumn, -1);
	        int dependentColIndex = headerMap.getOrDefault(dependentColumn, -1);

	        if (triggerColIndex == -1 || dependentColIndex == -1) {
	            throw new RuntimeException("Columns not found: " + triggerColumn + " / " + dependentColumn);
	        }

	        // ✅ Determine 1st, mid, last rows dynamically
	        int totalRows = sheet.getLastRowNum() - 2;
	        int midRow = (totalRows > 2) ? (totalRows / 2) : 1;
	        List<Integer> targetRows = Arrays.asList(2, midRow + 1, totalRows + 1);

	        int counter = 0;
	        for (int rowIndex : targetRows) {
	            Row row = sheet.getRow(rowIndex);
	            if (row == null) row = sheet.createRow(rowIndex);

	            // ✅ Fill trigger column
	            Cell triggerCell = row.getCell(triggerColIndex);
	            if (triggerCell == null) triggerCell = row.createCell(triggerColIndex);

	            String triggerValue = triggerValues.get(counter % triggerValues.size());
	            triggerCell.setCellValue(triggerValue);

	            // ✅ Save workbook (so formulas recalc in Excel)
	            try (FileOutputStream fos = new FileOutputStream(filePath)) {
	                workbook.write(fos);
	            }

	            // ✅ Read dependent value
	            Cell dependentCell = row.getCell(dependentColIndex);
	            String actualValue = getCellValueEvaluated(dependentCell, workbook);
	           // String actualValue = (dependentCell == null) ? "" : dependentCell.toString().trim();

	            // ✅ Validate
	            if (expectedValue.equals(actualValue)) {
	                LoggerUtil.pass("PASS: Row " + (rowIndex + 1) + " → After selecting '" + triggerColumn + "' = " + triggerValue +
	                        ", '" + dependentColumn + "' defaulted to " + expectedValue);
	            } else {
	                LoggerUtil.fail("FAIL: Row " + (rowIndex + 1) + " → After selecting '" + triggerColumn + "' = " + triggerValue +
	                        ", '" + dependentColumn + "' expected " + expectedValue + " but found: " + actualValue);
	            }

	            counter++;
	        }
	    }
	    private static String getCellValueEvaluated(Cell cell, XSSFWorkbook workbook) {
	        if (cell == null) return "";

	        FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
	        if (cell.getCellType() == CellType.FORMULA) {
	            CellValue eval = evaluator.evaluate(cell);
	            switch (eval.getCellType()) {
	                case NUMERIC:
	                    return String.valueOf((int) eval.getNumberValue());
	                case STRING:
	                    return eval.getStringValue();
	                case BOOLEAN:
	                    return String.valueOf(eval.getBooleanValue());
	                default:
	                    return "";
	            }
	        } else {
	            return cell.toString().trim();
	        }
	    }
	    
	    public static void writeCellValue(File file, String sheetName, int excelRowNo, String columnName, String value) throws Exception {
	        int rowIndex = excelRowNo - 1;

	        try (FileInputStream fis = new FileInputStream(file);
	             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

	            XSSFSheet sheet = workbook.getSheet(sheetName);
	            if (sheet == null) throw new IllegalArgumentException("Sheet not found: " + sheetName);

	            Row headerRow = sheet.getRow(1); // Excel header is in row 2 → index 1
	            if (headerRow == null) throw new IllegalArgumentException("Header row not found in " + sheetName);

	            int colIndex = -1;
	            for (Cell cell : headerRow) {
	                if (cell.getCellType() == CellType.STRING) {
	                    String headerName = cell.getStringCellValue().trim();
	                    if (headerName.equalsIgnoreCase(columnName.trim())) {
	                        colIndex = cell.getColumnIndex();
	                        break;
	                    }
	                }
	            }
	            if (colIndex == -1) throw new IllegalArgumentException("Column not found: " + columnName);

	            Row row = sheet.getRow(rowIndex);
	            if (row == null) row = sheet.createRow(rowIndex);

	            Cell cell = row.getCell(colIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
	            cell.setCellFormula(null);
	            cell.setCellType(CellType.STRING);
	            cell.setCellValue(value);

	            try (FileOutputStream fos = new FileOutputStream(file)) {
	                workbook.write(fos);
	                fos.flush();
	            }
	        }
	    }

	    public static boolean verifyQtyPcInExcel(File file, String sheetName, int excelRowNo, String columnName, String expectedValue) throws Exception {
	        int rowIndex = excelRowNo - 1;
	        try (FileInputStream fis = new FileInputStream(file);
	             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

	            XSSFSheet sheet = workbook.getSheet(sheetName);
	            if (sheet == null) throw new IllegalArgumentException("Sheet not found: " + sheetName);

	            // Header Row = Excel Row 2 (Java index 1)
	            Row headerRow = sheet.getRow(1);
	            int colIndex = -1;
	            for (Cell cell : headerRow) {
	                if (cell.getStringCellValue().trim().equalsIgnoreCase(columnName.trim())) {
	                    colIndex = cell.getColumnIndex();
	                    break;
	                }
	            }
	            if (colIndex == -1) throw new IllegalArgumentException("Column not found: " + columnName);

	            Row row = sheet.getRow(rowIndex);
	            if (row == null) return false;
	            Cell cell = row.getCell(colIndex);
	            if (cell == null) return false;

	            // ✅ Evaluate formula if present
	            FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
	            String actualValue;
	            if (cell.getCellType() == CellType.FORMULA) {
	                CellValue eval = evaluator.evaluate(cell);
	                switch (eval.getCellType()) {
	                    case NUMERIC: actualValue = String.valueOf((int) eval.getNumberValue()); break;
	                    case STRING:  actualValue = eval.getStringValue(); break;
	                    case BOOLEAN: actualValue = String.valueOf(eval.getBooleanValue()); break;
	                    default:      actualValue = ""; break;
	                }
	            } else {
	                actualValue = cell.toString().trim();
	            }

	            if (expectedValue.equals(actualValue)) {
	                LoggerUtil.pass("Row " + excelRowNo + " Qty/Pc matched. Expected = " + expectedValue + " | Actual = " + actualValue);
	                return true;
	            } else {
	                LoggerUtil.fail("Row " + excelRowNo + " Qty/Pc mismatch. Expected = " + expectedValue + " | Actual = " + actualValue);
	                return false;
	            }
	        }
	    }
	    
	    public static Set<String> getDropdownValuess(XSSFWorkbook workbook, String sheetName, String columnHeader) {
	        Set<String> values = new LinkedHashSet<>();
	        try {
	            XSSFSheet sheet = workbook.getSheet(sheetName);
	            if (sheet == null) {
	                LoggerUtil.error("Sheet not found: " + sheetName);
	                return values;
	            }

	            // 1️⃣ Find column index
	            Row headerRow = sheet.getRow(1);
	            int colIndex = -1;
	            for (Cell cell : headerRow) {
	                if (cell != null && cell.getCellType() == CellType.STRING &&
	                    cell.getStringCellValue().trim().equalsIgnoreCase(columnHeader.trim())) {
	                    colIndex = cell.getColumnIndex();
	                    break;
	                }
	            }
	            if (colIndex == -1) {
	                LoggerUtil.error("Column not found: " + columnHeader + " in sheet " + sheetName);
	                return values;
	            }

	            // 2️⃣ Loop through validations
	            List<? extends DataValidation> validations = sheet.getDataValidations();
	            for (DataValidation validation : validations) {
	                CellRangeAddressList addrList = validation.getRegions();
	                for (CellRangeAddress addr : addrList.getCellRangeAddresses()) {
	                    if (addr.getFirstColumn() == colIndex) {
	                        DataValidationConstraint constraint = validation.getValidationConstraint();
	                        if (constraint == null) continue;

	                        String formula = constraint.getFormula1();
	                        if (formula == null || formula.trim().isEmpty()) continue;

	                        // ✅ Case 1: Simple explicit list
	                        if (constraint.getExplicitListValues() != null) {
	                            for (String v : constraint.getExplicitListValues())
	                                if (v != null && !v.trim().isEmpty()) values.add(v.trim());
	                            continue;
	                        }

	                        // ✅ Case 2: OFFSET + MATCH + COUNTIF dynamic formula
	                        if (formula.toUpperCase().contains("OFFSET") &&
	                            formula.toUpperCase().contains("MATCH") &&
	                            formula.toUpperCase().contains("COUNTIF")) {

	                            /*
	                             Example:
	                             OFFSET(Process_Master!$C$5, MATCH(C3, Process_Master!$C$5:$C$2000, 0)-1, -1, COUNTIF(Process_Master!$C$5:$C$2000, C3))
	                             Means:
	                             → Match Process_Cost!C3 (Supplier) with Process_Master!$C$5:$C$2000
	                             → Then pull Process Name from Process_Master (column before C, i.e. B)
	                             → Pull as many rows as COUNTIF result.
	                             */

	                            // Extract sheet and supplier range
	                            String targetSheetName = "Process_Master";
	                            XSSFSheet masterSheet = workbook.getSheet(targetSheetName);
	                            if (masterSheet == null) continue;

	                            // Identify columns
	                            int supplierCol = CellReference.convertColStringToIndex("C"); // Process_Master!C = Supplier
	                            int processNameCol = supplierCol - 1; // Column B = Process Name

	                            // Read supplier value from current Process_Cost row
	                            int rowIndex = addr.getFirstRow();
	                            Row processRow = sheet.getRow(rowIndex);
	                            if (processRow == null) continue;

	                            // Supplier value (Process_Cost.C3)
	                            Cell supplierCell = processRow.getCell(CellReference.convertColStringToIndex("C"));
	                            if (supplierCell == null) continue;
	                            String supplierValue = supplierCell.toString().trim();
	                            if (supplierValue.isEmpty()) continue;

	                            // Filter Process_Master where Supplier == supplierValue
	                            for (int r = 4; r <= masterSheet.getLastRowNum(); r++) {
	                                Row masterRow = masterSheet.getRow(r);
	                                if (masterRow == null) continue;
	                                Cell supCell = masterRow.getCell(supplierCol);
	                                Cell procNameCell = masterRow.getCell(processNameCol);

	                                if (supCell == null || procNameCell == null) continue;
	                                String supVal = supCell.toString().trim();
	                                String procVal = procNameCell.toString().trim();

	                                if (!supVal.isEmpty() && supVal.equalsIgnoreCase(supplierValue) && !procVal.isEmpty()) {
	                                    values.add(procVal);
	                                }
	                            }

	                            LoggerUtil.info("✅ Extracted OFFSET-based filtered list for Supplier [" + supplierValue + "]: " + values);
	                        }
	                    }
	                }
	            }

	            LoggerUtil.info("Dropdown values extracted for [" + columnHeader + "] in sheet [" + sheetName + "]: " + values);

	        } catch (Exception e) {
	            LoggerUtil.error("Error extracting dropdown for " + columnHeader + ": " + e.getMessage());
	        }
	        return values;
	    }
	    
	    public static Map<String, String> getFirstNonEmptyRowValues(
		        String filePath, String sheetName, List<String> columns, int headerRowIndex) throws IOException {

		    Map<String, String> result = new LinkedHashMap<>();
		    try (FileInputStream fis = new FileInputStream(filePath);
		         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

		        XSSFSheet sheet = workbook.getSheet(sheetName);
		        if (sheet == null) return result;

		        Row header = sheet.getRow(headerRowIndex);
		        Map<String, Integer> colMap = new HashMap<>();
		        for (Cell cell : header) {
		            if (cell != null && cell.getCellType() == CellType.STRING)
		                colMap.put(cell.getStringCellValue().trim(), cell.getColumnIndex());
		        }

		        // Data starts after header
		        for (int r = headerRowIndex + 1; r <= sheet.getLastRowNum(); r++) {
		            Row row = sheet.getRow(r);
		            if (row == null) continue;

		            boolean valid = true;
		            for (String col : columns) {
		                int idx = colMap.getOrDefault(col, -1);
		                if (idx == -1) continue;
		                Cell c = row.getCell(idx);
		                if (c == null || c.toString().trim().isEmpty()) {
		                    valid = false;
		                    break;
		                }
		                result.put(col, c.toString().trim());
		            }
		            if (valid && !result.isEmpty()) return result;
		        }
		    }
		    return result;
		}
	    public static String getCellValueByIndex(XSSFSheet sheet, int rowNum, int colNum) {
		    Row row = sheet.getRow(rowNum);
		    if (row == null) return "";
		    Cell cell = row.getCell(colNum, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
		    return cell.toString().trim();
		}
	    
	    public static List<String> getDropdownValuesFromColumn(
	            XSSFWorkbook workbook, String sheetName, String columnName) {

	        Sheet sheet = workbook.getSheet(sheetName);
	        Map<String, Integer> headerMap = getHeaderMap(workbook, sheetName, 1);
	        if (!headerMap.containsKey(columnName)) return null;

	        int colIndex = headerMap.get(columnName);
	        List<? extends DataValidation> validations = sheet.getDataValidations();

	        for (DataValidation dv : validations) {
	            for (CellRangeAddress region : dv.getRegions().getCellRangeAddresses()) {
	                if (region.getFirstColumn() == colIndex) {
	                    DataValidationConstraint constraint = dv.getValidationConstraint();
	                    if (constraint != null && constraint.getExplicitListValues() != null) {
	                        return Arrays.asList(constraint.getExplicitListValues());
	                    }
	                }
	            }
	        }
	        return null;
	    }

	    public static Set<String> getDropdownValues(XSSFWorkbook workbook, String sheetName, String columnHeader) {
	        Set<String> values = new LinkedHashSet<>();
	        try {
	            XSSFSheet sheet = workbook.getSheet(sheetName);
	            if (sheet == null) {
	                LoggerUtil.error("Sheet not found: " + sheetName);
	                return values;
	            }

	            // 1. Find column index by header row (row 2 = index 1)
	            Row headerRow = sheet.getRow(1);
	            int colIndex = -1;
	            for (Cell cell : headerRow) {
	                if (cell != null && cell.getCellType() == CellType.STRING &&
	                    cell.getStringCellValue().trim().equalsIgnoreCase(columnHeader.trim())) {
	                    colIndex = cell.getColumnIndex();
	                    break;
	                }
	            }
	            if (colIndex == -1) {
	                LoggerUtil.error("Column not found: " + columnHeader + " in sheet " + sheetName);
	                return values;
	            }

	            // 2. Loop through validations in this sheet
	            List<? extends DataValidation> validations = sheet.getDataValidations();
	            for (DataValidation validation : validations) {
	                CellRangeAddressList addrList = validation.getRegions();
	                for (CellRangeAddress addr : addrList.getCellRangeAddresses()) {
	                    if (addr.getFirstColumn() == colIndex) {
	                        DataValidationConstraint constraint = validation.getValidationConstraint();

	                        // Case A: Explicit dropdown list
	                        if (constraint.getExplicitListValues() != null) {
	                            for (String v : constraint.getExplicitListValues()) {
	                                if (v != null && !v.trim().isEmpty()) {
	                                    values.add(v.trim());
	                                }
	                            }
	                        }

	                        // Case B: Formula range (like =CurrencyMaster!A2:A500)
	                        if (constraint.getFormula1() != null) {
	                            String formula = constraint.getFormula1();
	                            if (formula.contains("!")) {
	                                String[] parts = formula.split("!");
	                                String targetSheetName = parts[0].replace("=", "").replace("'", "").trim();
	                                String rangeRef = parts[1];

	                                if (rangeRef.contains(":")) {
	                                    String[] rangeSplit = rangeRef.split(":");
	                                    CellReference startRef = new CellReference(rangeSplit[0]);
	                                    CellReference endRef = new CellReference(rangeSplit[1]);

	                                    XSSFSheet targetSheet = workbook.getSheet(targetSheetName);
	                                    if (targetSheet != null) {
	                                        for (int r = startRef.getRow(); r <= endRef.getRow(); r++) {
	                                            Row row = targetSheet.getRow(r);
	                                            if (row == null) continue;
	                                            Cell cell = row.getCell(startRef.getCol());
	                                            if (cell == null) continue;
	                                            String val = cell.toString().trim();
	                                            if (!val.isEmpty()) {
	                                                values.add(val);
	                                            }
	                                        }
	                                    }
	                                }
	                            }
	                        }
	                    }
	                }
	            }

	            LoggerUtil.info("Dropdown values extracted for [" + columnHeader + "] in sheet [" + sheetName + "]: " + values);

	        } catch (Exception e) {
	            LoggerUtil.error("Error while extracting dropdown values for column: " + columnHeader + " - " + e.getMessage());
	        }
	        return values;
	    }
	    
	    public static String getCellValueByColumn(String filePath, String sheetName, String targetColumn,
				String supplierValue, String processValue, int headerRowIndex) throws IOException {
			try (FileInputStream fis = new FileInputStream(filePath); XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

				XSSFSheet sheet = workbook.getSheet(sheetName);
				if (sheet == null)
					return "";

				Map<String, Integer> colMap = getHeaderMap(workbook, sheetName, headerRowIndex);

				int supplierIdx = colMap.getOrDefault("Supplier", -1);
				int processIdx = colMap.getOrDefault("Process Name", -1);
				int targetIdx = colMap.getOrDefault(targetColumn, -1);
				if (supplierIdx == -1 || processIdx == -1 || targetIdx == -1)
					return "";

				for (int r = headerRowIndex + 1; r <= sheet.getLastRowNum(); r++) {
					Row row = sheet.getRow(r);
					if (row == null)
						continue;

					String s = ExcelUtil.getCellValueByIndex(sheet, r, supplierIdx);
					String p = ExcelUtil.getCellValueByIndex(sheet, r, processIdx);
					if (s.equalsIgnoreCase(supplierValue) && p.equalsIgnoreCase(processValue)) {
						return ExcelUtil.getCellValueByIndex(sheet, r, targetIdx);
					}
				}
			}
			return "";
		}
	    
	    public static String getCellValueByColumnCustomer(String filePath, String sheetName, String targetColumn,
				String supplierValue, String processValue, int headerRowIndex) throws IOException {
			try (FileInputStream fis = new FileInputStream(filePath); XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

				XSSFSheet sheet = workbook.getSheet(sheetName);
				if (sheet == null)
					return "";

				Map<String, Integer> colMap = getHeaderMap(workbook, sheetName, headerRowIndex);

				int customerIdx = colMap.getOrDefault("Customer", -1);
				int processIdx = colMap.getOrDefault("Process Name", -1);
				int targetIdx = colMap.getOrDefault(targetColumn, -1);
				if (customerIdx == -1 || processIdx == -1 || targetIdx == -1)
					return "";

				for (int r = headerRowIndex + 1; r <= sheet.getLastRowNum(); r++) {
					Row row = sheet.getRow(r);
					if (row == null)
						continue;

					String s = ExcelUtil.getCellValueByIndex(sheet, r, customerIdx);
					String p = ExcelUtil.getCellValueByIndex(sheet, r, processIdx);
					if (s.equalsIgnoreCase(supplierValue) && p.equalsIgnoreCase(processValue)) {
						return ExcelUtil.getCellValueByIndex(sheet, r, targetIdx);
					}
				}
			}
			return "";
		}
	    
	    public static int getColumnIndex(Sheet sheet, String columnName) {
		    // Header is in Excel row 2 → 0-based index = 1
		    Row headerRow = sheet.getRow(1);
		    if (headerRow == null) return -1;

		    for (int i = 0; i < headerRow.getLastCellNum(); i++) {
		        String headerText = getCellValue(headerRow.getCell(i)).trim();
		        if (headerText.equalsIgnoreCase(columnName)) {
		            return i;
		        }
		    }
		    return -1; // if column not found
		}
	    public static String getCellValue(Cell cell) {
		    if (cell == null) return "";

		    switch (cell.getCellType()) {
		        case STRING:
		            return cell.getStringCellValue().trim();

		        case NUMERIC:
		            // Convert numeric to plain string (no scientific notation)
		            double num = cell.getNumericCellValue();
		            if (num == (long) num) {
		                return String.valueOf((long) num); // integer format
		            } else {
		                return String.valueOf(num); // decimal format
		            }

		        case BOOLEAN:
		            return String.valueOf(cell.getBooleanCellValue());

		        case FORMULA:
		            try {
		                return cell.getStringCellValue();
		            } catch (IllegalStateException e) {
		                return String.valueOf(cell.getNumericCellValue());
		            }

		        default:
		            return "";
		    }
		}
	    
	    public static double safeParseDouble(String val) {
		    try { return Double.parseDouble(val.replaceAll("[^0-9.\\-]", "")); }
		    catch (Exception e) { return -9999; }
		}
	    
	    public static double getNumericValue(String filePath, String sheetName, int rowNum, String columnName) {
		    try (FileInputStream fis = new FileInputStream(filePath);
		         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

		        XSSFSheet sheet = workbook.getSheet(sheetName);
		        int colIndex = getColumnIndex(sheet, columnName);

		        Row row = sheet.getRow(rowNum - 1); // Excel rows start at 2, POI rows start at 1
		        Cell cell = row.getCell(colIndex);

		        FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
		        CellValue cellValue = evaluator.evaluate(cell);

		        if (cellValue == null) {
		            return 0.0;
		        }

		        switch (cellValue.getCellType()) {
		            case NUMERIC:
		                return cellValue.getNumberValue();
		            case STRING:
		                return Double.parseDouble(cellValue.getStringValue());
		            default:
		                return 0.0;
		        }
		    } catch (Exception e) {
		        throw new RuntimeException("Error reading numeric value from Excel: " + e.getMessage(), e);
		    }
		}
	    
	    public static String getStringValue(String filePath, String sheetName, int rowNum, String columnName) {
		    try (FileInputStream fis = new FileInputStream(filePath);
		         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

		        XSSFSheet sheet = workbook.getSheet(sheetName);
		        int colIndex = getColumnIndex(sheet, columnName);

		        Row row = sheet.getRow(rowNum - 1);
		        Cell cell = row.getCell(colIndex);

		        FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
		        CellValue cellValue = evaluator.evaluate(cell);

		        if (cellValue == null) {
		            return "";
		        }

		        switch (cellValue.getCellType()) {
		            case STRING:
		                return cellValue.getStringValue().trim();
		            case NUMERIC:
		                return String.valueOf(cellValue.getNumberValue());
		            default:
		                return "";
		        }
		    } catch (Exception e) {
		        throw new RuntimeException("Error reading string value from Excel: " + e.getMessage(), e);
		    }
		}
	    
	    /**
	     * Finds the column index within a header row for a given column name.
	     * Returns -1 if not found.
	     */
	    public static int findColumnIndex(Row headerRow, String columnName) {
	        if (headerRow == null) return -1;
	        DataFormatter formatter = new DataFormatter();

	        for (int i = 0; i < headerRow.getLastCellNum(); i++) {
	            Cell cell = headerRow.getCell(i);
	            if (cell == null) continue;

	            String cellValue = formatter.formatCellValue(cell).trim();
	            if (cellValue.equalsIgnoreCase(columnName)) {
	                return i;
	            }
	        }
	        return -1;
	    }
		
	    /**
	     * Finds the last non-empty row in the given Excel sheet.
	     * Skips trailing blank rows automatically.
	     */
	    public static int getLastNonEmptyRow(File file, String sheetName) throws Exception {
	        try (FileInputStream fis = new FileInputStream(file);
	             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
	            XSSFSheet sheet = workbook.getSheet(sheetName);
	            if (sheet == null) throw new IllegalArgumentException("Sheet not found: " + sheetName);

	            int lastRow = sheet.getLastRowNum();
	            for (int i = lastRow; i >= 0; i--) {
	                Row row = sheet.getRow(i);
	                if (row == null) continue;
	                boolean hasData = false;
	                for (Cell c : row) {
	                    String val = c.toString().trim();
	                    if (!val.isEmpty()) {
	                        hasData = true;
	                        break;
	                    }
	                }
	                if (hasData) return i + 1; // return Excel row number (1-based)
	            }
	            return 1; // fallback (header only)
	        }
	    }
	    
	    /**
	     * Dynamically reads a cell value from Excel by header name.
	     * Automatically detects header row, normalizes column names, and skips blanks.
	     */
	    public static String readCellValue(File file, String sheetName, int excelRowNo, String columnName) throws Exception {
	        int rowIndex = excelRowNo - 1;

	        try (FileInputStream fis = new FileInputStream(file);
	             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

	            XSSFSheet sheet = workbook.getSheet(sheetName);
	            if (sheet == null)
	                throw new IllegalArgumentException("Sheet not found: " + sheetName);

	            // STEP 1 → Dynamically locate the correct header row
	            Row headerRow = null;
	            int headerRowIndex = -1;
	            for (int i = 0; i <= 10; i++) { // Scan first 10 rows to find header row
	                Row r = sheet.getRow(i);
	                if (r != null) {
	                    int filledCells = 0;
	                    for (Cell c : r) {
	                        String val = getSafeCellText(c);
	                        if (!val.isEmpty()) filledCells++;
	                    }
	                    // Usually header row has "S.No." or multiple filled columns
	                    if (filledCells > 5 && getSafeCellText(r.getCell(0)).toLowerCase().contains("s.no")) {
	                        headerRow = r;
	                        headerRowIndex = i;
	                        break;
	                    }
	                }
	            }

	            // fallback: pick the first non-empty row if S.No. not found
	            if (headerRow == null) {
	                for (int i = 0; i <= 10; i++) {
	                    Row r = sheet.getRow(i);
	                    if (r != null && r.getPhysicalNumberOfCells() > 5) {
	                        headerRow = r;
	                        headerRowIndex = i;
	                        break;
	                    }
	                }
	            }

	            if (headerRow == null)
	                throw new IllegalArgumentException("❌ Unable to detect header row in sheet: " + sheetName);

	            LoggerUtil.info("📘 Detected header row at index: " + headerRowIndex);

	            // STEP 2 → Normalize target header name
	            String normalizedTarget = normalizeText(columnName);

	            // STEP 3 → Identify column index dynamically
	            int colIndex = -1;
	            for (Cell cell : headerRow) {
	                if (cell == null) continue;
	                String headerName = getSafeCellText(cell);
	                String normalizedHeader = normalizeText(headerName);

	                if (normalizedHeader.equals(normalizedTarget)
	                        || normalizedHeader.contains(normalizedTarget)
	                        || normalizedTarget.contains(normalizedHeader)) {
	                    colIndex = cell.getColumnIndex();
	                    LoggerUtil.info("✅ Matched Excel column '" + columnName + "' → '" + headerName + "'");
	                    break;
	                }
	            }

	            if (colIndex == -1) {
	                StringBuilder allHeaders = new StringBuilder();
	                for (Cell c : headerRow) allHeaders.append(getSafeCellText(c)).append(" | ");
	                LoggerUtil.error("❌ Column not found: " + columnName + " | Available headers: " + allHeaders);
	                throw new IllegalArgumentException("❌ Column not found: " + columnName);
	            }

	            // STEP 4 → Find last non-empty row (auto adjust)
	            int lastDataRow = findLastNonEmptyRow(sheet, colIndex);
	            if (rowIndex >= lastDataRow) rowIndex = lastDataRow; // adjust if too large

	            Row row = sheet.getRow(rowIndex);
	            if (row == null) return "";

	            Cell cell = row.getCell(colIndex);
	            return getCellValueEvaluated(cell, workbook);
	        }
	    }
	    /**
	     * Reads safe string from a cell regardless of its type.
	     */
	    private static String getSafeCellText(Cell cell) {
	        try {
	            if (cell == null) return "";
	            if (cell.getCellType() == CellType.STRING)
	                return cell.getStringCellValue().trim();
	            else if (cell.getCellType() == CellType.NUMERIC)
	                return new java.text.DecimalFormat("#.###").format(cell.getNumericCellValue());
	            else
	                return cell.toString().trim();
	        } catch (Exception e) {
	            return "";
	        }
	    }
	    /**
	     * Normalizes text for robust header matching.
	     */
	    private static String normalizeText(String text) {
	        if (text == null) return "";
	        return text
	                .replaceAll("\\s+", "")
	                .replaceAll("[\\^_/\\-.]", "")
	                .replaceAll("³", "3")
	                .replaceAll("²", "2")
	                .replaceAll("[^\\p{ASCII}]", "")
	                .toLowerCase()
	                .trim();
	    }
	    /**
	     * Finds the last row in a sheet that has non-empty data in the given column.
	     */
	    private static int findLastNonEmptyRow(XSSFSheet sheet, int colIndex) {
	        int lastRow = sheet.getLastRowNum();
	        for (int i = lastRow; i >= 0; i--) {
	            Row r = sheet.getRow(i);
	            if (r != null) {
	                Cell c = r.getCell(colIndex);
	                if (c != null && !getSafeCellText(c).isEmpty()) {
	                    return i;
	                }
	            }
	        }
	        return lastRow;
	    }
	    
	    /**
	     * Reads all non-empty values from a specific column header in an Excel sheet.
	     * Automatically handles numeric, formula, and string cell types safely.
	     */
	    public static List<String> readColumnValues(File file, String sheetName, String columnName) throws Exception {
	        List<String> values = new ArrayList<>();
	        DataFormatter formatter = new DataFormatter();

	        try (FileInputStream fis = new FileInputStream(file);
	             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

	            XSSFSheet sheet = workbook.getSheet(sheetName);
	            if (sheet == null)
	                throw new IllegalArgumentException("Sheet not found: " + sheetName);

	            // Find the header row dynamically (search all rows until the target header appears)
	            Row headerRow = null;
	            int headerRowIndex = -1;
	            for (int i = 0; i <= 10 && i <= sheet.getLastRowNum(); i++) {
	                Row row = sheet.getRow(i);
	                if (row == null) continue;
	                for (Cell cell : row) {
	                    String cellText = formatter.formatCellValue(cell).trim();
	                    if (cellText.equalsIgnoreCase(columnName.trim())) {
	                        headerRow = row;
	                        headerRowIndex = i;
	                        break;
	                    }
	                }
	                if (headerRow != null) break;
	            }

	            if (headerRow == null)
	                throw new IllegalArgumentException("Header '" + columnName + "' not found in " + sheetName);

	            // Find column index
	            int colIndex = -1;
	            for (Cell cell : headerRow) {
	                String header = formatter.formatCellValue(cell).trim();
	                if (header.equalsIgnoreCase(columnName.trim())) {
	                    colIndex = cell.getColumnIndex();
	                    break;
	                }
	            }
	            if (colIndex == -1)
	                throw new IllegalArgumentException("Column not found: " + columnName);

	            // Read all non-empty values from that column
	            for (int i = headerRowIndex + 1; i <= sheet.getLastRowNum(); i++) {
	                Row row = sheet.getRow(i);
	                if (row == null) continue;

	                Cell cell = row.getCell(colIndex);
	                String val = (cell == null) ? "" : formatter.formatCellValue(cell).trim();

	                if (!val.isEmpty()) {
	                    values.add(val);
	                }
	            }
	        }
	        return values;
	    }

}