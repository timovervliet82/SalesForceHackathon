package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitAction{

    static private WebDriver driver;
    public WaitAction (WebDriver driver){
        this.driver = driver;
    }


    static private int timeOutSecs = 60;


   static public WebElement waitForElement(By by) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutSecs, 20);
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }
}
