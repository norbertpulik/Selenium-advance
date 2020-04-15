package helpers;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader {

	private String excelPath;
	private Workbook excelData;

	public ExcelReader(String exelPath) throws IOException {
		FileInputStream fileInputStream = new FileInputStream(new File(exelPath));
		this.excelData = new XSSFWorkbook(fileInputStream);

	}

	public Sheet getSheetByName(String sheetName) {
		return excelData.getSheet(sheetName);
		
	}

}
