package practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.ContactInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class ScenarioWithDDtAndGU {

	public static void main(String[] args) throws IOException, InterruptedException {

		// create object of all Utility classes

		PropertyFileUtility pUtil = new PropertyFileUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		SeleniumUtility sUtil = new SeleniumUtility();

		String URL = pUtil.readDataFrmPropertyFile("url");
		String USERNAME = pUtil.readDataFrmPropertyFile("username");
		String PASSWORD = pUtil.readDataFrmPropertyFile("password");

		String LASTNAME = eUtil.readDataFrmExcel("Contacts", 1, 2);
		// String LASTNAME =
		// wb.getSheet("Contacts").getRow(1).getCell(2).getStringCellValue();

		WebDriver driver = new EdgeDriver();
		sUtil.maximizeWindow(driver);

		// driver.manage().window().maximize();

		sUtil.implictWait(driver);

		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get(URL);

		/*
		 * driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		 * driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		 * driver.findElement(By.id("submitButton")).click();
		 */

		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		/*
		 * lp.getUserNameEdt().sendKeys(USERNAME);
		 * lp.getPasswordEdt().sendKeys(PASSWORD); lp.getSubmitBtn().click();
		 */

		// ContactsPage cp=new ContactsPage(driver);
		HomePage hp = new HomePage(driver);
		hp.clickOnContactsLink();

		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactLookUpImg();

		CreateNewContactPage cnp = new CreateNewContactPage(driver);
		cnp.createNewContact(LASTNAME);
		/*
		 * // cnp.
		 * 
		 * driver.findElement(By.linkText("Contacts")).click();
		 * driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		 * 
		 * 
		 * driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		 * 
		 * driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		 * 
		 * String headerText =
		 * driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		 * System.out.println(headerText);
		 * 
		 * if (headerText.contains(LASTNAME)) {
		 * 
		 * System.out.println("PASS"); } else { System.out.println("FAIL"); }
		 */
		
		// 6.Validate for Contact

				ContactInfoPage cip = new ContactInfoPage(driver);
				String contactHeader = cip.captureHeaderText();
				System.out.println(contactHeader);

				if (contactHeader.contains(LASTNAME)) {

					System.out.println("PASS");
				} else {
					System.out.println("FAIL");
				}

				// 7.Logout of App
				hp.logoutOfApp(driver);

				// 8.Close the browser
				driver.quit();
	}

}
