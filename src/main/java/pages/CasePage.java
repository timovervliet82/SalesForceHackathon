package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CasePage {
    private WebDriver driver;
    private int timeOut=5;

    private String casePageUrl = "https://eu16.lightning.force.com/lightning/o/Case/home";


    public CasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void openCaseUrl(){
        driver.get(casePageUrl);
    }


}
