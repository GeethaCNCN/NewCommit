package practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class More {

	public static void main(String[] args) {

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.navigate().to("http://localhost:8888/index.php?module=Emails&action=index");

		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.xpath("//a[.='More']")).click();
		driver.findElement(By.name("Price Books")).click();

		// driver.findElement(By.name("search_text")).click();
		driver.findElement(By.name("search_text")).sendKeys("abc");
		WebElement searchField = driver.findElement(By.name("search_field"));

		Select s = new Select(searchField);

		s.selectByVisibleText("Active");
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.xpath("//td[.='G']")).click();
		
		WebElement quick = driver.findElement(By.id("qccombo"));
		
		Select s1 = new Select(quick);
		
	//	s1.selectByValue("Calender");		
		s1.selectByVisibleText("New Project Milestone");
		driver.findElement(By.name("projectmilestonename")).sendKeys("Hello123");
		driver.findElement(By.id("jscal_field_projectmilestonedate")).sendKeys("2024-02-26");
		driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
		driver.findElement(By.xpath("//input[@value='T']")).click();
		driver.findElement(By.id("projectid_display")).sendKeys("Geetha123");
		driver.findElement(By.xpath("//input[@accesskey=\"S\"]")).click();
		driver.switchTo().alert().accept();
		driver.findElement(By.id("projectid_display")).click();
		driver.findElement(By.xpath("//img[@alt=\"Select\"]")).click();
		
		
		String parent = driver.getWindowHandle();
		System.out.println(parent);
		
		Set<String> child = driver.getWindowHandles();
		System.out.println(child);
		child.remove(parent);
 
		for (String string : child) {
			driver.switchTo().window(string);
		}
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//body[@class=\"small\"]")).click();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
