package com.lhind.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private final By computersMenu = By.xpath("//ul[@class='top-menu notmobile']//a[@href='/computers' and text()='Computers ']");
    private final By notebooksLink = By.xpath("//ul[@class='sublist first-level']//a[@href='/notebooks']");
    private final By pageTitle = By.xpath("//div[@class='page-title']");
    private final By displayDropdown = By.xpath("//select[@id='products-pagesize']");
    private final By option9 = By.xpath("//select[@id='products-pagesize']//option[@value='9']");
    private final By filter16GB = By.xpath("//input[@id=\"attribute-option-10\"]");
    private final By addToWishlistBtn = By.xpath("(//button[text()='Add to wishlist'])[2]");
    private final By productAddedToWishlistMsg = By.xpath("//p[@class='content' and contains(text(), 'The product has been added to your')]");
    private final By addToCartBtn4 = By.xpath("(//button[text()='Add to cart'])[4]");
    private final By addToCartBtn5 = By.xpath("(//button[text()='Add to cart'])[5]");
    private final By addToCartBtn6 = By.xpath("(//button[text()='Add to cart'])[6]");
    private final By wishlistQty = By.xpath("//span[@class='wishlist-qty' and contains(text(), '2')]");
    private final By cartQty = By.xpath("//span[@class='cart-qty' and contains(text(), '3')]");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    // Method to hover over the Computers Menu and click on Notebooks
    public void hoverAndClickNotebooks() {
        Actions actions = new Actions(driver);
        WebElement computersMenuElement = driver.findElement(computersMenu);
        actions.moveToElement(computersMenuElement).perform();
        wait.until(ExpectedConditions.elementToBeClickable(notebooksLink)).click();
    }

    // Verify we have navigated to Notebooks Page
    public boolean isNotebooksPageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle)).getText().contains("Notebooks");
    }

    // Choose 9 on Display dropdown
    public void selectDisplayOption9() {
        driver.findElement(displayDropdown).click();
        wait.until(ExpectedConditions.elementToBeClickable(option9)).click();
    }

    // Verify only 6 items are displayed in product container
    public boolean are6ItemsDisplayed() {
        return driver.findElements(By.xpath("//div[@class='product-grid']//div[@class='product-item']")).size() == 6;
    }

    // Check 16GB option filter
    public void select16GBFilter() {
        driver.findElement(filter16GB).click();
    }

    // Verify only 1 item is displayed after 16GB filter is selected
    public boolean is1ItemDisplayedAfter16GBFilter() {
        return driver.findElements(By.xpath("//div[@class='product-grid']//div[@class='product-item']")).size() == 1;
    }

    // Uncheck 16GB filter
    public void uncheck16GBFilter() {
        driver.findElement(filter16GB).click();
    }

    // Verify that 6 items are displayed after unchecking 16GB filter
    public boolean are6ItemsDisplayedAfterUnchecking16GB() {
        return driver.findElements(By.xpath("//div[@class='product-grid']//div[@class='product-item']")).size() == 6;
    }

    // Add items to wishlist
    public void addToWishlist() {
        driver.findElement(addToWishlistBtn).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(productAddedToWishlistMsg));
    }

    // Add items to cart
    public void addToCart() {
        driver.findElement(addToCartBtn4).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(productAddedToWishlistMsg));
        driver.findElement(addToCartBtn5).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(productAddedToWishlistMsg));
        driver.findElement(addToCartBtn6).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(productAddedToWishlistMsg));
    }

    // Verify Wishlist count
    public boolean verifyWishlistCount() {
        return driver.findElement(wishlistQty).isDisplayed();
    }

    // Verify Shopping Cart count
    public boolean verifyCartCount() {
        return driver.findElement(cartQty).isDisplayed();
    }
}
