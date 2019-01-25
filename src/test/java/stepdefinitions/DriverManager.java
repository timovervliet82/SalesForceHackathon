package stepdefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.LoginPageObject;

import java.util.HashMap;
import java.util.Map;


public class DriverManager {

    public static WebDriver driver;

    @Before
    public static void setup(){
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://login.salesforce.com/");
        new LoginPageObject(driver).loginUser("hackathon8@mailinator.com", "Valori2019");

    }

    @After
    public static void tearDown(){
        driver.quit();
    }

}
