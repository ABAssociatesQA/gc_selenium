package testscripts;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import baseutils.Browser;
import baseutils.CommonLib;
import baseutils.Reports;
import pagefactory.SeleniumPlayGround_SimpleFormDemoPage;
import pagefactory.SeleniumPlaygroundPage;
import pagefactory.WindowPopUpModelPage;
import pagefactory.WindowPopupModel_FacebookPage;
import testdata.Constants;

public class BaseTest {
	WebDriver driver;
	CommonLib commonLibObj;
	
	SeleniumPlaygroundPage seleniumPlaygroundPageObj;
	SeleniumPlayGround_SimpleFormDemoPage seleniumPlayGround_SimpleFormDemoPageObj;
	WindowPopUpModelPage windowPopupModelPageObj;
	WindowPopupModel_FacebookPage windowPopupModel_FacebookPageObj;
	
	ExtentSparkReporter esr;
	ExtentReports extentReports;
	ExtentTest test;
	
	@BeforeTest
	public void beforeSuite() {
		esr=new ExtentSparkReporter("target/ExecutionReport.html");
		extentReports=new ExtentReports();
		extentReports.attachReporter(esr);
	}
	@AfterTest
	public void afterSuite() {
		extentReports.flush();
	}
	
	
	@BeforeMethod
	public void beforeMethod(Method method) {
		try{
			test=extentReports.createTest(method.getName());
		}catch(Exception e) {
			extentReports=new ExtentReports();
			extentReports.attachReporter(esr);
			test=extentReports.createTest("Deafult Test");
		}
		Browser browserObj=new Browser();
		driver=browserObj.getBrowser(Constants.browserName, Constants.driverpath);
		
		Reports.info("Navigating to url:"+Constants.url,test);
		driver.navigate().to(Constants.url);
		
		commonLibObj=new CommonLib(driver,Constants.milliseconds,test,true);
		seleniumPlaygroundPageObj=new SeleniumPlaygroundPage(driver);
		seleniumPlayGround_SimpleFormDemoPageObj=new SeleniumPlayGround_SimpleFormDemoPage(driver);
		windowPopupModelPageObj=new WindowPopUpModelPage(driver);
		windowPopupModel_FacebookPageObj=new WindowPopupModel_FacebookPage(driver);
	}
	
	@AfterMethod
	public void afterMethod() {
		
		driver.quit();
		
	}

}
