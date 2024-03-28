package contactTests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.ContactInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class CreateNewContactTest extends BaseClass {

	@Test (groups = "SmokeSuite")

	public void createContactWithMandatoryFields() throws IOException, InterruptedException {

		/*
		 * // create object of all Utility classes
		 * 
		 * PropertyFileUtility pUtil = new PropertyFileUtility(); ExcelFileUtility eUtil
		 * = new ExcelFileUtility(); SeleniumUtility sUtil = new SeleniumUtility();
		 * 
		 * // Read data from property file
		 * 
		 * String URL = pUtil.readDataFrmPropertyFile("url"); String USERNAME =
		 * pUtil.readDataFrmPropertyFile("username"); String PASSWORD =
		 * pUtil.readDataFrmPropertyFile("password");
		 */

		// Read data from Excel file
		String LASTNAME = eUtil.readDataFrmExcel("Contacts", 1, 2);

		/*
		 * // Launch the browser WebDriver driver = new EdgeDriver();
		 * sUtil.maximizeWindow(driver); sUtil.implictWait(driver);
		 * 
		 * driver.get(URL);
		 * 
		 * LoginPage lp = new LoginPage(driver); lp.loginToApp(USERNAME, PASSWORD);
		 */

		HomePage hp = new HomePage(driver);
		hp.clickOnContactsLink();
  
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactLookUpImg();

		CreateNewContactPage cnp = new CreateNewContactPage(driver);
		cnp.createNewContact(LASTNAME);

		// 6.Validate for Contact

		ContactInfoPage cip = new ContactInfoPage(driver);
		String contactHeader = cip.captureHeaderText();
		System.out.println(contactHeader);

		if (contactHeader.contains(LASTNAME)) {

			System.out.println("PASS");
		} else {
			System.out.println("FAIL");
		}

		 
		 
	}

}
