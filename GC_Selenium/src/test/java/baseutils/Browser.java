package baseutils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

public class Browser {
	
	WebDriver driver;
	public WebDriver getBrowser(String browserName,String driverPath) {
		Reporter.log("Launching the "+browserName+" browser",true);
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", driverPath);
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--remote-allows-origin=*");
			driver=new ChromeDriver(options);
			
		}else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.firefox.driver", driverPath);
			driver=new FirefoxDriver();
			
		}
		driver.manage().window().maximize();
		
		return driver;
	}

}
