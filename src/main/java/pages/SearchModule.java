package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchModule {

    private By searchResultsPage = By.xpath("//*[@id='content-selection-search-result']");
    private By cookieWallButton = By.xpath("//*[@id='cookiewall_popup']//p/button");
    private By searchFilterDropDownButton = By.className("rfs-select__button");
    private By centerButton = By.className("center-button");

    private WebDriver driver;
    private int timeOut = 5;

    public SearchModule(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Boolean searchModuleElementIsVisible() {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(searchResultsPage, By.xpath("//dl")));
        return driver.findElement(searchResultsPage).isDisplayed();
    }

    public void checkAndClickThroughCookieWall() {
        List<WebElement> isCookieWallPresent = driver.findElements(By.xpath("//*[@id='cookiewall_popup']"));
        if (isCookieWallPresent.size() != 0) {
            driver.findElement(cookieWallButton).click();
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.presenceOfElementLocated(centerButton));
        }
    }

    public Boolean searchResults(String expectedResult) throws InterruptedException {
        Thread.sleep(1000);
        List<String> searchResultText = new ArrayList<>();
        List<WebElement> searchResults = driver.findElements(By.xpath("//*[@class='searchresult']"));
        for (WebElement searchResult : searchResults) {
            searchResultText.add(searchResult.getText());
        }

        boolean expectedResultFound = false;
        for (String result : searchResultText)
            if (result.contains(expectedResult)) {
                expectedResultFound = true;
                break;
            }

        return expectedResultFound;
    }

    public void selectDropDownValue(String filterValue) {
        String expectedValue = filterValue.toLowerCase();
        checkAndClickThroughCookieWall();
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.elementToBeClickable(centerButton));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(searchFilterDropDownButton)));
        driver.findElement(searchFilterDropDownButton).click();

        List<WebElement> dropDownItems = driver.findElements(By.xpath("//*[@id='viewNameKey-container']/ng-transclude/rfs-select-option"));
        List<String> dropDownValues = new ArrayList<>();
        for (WebElement item : dropDownItems) {
            dropDownValues.add(item.getAttribute("value").toLowerCase());
        }
        if (!dropDownValues.contains(expectedValue)) {
            throw new AssertionError("Entered value can not be found in dropdown list");
        }

        switch (expectedValue) {
            case "business":
                driver.findElement(By.xpath("//*[@id='viewNameKey_business']")).click();
                break;

            case "retail":
                driver.findElement(By.xpath("//*[@id='viewNameKey_retail']")).click();
                break;

            default:
                throw new AssertionError("No locator defined to be clicked");
        }
    }
}



