package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {

	
	//@FindBy(xpath = "//img[@title='Create Contact....]")
	
	@FindBy(xpath="//img[@title='Create Contact...']")
	
	private WebElement createContactLookUpImg;
	
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public WebElement getCreateContactLookUpImg() {
		return createContactLookUpImg;
	}

	public void clickOnCreateContactLookUpImg() {

		createContactLookUpImg.click();

	}
	
	
	

}