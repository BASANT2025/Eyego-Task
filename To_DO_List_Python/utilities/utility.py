from selenium import webdriver
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.common.exceptions import TimeoutException
from selenium.webdriver.common.action_chains import ActionChains

class Utility:

    @staticmethod
    def open_browser():
        options = Options()
        options.add_argument("--start-maximized")
        options.add_argument("--incognito")
        driver = webdriver.Chrome(options=options)
        driver.get("https://flask.io/7XmdCLDx8zHp")
        driver.implicitly_wait(4)
        return driver

    @staticmethod
    def AddNewTask(driver, locator, task):
        #WebDriverWait(driver, 5).until(EC.visibility_of_element_located(locator))
        task_element = driver.find_element(*locator)
        task_element.send_keys(task)
        task_element.send_keys(Keys.ENTER)
        Utility.PauseTest(3, driver)

    @staticmethod
    def hover_over_element(driver,locator):
        element= WebDriverWait(driver, 8).until(EC.visibility_of_element_located(locator))
        actions = ActionChains(driver)
        actions.move_to_element(element).perform()

    @staticmethod
    def ClickOnElement(driver, locator):
        element= WebDriverWait(driver, 8).until(EC.visibility_of_element_located(locator))
        WebDriverWait(driver, 8).until(EC.element_to_be_clickable(locator))
        driver.execute_script("arguments[0].scrollIntoView(true);", element)
        driver.find_element(*locator).click()
        Utility.PauseTest(3, driver)
        

    @staticmethod
    def AcceptAlert(driver):
        driver.switch_to.alert.accept()
        Utility.PauseTest(4, driver)

    @staticmethod
    def QuitTest(driver):
        driver.quit()

    @staticmethod
    def PauseTest(seconds, driver):
        try:
            WebDriverWait(driver, seconds).until(lambda d: False)
        except TimeoutException:
            pass  # Expected timeout acts as delay
