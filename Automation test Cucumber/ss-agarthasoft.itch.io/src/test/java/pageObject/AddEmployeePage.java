package pageObject;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;

public class AddEmployeePage extends BaseClass {
	
	public AddEmployeePage(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(webDriver, this);
	}
	
	@FindBy(id = "firstName")
	private WebElement firstName;
	
	@FindBy(id = "middleName")
	private WebElement midName;
	
	@FindBy(id = "lastName")
	private WebElement lastName;
	
	@FindBy(id = "employeeId")
	private WebElement idEmployee;
	
	@FindBy(id = "btnSave")
	private WebElement btnSave;
	
	public void setFirstName(String firstname) {
		firstName.sendKeys(firstname);
	}
	
	public void setMidName(String middlename) {
		midName.sendKeys(middlename);
	}
	
	public void setLastName(String lastname) {
		lastName.sendKeys(lastname);
	}
	
	public void setEmployeeId(String employeeid) {
		idEmployee.clear();
		idEmployee.sendKeys(employeeid + getRandomID());
	}
	
	public void btnSaveClick() {
		btnSave.click();
	}
	
	public int getRandomID(){
        Random randomID = new Random();
        return randomID.nextInt(901);
    }
	
}
