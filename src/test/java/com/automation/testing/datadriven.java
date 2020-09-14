package com.automation.testing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class datadriven {

	public static void main(String[] args) throws IOException {
		File f = new File("C:\\Users\\HP\\workspace\\AutomationTesting\\Credentials.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);

		Sheet sheet = wb.getSheetAt(0);
		int rowsize = sheet.getPhysicalNumberOfRows();
		for (int i = 0; i < rowsize; i++) {
			Row row = sheet.getRow(i);

			int cellsize = row.getPhysicalNumberOfCells();
			for (int j = 0; j < cellsize; j++) {
				Cell cell = row.getCell(j);

				CellType celltype = cell.getCellType();
				if (celltype.equals(celltype.STRING)) {
					String stringCellValue = cell.getStringCellValue();
					System.out.println(stringCellValue);
				} else if (celltype.equals(celltype.NUMERIC)) {
					double numericCellValue = cell.getNumericCellValue();
					System.out.println(numericCellValue);
				}
			}
		}
		Cell createCell = wb.createSheet("Datas1").createRow(6).createCell(6);
		createCell.setCellValue("nithi");

		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
		wb.close();
		System.out.println("data added successfully");

	}
}
