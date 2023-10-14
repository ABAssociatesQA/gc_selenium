package testngex;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test1 {
	
	
	//annoatations
	//@Test, @
	@BeforeSuite
	public void bs() {
		Reporter.log("BeforeSuite",true);
	}
	//@BeforeTest
	//@Parameters({"username","password","url"})
	public void bt(String username, String password, String url) {
		System.out.println(username);
		System.out.println(password);
		System.out.println(url);
		Reporter.log("Before Test",true);
		
	}
	@BeforeClass
	public void bc(){
		Reporter.log("Before class",true);

	}
	
	@BeforeMethod
	public void bm() {
		Reporter.log("Before method",true);

	}
	@AfterMethod
	public void am() {
		Reporter.log("after method",true);

	}
	@AfterClass()
	public void ac() {
		Reporter.log("after class",true);

	}
	@AfterTest
	public void at() {
		Reporter.log("after test",true);

	}
	@AfterSuite
	public void as() {
		Reporter.log("after suite",true);

	}
	@Test(priority = 1)
	public void test() {
		Reporter.log("in test",true);
	}
	
	@Test(priority=0)
	public void test1() {
		Reporter.log("in test1",true);
	}
	
	
}
