package testscripts;

import org.testng.annotations.Test;

public class WindowPopupModelTest extends BaseTest{
	
	@Test
	public void handleWindowTest() {
		/**click on window popup modal*/
		commonLibObj.click(seleniumPlaygroundPageObj.windowPopupModel_link(), "windowPopupModel_link");
		
		/**click on likeusfacebook and provide value to email editbox*/
		commonLibObj.click(windowPopupModelPageObj.likeUsOnFacebook_link(), "likeUsOnFacebook_link");
		commonLibObj.handleWindow("window1");
		
		try {
			commonLibObj.sendKeys(windowPopupModel_FacebookPageObj.email_editbox(), "email_editbox", "abc@gmail.com");
		}catch(Exception e) {
			
		}
		
		/***come back to main window and click on follow twiter**/
		commonLibObj.handleWindow("window0");
		commonLibObj.click(windowPopupModelPageObj.followOnTwitter_link(), "followOnTwitter_link");

	}

}
