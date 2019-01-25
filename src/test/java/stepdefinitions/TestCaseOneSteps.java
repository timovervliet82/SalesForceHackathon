package stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.ContactPersonPage;
import pages.HomePage;


public class TestCaseOneSteps extends SalesScenario{
    WebDriver driver = getDriver();

    HomePage homePage = new HomePage(driver);
    ContactPersonPage contactPersonPage = new ContactPersonPage(driver);

    @Given("^I am on Sales Force Home page$")
    public void iAmOnSalesForceHomePage() {
        homePage.validateHomePage();
    }


    @When("^I add a new contact person named \"([^\"]*)\"$")
    public void iAddANewContactPersonNamedLastname(String name) {
        homePage.createNewContact();
        contactPersonPage.addNewContactPerson(name);
    }
}
