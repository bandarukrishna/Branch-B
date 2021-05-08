package stepDefinitions;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import com.aventstack.extentreports.ExtentTest;
import com.qa.base.TestBase;
import com.qa.pages.LandingPage;
import com.qa.pages.RegisterPage;
import com.qa.util.TestUtil;
import com.vimalselvam.cucumber.listener.Reporter;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.Step;
//@Listeners(com.qa.ExtentReportListener.ITestListenerImpl.class)
public class RegisterPageTest {
RegisterPage regpage= new RegisterPage();
LandingPage lanpage=new LandingPage();
Scenario scenario;
Step step;
String Stepname;
ExtentTest extest;
Logger log = Logger.getLogger(this.getClass());
	@When("^user clicks on registerlink$")
	public void user_clicks_on_registerlink() throws Throwable {
		 Stepname="Registeration Test Scenario";
		 Reporter.addScreenCaptureFromPath(TestUtil.takeScreenShot());
		 lanpage.click_on_register_button();
		 log.info("user clicks on registerlink");
		//System.out.println("Step name:" +step.getName());
		// System.out.println("Scenario name: "+scenario.getId().toString());
		// Reporter.addScenarioLog(scenario.getName());
		 Reporter.addStepLog("My test addStepLog message");
         Reporter.addScreenCaptureFromPath(TestUtil.takeScreenShot());
		
	}

	@Then("^user enters contact information \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_contact_information_and_and_and(String firstname, String lastname, String phone, String email) throws Throwable {
		Stepname="user enters contact information";
		//Cucumber_ExtentReportListener.extentTestSetup("mercurytours Feature","Registeration Test Scenario"); 
	    regpage.enterContactInformation(firstname, lastname, phone, email);
	    log.info("user entered contact information");
	   ///////below step is to generate extent from test runner
	    //Cucumber_ExtentReportListener.addingPassedLogInfo(Stepname, "Pass", driver,"Then");
	  //  Reporter.addScreenCaptureFromPath(afterScenario());
	    Reporter.addScreenCaptureFromPath(TestUtil.takeScreenShot());
	    Reporter.addStepLog("My test addStepLog message1");
        Reporter.addScenarioLog("This is scenario log1");
	  
	}

	@Then("^user enters mailing address information \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_mailing_address_information_and_and_and_and(String address1, String city, String state, String postalcode) throws Throwable {
	   regpage.enterMailingInformation(address1,city, state, postalcode);
	 //  Reporter.addScreenCaptureFromPath(afterScenario());
	   Reporter.addScreenCaptureFromPath(TestUtil.takeScreenShot());
	   Reporter.addStepLog("My test addStepLog message2");
       Reporter.addScenarioLog("This is scenario log2");
	   
	}

	@Then("^user enters user information \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_user_information_and_and(String username, String password, String confirmpassword) throws Throwable {
	   regpage.entersUserInformation(username, password, confirmpassword);
	  // Reporter.addScreenCaptureFromPath(afterScenario()); 
	   Reporter.addScreenCaptureFromPath(TestUtil.takeScreenShot());
	   Reporter.addStepLog("My test addStepLog message3");
       Reporter.addScenarioLog("This is scenario log3");
	}

	@Then("^user closes the browser$")
	public void user_closes_the_browser() throws Throwable {
		TestBase.close_browser();	
		System.out.println("browser closed");
	}
}
