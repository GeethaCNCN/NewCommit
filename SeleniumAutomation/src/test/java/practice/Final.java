package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Final extends Scenario2 {

	public static void main(String[] args) {

		WebDriver driver = new EdgeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("http://localhost:8888/index.php");

		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();

		driver.findElement(By.name("lastname")).sendKeys("Geetha C N");

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		String headerText = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		System.out.println(headerText);

		if (headerText.contains("Geetha C N")) {

			System.out.println("PASS");
		} else {
			System.out.println("FAIL");
		}

		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();

		WebElement sOut = driver.findElement(By.linkText("Sign Out"));

		Actions a = new Actions(driver);
		a.moveToElement(sOut).click().perform();
		
		driver.quit();

	}

}
