package com.pom;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BaseConfiguration;

public class loginMainPage extends BaseConfiguration {

	public loginMainPage() throws IOException, FileNotFoundException {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "input-1")
	WebElement username;
	@FindBy(id = "input-2")
	WebElement password;
	@FindBy(xpath = "//button[@type=\"submit\"]")
	WebElement submit;
	
	@FindBy(id = "//span[@class=\"username text-ellipsis\"]")
	WebElement activeUser;
	
	public void login(String user, String pwd) throws InterruptedException, FileNotFoundException, IOException {
		username.sendKeys(user);
		Thread.sleep(2000);
		password.sendKeys(pwd);
		Thread.sleep(2000);
		submit.click();
		Thread.sleep(2000);
	}

}
