package stepdefinitions;

import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class StepDefinitions {
    private WebDriver driver;

    public StepDefinitions (DriverManager driverManager ){
        this.driver = DriverManager.driver;
    }

}


