package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class AppUtil {                 // to maintain pre-condition and post-condition we prepared AppUtil class            
	public static Properties concrop;   // we can re-use this class in driver script 
	public static WebDriver driver;
	@BeforeTest 
	public static void setup() throws Throwable
	{
		concrop = new Properties();
		concrop.load(new FileInputStream("C:\\Qedge_selenium\\DDT_FrameWork\\PropertyFiles\\Environment.properties"));
		if (concrop.getProperty("Browser").equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		else if(concrop.getProperty("Browser").equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("browser value is not matching");
		}

	}
	@AfterTest
	public static  void teardown()
	{
		driver.quit();
	}

}
