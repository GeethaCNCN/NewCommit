package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consists of Generic methods related to Excel file
 * 
 * @author Geetha
 */

public class ExcelFileUtility {

	/**
	 * This method will read data from exile file and return the value to the Caller
	 * @param j 
	 * @param i 
	 * @param string 
	 * @return 
	 * 
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */

	public String readDataFrmExcel(String string, int i, int j) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");

		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet("Contacts").getRow(1).getCell(2).getStringCellValue();

		System.out.println(value);
		return value;
	}

}
