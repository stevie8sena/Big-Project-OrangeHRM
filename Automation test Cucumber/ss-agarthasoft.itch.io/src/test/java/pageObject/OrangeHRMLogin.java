package pageObject;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;

public class OrangeHRMLogin extends BaseClass {

	public OrangeHRMLogin(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(webDriver, this);
	}
	
	@FindBy(id = "txtUsername")
	private WebElement inputUsername;
	
	@FindBy(id = "txtPassword")
	private WebElement inputPassword;
	
	@FindBy(id = "btnLogin")
	private WebElement btnLogin;
	
	@FindBy(id = "spanMessage")
	private WebElement errorMessage;
	
	@FindBy(id = "forgotPasswordLink")
	private WebElement forgotPasswordLink;
		
	public boolean isLoginPageAppear() {
		inputUsername.isDisplayed();
		inputPassword.isDisplayed();
		btnLogin.isDisplayed();
		return true;
	}
	
	
	public void setUsername(String user) {
		inputUsername.sendKeys(user);
	}
	
	public void setPassword(String pw) {
		inputPassword.sendKeys(pw);
	}
	
	public void clickLoginButton() {
		btnLogin.click();
	}
	
	public boolean errorMessage(String result) {
		errorMessage.isDisplayed();
		return true;
	}
	
	public void btnForgotPassword() {
		forgotPasswordLink.click();
	}
	
}
