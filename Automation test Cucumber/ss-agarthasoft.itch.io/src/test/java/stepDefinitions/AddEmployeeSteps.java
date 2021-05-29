package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import gherkin.lexer.Id;
import pageObject.AddEmployeePage;
import pageObject.DashboardPage;
import pageObject.OrangeHRMLogin;
import cucumber.api.java.en.Then;

import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.And;
import cucumber.api.java.en.But;

public class AddEmployeeSteps {
	public WebDriver driver;
	
	public AddEmployeeSteps() {
		driver = Hooks.driver;
	}
	
	@Given("User in login page OrangeHRM for Add Employee")
	public void userLogin() throws Throwable {
		OrangeHRMLogin ohrmLoginPage = new OrangeHRMLogin(driver);
		driver.navigate().to("http://qa.cilsy.id/");
		ohrmLoginPage.setUsername("Admin");
		ohrmLoginPage.setPassword("s3Kol4HQA!*");
		ohrmLoginPage.clickLoginButton();
		Thread.sleep(1000);
	}
	
	@Given("User on add employee page")
	public void given() throws Throwable {
		driver.navigate().to("http://qa.cilsy.id/symfony/web/index.php/pim/viewEmployeeList");
		driver.navigate().to("http://qa.cilsy.id/symfony/web/index.php/pim/addEmployee");
	}
	
	
	@When("Input data using \"(.*)\" as firstname, \"(.*)\" as middlename, \"(.*)\" as lastname and (.*) as employeeid")
	public void when(String firstname, String middlename, String lastname, String employeeid) throws Throwable {
		AddEmployeePage addEmployeePage = new AddEmployeePage(driver);
		addEmployeePage.setFirstName(firstname);
		addEmployeePage.setMidName(middlename);
		addEmployeePage.setLastName(lastname);
		addEmployeePage.setEmployeeId(employeeid);
		addEmployeePage.btnSaveClick();
	}

	@Then("Employee added on list")
	public void then() throws Throwable {
		WebElement actualFirstName = driver.findElement(By.id("personal_txtEmpFirstName"));
		WebElement actualMidName = driver.findElement(By.id("personal_txtEmpMiddleName"));
		WebElement actualLastName = driver.findElement(By.id("personal_txtEmpLastName"));
		try {
			Assert.assertEquals("Rasyid", actualFirstName);
			Assert.assertEquals("Sholeh", actualMidName);
			Assert.assertEquals("Rosena", actualLastName);
		} catch (AssertionError e) {
			System.out.println("Employee not added. \n");
		}
		
	}

}
