package stepdefinitions;

import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class StepDefinitions extends SalesScenario{
    private WebDriver driver = getDriver();

    public StepDefinitions (DriverManager driverManager ){
        this.driver = DriverManager.driver;
    }

}


