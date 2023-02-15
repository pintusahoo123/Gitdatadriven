package commonFunctions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Reporter;

import config.AppUtil;

public class FunctionLibrary extends AppUtil{  //here we extends apputil class for repository purpose
	public static boolean verify_login(String username, String password)
	{
		driver.get(concrop.getProperty("URL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector(concrop.getProperty("Objuser"))).sendKeys(username);
		driver.findElement(By.cssSelector(concrop.getProperty("Objpass"))).sendKeys(password);
		driver.findElement(By.cssSelector(concrop.getProperty("Objlogin"))).click();
		//String error = driver.findElement(By.cssSelector(concrop.getProperty("Objerrormessage"))).getText();
		String expected ="dashboard";
		String actual =driver.getCurrentUrl();
		if (actual.contains(expected))
		{
			Reporter.log("Login succes  "+expected+"     "+actual,true);
			return true;
		}
		else
		{
			String error = driver.findElement(By.cssSelector(concrop.getProperty("Objerrormessage"))).getText();
			Reporter.log( error+"    "+expected+"     "+actual,true);
			return false;
			
		}
		
		
	}

}
