package com.extent.testcase;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.extent.base.TestBase;
import com.extent.pages.LoginPage;
import com.extent.utils.TestUtils;

public class LoginTest extends TestBase {
	
	
	LoginPage loginPage;
	TestUtils testUtils;
	
	
	@BeforeTest
	public void Satrt() throws IOException {
		init();
		loginPage = new LoginPage(driver);
		testUtils = new TestUtils(driver);
		testUtils.extentReport();
		testUtils.testCaseCreate("Practice");
	}
	
	@Test(priority = 1)
	public void m1() throws IOException {	
		loginPage.enterUsername("biswajit.sahoo@apmosys.com");	
		testUtils.passTestCase("Enter user name");
	}
	
	
	@Test(priority = 2)
	public void m2() throws IOException {
		try {
		loginPage.enterPassword("Welcome@2022") ;
		testUtils.passTestCase("Enter password");
		}
		catch(Exception e) {
			testUtils.failTestCase("Enter password");
		}
	}
	
	@Test(priority = 3)
	public void m3() throws IOException {	
		boolean b = loginPage.CheckSigninBtn();	
		Assert.assertTrue(b);
		testUtils.failTestCase("Check signbtn");
	}
	
	@AfterTest
	public void TeadrDown() {
		testUtils.ExtentFlush();
		driver.quit();
	}

}
