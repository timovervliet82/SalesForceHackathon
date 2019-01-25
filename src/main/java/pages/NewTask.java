package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

public class NewTask {

    private WebDriver driver;
    private By btn_save = By.cssSelector("[title='Opslaan']");
    private By fld_assignTo = By.cssSelector("[title='Zoeken in Mensen']");
    private By fld_status = By.cssSelector("(//*[contains(./text(),'Status')]/..//div[@class='uiMenu'])[4]");
    private By fld_subject = By.xpath("//label[contains(./text(),'Onderwerp')]/..//input" );
    private By fld_contact = By.xpath("//span[contains(./text(),'Naam')]/..//..//input" );

    public NewTask(WebDriver driver) {
        this.driver = driver;
        WaitAction.waitForElement(driver, btn_save);
    }

    public void taskAssignTo(String user){
        driver.findElement(fld_assignTo).sendKeys(user);
    }

    public void taskStatus(String status){
        driver.findElement(fld_status).sendKeys(status);
    }

    public void taskSubject(String subject){
        driver.findElement(fld_subject).sendKeys(subject + Keys.TAB);
    }

    public void taskContact(String contact){
        driver.findElement(fld_contact).sendKeys(contact);
        waitNow();
        driver.findElement(fld_contact).sendKeys(Keys.ENTER);
        waitNow();

        driver.findElement(By.cssSelector("a[title='"+ contact+"']")).click();

    }

    public void taskSave(){
        WaitAction.waitForElement(driver, btn_save).click();
    }

    private void waitNow(){
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
