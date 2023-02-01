package org.tditsolutions.qa.testbase;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.tditsolutions.qa.driverfactory.DriverFactory;
import org.tditsolutions.qa.pages.AddAccountPage;
import org.tditsolutions.qa.pages.HomePage;
import org.tditsolutions.qa.pages.LoginPage;
import org.tditsolutions.qa.utils.PropConfig;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestBase {
	protected WebDriver driver;
	public LoginPage loginPage;
	public  HomePage homePage;
	protected AddAccountPage addAccPage;

	DriverFactory df;
	PropConfig propConfig;
	Properties prop;

	@BeforeMethod
	public void beforeMethod() {
//		propConfig = PropConfig.getInstance();
//		try {
//			prop = PropConfig.load_prop("QA");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		df = new DriverFactory();
//		driver = df.init_driver(prop.getProperty("browser"));
		
//		WebDriverManager.firefoxdriver().setup();
//		WebDriver driver=new FirefoxDriver();
//		WebDriverManager.edgedriver().setup();
//		driver = new EdgeDriver();
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		driver.get("https://tool2.tdittesting.in/login.php");
		//driver.get(prop.getProperty("app_url"));
		System.out.println(driver);
		loginPage = new LoginPage(driver);
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
}