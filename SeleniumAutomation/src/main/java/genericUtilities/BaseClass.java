package genericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import objectRepository.HomePage;
import objectRepository.LoginPage;

public class BaseClass {

	public PropertyFileUtility pUtil = new PropertyFileUtility();
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public SeleniumUtility sUtil = new SeleniumUtility();
	public static WebDriver driver;

	@BeforeSuite
	public void bsConfig() {

		System.out.println("<-----DB Connection successful------>");

	}

	@BeforeClass
	public void bcConfig() throws IOException {

		String URL = pUtil.readDataFrmPropertyFile("url");
		driver = new EdgeDriver();
		sUtil.maximizeWindow(driver);
		sUtil.implictWait(driver);
		driver.get(URL);

		System.out.println("<-----Browser launch iss successful------>");

	}

	@BeforeMethod
	public void bmConfig() throws IOException {
		String USERNAME = pUtil.readDataFrmPropertyFile("username");
		String PASSWORD = pUtil.readDataFrmPropertyFile("password");

		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println("<-------------Login successful--------------->");
	}

	@AfterMethod
	public void amConfig() throws InterruptedException {
		HomePage hp = new HomePage(driver);
		hp.logoutOfApp(driver);
		System.out.println("<---------------LOGOUT SUCCESSFULE----------------->");

	}

	@AfterClass
	public void acConfig() {
		driver.quit();
		System.out.println("<----------Browser closure successful----------->");
	}

	@AfterSuite
	public void asConfig() {
		System.out.println("<--------DB Cclosure is successful---------->");
	}

}
