package Utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Utility {
    //TODO: Setup the browser before each test
    public static WebDriver OpenBrowser(WebDriver chromeDriver){
        ChromeOptions options = new ChromeOptions();
        //Set the browser options to open in maximized view and in an icognito window
        options.addArguments("--start-maximized");
        chromeDriver = new ChromeDriver(options);
        chromeDriver.get("https://flask.io/7XmdCLDx8zHp");
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        return chromeDriver;
    }
    //TODO: Send text to task input field to add a new task
    public static void AddNewTask(WebDriver chromeDriver, By locator, String task){
//        new WebDriverWait(chromeDriver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(locator));
        WebElement Task = chromeDriver.findElement(locator);
        Task.sendKeys(task);
        Task.sendKeys(Keys.ENTER);
        PauseTest(3,chromeDriver);
    }

    //TODO: Hover over the element == To make the deletion button displayed
    public static void hoverOverElement(WebDriver chromeDriver, By locator) {
        Actions actions = new Actions(chromeDriver);
        actions.moveToElement(chromeDriver.findElement(locator)).perform(); // Hover action
    }

    //TODO: Click the element == To delete task
    public static void ClickOnElement(WebDriver chromeDriver, By locator){

        //new WebDriverWait(chromeDriver, Duration.ofSeconds(8)).until(ExpectedConditions.visibilityOfElementLocated(locator));
        new WebDriverWait(chromeDriver, Duration.ofSeconds(8)).until(ExpectedConditions.elementToBeClickable(locator));
        chromeDriver.findElement(locator).click();
        PauseTest(3,chromeDriver);

    }

    //TODO: Accept the alert displayed after deleting a task
    public static void AcceptAlert(WebDriver chromeDriver){
        chromeDriver.switchTo().alert().accept();
        PauseTest(4,chromeDriver);

    }

    //TODO: Quit the browser after each test
    public static void QuitTest(WebDriver chromeDriver){
        chromeDriver.quit();
    }

    //TODO: Pause the test so that the execution can be recorded
    public static void PauseTest(int seconds, WebDriver chromeDriver){
            try {
                new WebDriverWait(chromeDriver, Duration.ofSeconds(seconds))
                        .until(driver -> false);  // Always false, just to cause wait
            } catch (TimeoutException e) {
                // Expected timeout — this acts like a pause
        }
    }
}
