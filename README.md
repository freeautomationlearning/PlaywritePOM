
#  Playwright Framework (UI + API )

I have designed a Framework which supports POM design pattern for UI and API testing.
This Framework is using Playwright automation library for UI and API test automation. 
For reporting we are using Extent Report. A single reports contains UI and API results. You get Report under target>>Spark folder  


## Installation

Clone the project on your local system and run the below commands

```
    mvn install
    mvn clean test
```

## About Framework

### Design Pattern and Organization:

The framework utilizes the Page Object Model (POM) design pattern, which promotes maintaining a clear structure for UI interactions by encapsulating web page functionalities in dedicated classes. This helps with code reusability, structure, and maintainability.

The framework is organized into several packages that separate concerns, enhancing readability and maintainability.

### Base Packages:

com.freeautomationlearning.base: This package contains base classes that provide utility functions and shared functionalities for UI and API testing, including session management for Playwright and extent reports for logging.

UI and API bases are differentiated, allowing specific implementations for web UI and REST API automations.

### UI Pages:

com.freeautomationlearning.ui.pages: This package includes classes that represent different pages of the target application (e.g., HomePage, DashboardPage, ResetPassword). Each class contains methods that define the actions that can be performed on that particular page (e.g., enterUserName, clickOnLogout, etc.).

### API Pages:

com.freeautomationlearning.api.pages: Similar to the UI pages, this package includes classes for managing API interactions with endpoints such as LoginPage and Users, containing relevant methods like loginUser and verifyUserNameDetails.

### Listeners and Reporting:

The framework leverages TestNG listeners to create a cohesive reporting mechanism using Extent Reports. The TestListeners class manages the reporting workflow (like before/after test execution) and appends logs and screenshots for better analysis.

The ExtentReportManager class is responsible for initializing, creating, and flushing reports. It handles all interactions with the Extent Reports library.

### Utility Classes:

com.freeautomationlearning.utlis: This package provides utility functions to read configuration values, process JSON data, and manage constants used throughout the framework. For example, UtilClass carries methods to retrieve data from JSON files and defines configurations.

### API Testing Structure:

The API interaction classes (APIFactoryBase, APIFactoryBaseImplementation) manage HTTP requests, context settings for API interactions, and provide a structured way to call APIs with request options (like headers).

The actual API tests (e.g., LoginTestScript, UserDetailsTestScript) leverage the base API test classes for setting up the testing environment before each test runs.

### UI Testing Structure:

The UI interactions follow a similar structure to API testing using UIFactoryBase and UIFactoryBaseImplementation, which provides browser launch and context management.

The UI test classes utilize page object classes (like LoginTestScript) to execute user flows interactively.


### Data Handling:
The framework pulls test data from JSON files stored in the filesystem. Test data is accessed through utility functions, ensuring that the execution remains data-driven.


## 🚀 About Me
I am Full Stack Tester. For more info Please go to my channel on YouTube [Free Automation Learning](https://www.youtube.com/channel/UCFs7BfAeJI6MtdqzTXdA9Og)


## 🔗 Links
[![portfolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://freeautomationlearning.github.io/home/)
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/chirag-singh-freeautomationlearning/)
[![twitter](https://img.shields.io/badge/twitter-1DA1F2?style=for-the-badge&logo=twitter&logoColor=white)](https://twitter.com/freeautomation)

