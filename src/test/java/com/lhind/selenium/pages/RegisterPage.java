package com.lhind.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class RegisterPage {

    private WebDriver driver;

    // Locators
    private final By registerButton = By.xpath("//a[@class='ico-register' and contains(@href, '/register')]");
    private final By pageTitle = By.xpath("//div[@class='page-title']");
    private final By genderFemale = By.xpath("//input[@id='gender-female']");
    private final By firstName = By.xpath("//input[@id='FirstName']");
    private final By lastName = By.xpath("//input[@id='LastName']");
    private final By dobDay = By.xpath("//select[@name='DateOfBirthDay']/option[@value='3']");
    private final By dobMonth = By.xpath("//select[@name='DateOfBirthMonth']/option[@value='10']");
    private final By dobYear = By.xpath("//select[@name='DateOfBirthYear']/option[@value='1983']");
    private final By email = By.xpath("//input[@id='Email']");
    private final By company = By.xpath("//input[@id='Company']");
    private final By password = By.xpath("//input[@id='Password']");
    private final By confirmPassword = By.xpath("//input[@id='ConfirmPassword']");
    private final By registerSubmitButton = By.xpath("//button[@id='register-button']");
    private final By logoutButton = By.xpath("//a[@href='/logout']");
    private final By successMessage = By.xpath("//div[@class='result' and text()='Your registration completed']");

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
        clickElement(registerButton);
    }

    // Method to get the page title
    public String getPageTitle() {
        return getElementText(pageTitle);
    }

    // Method to select gender Female
    public void selectGenderFemale() {
        clickElement(genderFemale);
    }

    // Method to enter first name
    public void enterFirstName(String fname) {
        waitUntilElementIsVisible(firstName, Duration.ofSeconds(10));
        driver.findElement(firstName).sendKeys(fname);
    }

    // Method to enter last name
    public void enterLastName(String lname) {
        waitUntilElementIsVisible(lastName, Duration.ofSeconds(10));
        driver.findElement(lastName).sendKeys(lname);
    }

    // Method to select date of birth
    public void selectDateOfBirth() {
        clickElement(dobDay);
        clickElement(dobMonth);
        clickElement(dobYear);
    }

    // Method to input email
    public void enterEmail(String emailInput) {
        waitUntilElementIsVisible(email, Duration.ofSeconds(10));
        driver.findElement(email).sendKeys(emailInput);
    }

    // Method to input company name
    public void enterCompanyName(String companyName) {
        waitUntilElementIsVisible(company, Duration.ofSeconds(10));
        driver.findElement(company).sendKeys(companyName);
    }

    // Method to scroll down the page
    public void scrollDown() {
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("window.scrollBy(0,250)");
    }

    // Method to input password
    public void enterPassword(String passwordInput) {
        waitUntilElementIsVisible(password, Duration.ofSeconds(10));
        driver.findElement(password).sendKeys(passwordInput);
    }

    // Method to input confirm password
    public void enterConfirmPassword(String confirmPwdInput) {
        waitUntilElementIsVisible(confirmPassword, Duration.ofSeconds(10));
        driver.findElement(confirmPassword).sendKeys(confirmPwdInput);
    }

    // Method to click the final register button
    public void clickRegisterSubmitButton() {
        clickElement(registerSubmitButton);
    }

    // Method to get the success message text
    public String getSuccessMessage() {
        return getElementText(successMessage);
    }

    // Method to click the logout button
    public void clickLogoutButton() {
        clickElement(logoutButton);
        System.out.println("Clicked the Logout button.");
    }
}
