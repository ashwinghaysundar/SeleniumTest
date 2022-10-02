package com.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import Base.BaseConfiguration;

public class TestUtils extends BaseConfiguration{

	public TestUtils() throws IOException, FileNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("deprecation")
	public static void waitForPageLoad() {
		driver.manage().timeouts().pageLoadTimeout(TestConstants.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	}
	
	@SuppressWarnings("deprecation")
	public static void implicitWait() {
		driver.manage().timeouts().implicitlyWait(TestConstants.IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
	}
	
	public static String getTitle() throws InterruptedException {
		Thread.sleep(3000);
		return driver.getTitle();
	}
	
}
