package org.tditsolutions.qa.utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropConfig {

	private static PropConfig propConfig;

	private PropConfig() {

	}

	public static PropConfig getInstance() {
		if (propConfig == null) {
			propConfig = new PropConfig();
			return propConfig;
		} else {
			return propConfig;
		}
	}

	public static Properties load_prop(String env) throws IOException {
		String filePath = "";
		if (env.equals("QA")) {
			System.out.println(System.getProperty("user.dir"));
			String basePath = System.getProperty("user.dir");
			filePath = basePath + "\\src\\main\\resources\\config\\qa_config.properties";
			System.out.println(filePath);

		} else if (env.equals("UAT")) {
			System.out.println(System.getProperty("user.dir"));
			String basePath = System.getProperty("user.dir");
			filePath = basePath + "\\src\\main\\resources\\config\\uat_config.properties";
			System.out.println(filePath);
		}

		FileReader file = new FileReader(new File(filePath));
		Properties prop = new Properties();
		prop.load(file);
		return prop;
	}

}
