package stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class StepDefinitionsCases {
    private WebDriver driver;

    public StepDefinitionsCases(DriverManager driverManager ){
        this.driver = DriverManager.driver;
    }

    @Given("^user wants to get an overview of all open cases$")
    public void userOpensOverviewCasesPage() {
    }

    @When("^the user wants to sort the open cases by high priority$")
    public void userSortsTheCasesOverview() {
    }

    @Then("^the user gets an sorted overview sorted by high priority")
    public void userSeesSortedOverview() {
    }
}


