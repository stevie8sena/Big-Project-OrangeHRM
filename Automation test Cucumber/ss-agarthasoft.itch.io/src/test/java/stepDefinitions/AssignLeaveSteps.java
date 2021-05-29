package stepDefinitions;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import pageObject.AddEmployeePage;
import pageObject.*;
import pageObject.AssignLeavePage;
import pageObject.DashboardPage;
import pageObject.OrangeHRMLogin;
import utilities.BaseClass;

public class AssignLeaveSteps {
	public WebDriver driver;
	
	public AssignLeaveSteps() {
		driver = Hooks.driver;
	}
	
	@Given("User in login page OrangeHRM for Assign Leave")
	public void userLogin() throws Throwable {
		OrangeHRMLogin ohrmLoginPage = new OrangeHRMLogin(driver);
		driver.navigate().to("http://qa.cilsy.id/");
		ohrmLoginPage.setUsername("Admin");
		ohrmLoginPage.setPassword("s3Kol4HQA!*");
		ohrmLoginPage.clickLoginButton();
		Thread.sleep(1000);
	}
	
	@Given("User on Assign Leave page")
	public void given() throws Throwable {
		DashboardPage dbPage = new DashboardPage(driver);
		AssignLeavePage alPage = new AssignLeavePage(driver);
		dbPage.clickAssignLeaveIcon();
		Assert.assertTrue(alPage.titleAssignLeave());
	}
	
	@When("Leave all field empty")
	public void when() throws Throwable {
		AssignLeavePage alPage = new AssignLeavePage(driver);
		alPage.btnAssign();
	}
	
	@Then("Leave not added")
	public void then() throws Throwable {
		if (driver.findElement(By.className("validation-error")).isDisplayed()) {
			System.out.println("Leave not added. \n");
		}
	}

	@When("User fill employee name, leave type, and date")
	public void fillLeaveData() throws Throwable {
		AssignLeavePage alPage = new AssignLeavePage(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("assignleave_txtEmployee_empName")));
		
		alPage.setEmployeeName();
		alPage.setLeaveType();
		alPage.setDate();
		alPage.btnAssign();
	}
	
	@Then("Employee leave added on list")
	public void verifyLeave() throws Throwable {
		if (driver.getPageSource().contains("Successfully Assigned")) {
		System.out.println("Leave Added. \n");	
		}
	}
}
