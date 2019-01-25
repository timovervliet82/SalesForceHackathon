package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;

    private By contactPersonMenu = By.cssSelector("a[title='Contactpersonen'] + one-app-nav-bar-item-dropdown");

    private By addContactPerson = By.xpath("(.//*[@data-key='add'])[4]");

    public HomePage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void createNewContact(){
        driver.findElement(contactPersonMenu).click();
        WebDriverWait wait = new WebDriverWait(driver,30);
        WebElement addContactelement = wait.until(ExpectedConditions.elementToBeClickable(addContactPerson));
        addContactelement.click();
    }
}
