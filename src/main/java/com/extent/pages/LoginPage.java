package com.extent.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.extent.base.TestBase;

public class LoginPage {
	
	public LoginPage(WebDriver driver){
		super();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='username']")
	WebElement userName;
	
	@FindBy(xpath = "//input[@id='userPassword']")
	WebElement passWord;
	
	@FindBy(xpath = "//button[contains(text(),'SIGN IN')]")
	WebElement SignInBtn;
	
	public void enterUsername(String name) {
		userName.sendKeys(name);
	}
	
	public void enterPassword(String pass) {
		passWord.sendKeys(pass);
	}
	
	public boolean CheckSigninBtn() {
		boolean s = SignInBtn.isDisplayed();
		return s;
	}

}
