package com.extent.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBase {
	
	public WebDriver driver;
	
	public void init() {
		String Browser = "chrome";
		if(Browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\100005482\\Downloads\\chromedriver.exe");
			ChromeOptions option =new ChromeOptions();
			option.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(option);
			
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://ishine.apmosys.com/#/login");
		
				
	}
	
//	https://ishine.apmosys.com/#/login
	
//	public static void main(String[] args) {
//		TestBase bs = new TestBase();
//		bs.init();
//	}

}
