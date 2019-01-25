package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactPersonPage {
    private WebDriver driver;

    private By addNewContactPersonButton = By.cssSelector("a[title='Nieuw']");

    private By lastNameField = By.cssSelector("input[class*='lastName']");

    private By firstNameField = By.cssSelector("input[class*='firstName']");

    private By saveButton = By.cssSelector("button[title='Opslaan']");

    private By contactPersonMenu = By.cssSelector("li[data-id='Contact']");



    WebDriverWait wait;

    public ContactPersonPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver,30);
    }

    public void addNewContactPerson(String name){
        wait.until(ExpectedConditions.elementToBeClickable(addNewContactPersonButton)).click();
        //wait for layout to load and fill in keys
        wait.until(ExpectedConditions.elementToBeClickable(lastNameField)).sendKeys(name);
        driver.findElement(firstNameField).sendKeys("Loop een");
        driver.findElement(saveButton).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(contactPersonMenu)).click();
    }
}
