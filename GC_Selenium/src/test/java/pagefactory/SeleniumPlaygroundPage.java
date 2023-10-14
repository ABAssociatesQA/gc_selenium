package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumPlaygroundPage {
	
	public SeleniumPlaygroundPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[contains(@href,'simple-form')]")
	private WebElement simpleFormDemo_link;
	
	public WebElement simpleFormDemo_link() {
		return simpleFormDemo_link;
	}
	
	@FindBy(xpath="//a[contains(@href,'radiobutton')]")
	private WebElement radioButtonDemo_link;
	
	public WebElement radioButtonDemo_link() {
		return radioButtonDemo_link;
	}
	
	@FindBy(xpath="//a[contains(@href,'iframe')]")
	private WebElement iframeDemo_link;
	
	public WebElement iframeDemo_link() {
		return iframeDemo_link;
	}
	
	@FindBy(xpath="//a[contains(@href,'window-popup')]")
	private WebElement windowPopupModel_link;
	
	public WebElement windowPopupModel_link() {
		return windowPopupModel_link;
	}
}
