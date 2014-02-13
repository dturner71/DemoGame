package com.demoTests.example;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import screen.mainScreen;
import library.testBase;

public class demo extends testBase {

	@BeforeClass 
	@Parameters({"app","device","BROWSER_NAME","VERSION","PLATFORM","app_package","app_activity"})
	public void before(String app, String device, String BROWSER_NAME, String VERSION, String PLATFORM, String app_package, String app_activity) {
//		setDeviceType(!device.equals("iphone"));
		setup(app, device, BROWSER_NAME, VERSION, PLATFORM, app_package, app_activity);
	}

	@Test
	public void test01(){
		getWebElement(mainScreen.buttonProgressBar, true);

	}





	@AfterClass
	public void tearDown() throws Exception {
		//Close the app and simulator
		driver.quit();
	}
}