package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;

public class DashboardPage extends BaseClass {
	
	public DashboardPage(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(webDriver, this);
	}
	
	@FindBy(xpath = "/html/body/div[1]/div[3]/div/div[1]/h1")
	private WebElement dashboardText;
	
	@FindBy(id = "welcome")
	private WebElement usernameMenu;
	
	@FindBy(how = How.CSS, using = ".quickLaungeContainer > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > div:nth-child(1) > a:nth-child(1)")
	private WebElement assignLeaveIcon;
	
	public boolean dashboardTextDisplay() {
		dashboardText.isDisplayed();
		return true;
	}
	
	public void clickUsernameMenu() {
		usernameMenu.click();
	}
	
	public void clickAssignLeaveIcon() {
		assignLeaveIcon.click();
	}
}
