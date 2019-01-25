package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageObject {
    private WebDriver driver;

    By fld_username = By.cssSelector("[id='username']");
    By fld_password = By.cssSelector("[id='password']");
    By btn_login = By.cssSelector("[id='Login']");


    public LoginPageObject (WebDriver driver){
        this.driver = driver;
    }

    private void setUsername(String username){
        driver.findElement(fld_username).sendKeys(username);
    }

    private void setPassword(String password){
        driver.findElement(fld_username).sendKeys(password);
    }

    private void clickLogin(){
        driver.findElement(btn_login).click();

    }

    private void loginUser(String username, String password){
        setUsername(username);
        setPassword(password);
        clickLogin();
    }
}
