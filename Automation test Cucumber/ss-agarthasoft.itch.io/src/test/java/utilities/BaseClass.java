package utilities;

import org.openqa.selenium.WebDriver;

public class BaseClass {
	public static WebDriver webDriver;
	
	public BaseClass(WebDriver webDriver) {
		BaseClass.webDriver = webDriver;
	}

}