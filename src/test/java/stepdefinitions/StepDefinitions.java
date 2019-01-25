package stepdefinitions;

import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;
import pages.LoginPageObject;

import static org.junit.Assert.assertTrue;

public class StepDefinitions extends SalesScenario{
    private WebDriver driver = getDriver();

    private LoginPageObject loginPageObject;

    public StepDefinitions (DriverManager driverManager ){
        this.driver = DriverManager.driver;
    }

    @Given("^the user is logged into SalesForce$")
    public void userOpensOverviewCasesPage() {
    }


}


