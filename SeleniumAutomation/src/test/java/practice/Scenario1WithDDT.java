package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Scenario1WithDDT {

	public static void main(String[] args) throws IOException {

		// 1.Read the required data
		// read data from property file

		FileInputStream fisp = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");

		Properties p = new Properties();
		p.load(fisp);
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
				
		FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");

		Workbook wb = WorkbookFactory.create(fise);
		String LASTNAME = wb.getSheet("Contacts").getRow(1).getCell(2).getStringCellValue();
		
		
		WebDriver driver = new EdgeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get(URL);

		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();

		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		String headerText = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		System.out.println(headerText);

		if (headerText.contains(LASTNAME)) {

			System.out.println("PASS");
		} else {
			System.out.println("FAIL");
		}
		
	}

}
