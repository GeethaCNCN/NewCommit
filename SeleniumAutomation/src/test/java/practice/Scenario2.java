package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Scenario2 {

	// static WebDriver driver;

	public static void main(String[] args) {
		// public void contact() {

		/*
		 * driver.findElement(By.xpath("//a[.='Contacts']")).click(); } }
		 */

		WebDriver driver = new EdgeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("http://localhost:8888/index.php");

		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("")).click();
		
		 // driver.findElement(By.xpath("//a[.='Contacts']")).click(); } }


	}
}