package assignments.assignment9_DataDrivenTesting;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcelData {

	private InputStream oFileReader;
	private Workbook myWorkBook;

	public Object[][] createDataArray(String sFileName, String sSheetName) {
		String[][] dataArray = null;
		openExcelWorkBook(sFileName);
		int rows = getRowCountOfSheet(sSheetName);
		int cells = getCellCount(sSheetName, 1);
		dataArray = new String[rows][cells];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cells; j++) {
				dataArray[i][j] = getCellData(sSheetName, i, j);
				System.out.println(dataArray[i][j]);
			}
		}
		return dataArray;
	}

	public void openExcelWorkBook(String sFileName) {
		try {
			oFileReader = new FileInputStream(sFileName);
			myWorkBook = WorkbookFactory.create(oFileReader);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getRowCountOfSheet(String sSheetName) {
		try {
			Sheet mySheet;
			mySheet = myWorkBook.getSheet(sSheetName);
			System.out.println("Sheet Name: " + sSheetName);
			return mySheet.getPhysicalNumberOfRows();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	public int getCellCount(String sSheetName, int iRow) {
		try {
			Sheet mySheet;
			mySheet = myWorkBook.getSheet(sSheetName);
			Row myRow;
			myRow = mySheet.getRow(iRow - 1);
			return myRow.getLastCellNum();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

	}

	public String getCellData(String sSheetName, int iRow, int iCell) {
		Sheet mySheet;
		mySheet = myWorkBook.getSheet(sSheetName);
		Row myRow;
		myRow = mySheet.getRow(iRow);
		Cell myCell;
		myCell = myRow.getCell(iCell);
		if (myCell == null) {
			return "";
		} else {
			if (myCell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
				System.out.println("Cell Value" + String.valueOf((long) myCell.getNumericCellValue()));
				return String.valueOf((long) myCell.getNumericCellValue());
			} else {
				System.out.println("Cell Value :" + myCell.getStringCellValue());
				return myCell.getStringCellValue();

			}
		}

	}
}

