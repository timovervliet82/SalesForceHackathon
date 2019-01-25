package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ParticulierenPage {

    private WebDriver driver;
    private int timeOut = 5;

    private By hypotheekLink = By.xpath("//a[contains(text(), 'Hypotheek')]");

    private By searchField = By.id ("ra_searchfield");

    private By helpBlock = By.xpath ("//div[@class='left']");


    public ParticulierenPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void isParticulierenElementVisible(){
        WebDriverWait waitTime = new WebDriverWait(driver,timeOut);
        waitTime.until(ExpectedConditions.visibilityOf(driver.findElement(hypotheekLink)));
        driver.findElement(hypotheekLink).isDisplayed();
    }

    public void enterValueInSearchField(String searchTerm){
        WebDriverWait waitTime = new WebDriverWait(driver,timeOut);
        waitTime.until(ExpectedConditions.visibilityOf(driver.findElement(searchField)));
        WebElement clickableField = driver.findElement(helpBlock).findElement(By.id("ra_searchfield"));
        clickableField.sendKeys(searchTerm);
        WebElement searchIcon = driver.findElement(helpBlock).findElement(By.id("zoeken1"));
        searchIcon.click();
    }


}
