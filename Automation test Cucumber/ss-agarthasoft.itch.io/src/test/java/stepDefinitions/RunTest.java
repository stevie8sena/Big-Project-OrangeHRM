package stepDefinitions;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import java.io.File;
import com.cucumber.listener.Reporter;

@RunWith(Cucumber.class)
@CucumberOptions(
		tags = {"@ForgotPass, @Login, @AddEmployee, @AssignLeave, @Logout"},
		features = {"classpath:features/"},
		glue = {"classpath:stepDefinitions"},
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}
		)


public class RunTest {
	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File("config/report.xml"));
	}
}