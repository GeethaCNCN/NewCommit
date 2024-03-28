package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class consists of generic methods related to Selenium WebDriver
 * 
 * @author Geetha
 */

public class SeleniumUtility {

	/**
	 * This method will maximize the window
	 * 
	 * @param driver
	 */

	public void maximizeWindow(WebDriver driver) {

		driver.manage().window().maximize();

	}

	/**
	 * This method will minimize the window
	 */

	public void minimizeWindow(WebDriver driver) {

		driver.manage().window().minimize();
	}

	/**
	 * This method will add 15 seconds of implicitly wait
	 * 
	 * @param driver
	 */

	public void implictWait(WebDriver driver) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	/**
	 * This method will wait for 10 seconds for a webelement to be visible
	 * 
	 * @param driver
	 */
	public void waitForElementToBeVisible(WebDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(null));

	}

	/**
	 * This method will for
	 * 
	 * @param element
	 * @param index
	 */

	public void waitForElementToBeVisiblebyLocator(WebDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(null));

	}

	/*
	 * public void waitForElementToBeVisiblebyText(WebDriver driver) {
	 * 
	 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 * 
	 * 
	 * }
	 */

	/**
	 * This method will handle drop down by index
	 * 
	 * @param element
	 * @param index
	 */

	public void handleDropDowm(WebElement element, int index) {

		Select sel = new Select(element);
		sel.selectByIndex(index);

	}

	/**
	 * This method will handle drop down by value
	 * 
	 * @param element
	 * @param value
	 */

	public void handleDropDowm(WebElement element, String value) {

		Select sel = new Select(element);
		sel.selectByVisibleText(value);

	}

	/**
	 * This method will handle drop down by visible text
	 * 
	 * @param text
	 * @param element
	 */

	public void handleDropDowm(String text, WebElement element) {

		Select sel = new Select(element);
		sel.selectByVisibleText(text);

	}

	/**
	 * 
	 */

	public void mouseHoverAction(WebDriver driver, WebElement element) {

		Actions act = new Actions(driver);
		act.moveToElement(element);
	}

	public void rightClickAction(WebDriver driver) {

		Actions act = new Actions(driver);
		act.contextClick().perform();
	}

	public void doubleClickAction(WebDriver driver) {

		Actions act = new Actions(driver);
		act.doubleClick();
	}

	public void dragDropAction(WebDriver driver, WebElement src, WebElement dest) {

		Actions act = new Actions(driver);
		act.dragAndDrop(src, dest).perform();
	}

	public void scrollDownAction(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("Window.scrollBy(0,500)", "");

	}

	public void scrollUpAction(WebDriver driver) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("Window.scrollBy(0,500)", "");

	}

	public void scrollToElement(WebDriver driver, WebElement element) {

		Actions act = new Actions(driver);
		act.scrollToElement(element).perform();

	}

	public void handleFrame(WebDriver driver, int frameIndex) {
		driver.switchTo().frame(frameIndex);
	}

	public void handleFrame(WebDriver driver, String nameorID) {
		driver.switchTo().frame(nameorID);
	}

	public void handleFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	/**
	 * This method will accept the alert pop up
	 * 
	 * @param driver
	 */

	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * This method will cancel the alert pop up
	 * 
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * This method will enter text into alert pop up * @param driver
	 * 
	 * @param text
	 */

	public void enterTextAlert(WebDriver driver, String text) {
		driver.switchTo().alert().sendKeys(text);
	}

	/**
	 * This method will capture the alert text and return it to caller
	 * 
	 * @param driver
	 * @param text
	 */
	public String gettAlertText(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}

	/**
	 * This method will capture the screenshot and return the path to the caller
	 * @param driver
	 * @param ScreenshotName
	 * @return
	 * @throws IOException
	 */
	public String captureScreenshot(WebDriver driver, String ScreenshotName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\ScreenShots\\" + ScreenshotName + ".png");
		Files.copy(source, dst);

		return dst.getAbsolutePath();

	}

}
