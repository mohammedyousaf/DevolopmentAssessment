package secondquestion;

import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public String strcellData(int row, int col, String path) throws IOException {

		XSSFWorkbook workbook = new XSSFWorkbook(path);
		XSSFSheet sheet = workbook.getSheet("sheet1");
		try {
			return sheet.getRow(row).getCell(col).getStringCellValue();
		} catch (RuntimeException e) {
			return "";
		} finally {
			workbook.close();
		}
	}

	public int numcellData(int row, int col, String path) throws IOException {

		XSSFWorkbook workbook = new XSSFWorkbook(path);
		XSSFSheet sheet = workbook.getSheet("sheet1");
		try {
			return (int) sheet.getRow(row).getCell(col).getNumericCellValue();
		} catch (RuntimeException e) {

			return 0;
		} finally {
			workbook.close();
		}

	}

	public int rowCount(String path) throws IOException {

		XSSFWorkbook workbook = new XSSFWorkbook(path);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		int rows = sheet.getPhysicalNumberOfRows();
		workbook.close();
		return rows;

	}

	public String gradeCalc(int mark) {

		String grade = "";
		if (mark > 90) {
			grade = "A1";
		}
		if (mark <= 90) {
			grade = "A2";
		}
		if (mark <= 80) {
			grade = "B1";
		}
		if (mark <= 70) {
			grade = "B2";
		}
		if (mark <= 60) {
			grade = "C1";
		}
		if (mark <= 50) {
			grade = "C2";
		}
		if (mark <= 40) {
			grade = "D";
		}
		if (mark <= 32) {
			grade = "E1";
		}
		if (mark <= 20) {
			grade = "E2";
		}

		return grade;
	}

	public float gradePointCalc(int mark) {

		int gradePoint = 0;

		if (mark > 90) {
			gradePoint = 10;
		}
		if (mark <= 90) {
			gradePoint = 9;
		}
		if (mark <= 80) {
			gradePoint = 8;
		}
		if (mark <= 70) {
			gradePoint = 7;
		}
		if (mark <= 60) {
			gradePoint = 6;
		}
		if (mark <= 50) {
			gradePoint = 5;
		}
		if (mark <= 40) {
			gradePoint = 4;
		}
		return gradePoint;
	}

}
