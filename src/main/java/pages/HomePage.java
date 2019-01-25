package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class HomePage {
    private WebDriver driver;

    private By contactPersonMenu = By.cssSelector("li[data-id='Contact']");

    WebDriverWait wait;

    public HomePage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver,30);
    }

    public void validateHomePage() {
        assertTrue("Home page not located", wait.until(ExpectedConditions.elementToBeClickable(contactPersonMenu)).isDisplayed());
    }

    public void createNewContact(){
        wait.until(ExpectedConditions.elementToBeClickable(contactPersonMenu)).click();
    }
}
