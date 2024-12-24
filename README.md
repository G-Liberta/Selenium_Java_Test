# Selenium & Java Automation Project

This project demonstrates automated UI testing using Java, Selenium WebDriver, TestNG, and the Page Object Model (POM) design pattern. 
The tests are implemented for the [nopCommerce Demo Store](https://demo.nopcommerce.com/) to verify different functionalities such as Register, Login, Add item to shopping cart, and other test scenarios.


## Features

- **Selenium WebDriver**: For browser automation.
- **TestNG**: For test management, assertions, and reporting.
- **Page Object Model (POM)**: To organize locators and actions for better reusability.
- **Maven**: For dependency management and build configuration.
- **Screenshots**: Automatically captured on test failures.
- **Reports**: Test results are logged using TestNG.

## Prerequisites

- **Java**: JDK 8 or later. Configure the JAVA_HOME environment variable.
- **Selenium**: Included in your Maven pom.xml file
- **Maven**: Installed and configured
- **TestNG**: Included in your Maven pom.xml file
- **ChromeDriver**: Installed and should be cmpatible to your Chrome browser version
- **VS Code**: IDE used for development (optional)

## Installation

1. Clone the repository:
   git clone <repository-url>
   cd <repository-directory>
2. Install dependencies: mvn clean install