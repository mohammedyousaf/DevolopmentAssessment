package secondquestion;

import java.io.File;
import java.util.Scanner;
import com.fasterxml.jackson.databind.JsonNode;


public class ExcelToJsonConverter {

	public static void main(String[] args) {

		CommonUtils utils = new CommonUtils();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Type the path of excel file");
		String path = scanner.nextLine();
		File excel = new File(path);
		JsonNode data = utils.excelToJson(excel);
		System.out.println("Excel file contains the Data:\n" + data);
		scanner.close();
	}
}