package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class consists of generic methods related to property file
 * 
 * @author Geetha
 */

//Before class need to add the description type /**
//Dont write main method inside Utility classes, Only generic methods should there 

public class PropertyFileUtility {

	/**
	 * This method will read data from property file and return the value of Caller
	 * 
	 * @param key
	 * @return
	 * @throws IOException
	 */

	public String readDataFrmPropertyFile(String key) throws IOException {

		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;

	}

}
