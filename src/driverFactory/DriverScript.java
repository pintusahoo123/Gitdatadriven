package driverFactory;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;
import org.testng.annotations.Test;

import commonFunctions.FunctionLibrary;
import config.AppUtil;
import utilities.ExcelFileUtil;

public class DriverScript extends AppUtil { // we extends apputill class here for pre-condition and post-condition
String inputpath = "C:\\Qedge_selenium\\DDT_FrameWork\\Fileinput\\LoginData.xlsx";
String outputpath = "C:\\Qedge_selenium\\DDT_FrameWork\\Fileoutput\\DataDrivenResults.xlsx";

@Test
public void Starttest() throws Throwable
{
	// create object for excelfile utill
	ExcelFileUtil xl = new ExcelFileUtil(inputpath);
	// count no of rows in login sheet
	int rc = xl.rowCount("Login");
	Reporter.log("no of rows are"+rc,true);
	for (int i=1; i<=rc; i++)
	{
		String user = xl.getCellData("Login", i, 0);
		String pass = xl.getCellData("Login", i, 1);
		// cell login method from function library
		boolean res = FunctionLibrary.verify_login(user, pass);
		if (res)
		{
			xl.setCellData("Login", i, 2, "login succes", outputpath);
			xl.setCellData("Login", i, 3, "pass", outputpath);
		}
		else
		{
			// take screenshot for failed testcases
			File screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screen,new File("./screenshot/iteration/"+i+"_"+"Loginpage.png"));
			xl.setCellData("Login", i, 2, "login failed", outputpath);
			xl.setCellData("Login",i, 3, "fail", outputpath);
			
		}
	}
	
}
}
