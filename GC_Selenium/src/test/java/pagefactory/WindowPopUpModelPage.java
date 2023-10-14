package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WindowPopUpModelPage {
	
	
	public WindowPopUpModelPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//a[@title='Follow @Lambdatesting on Facebook']")
	private WebElement likeUsOnFacebook_link;
	
	public WebElement likeUsOnFacebook_link() {
		return likeUsOnFacebook_link;
	}
	
	@FindBy(xpath="//a[@title='Follow @Lambdatesting on Twitter']")
	private WebElement followOnTwitter_link;
	
	public WebElement followOnTwitter_link() {
		return followOnTwitter_link;
	}

}
