package config;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import commonFunctions.Loginpage;
import commonFunctions.Logoutpage;

public class AppUtil1 {
	public static WebDriver driver;
	@BeforeTest
	public static void adminlogin()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://orangehrm.qedgetech.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// we can direct call/acces  login data from loginpage which we have created
		Loginpage login = PageFactory.initElements(driver, Loginpage.class);
		login.verify_Login("Admin", "Qedge123!@#");
	}
	@AfterTest
	public  static void logoutapp()
	{
		// we can direct call logout method from Logoutpage which we have created
		Logoutpage logout = PageFactory.initElements(driver, Logoutpage.class);
		logout.verifyLogout();
		driver.close();
	}

}
