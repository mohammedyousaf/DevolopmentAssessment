package datamanager;

import com.fasterxml.jackson.databind.JsonNode;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DataManager {

	static Logger logger = LogManager.getLogger(DataManager.class);

	public static void main(String[] args) throws Exception {

		CommonUtils utils = new CommonUtils();
		Scanner scanner = new Scanner(System.in);

		logger.info(
				"Type which program to run\n\n Type 1 to display excel file in Json \n Type 2 to upload excel file to Database\n Type 3 to display database in Json format\n");
		String chooser = scanner.nextLine();

		if (chooser.equals("1")) {

			// Excel to json converter
			File file = new File("C:\\Users\\ecs\\Desktop\\ECS training\\resources\\" + "Book1.xlsx");
			String path = file.getAbsolutePath();
			File excel = new File(path);
			JsonNode data = utils.excelToJson(excel);
			logger.info("Excel file contains the Data:\n{}", data);

		}

		if (chooser.equals("2")) {

			// Excel to database uploader
			String dbName = "student_data";
			File file = new File("C:\\Users\\ecs\\Desktop\\ECS training\\resources\\" + "Book1.xlsx");
			String path = file.getAbsolutePath();
			String userName = "root";
			String password = "abc123!@#";
			utils.excelToDb(path, dbName, userName, password);
		}

		if (chooser.equals("3")) {

			// database to json converter
			GsonBuilder gsonBuilder = new GsonBuilder();
	        Gson gson = gsonBuilder.create();
			ArrayList<HashMap<String, Object>> array=new ArrayList<HashMap<String, Object>>();
			CommonUtils.dbToJson(array);
			String jsonOject = gson.toJson(array);
			logger.info("{\"student_data\":{}}",jsonOject);

		}

		scanner.close();

	}
}