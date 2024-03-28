package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class Scenario5 {

	static String firstName = "Siri";
	static String lastName = "Rao";
	static String mailId = "hello123@gmail.com";
	static long mobile = 9712345601l;

	public static void main(String[] args) {

		WebDriver driver = new EdgeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("http://localhost:8888/index.php");

		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.xpath("//a[.='Contacts']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();

		WebElement name = driver.findElement(By.name("salutationtype"));
		Select s = new Select(name);
		s.selectByVisibleText("Mrs.");

		WebElement fName = driver.findElement(By.name("firstname"));
		fName.sendKeys("Siri");
		WebElement lName = driver.findElement(By.name("lastname"));
		lName.sendKeys("Rao");
		// driver.findElement(By.id("account_id")).sendKeys("Wipro");
		driver.findElement(By.xpath("//img[@alt=\"Select\"]")).click();
		WebElement leadSrc = driver.findElement(By.name("leadsource"));
		Select s1 = new Select(leadSrc);
		s1.selectByVisibleText("Employee");
		driver.findElement(By.id("title")).sendKeys("QA Engineer");
		driver.findElement(By.id("department")).sendKeys("Engineering");
		driver.findElement(By.id("email")).sendKeys("hello123@gmail.com");
		driver.findElement(By.id("assistant")).sendKeys("Sana");
		driver.findElement(By.id("assistantphone")).sendKeys("9814264748");
		driver.findElement(By.name("emailoptout")).click();
		driver.findElement(By.name("reference")).click();
		driver.findElement(By.name("notify_owner")).click();

		driver.findElement(By.id("phone")).sendKeys("0809621564627");
		driver.findElement(By.id("mobile")).sendKeys("9712345601");
		driver.findElement(By.id("homephone")).sendKeys("08012348765");
		driver.findElement(By.id("otherphone")).sendKeys("9812376510");
		driver.findElement(By.id("fax")).sendKeys("123");
		driver.findElement(By.name("birthday")).sendKeys("2009-06-16");
		// driver.findElement(By.id("jscal_trigger_birthday")).click;

		driver.findElement(By.name("contact_name")).sendKeys("Ram");
		driver.findElement(By.name("secondaryemail")).sendKeys("siri123@gmail.com");
		driver.findElement(By.name("donotcall")).click();
		driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();

		WebElement assgndGrp = driver.findElement(By.name("assigned_group_id"));

		Select s3 = new Select(assgndGrp);
		s3.selectByVisibleText("Support Group");

		driver.findElement(By.name("portal")).click();
		driver.findElement(By.id("jscal_field_support_start_date")).sendKeys("2024-02-20");
		driver.findElement(By.id("jscal_field_support_end_date")).sendKeys("2025-02-26");

		driver.findElement(By.name("mailingstreet")).sendKeys("#21,Sathya,7th cross,Bangalore");
		driver.findElement(By.id("mailingpobox")).sendKeys("560072");
		driver.findElement(By.id("mailingcity")).sendKeys("Bangalore");
		driver.findElement(By.id("mailingstate")).sendKeys("Karnataka");
		driver.findElement(By.id("mailingzip")).sendKeys("560042");
		driver.findElement(By.id("mailingcountry")).sendKeys("India");
		driver.findElement(By.xpath("(//input[@name='cpy'])[2]")).click();

		driver.findElement(By.name("description")).sendKeys("Hello,Siri here");
		WebElement upload = driver.findElement(By.name("imagename"));
		// upload.click();
		// sendKeys("C:\\Users\\Geetha\\Desktop\\hello geetha here.txt");
		upload.sendKeys("C:\\Users\\Geetha\\Desktop\\hello geetha here.txt");

		// WebElement fName = driver.findElement(By.name("firstname"));
		// WebElement lName = driver.findElement(By.name("lastname"));

		if (firstName.contains("Siri")) {
			System.out.println("Pass");

			if (lastName.contains("Rao")) {
				System.out.println("Pass");

				if (mailId.contains("hello123@gmail.com")) {
					System.out.println("Pass");

				} else {
					System.out.println("Fail");
				}

			} else {

				System.out.println("Fail");
			}

		} else {

			System.out.println("Fail");
		}

	}

}
