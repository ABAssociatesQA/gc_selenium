package ab.GC_Selenium;

import java.time.Duration;
import java.util.List;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Unit test for simple App.
 */
public class KeyBoard 
{
    public static void main(String[] args) throws InterruptedException {
    	String url="https://www.gmail.com";
		//Launch the browser
    	System.out.println("Launch the browser");
    	System.setProperty("webdriver.chrome.driver", "../GC_Selenium/Drivers/chromedriver.exe");
    	WebDriver driver=new ChromeDriver();
    	Thread.sleep(3000);
    	
    	driver.manage().window().maximize();
    	//Navigate to url
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    	System.out.println("Navigate to url:"+url);
    	driver.navigate().to(url);
    	Thread.sleep(3000);
    	
    	//identify the webelement
    	WebElement createAccount_link=driver.findElement(By.xpath("//span[text()='Create account']"));
    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.elementToBeClickable(createAccount_link));
    	
    	//perform the action
    	createAccount_link.click();
    	Thread.sleep(3000);

    	WebElement forMyPersonalUse_link=driver.findElement(By.xpath("//span[text()='For my personal use']"));
    	forMyPersonalUse_link.click();
    	Thread.sleep(3000);
    	
    	//firstName
    	WebElement firstName_editbox=driver.findElement(By.name("firstName"));
    	
    	Actions action=new Actions(driver);
    	action.sendKeys("Rakesh"+Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).build().perform();
    	Thread.sleep(3000);
    	
    	//handling dropdowns:
    	WebElement language_dropdown=driver.findElement(By.xpath("//div[@aria-haspopup='listbox']"));
    	language_dropdown.click();
    	Thread.sleep(3000);
    	
    	List<WebElement> language_dropdownList=driver.findElements(By.xpath("//ul[@aria-label='Change language']/li/span/span"));
    	String expectedLanguage="‪English (United States)‬";
    	
    	for(int i=0;i<language_dropdownList.size();i++) {
    		WebElement element=language_dropdownList.get(i);
    		String actual=element.getText();
    		System.out.println(actual);
    		if(expectedLanguage.equals(actual)) {
    			System.out.println("Select language as :"+actual);
    			action.click(element).build().perform();
    			Thread.sleep(1000);
    			break;
    		}
    	}
    	
    	WebElement month_dropdown=driver.findElement(By.id("month"));
    	Select selectObj=new Select(month_dropdown);
    	
    	System.out.println(selectObj.getOptions());
    	System.out.println(selectObj.isMultiple());
    	selectObj.selectByIndex(3);
    	Thread.sleep(3000);
    	
    	selectObj.selectByValue("8");
    	Thread.sleep(3000);
    	
    	selectObj.selectByVisibleText("July");
    	Thread.sleep(3000);
    	
    	
    	
    	
    	
    	
    	driver.quit();
    	
    	
    	//wait---
    	//Java wait--Thread.sleep()-10sec--2sec,8 sec
    	//implicitwait--20sec--6sec, wait until page gets loaded
    	//explicit wait--20sec ---entire-10sec, element-2sec
    	//fluent wait-
    	
	}
    
}
