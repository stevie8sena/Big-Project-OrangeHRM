package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;

public class ForgotPassword extends BaseClass {
	
	public ForgotPassword(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(webDriver, this);
	}
	
	@FindBy(id = "securityAuthentication_userName")
	private WebElement usernameOHRM;
	
	@FindBy(id = "btnSearchValues")
	private WebElement btnResetPassword;
	
	public void setUsernameOHRM(String username) {
		usernameOHRM.sendKeys(username);
	}
	
	public void clickResetPassword() {
		btnResetPassword.click();
	}
}
