package testngex;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HandlingPopups {
	WebDriver driver;
	@BeforeMethod
	public void bm() {
		Browser browserObj=new Browser();
		driver=browserObj.getBrowser("chrome","../GC_Selenium/Drivers/chromedriver.exe");
		
	}
	@AfterMethod
	public void am() {
		driver.quit();
	}
	
	@Test
	public void handleAlerts() throws InterruptedException {
		
		/****Handling alerts ***/
		driver.get("https://www.lambdatest.com/selenium-playground/javascript-alert-box-demo");
		WebElement alertPopup=driver.findElement(By.xpath("//p[contains(text(),'Confirm box')]/button[text()='Click Me']"));
		alertPopup.click();
		Thread.sleep(3000);
		Alert alt=driver.switchTo().alert();
		System.out.println(alt.getText());
		alt.dismiss();
		
		alertPopup.click();
		Thread.sleep(3000);
		alt.accept();
		
		
	}
	
	@Test
	public void handleWindow() throws InterruptedException {

		driver.get("https://www.lambdatest.com/selenium-playground/window-popup-modal-demo");
		
		WebElement likeUsOnFacebook_link=driver.findElement(By.xpath("//a[@title=\"Follow @Lambdatesting on Facebook\"]"));
		likeUsOnFacebook_link.click();
		Thread.sleep(3000);
		
		Set set=driver.getWindowHandles();
		List<String> windows=new LinkedList(set);
		System.out.println(windows);
		
		driver.switchTo().window(windows.get(1));
		Thread.sleep(5000);
		
		WebElement email_editbox=driver.findElement(By.xpath("//label[@aria-label=\"Email address or phone number\"]//input"));
		//new Actions(driver).sendKeys(email_editbox,"abc@gmail.com").build().perform();
		email_editbox.sendKeys("abc@gmail.com");
		Thread.sleep(3000);
		
		driver.switchTo().window(windows.get(0));
		WebElement followOnTwitter_link=driver.findElement(By.xpath("//a[@title=\"Follow @Lambdatesting on Twitter\"]"));
		followOnTwitter_link.click();
		Thread.sleep(3000);
		
	
	}
	
	//@Test
	public void handleFrames() {
		
	}

}
