package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObject.DashboardPage;
import pageObject.OrangeHRMLogin;

public class LogoutSteps {
	public WebDriver driver;
	
	public LogoutSteps() {
		driver = Hooks.driver;
	}
	
	@Given("User in login page OrangeHRM for Logout")
	public void userLogin() throws Throwable {
		OrangeHRMLogin ohrmLoginPage = new OrangeHRMLogin(driver);
		driver.navigate().to("http://qa.cilsy.id/");
		ohrmLoginPage.setUsername("Admin");
		ohrmLoginPage.setPassword("s3Kol4HQA!*");
		ohrmLoginPage.clickLoginButton();
		Thread.sleep(1000);
	}
	
	@Given("User in dashboard page")
	public void userLoggedIn() {
		driver.navigate().to("http://qa.cilsy.id/symfony/web/index.php/dashboard");
	}
	
	@When("User click Logout url in username menu")
	public void dashboardPage() throws InterruptedException {
		DashboardPage dbPage = new DashboardPage(driver);
		Thread.sleep(2000);
		dbPage.clickUsernameMenu();
		driver.findElement(By.partialLinkText("Logout")).click();
	}
	
	@Then("User successfully logout")
	public void userLoggedOut() {
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "http://qa.cilsy.id/symfony/web/index.php/auth/login";
		Assert.assertEquals(expectedUrl, actualUrl);
	}
}
