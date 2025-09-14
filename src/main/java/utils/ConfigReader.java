package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	public static Properties intializeProperties() {
		Properties value = new Properties();
		try (FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "/src/test/resources/config/data.properties")) {
			value.load(file); // read key=value pairs
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}
}
