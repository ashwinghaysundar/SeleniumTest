package com.pom;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.util.TestUtils;

import Base.BaseConfiguration;

public class loginPage_2 extends BaseConfiguration {

	public loginPage_2() throws IOException, FileNotFoundException{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"post-175\"]/div//div[1]/div//div[2]/div[2]//div[4]/div//a")
	WebElement loginButton;
	
	public void clickOnLoginButton() {
		TestUtils.implicitWait();
		loginButton.click();
	}


}
