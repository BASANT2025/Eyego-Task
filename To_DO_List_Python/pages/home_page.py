from selenium.webdriver.common.by import By
from utilities.utility import Utility # type: ignore

class Home_Page:
    def __init__(self, chromeDriver):
        self.chromeDriver = chromeDriver

    # Locators
    InputField = (By.XPATH, "//input[@placeholder='Write your next task here...']")
    CheckBox = (By.XPATH, "//label[@title='Done']")
    TaskLabel = (By.XPATH, "//form[@class='edit_task']")
    DeleteButton = (By.XPATH, "//li[@class='delete']/a[@data-hint='Delete task']/i[@class='icon-remove']")

    # Actions
    def AddNewTask(self, Task):
        Utility.AddNewTask(self.chromeDriver, self.InputField, Task)
        return self

    def MarkAsCompleted(self):
        Utility.ClickOnElement(self.chromeDriver, self.CheckBox)
        return self

    def DeleteCompletedTask(self):
        Utility.hover_over_element(self.chromeDriver, self.TaskLabel)
        Utility.ClickOnElement(self.chromeDriver, self.DeleteButton)
        Utility.AcceptAlert(self.chromeDriver)
