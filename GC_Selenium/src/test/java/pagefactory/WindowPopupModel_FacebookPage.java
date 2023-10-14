package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WindowPopupModel_FacebookPage {
	
	public WindowPopupModel_FacebookPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//label[@aria-label='Email address or phone number']//input")
	private WebElement email_editbox;
	
	public WebElement email_editbox() {
		return email_editbox;
	}
	

}
