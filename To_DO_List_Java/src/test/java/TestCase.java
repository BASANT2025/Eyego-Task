import Pages.Home_Page;
import Utilities.Utility;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase {
    private WebDriver chromeDriver;

    @BeforeMethod
    public void SetupDriver(){
        chromeDriver = Utility.OpenBrowser(chromeDriver);
}

    @Test
    public void AddValidNewTask (){
        Home_Page page = new Home_Page(chromeDriver);
        page.AddNewTask("Drink more water").MarkAsCompleted().DeleteCompletedTask();
    }



    @AfterMethod
    public void Quit(){
    Utility.QuitTest(chromeDriver);
    }
}
