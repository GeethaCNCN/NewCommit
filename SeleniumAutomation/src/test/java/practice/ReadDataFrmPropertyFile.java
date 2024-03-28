package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFrmPropertyFile {

	public static void main(String[] args) throws IOException {

		// 1.Open the document in java readable format
		// only for property file, file input stream is used
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");

		// 2.Create an object of Properties class from Java.util

		Properties p = new Properties();

		// 3.Load the file input stream to propeties
		p.load(fis);

		// 4.provide the key and read the value

		String value = p.getProperty("url");
		System.out.println(value);

	}

}
