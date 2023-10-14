package ab.GC_Selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    public static void main(String[] args) throws InterruptedException {
    	String url="https://www.gmail.com";
		//Launch the browser
    	System.out.println("Launch the browser");
    	System.setProperty("webdriver.chrome.driver", "../GC_Selenium/Drivers/chromedriver.exe");
    	WebDriver driver=new ChromeDriver();
    	Thread.sleep(3000);
    	
    	//Navigate to url
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    	System.out.println("Navigate to url:"+url);
    	driver.navigate().to(url);
    	Thread.sleep(3000);
    	
    	//driver functions
    	driver.manage().window().maximize();
    	System.out.println(driver.getCurrentUrl());
    	System.out.println(driver.getTitle());
    	System.out.println(driver.getWindowHandle());
    	System.out.println(driver.getWindowHandles());
    	
    	//identify the webelement
    	WebElement createAccount_link=driver.findElement(By.xpath("//span[text()='Create account']"));
    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.elementToBeClickable(createAccount_link));
    	
    	//perform the action
    	createAccount_link.click();
    	Thread.sleep(3000);
    	
    	System.out.println(createAccount_link.getAttribute("jsname"));
    	System.out.println(createAccount_link.getText());
    	System.out.println(createAccount_link.getTagName());
    	System.out.println(createAccount_link.isDisplayed());
    	System.out.println(createAccount_link.isEnabled());
    	System.out.println(createAccount_link.isSelected());
    	
    	WebElement forMyPersonalUse_link=driver.findElement(By.xpath("//span[text()='For my personal use']"));
    	forMyPersonalUse_link.click();
    	Thread.sleep(3000);
    	
    	
    	driver.navigate().back();
    	Thread.sleep(3000);
    	driver.navigate().forward();
    	Thread.sleep(3000);
    	driver.navigate().refresh();
    	//close the browser
    	driver.quit();
    	
    	
    	//wait---
    	//Java wait--Thread.sleep()-10sec--2sec,8 sec
    	//implicitwait--20sec--6sec, wait until page gets loaded
    	//explicit wait--20sec ---entire-10sec, element-2sec
    	//fluent wait-
    	
	}
    
}
