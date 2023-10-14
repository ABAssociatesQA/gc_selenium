package baseutils;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

public class CommonLib {
	
	public int milliseconds;
	WebDriver driver;
	ExtentTest test;
	boolean screenshot;
	public CommonLib(WebDriver driver,int milliseconds,ExtentTest test,boolean screenshot) {
		this.milliseconds=milliseconds;
		this.driver=driver;
		this.screenshot=screenshot;
		this.test=test;
		
	}
	
	public void smartSleep() {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}

	public void click(WebElement element, String webelementName) {
		Reporter.log("Click on "+ webelementName,true);
		test.info("Click on "+ webelementName);
		element.click();
		if(screenshot) {
		test.pass(MediaEntityBuilder.createScreenCaptureFromBase64String(((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64)).build());
		}
		smartSleep();
	}
	
	public void sendKeys(WebElement element, String webelementName, String value) {
		Reporter.log("Provide value to "+ webelementName+ " as "+value,true);
		test.info("Provide value to "+ webelementName+ " as "+value);
		try{
			element.clear();
		}catch(Exception e) {}
		element.sendKeys(value);
		smartSleep();
		if(screenshot) {
			test.pass(MediaEntityBuilder.createScreenCaptureFromBase64String(((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64)).build());
			}
	}
	public void verifyText(String expected, String actual) {
		if(expected.equals(actual)) {
			Reporter.log("The available text is as expected--->PASS", true);
			test.pass("The available text is as expected");
			if(screenshot) {
				test.pass(MediaEntityBuilder.createScreenCaptureFromBase64String(((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64)).build());
				}}else {
			Reporter.log("The available text is not as expected--->FAIL", true);
			test.fail("The available text is not as expected");
			test.fail(MediaEntityBuilder.createScreenCaptureFromBase64String(((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64)).build());
		}
	}
	
	public Actions actions() {
		Actions actions=new Actions(driver);
		return actions;
	}
	
	public void selectDropdown(WebElement dropdown,List<WebElement> dropdownList,String value, String webelementName) {
    	//dropdown.click();
		click(dropdown,webelementName);
    	
    	for(int i=0;i<dropdownList.size();i++) {
    		WebElement element=dropdownList.get(i);
    		String actual=element.getText();
    		System.out.println(actual);
    		if(value.equals(actual)) {
    			Reporter.log("Select value as :"+actual, true);
    			actions().click(element).build().perform();
    			smartSleep();
    			break;
    		}
    	}
	}
	
	public void handleWindow(String windowID) {
		List<String> list=new LinkedList(driver.getWindowHandles());
		String window="window";
		for(int i=0;i<list.size();i++) {
			System.out.println(windowID);
			window="window"+i;
			System.out.println(window);
			if(window.equals(windowID)) {
				Reporter.log("Switch to window",true);
				driver.switchTo().window(list.get(i));
				break;
			}
		}
	}
	
	
	
	
	
	public void verifyText(WebElement element,String expected) {
		String actual=element.getText();
		if(expected.equals(actual)) {
			Reporter.log("The available text is as expected--->PASS", true);
		}else {
			Reporter.log("The available text is as expected--->PASS", true);
		}
	}
	
	
}
