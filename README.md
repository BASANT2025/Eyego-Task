# To-Do List Automation (Python Selenium)

This project automates a basic to-do list application hosted at `https://flask.io/7XmdCLDx8zHp` using Python, Selenium, and the Page Object Model (POM) design pattern.

## 📁 Project Structure

```
To_DO_List_Python/
├── pages/
│   └── home_page.py        # Page methods: add, complete, delete task
├── utilities/
│   └── utility.py          # Chrome browser setup using Selenium
|                           # Utility functions to use in home_page class to make the code readable and reusable
└── tests/
    └── test_case.py        # unittest test case to run all steps (Adding new task-Mark it as completed-Deleting it)
```

## Features Automated

- Add a new task
- Mark the task as completed
- Delete the task

## Requirements

- Python 3.8+
- Selenium Framework
- Google Chrome browser installed
- Chromedriver in PATH
- Visual Studio Code (Optional)

## Installation

1. Install dependencies:

   Install Python & ChromeDriver.
   Install Selenium.

   ```bash
   pip install selenium
   ```

2. Clone or download the repository.

3. Run the test case:
   ```bash
   from the
   python tests/test_case.py
   or
   python -m unittest tests/test_case.py
   ```

## Assumptions made in Automation Testing

- Web application is publicly accessible.
- No login required.
- Elements remain stable during the session.

## Assumptions made in Manual Testing

1. The maximum number of allowable tasks for each user is 10 task/list.
2. All Error messages that should appear are assumed, because there is no requirements available for the website.
3. The displayed date can not be editted by the user.

## Author

- Basant Elsayed
