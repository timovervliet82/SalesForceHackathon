package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;
    private int timeOut=5;

    private By raboLogo = By.className("logo");
    private By particulierenLink = By.xpath ("//a[contains(text(), 'Particulieren')]");


    public HomePage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public Boolean isLogoVisible(){

        return driver.findElement(raboLogo).isDisplayed();
    }

    public void clickParticulierenLink(){
        WebDriverWait waitTime = new WebDriverWait(driver,timeOut);
        waitTime.until(ExpectedConditions.visibilityOf(driver.findElement(particulierenLink)));
        driver.findElement(particulierenLink).click();
    }
}
