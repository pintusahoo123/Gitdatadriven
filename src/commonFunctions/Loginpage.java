package commonFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage {
	// define repository
	@FindBy (name = "txtUsername")
	WebElement user;
	@FindBy (id ="txtPassword")
	WebElement pass;
	@FindBy (name ="Submit")
	WebElement loginbtn;
	// define method
	public void verify_Login(String username, String password)
	{
		user.sendKeys("username");
		pass.sendKeys("password");
		loginbtn.click();
	}
	

}
