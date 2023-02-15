package commonFunctions;

import java.awt.Desktop.Action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class AddEmpPage {
	WebDriver driver ;
	public AddEmpPage(WebDriver driver) // use constructor here bcoz i want webdriver methods in this class
	{
		this.driver = driver;           // here this is used for accesing all webelemts methods
	}
	@FindBy(xpath = "//b[normalize-space()='PIM']")
	WebElement clickpim;
	@FindBy (name ="btnAdd")
	WebElement clickadd;
	@FindBy ( name ="firstName")
	WebElement fname;
	@FindBy ( name ="middleName")
	WebElement mname;
	@FindBy ( name ="lastName")
	WebElement lname;
	@FindBy (xpath = "//input[@id='employeeId']")
	WebElement beforeid;
	@FindBy (xpath = "//input[@id='btnSave']")
	WebElement clicksave;
	@FindBy (xpath = "//input[@id='personal_txtEmployeeId']")
	WebElement afterid;
	public boolean addEmp(String firstname, String middlename,String lastname)
	{
		// iwant to moveover to mouse to pim and moveover to add and click
		Actions ac = new Actions(driver);
		ac.moveToElement(clickpim).click().perform();
		ac.moveToElement(clickadd).click().perform();
		this.fname.sendKeys(firstname);
		this.mname.sendKeys(middlename);
		this.lname.sendKeys(lastname);
		// i want to match before and after employee id runtime value
		String expectedEid = this.beforeid.getAttribute("value");
		ac.moveToElement(clicksave).click().perform();
		String actualEid = this.afterid.getAttribute("value");
		System.out.println(expectedEid+"    "+actualEid);
		if(expectedEid.equals(actualEid))
		{
			Reporter.log("add employee succes",true);
			return true;
		}
		else
		{
			Reporter.log("add employee failed",true);
			return false;
		}
		
	}

}
