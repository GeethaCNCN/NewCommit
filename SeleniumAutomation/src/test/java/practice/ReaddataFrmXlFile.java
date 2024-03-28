package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReaddataFrmXlFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
//1.open the document in java readable format

		FileInputStream file = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");

		// 2.create a workbook

		Workbook wB = WorkbookFactory.create(file);
		// 3.navigate to required sheet
		Sheet sh = wB.getSheet("Contacts");

		// 4.navigate to required row
		Row row = sh.getRow(1);

		// 5.navigate to required cell
		Cell cell = row.getCell(2);

		// 6.capture the data
		String value = cell.getStringCellValue();
		System.out.println(value);
		// 7.close the workbook
		wB.close();
		
		
		String value1 = wB.getSheet("Contacts").getRow(3).getCell(4).getStringCellValue();
		System.out.println(value1);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
