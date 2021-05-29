package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObject.OrangeHRMLogin;
import pageObject.DashboardPage;

public class LoginSteps {
	public WebDriver driver;
	
	public LoginSteps() {
		driver = Hooks.driver;
	}
	
	@Given("User in OrangeHRM login page")
	public void visitLoginPage() throws Throwable {
		OrangeHRMLogin ohrmLoginPage = new OrangeHRMLogin(driver);
		driver.navigate().to("http://qa.cilsy.id/");
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "http://qa.cilsy.id/symfony/web/index.php/auth/login";
		try {
			Assert.assertEquals(expectedUrl, actualUrl);
			Assert.assertTrue(ohrmLoginPage.isLoginPageAppear());
		} catch (AssertionError e) {
			System.out.println("Login page error. \n");
		}
	}
	
	@When("Input authentication using \"(.*)\" as username and \"(.*)\" as password")
	public void inputCredential(String username, String password) throws Throwable {
		OrangeHRMLogin ohrmLoginPage = new OrangeHRMLogin(driver);
		ohrmLoginPage.setUsername(username);
		ohrmLoginPage.setPassword(password);
		ohrmLoginPage.clickLoginButton();
	}
	
	@When("Input invalid authentication using (.*) as username and (.*) as password")
	public void inputInvalidCredential(String uname, String pw) throws Throwable {
		OrangeHRMLogin ohrmLoginPage = new OrangeHRMLogin(driver);
		ohrmLoginPage.setUsername(uname);
		ohrmLoginPage.setPassword(pw);
		ohrmLoginPage.clickLoginButton();
	}
	
	@Then("User navigate to OrangeHRM dashboard")
	public void verifyDashboardPage() throws Throwable {
		DashboardPage dbPage = new DashboardPage(driver);
		Assert.assertTrue(dbPage.dashboardTextDisplay());
	}

	
	@Then("Error message (.*)")
	public void verifLoginNegative(String result) throws Throwable {
		OrangeHRMLogin ohrmLoginPage = new OrangeHRMLogin(driver);
		Assert.assertTrue(ohrmLoginPage.errorMessage(result));
	}
}
