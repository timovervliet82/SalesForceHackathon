package stepdefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPageObject;


public class DriverManager {

    public static WebDriver driver;

    @Before
    public static void setup(){
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://login.salesforce.com/");
        new LoginPageObject(driver).loginUser("hackathon8@mailinator.com", "Valori2019");

    }

    @After
    public static void tearDown(){
//        driver.quit();
    }

}
