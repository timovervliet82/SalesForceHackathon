package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CasePage {
    private WebDriver driver;
    private int timeOut=5;

    private String casePageUrl = "https://eu16.lightning.force.com/lightning/o/Case/home";

    private By caseFilterDropdown = By.xpath("//*[@title='Lijstweergave selecteren']");
    private By allCasesFilterOption = By.xpath("//*[contains(text(),'Alle open cases')]");
    private By tableRows = By.xpath("//*[@data-aura-class='uiVirtualDataTable']//tr");
    private By prioritySortingButton = By.xpath("//span[@title='Prioriteit']");

    public CasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void openCaseUrl(){
        driver.get(casePageUrl);
    }

    public void filterCasesToAllOpenCases(){
        WebDriverWait wait = new WebDriverWait(driver,30);
        WebElement filterCases = wait.until(ExpectedConditions.elementToBeClickable(caseFilterDropdown));
        filterCases.click();
        WebElement openCasesOption = wait.until(ExpectedConditions.elementToBeClickable(allCasesFilterOption));
        openCasesOption.click();
    }

    public void waitForTableToBePopulated(){
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(tableRows,4));
    }

    public void clickSortingButton() throws InterruptedException {
        driver.get(casePageUrl);
        WebDriverWait wait = new WebDriverWait(driver,30);
        WebElement filterCases = wait.until(ExpectedConditions.elementToBeClickable(caseFilterDropdown));
        filterCases.click();
        WebElement openCasesOption = wait.until(ExpectedConditions.elementToBeClickable(allCasesFilterOption));
        openCasesOption.click();
        Thread.sleep(3000);
        WebElement sortingButton = wait.until(ExpectedConditions.elementToBeClickable(prioritySortingButton));
        sortingButton.click();
        Thread.sleep(2000);
    }

    private void resetSorting() throws InterruptedException {
        List<WebElement> listRows = driver.findElements(tableRows);

        String sortedPriority = listRows.get(1).getText().toLowerCase();
        if (!sortedPriority.contains("low")){
            clickSortingButton();
        }

    }

    public Boolean isPrioritySorted() throws InterruptedException {
        boolean isSorted;
        Thread.sleep(2000);
        List<WebElement> listRows = driver.findElements(tableRows);

        String sortedPriority = listRows.get(1).getText().toLowerCase();
        System.out.println(sortedPriority);

        isSorted = sortedPriority.contains("high");
        resetSorting();
        return isSorted;
        }
}
