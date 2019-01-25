package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TasksPage {

    private WebDriver driver;

    public TasksPage(WebDriver driver) {
        this.driver = driver;
    }

    By btn_labelPage = By.cssSelector("[data-id='Task']");
    By el_taskBar = By.cssSelector("[class='oneConsoleObjectHome']");
    By btn_addNewTaskMenu = By.cssSelector("[class='uiPopupTrigger']");
    By btn_addNewTask = By.cssSelector("[title='Nieuwe taak']");

    public void openTasksPage() {
        WaitAction.waitForElement(driver, btn_labelPage).click();
    }

    public NewTask addNewTask() {
        WaitAction.waitForElement(driver, el_taskBar);
        WaitAction.waitForElement(driver, btn_addNewTaskMenu).click();
        WaitAction.waitForElement(driver, btn_addNewTaskMenu).click();
        WaitAction.waitForElement(driver, btn_addNewTaskMenu).click();
        WaitAction.waitForElement(driver, btn_addNewTask).click();
        return new NewTask(driver);
    }

}
