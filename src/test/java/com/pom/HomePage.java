package com.pom;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BaseConfiguration;

public class HomePage extends BaseConfiguration {

	public HomePage() throws IOException, FileNotFoundException{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class='username text-ellipsis']")
	WebElement activeUser;
	
	public String getActiveUser() throws InterruptedException {
		Thread.sleep(2000);
		return activeUser.getText();
	}

}
