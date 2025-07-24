import unittest
from utilities.utility import Utility 
from pages.home_page import Home_Page 

class TestCase(unittest.TestCase):
    def setUp(self):
        self.chromeDriver = Utility.open_browser()

    def test_AddValidNewTask(self):
        page = Home_Page(self.chromeDriver)
        page.AddNewTask("Drink more water").MarkAsCompleted().DeleteCompletedTask()

    def tearDown(self):
        Utility.QuitTest(self.chromeDriver)

if __name__ == "__main__":
    unittest.main()
