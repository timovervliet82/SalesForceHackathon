package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

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
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(tableRows,6));
    }

    public void clickSortingButton(){
        WebDriverWait wait = new WebDriverWait(driver,30);
        WebElement sortButton = wait.until(ExpectedConditions.elementToBeClickable(prioritySortingButton));
        sortButton.click();
    }

    public Boolean isPrioritySorted(){
        boolean isSorted = false;
        String rowData = driver.findElement(tableRows).getText();

        //*[@data-aura-class='uiVirtualDataTable']//tr



        return isSorted;
    }
}
