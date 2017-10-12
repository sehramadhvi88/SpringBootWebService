package com.madhvi.spring.data.bulk;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.ResourceUtils;

@SpringBootApplication
public class SpringDataBulkInsertApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataBulkInsertApplication.class, args);

		createJson("filename.txt", divisionHeader);
	}

	public static void createJson(String fileName, String header[]) {

		System.out.println("inside create json");
		String line = null;

		try {

			File file = ResourceUtils.getFile("classpath:static/" + fileName);
			FileReader fileReader = new FileReader(file);
			BufferedReader bReader = new BufferedReader(fileReader);
			JSONArray jArry = new JSONArray();
			while ((line = bReader.readLine()) != null) {
				System.out.println(line);

				String result[] = line.split("<>");
				int i = 0;
				JSONObject jObjd = new JSONObject();
				jArry.put(jObjd);
				for (String str : result) {
					if (!header[i].equals("no-match")) {
						
							jObjd.put(header[i], str);
						
					}
					i = i + 1;
				}
			}

			System.out.println(jArry.toString());

			bReader.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
