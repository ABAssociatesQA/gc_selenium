package ab.GC_Selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {
	//htmltag[@att='value']
	//htmltag[@att='value' and @att1=value]
	//htmltag[@att='value' or @att1=value]
	//parentHtmlTag[htmltag[@att='value']]
	//htmltag[@att='value']/child
	//htmltag[@att='value']/following-sibling::htmltag
	//htmltag[@att='value']/preceding-sibling::htmltag
	//htmltag[text()='value']
	//htmltag[contains(@att,'value')]
	//htmltag[contains(text(),'value')]
	
	
	
	public static void main(String[] args) throws InterruptedException {
		String url="https://www.naukri.com/";
		//Launch the browser
    	System.out.println("Launch the browser");
    	System.setProperty("webdriver.chrome.driver", "../GC_Selenium/Drivers/chromedriver.exe");
    	WebDriver driver=new ChromeDriver();
    	Thread.sleep(3000);
    	
    	//Navigate to url
    	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    	System.out.println("Navigate to url:"+url);
    	driver.navigate().to(url);
    	Thread.sleep(3000);
    	
    	WebElement companies_link=driver.findElement(By.xpath("//div[text()='Companies']"));
    	WebElement companies_topCompanies_link=driver.findElement(By.xpath("//div[text()='Top companies']"));
    	
    	//Mouse hover operation
    	Actions action=new Actions(driver);
    	action.moveToElement(companies_link).click(companies_topCompanies_link).build().perform();
    	Thread.sleep(3000);
    	
    	
    	
    	driver.quit();
	}

}
