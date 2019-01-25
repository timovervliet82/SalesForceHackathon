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

public class StepDefinitions {
    private WebDriver driver;

    public StepDefinitions (DriverManager driverManager ){
        this.driver = DriverManager.driver;
    }

    @Given("^I am on the Rabobank homepage$")
    public void i_am_on_the_Rabobank_homepage() {
        HomePage homePage = new HomePage(driver);
        assertTrue("Expecting the Rabobank logo to be visible",homePage.isLogoVisible());
    }

    @Given("^I navigate to particulieren$")
    public void i_navigate_to_particulieren() {
        HomePage homePage = new HomePage(driver);
        ParticulierenPage particulierenPage = new ParticulierenPage(driver);
        homePage.clickParticulierenLink();
        particulierenPage.isParticulierenElementVisible();
    }

    @When("^I search for \"([^\"]*)\"$")
    public void i_search_for(String searchTerm) {
        ParticulierenPage particulierenPage = new ParticulierenPage(driver);
        particulierenPage.enterValueInSearchField(searchTerm);

    }

    @Then("^I find the information page containing information about \"([^\"]*)\"$")
    public void iFindTheInformationPageContainingInformationAbout(String searchResult) throws InterruptedException {
    SearchModule searchModule = new SearchModule(driver);
    searchModule.checkAndClickThroughCookieWall();
        if (searchModule.searchModuleElementIsVisible()){
            assertTrue("Search results did not contain "+searchResult,searchModule.searchResults(searchResult));
            }
            else throw new AssertionFailedError("Unable to find search results");
    }

    @When("^I select \"([^\"]*)\" to filter the search results$")
    public void i_select_to_filter_the_search_results(String filterValue) {
        SearchModule searchModule = new SearchModule(driver);
        searchModule.selectDropDownValue(filterValue);
    }

}


