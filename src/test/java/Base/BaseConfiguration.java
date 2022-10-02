package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.util.TestUtils;

public class BaseConfiguration {

	public static WebDriver driver;
	public static Properties prop;
	public static String url;

	public BaseConfiguration() throws IOException, FileNotFoundException {
		prop = new Properties();
		FileInputStream ip = new FileInputStream(
				"C:\\Users\\Administrator\\Desktop\\MANUAL TESTING\\Test\\TestDemo\\src\\test\\resources\\config\\configuration.properties");
		prop.load(ip);
		url = prop.getProperty("applicationUrl");
	}

	public static void initilization() {
		try {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Administrator\\Desktop\\MANUAL TESTING\\chrome_New\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			TestUtils.waitForPageLoad();
			TestUtils.implicitWait();
			driver.get(url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
