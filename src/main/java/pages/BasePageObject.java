package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePageObject {

    private WebDriver driver;
    private int timeOut = 5;

    public BasePageObject(WebDriver driver){
        this.driver = driver;
    }
}
