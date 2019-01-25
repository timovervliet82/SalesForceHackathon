package stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.CasePage;

import static org.junit.Assert.assertTrue;

public class StepDefinitionsCases {
    private WebDriver driver;
    private CasePage casePage;

    public StepDefinitionsCases(DriverManager driverManager ){
        this.driver = DriverManager.driver;
    }

    @Given("^user wants to get an overview of all open cases$")
    public void userOpensOverviewCasesPage() {
        casePage = new CasePage(driver);
        casePage.openCaseUrl();
    }

    @When("^the user wants to sort the open cases by high priority$")
    public void userSortsTheCasesOverview() {
        casePage = new CasePage(driver);
        casePage.filterCasesToAllOpenCases();
        casePage.waitForTableToBePopulated();
        casePage.clickSortingButton();
    }

    @Then("^the user gets an sorted overview sorted by high priority")
    public void userSeesSortedOverview() {

    }
}


