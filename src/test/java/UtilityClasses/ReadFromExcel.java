package UtilityClasses;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadFromExcel {

	public int getRowStart() {
		int rowstart = 0;
		try {
			ClassLoader classLoader = this.getClass().getClassLoader();
			FileInputStream file = new FileInputStream(classLoader.getResource("Mehul.xlsx").getFile());
			Workbook wb = WorkbookFactory.create(file);
			Sheet sheet = wb.getSheetAt(0);
			rowstart = sheet.getFirstRowNum();
			file.close();

		} catch (Exception e) {
			System.out.println("Exception occur in getting row start");
		}
		return rowstart;
	}
	

	public int getRowEnd() {
		int rowend = 0;
		try {
			ClassLoader classLoader = this.getClass().getClassLoader();
			FileInputStream file = new FileInputStream(classLoader.getResource("Mehul.xlsx").getFile());
			Workbook wb = WorkbookFactory.create(file);
			Sheet sheet = wb.getSheetAt(0);
			rowend = sheet.getLastRowNum();
			file.close();

		} catch (Exception e) {
			System.out.println("Exception occur in getting row End");
		}
		return rowend;
	}

	
	public int[] getExpectedResponseCodes() {
		int expectedresponseCode[] = new int[1000];
		try {
			ClassLoader classLoader = this.getClass().getClassLoader();
			FileInputStream file = new FileInputStream(classLoader.getResource("Mehul.xlsx").getFile());
			Workbook wb = WorkbookFactory.create(file);
			Sheet sheet = wb.getSheetAt(0);
			int rowStart = sheet.getFirstRowNum();
			int rowEnd = sheet.getLastRowNum();
			for (int i = rowStart + 1; i <= rowEnd; i++) {
				Row row = sheet.getRow(i);
				expectedresponseCode[i] = (int) row.getCell(2).getNumericCellValue();
			}

		} catch (Exception e) {
			System.out.println("Exception occur in getting responseCodes ");
		}
		return expectedresponseCode;
	}

	public String[] getUrls() {
		String[] Url = new String[1000];
		try {
			ClassLoader classLoader = this.getClass().getClassLoader();
			FileInputStream file = new FileInputStream(classLoader.getResource("Mehul.xlsx").getFile());
			Workbook wb = WorkbookFactory.create(file);
			Sheet sheet = wb.getSheetAt(0);
			int rowStart = sheet.getFirstRowNum();
			int rowEnd = sheet.getLastRowNum();
			for (int i = rowStart + 1; i <= rowEnd; i++) {
				Row row = sheet.getRow(i);
				Url[i] = row.getCell(1).getStringCellValue();

			}

		} catch (Exception e) {
			System.out.println("Exception occur in getting Url/'s ");
		}
		return Url;
	}

	public String[] getRequests() {
		String[] requests = new String[1000];
		try {
			ClassLoader classLoader = this.getClass().getClassLoader();
			FileInputStream file = new FileInputStream(classLoader.getResource("Mehul.xlsx").getFile());
			Workbook wb = WorkbookFactory.create(file);
			Sheet sheet = wb.getSheetAt(0);
			int rowStart = sheet.getFirstRowNum();
			int rowEnd = sheet.getLastRowNum();
			for (int i = rowStart + 1; i <= rowEnd; i++) {
				Row row = sheet.getRow(i);
				requests[i] = row.getCell(0).getStringCellValue();

			}

		} catch (Exception e) {
			System.out.println("Exception occur in getting requests ");
		}
		return requests;
	}

	public String[] getResponses() {
		String[] responses = new String[1000];
		try {
			ClassLoader classLoader = this.getClass().getClassLoader();
			FileInputStream file = new FileInputStream(classLoader.getResource("Mehul.xlsx").getFile());
			Workbook wb = WorkbookFactory.create(file);
			Sheet sheet = wb.getSheetAt(0);
			int rowStart = sheet.getFirstRowNum();
			int rowEnd = sheet.getLastRowNum();
			for (int i = rowStart + 1; i <= rowEnd; i++) {
				Row row = sheet.getRow(i);
				responses[i] = row.getCell(3).getStringCellValue();

			}

		} catch (Exception e) {
			System.out.println("Exception occur in getting responses");
		}
		return responses;
	}

	public String[] getData() {
		String[] data = new String[1000];
		try {
			ClassLoader classLoader = this.getClass().getClassLoader();
			FileInputStream file = new FileInputStream(classLoader.getResource("Mehul.xlsx").getFile());
			Workbook wb = WorkbookFactory.create(file);
			Sheet sheet = wb.getSheetAt(0);
			int rowStart = sheet.getFirstRowNum();
			int rowEnd = sheet.getLastRowNum();
			for (int i = rowStart + 1; i <= rowEnd; i++) {
				Row row = sheet.getRow(i);
				data[i] = row.getCell(4).getStringCellValue();
			}

		} catch (Exception e) {
			System.out.println("Exception occur in getting data");
		}
		return data;
	}

}

