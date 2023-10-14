package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumPlayGround_SimpleFormDemoPage {
	
	public SeleniumPlayGround_SimpleFormDemoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user-message")
	private WebElement enterMessage_editbox;
	
	public WebElement enterMessage_editbox() {
		return enterMessage_editbox;
	}
	
	@FindBy(id="showInput")
	private WebElement getCheckedValue_button;
	
	public WebElement getCheckedValue_button() {
		return getCheckedValue_button;
	}
	
	@FindBy(id="message")
	private WebElement yourMessage_visibleText;
	
	public WebElement yourMessage_visibleText() {
		return yourMessage_visibleText;
	}

}
