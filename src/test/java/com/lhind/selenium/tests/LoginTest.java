package com.lhind.selenium.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.lhind.selenium.pages.LoginPage;
import com.lhind.selenium.pages.Common;

import static org.testng.Assert.assertTrue;

public class LoginTest extends Common {

    private LoginPage loginPage;
    private static final String EMAIL = "liberta@gmail.com";
    private static final String PASSWORD = "User123";

    @BeforeMethod
    public void setUpTest() {
        setUp();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testLogin() {
        try {
            loginPage.clickLoginLink();
            loginPage.enterEmail(EMAIL);
            loginPage.enterPassword(PASSWORD);
            loginPage.clickLoginButton();

            assertTrue(loginPage.isWelcomeMessageDisplayed(), "Welcome message is not displayed.");
            assertTrue(loginPage.isLogoutButtonDisplayed(), "Logout button is not displayed.");

            loginPage.clickLogoutButton();
        } catch (Exception e) {
            captureScreenshot("LoginTest_Failure");
            throw e;
        }
    }

    @AfterMethod
    public void tearDownTest() {
        tearDown();
    }
}
