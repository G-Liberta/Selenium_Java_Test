package com.lhind.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.lhind.selenium.utils.TestConfig;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class RegisterPage {

    private WebDriver driver;


    // Constructor
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    // Private method for explicit wait to check if element is visible
    private void waitUntilElementIsVisible(By locator, Duration timeout) {
        new WebDriverWait(driver, timeout)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Private method for explicit wait to check if element is clickable
    private void waitUntilElementIsClickable(By locator, Duration timeout) {
        new WebDriverWait(driver, timeout)
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    // Method to open the page
    public void openPage(String url) {
        driver.get(url);
    }

    // Method to click a button with explicit wait
    private void clickElement(By locator) {
        waitUntilElementIsClickable(locator, Duration.ofSeconds(10));
        driver.findElement(locator).click();
    }

    // Method to get text of an element
    private String getElementText(By locator) {
        waitUntilElementIsVisible(locator, Duration.ofSeconds(10));
        return driver.findElement(locator).getText();
    }

    // Method to click the Register button
    public void clickRegisterButton() {
        clickElement(TestConfig.registerButton);
    }

    // Method to get the page title
    public String getPageTitle() {
        return getElementText(TestConfig.pageTitle);
    }

    // Method to select gender Female
    public void selectGenderFemale() {
        clickElement(TestConfig.genderFemale);
    }

    // Method to enter first name
    public void enterFirstName(String fname) {
        waitUntilElementIsVisible(TestConfig.firstName, Duration.ofSeconds(10));
        driver.findElement(TestConfig.firstName).sendKeys(fname);
    }

    // Method to enter last name
    public void enterLastName(String lname) {
        waitUntilElementIsVisible(TestConfig.lastName, Duration.ofSeconds(10));
        driver.findElement(TestConfig.lastName).sendKeys(lname);
    }

    // Method to select date of birth
    public void selectDateOfBirth() {
        clickElement(TestConfig.dobDay);
        clickElement(TestConfig.dobMonth);
        clickElement(TestConfig.dobYear);
    }

    // Method to input email
    public void enterEmail(String emailInput) {
        waitUntilElementIsVisible(TestConfig.email, Duration.ofSeconds(10));
        driver.findElement(TestConfig.email).sendKeys(emailInput);
    }

    // Method to input company name
    public void enterCompanyName(String companyName) {
        waitUntilElementIsVisible(TestConfig.company, Duration.ofSeconds(10));
        driver.findElement(TestConfig.company).sendKeys(companyName);
    }

    // Method to scroll down the page
    public void scrollDown() {
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("window.scrollBy(0,250)");
    }

    // Method to input password
    public void enterPassword(String passwordInput) {
        waitUntilElementIsVisible(TestConfig.password, Duration.ofSeconds(10));
        driver.findElement(TestConfig.password).sendKeys(passwordInput);
    }

    // Method to input confirm password
    public void enterConfirmPassword(String confirmPwdInput) {
        waitUntilElementIsVisible(TestConfig.confirmPassword, Duration.ofSeconds(10));
        driver.findElement(TestConfig.confirmPassword).sendKeys(confirmPwdInput);
    }

    // Method to click the final register button
    public void clickRegisterSubmitButton() {
        clickElement(TestConfig.registerSubmitButton);
    }

    // Method to get the success message text
    public String getSuccessMessage() {
        return getElementText(TestConfig.successMessage);
    }

    // Method to click the logout button
    public void clickLogoutButton() {
        clickElement(TestConfig.logoutButton);
        System.out.println("Clicked the Logout button.");
    }
}
