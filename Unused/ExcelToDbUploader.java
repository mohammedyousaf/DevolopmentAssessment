package secondquestion;

import java.sql.*;
import java.util.Scanner;


class ExcelToDbUploader {

	public static void main(String[] args) throws Exception {
		
		CommonUtils utils = new CommonUtils();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Type the name of database :");
		String dbName = scanner.nextLine();
		System.out.println("type the path of excel file");
		String path = scanner.nextLine();

		Connection conn = null;
		String userName = "root";
		String password = "abc123!@#";

		utils.excelToDb(path, dbName, userName, password);

	}

	
}
