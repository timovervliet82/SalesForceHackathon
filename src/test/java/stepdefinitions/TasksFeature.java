package stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.NewTask;
import pages.TasksPage;

public class TasksFeature extends  SalesScenario{

    private WebDriver driver  = getDriver();
    private TasksPage tasksPage = new TasksPage(driver);
    private NewTask newTask;

    @Given("^I am in the \"([^\"]*)\" page$")
    public void iAmInThePage(String pageName){
        tasksPage = new TasksPage(driver);
        tasksPage.openTasksPage();
    }

    @When("^I add a new task$")
    public void iAddANewTask() {
        newTask = tasksPage.addNewTask();
    }

    @And("^the task is assigned to \"([^\"]*)\"$")
    public void theTaskIsAssignedTo(String assignTo){
        newTask.taskAssignTo(assignTo);
    }
}
