package com.testcase;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.slf4j.Logger;
import org.testng.Assert;
import com.pom.loginMainPage;
import com.pom.loginPage_1;
import com.pom.loginPage_2;
import com.util.TestConstants;
import com.util.TestUtils;

import Base.BaseConfiguration;

public class LoginTest extends BaseConfiguration {

	public loginPage_1 login1;
	public loginPage_2 login2;
	public loginMainPage loginPage;
	public Logger log;
	public String username;
	public String password;

	public LoginTest() throws IOException, FileNotFoundException {
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

	}

	@Test (enabled = true)
	public void getTitle_tc01() throws InterruptedException {
		System.out.println("Inside TC01");
		String title = TestUtils.getTitle();
		// log.info("PageTitle: ", title);
		System.out.println("PageTitle: " + title);
		Assert.assertEquals(title, TestConstants.PAGE_1_TITLE, "Title not matched");
	}

	@Test(enabled = true)
	public void tc02() throws InterruptedException {
		System.out.println("Inside TC02");
		login1.clickOnLoginLink();
		String title = TestUtils.getTitle();
		// log.info("PageTitle: ", title);
		System.out.println("PageTitle: " + title);
		Assert.assertEquals(title, TestConstants.PAGE_2_TITLE, "Title not matched");
	}

	@Test(enabled = true)
	public void tc03() throws InterruptedException   {
		System.out.println("Inside TC03");
		tc02();
		TestUtils.waitForPageLoad();
		Thread.sleep(5000);
		login2.clickOnLoginButton();
		String title = TestUtils.getTitle();
		// log.info("PageTitle: ", title);
		System.out.println("PageTitle: " + title);
		Assert.assertEquals(title, TestConstants.PAGE_1_TITLE, "Title not matched");
	}

	@Test(enabled = true)
	public void login_tc04() throws FileNotFoundException, InterruptedException, IOException {
		System.out.println("Inside TC04");
		tc03();
		loginPage.login(username, password);
		String title = TestUtils.getTitle();
		// log.info("PageTitle: ", title);
		System.out.println("PageTitle: " + title);
		Assert.assertEquals(title, TestConstants.HOMEPAGE_TITLE, "Title not matched");
	}
	
	@Test(enabled = true)
	public void invali_login_tc05() throws FileNotFoundException, InterruptedException, IOException {
		System.out.println("Inside TC05");
		tc03();
		loginPage.login(TestConstants.INVALID_USER, TestConstants.INVALID_PASSWORD);
		String title = TestUtils.getTitle();
		// log.info("PageTitle: ", title);
		System.out.println("PageTitle: " + title);
		Assert.assertEquals(title, TestConstants.PAGE_1_TITLE, "Title not matched");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
