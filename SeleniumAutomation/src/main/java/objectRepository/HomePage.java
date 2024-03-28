package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtility;

public class HomePage extends SeleniumUtility {

	@FindBy(linkText = "Contacts")
	private WebElement contactsLink;

	/*
	 * @FindBy(linkText = "Sign Out") private WebElement signOutEdt;
	 */
	
	@FindBy (xpath = "//a[.='Sign Out']")
	private WebElement signOutEdt;

	@FindBy(xpath = "//span[.=' Administrator']")
	private WebElement adminEdt;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement contactsLink() {
		return contactsLink;
	}

	public WebElement signOutEdt() {
		return signOutEdt;
	}

	public WebElement getadminEdt() {
		return adminEdt;
	}

	public void clickOnContactsLink() {
		contactsLink.click();

	}

	public void logoutOfApp(WebDriver driver) throws InterruptedException {
		mouseHoverAction(driver, adminEdt);
		Thread.sleep(2000);

		signOutEdt.click();
	}

}
