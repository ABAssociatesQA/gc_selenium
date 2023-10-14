package testscripts;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import baseutils.ReadExcelData;

public class SimpleFormDemoTest extends BaseTest{
	
	@DataProvider
	public String[][] sampleFormData() {
		ReadExcelData re=new ReadExcelData();
		return re.readExcel();
	}
	
	@Test//(dataProvider="sampleFormData")
//	public void simpleFormDemoTest(String message,String details) {
	public void sampleFormDemoTest() {
	//	String value = message+","+details;

	//	System.out.println(message+","+details);
		String value="Message";
		commonLibObj.click(seleniumPlaygroundPageObj.simpleFormDemo_link(), "Simple form demo link");
		commonLibObj.sendKeys(seleniumPlayGround_SimpleFormDemoPageObj.enterMessage_editbox(), "enterMessage_editbox",
				value);
		commonLibObj.click(seleniumPlayGround_SimpleFormDemoPageObj.getCheckedValue_button(), "getCheckedValue_button");
		commonLibObj.verifyText(seleniumPlayGround_SimpleFormDemoPageObj.yourMessage_visibleText(), value);
	}
	
	
	

}
