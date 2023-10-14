package ab.GC_Selenium;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class HandlingPopups {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "../GC_Selenium/Drivers/chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allows-origin=*");
		WebDriver driver=new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.get("https://timesofindia.indiatimes.com/sports/cricket/icc-world-cup/news/odi-world-cup-pakistan-presenter-leaves-india-due-to-personal-reasons-amid-backlash-over-old-anti-india-posts/articleshow/104289889.cms");
		
		System.out.println("switch to frame");
		WebElement havels_frame=driver.findElement(By.xpath("//iframe[@data-google-container-id='n']"));
		driver.switchTo().frame(havels_frame);
		Thread.sleep(3000);
		
		System.out.println("click on banner");
		WebElement banner=driver.findElement(By.id("ROS_Banner"));
		banner.click();
		Thread.sleep(3000);
		
		driver.switchTo().frame(1);
		driver.switchTo().frame(3);
		driver.switchTo().frame(5);
		driver.switchTo().defaultContent();
		
		
//		driver.get("https://www.lambdatest.com/selenium-playground/window-popup-modal-demo");
//		
//		WebElement likeUsOnFacebook_link=driver.findElement(By.xpath("//a[@title=\"Follow @Lambdatesting on Facebook\"]"));
//		likeUsOnFacebook_link.click();
//		Thread.sleep(3000);
//		
//		Set set=driver.getWindowHandles();
//		List<String> windows=new LinkedList(set);
//		System.out.println(windows);
//		
//		driver.switchTo().window(windows.get(1));
//		Thread.sleep(5000);
//		
//		WebElement email_editbox=driver.findElement(By.xpath("//label[@aria-label=\"Email address or phone number\"]//input"));
//		//new Actions(driver).sendKeys(email_editbox,"abc@gmail.com").build().perform();
//		email_editbox.sendKeys("abc@gmail.com");
//		Thread.sleep(3000);
//		
//		driver.switchTo().window(windows.get(0));
//		WebElement followOnTwitter_link=driver.findElement(By.xpath("//a[@title=\"Follow @Lambdatesting on Twitter\"]"));
//		followOnTwitter_link.click();
//		Thread.sleep(3000);
		
		/****Handling alerts ***/
//		driver.get("https://www.lambdatest.com/selenium-playground/javascript-alert-box-demo");
//		WebElement alertPopup=driver.findElement(By.xpath("//p[contains(text(),'Confirm box')]/button[text()='Click Me']"));
//		alertPopup.click();
//		Thread.sleep(3000);
//		Alert alt=driver.switchTo().alert();
//		System.out.println(alt.getText());
//		alt.dismiss();
//		
//		alertPopup.click();
//		Thread.sleep(3000);
//		alt.accept();
		
		driver.quit();
		
		
	}

}
