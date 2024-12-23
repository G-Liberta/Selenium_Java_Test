package com.lhind.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class RegisterPage {
    WebDriver driver;

    // Locators
    By registerButton = By.xpath("//a[@class='ico-register' and contains(@href, '/register')]");
    By pageTitle = By.xpath("//div[@class='page-title']");
    By genderFemale = By.xpath("//input[@id='gender-female']");
    By firstName = By.xpath("//input[@id='FirstName']");
    By lastName = By.xpath("//input[@id='LastName']");
    By dobDay = By.xpath("//select[@name='DateOfBirthDay']/option[@value='3']");
    By dobMonth = By.xpath("//select[@name='DateOfBirthMonth']/option[@value='10']");
    By dobYear = By.xpath("//select[@name='DateOfBirthYear']/option[@value='1983']");
    By email = By.xpath("//input[@id='Email']");
    By company = By.xpath("//input[@id='Company']");
    By password = By.xpath("//input[@id='Password']");
    By confirmPassword = By.xpath("//input[@id='ConfirmPassword']");
    By registerSubmitButton = By.xpath("//button[@id='register-button']");
    By logoutButton = By.xpath("//a[@href='/logout']");
    public By successMessage = By.xpath("//div[@class='result' and text()='Your registration completed']");

    // Constructor
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to open the page
    public void openPage() {
        driver.get("https://demo.nopcommerce.com/");
    }

    // Method to click the Register button with explicit wait
    public void clickRegisterButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(registerButton)).click();
    }

    // Method to get the page title text with explicit wait
    public String getPageTitle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle));
        return driver.findElement(pageTitle).getText();
    }

    // Method to select gender Female
    public void selectGenderFemale() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(genderFemale)).click();
    }

    // Method to enter first name
    public void enterFirstName(String fname) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName)).sendKeys(fname);
    }

    // Method to enter last name
    public void enterLastName(String lname) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastName)).sendKeys(lname);
    }

    // Method to select date of birth
    public void selectDateOfBirth() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(dobDay)).click();
        wait.until(ExpectedConditions.elementToBeClickable(dobMonth)).click();
        wait.until(ExpectedConditions.elementToBeClickable(dobYear)).click();
    }

    // Method to input email
    public void enterEmail(String emailInput) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(email)).sendKeys(emailInput);
    }

    // Method to input company name
    public void enterCompanyName(String companyName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(company)).sendKeys(companyName);
    }

    // Method to scroll down
    public void scrollDown() {
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("window.scrollBy(0,250)");
    }

    // Method to input password
    public void enterPassword(String passwordInput) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(password)).sendKeys(passwordInput);
    }

    // Method to input confirm password
    public void enterConfirmPassword(String confirmPwdInput) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmPassword)).sendKeys(confirmPwdInput);
    }

    // Method to click the final register button
    public void clickRegisterSubmitButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(registerSubmitButton)).click();
    }

    // Method to get the success message text
public String getSuccessMessage() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
    return driver.findElement(successMessage).getText();
}

    // Method to click the logout button
public void clickLogoutButton() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
    System.out.println("Clicked the Logout button.");
}
}

