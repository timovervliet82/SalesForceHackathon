package stepdefinitions;

import org.openqa.selenium.WebDriver;

public class SalesScenario extends DriverManager{

    WebDriver driver = DriverManager.driver;

    public WebDriver getDriver(){
        return driver;
    }


}
