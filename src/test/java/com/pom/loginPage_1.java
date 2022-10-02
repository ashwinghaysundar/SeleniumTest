package com.pom;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BaseConfiguration;

public class loginPage_1 extends BaseConfiguration {

	public loginPage_1() throws IOException, FileNotFoundException{
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Login")
	WebElement loginLink;
	
	public void clickOnLoginLink() {
		loginLink.click();
	}
}
