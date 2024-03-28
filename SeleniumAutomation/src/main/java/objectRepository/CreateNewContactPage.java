package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtility;

public class CreateNewContactPage extends SeleniumUtility {

	@FindBy(name = "lastname")
	private WebElement lastNameEdt;

	@FindBy(xpath = "//input[@name='button']")
	private WebElement saveBtn;

	@FindBy(name = "leadsource")
	private WebElement leadSourceDropDown;

	public CreateNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getLeadSourceDropDown() {
		return leadSourceDropDown;
	}

	public WebElement saveBtn() {
		return saveBtn;
	}

	public void createNewContact(String lastname) {
		lastNameEdt.sendKeys(lastname);
		saveBtn.click();
	}

	public void createNewContact(String lastname, String leadSourceValue) {
		lastNameEdt.sendKeys(lastname);
		handleDropDowm(leadSourceDropDown, leadSourceValue);
		saveBtn.click();

	}

}
