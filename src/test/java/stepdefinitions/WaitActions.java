package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitActions extends SalesScenario {

    private WebDriver driver = getDriver();
    private int timeOutSecs = 60;


    public WebElement waitForElement(By by) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutSecs, 20);
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }
}
