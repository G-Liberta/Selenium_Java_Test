package com.lhind.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.lhind.selenium.utils.TestConfig;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {

    private WebDriver driver;
    private WebDriverWait wait;



    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    // Method to hover over the Computers Menu and click on Notebooks
    public void hoverAndClickNotebooks() {
        Actions actions = new Actions(driver);
        WebElement computersMenuElement = driver.findElement(TestConfig.computersMenu);
        actions.moveToElement(computersMenuElement).perform();
        wait.until(ExpectedConditions.elementToBeClickable(TestConfig.notebooksLink)).click();
    }

    // Verify we have navigated to Notebooks Page
    public boolean isNotebooksPageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(TestConfig.pageTitle)).getText().contains("Notebooks");
    }

    // Choose 9 on Display dropdown
    public void selectDisplayOption9() {
        driver.findElement(TestConfig.displayDropdown).click();
        wait.until(ExpectedConditions.elementToBeClickable(TestConfig.option9)).click();
    }

    // Verify only 6 items are displayed in product container
    public boolean are6ItemsDisplayed() {
        return driver.findElements(By.xpath("//div[@class='product-grid']//div[@class='product-item']")).size() == 6;
    }

    // Check 16GB option filter
    public void select16GBFilter() {
        driver.findElement(TestConfig.filter16GB).click();
    }

    // Verify only 1 item is displayed after 16GB filter is selected
    public boolean is1ItemDisplayedAfter16GBFilter() {
        return driver.findElements(By.xpath("//div[@class='product-grid']//div[@class='product-item']")).size() == 1;
    }

    // Uncheck 16GB filter
    public void uncheck16GBFilter() {
        driver.findElement(TestConfig.filter16GB).click();
    }

    // Verify that 6 items are displayed after unchecking 16GB filter
    public boolean are6ItemsDisplayedAfterUnchecking16GB() {
        return driver.findElements(By.xpath("//div[@class='product-grid']//div[@class='product-item']")).size() == 6;
    }

    // Add items to wishlist
    public void addToWishlist() {
        driver.findElement(TestConfig.addToWishlistBtn).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(TestConfig.productAddedToWishlistMsg));
    }

    // Add items to cart
    public void addToCart() {
        driver.findElement(TestConfig.addToCartBtn4).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(TestConfig.productAddedToWishlistMsg));
        driver.findElement(TestConfig.addToCartBtn5).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(TestConfig.productAddedToWishlistMsg));
        driver.findElement(TestConfig.addToCartBtn6).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(TestConfig.productAddedToWishlistMsg));
    }

    // Verify Wishlist count
    public boolean verifyWishlistCount() {
        return driver.findElement(TestConfig.wishlistQty).isDisplayed();
    }

    // Verify Shopping Cart count
    public boolean verifyCartCount() {
        return driver.findElement(TestConfig.cartQty).isDisplayed();
    }

    // Dashboard method
    public void dashboard() {
        hoverAndClickNotebooks();
        addToCart();
    }
}
