package stepDefinitions;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pageObject.ForgotPassword;
import pageObject.OrangeHRMLogin;
import cucumber.api.java.en.Then;

public class ForgotPasswordSteps {
	public WebDriver driver;
	
	public ForgotPasswordSteps() {
		driver = Hooks.driver;
	}
	
  @Given("User navigate to Forgot Password page from OrangeHRM login page")
  public void given() throws Throwable {
	  OrangeHRMLogin loginPage = new OrangeHRMLogin(driver);
	  Thread.sleep(2000);
	  loginPage.btnForgotPassword();
  }

  @When("User input (.*) as username")
  public void when(String username) throws Throwable {
	  ForgotPassword fpPage = new ForgotPassword(driver);
	  fpPage.setUsernameOHRM(username);
	  fpPage.clickResetPassword();
  }

  @Then("Instruction for reset password has sent")
  public void then() throws Throwable {
	  if (driver.getPageSource().contains("Password reset email could not be sent")) {
			System.out.println("Password reset email could not be sent");	
		} else {
			System.out.println("Please contact HR admin in order to reset the password");
			
		}
	  
  }

}
