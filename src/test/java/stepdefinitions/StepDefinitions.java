package stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.AssertionFailedError;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.ParticulierenPage;
import pages.SearchModule;

import static org.junit.Assert.assertTrue;

public class StepDefinitions extends SalesScenario{
    private WebDriver driver = getDriver();

    public StepDefinitions (DriverManager driverManager ){
        this.driver = DriverManager.driver;
    }

}


