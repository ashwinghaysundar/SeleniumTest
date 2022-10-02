package com.testcase;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.slf4j.Logger;
import org.testng.Assert;

import com.pom.HomePage;
import com.pom.loginMainPage;
import com.pom.loginPage_1;
import com.pom.loginPage_2;
import com.util.TestConstants;
import com.util.TestUtils;

import Base.BaseConfiguration;

public class HomePageTest extends BaseConfiguration {

	public loginPage_1 login1;
	public loginPage_2 login2;
	public loginMainPage loginPage;
	public HomePage homePage;
	public String username;
	public String password;

	public HomePageTest() throws IOException, FileNotFoundException {
		super();
	}

	@BeforeMethod
	public void setUp() throws FileNotFoundException, IOException {
		initilization();

		username = prop.getProperty("username");
		password = prop.getProperty("password");

		login1 = new loginPage_1();
		login2 = new loginPage_2();
		loginPage = new loginMainPage();
		homePage = new HomePage();

	}

	@Test(enabled = true)
	public void activeUser_tc01() throws FileNotFoundException, InterruptedException, IOException {
		System.out.println("Inside TC01");
		login1.clickOnLoginLink();
		Thread.sleep(2000);
		login2.clickOnLoginButton();
		Thread.sleep(2000);
		loginPage.login(username, password);
		Thread.sleep(3000);
		TestUtils.waitForPageLoad();
		String title = TestUtils.getTitle();
		// log.info("PageTitle: ", title);
		System.out.println("PageTitle: " + title);
		Assert.assertEquals(title, TestConstants.HOMEPAGE_TITLE, "Title not matched");

		String actualUser = homePage.getActiveUser();
		System.out.println("Actual User: " + actualUser);
		String expectedUser = username.split("@")[0];
		System.out.println("ExpectedUser: " + expectedUser);
		Assert.assertEquals(actualUser, expectedUser, "Active user not matched..");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
