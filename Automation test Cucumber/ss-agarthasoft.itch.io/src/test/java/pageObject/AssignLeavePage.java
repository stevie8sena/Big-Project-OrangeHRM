package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.BaseClass;

public class AssignLeavePage extends BaseClass {
	
	public AssignLeavePage(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(webDriver, this);
	}
	
	@FindBy (how = How.XPATH, using = "/html/body/div[1]/div[3]/div[1]/div[1]/h1")
	private WebElement titleAssignLeave;
	
	@FindBy(id = "assignleave_txtEmployee_empName")
	private WebElement txtEmployeeName;
	
	@FindBy(id = "assignleave_txtLeaveType")
	private WebElement txtLeaveType;
	
	@FindBy(id = "assignleave_txtFromDate")
	private WebElement txtFromDate;
	
	@FindBy(id = "assignleave_txtToDate")
	private WebElement txtToDate;
	
	@FindBy(id = "assignBtn")
	private WebElement btnAssign;
	
	public boolean titleAssignLeave() {
		titleAssignLeave.isDisplayed();
		return true;
	}
	
	public void setEmployeeName() {
		txtEmployeeName.sendKeys("Rasyid Sholeh Rosena");
	}
	
	public void setLeaveType() {
		String value1 = "Sick";
		String value2 = "Emergency Leave";
		Select leaveType = new Select (txtLeaveType);
		leaveType.selectByVisibleText(value2);
	}
	
	public void setDate() {
		txtFromDate.sendKeys("2021-08-17");
		txtToDate.sendKeys("2021-08-19");
	}
	
	public void btnAssign() {
		btnAssign.click();
	}
}