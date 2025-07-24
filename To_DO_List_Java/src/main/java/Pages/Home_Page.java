package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home_Page {
WebDriver chromeDriver;
    //Constructor to make the two webDrivers in main and test is the same
    public Home_Page(WebDriver chromeDriver) {
        this.chromeDriver=chromeDriver;
    }

    //Locators
 private final By InputField = By.xpath("//input[@placeholder='Write your next task here...']");
 private final By CheckBox = By.xpath("//label[@title='Done']");
 private final By TaskLabel = By.xpath("//form[@class='edit_task']");
 private final By DeleteButton = By.xpath("//li[@class='delete']/a[@data-hint='Delete task']/i[@class='icon-remove']");

    //Actions
    //Adding new task
    public Home_Page AddNewTask(String Task){
        Utility.AddNewTask(chromeDriver,InputField,Task);
        return this;
    }

    //Mark the added task as completed
    public Home_Page MarkAsCompleted(){
        Utility.ClickOnElement(chromeDriver,CheckBox);
        return this;
    }

    //Delete the completed task
    public void DeleteCompletedTask(){
        Utility.hoverOverElement(chromeDriver,TaskLabel);
        Utility.ClickOnElement(chromeDriver,DeleteButton);
        Utility.AcceptAlert(chromeDriver);
    }

}
