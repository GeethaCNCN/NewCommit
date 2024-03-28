package practice;


import static org.testng.Assert.fail;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class DWS {

	WebDriver driver;

	@Test(retryAnalyzer = genericUtilities.RetryAnalyserImplementation.class)

	public void login() {

		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://demowebshop.tricentis.com/login");
		driver.findElement(By.id("Email")).sendKeys("hello@1234.gmail.com");

		try {
			driver.findElement(By.id("Pasword")).sendKeys("amd@123");
		} catch (NoSuchElementException n) {
			System.out.println("Wrong locator");
		}

		// NoSuchElement
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		driver.quit();
	}

}
