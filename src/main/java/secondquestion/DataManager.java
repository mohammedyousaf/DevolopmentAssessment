package secondquestion;

import java.sql.ResultSet;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.fasterxml.jackson.databind.JsonNode;

import java.io.File;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DataManager {

	static Logger logger = LogManager.getLogger(DataManager.class);

	@SuppressWarnings("unchecked")
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
			JSONObject jsonObject = new JSONObject();
			JSONArray array = new JSONArray();
			ResultSet result = utils.dbToJson();
			
			while (result.next()) {
				JSONObject studentRecord = new JSONObject();

				studentRecord.put("admission no", result.getInt("admission_no"));
				studentRecord.put("maths mark", result.getInt("maths"));
				studentRecord.put("name", result.getString("name"));
				studentRecord.put("physics mark", result.getInt("physics"));
				studentRecord.put("chemistry mark", result.getInt("chemistry"));
				array.add(studentRecord);
				
			}
			jsonObject.put("student_data", array);
			String json = jsonObject.toJSONString();
			logger.info(json);

		}

		scanner.close();

	}
}