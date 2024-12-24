package com.lhind.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.math.BigDecimal;
import java.time.Duration;

public class ShoppingCartPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private final By shoppingCartMenu = By.xpath("//li[@id='topcartlink']//a[@href='/cart']");
    private final By goToCartButton = By.xpath("//button[@class='button-1 cart-button']");
    private final By shoppingCartTitle = By.xpath("//div[@class='page-title' and contains(text(),'Shopping cart')]");
    private final By updateCartButton = By.xpath("//button[@id='updatecart']");
    private final By continueShoppingButton = By.className("button-2 continue-shopping-button");
    private final By estimateShippingButton = By.xpath("//a[@id='open-estimate-shipping-popup' and @class='estimate-shipping-button']");
    private final By priceForProduct1 = By.xpath("(//span[@class='product-subtotal'])[1]");
    private final By priceForProduct2 = By.xpath("(//span[@class='product-subtotal'])[2]");
    private final By priceForProduct3 = By.xpath("(//span[@class='product-subtotal'])[3]");
    private final By totalPrice = By.xpath("//tr[@class='order-total']//td[@class='cart-total-right']");

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Hover over Shopping Cart menu
    public void hoverOverShoppingCartMenu() {
        Actions actions = new Actions(driver);
        WebElement shoppingCartElement = wait.until(ExpectedConditions.visibilityOfElementLocated(shoppingCartMenu));
        actions.moveToElement(shoppingCartElement).perform();
    }

    // Click 'Go To Cart' button
    public void clickGoToCartButton() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(goToCartButton));
        button.click();
    }

    // Verify Shopping Cart Page title
    public boolean isShoppingCartPageDisplayed() {
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(shoppingCartTitle, "Shopping cart"));
    }

    // Verify buttons are displayed
    public boolean isUpdateCartButtonDisplayed() {
        return driver.findElement(updateCartButton).isDisplayed();
    }

    public boolean isContinueShoppingButtonDisplayed() {
        return driver.findElement(continueShoppingButton).isDisplayed();
    }

    public boolean isEstimateShippingButtonDisplayed() {
        return driver.findElement(estimateShippingButton).isDisplayed();
    }

    // Get price for a product
    private BigDecimal getPrice(By locator) {
        String priceText = driver.findElement(locator).getText().replace("$", "").trim();
        return new BigDecimal(priceText);
    }

    // Calculate total price of all products
    public BigDecimal calculateTotalPrice() {
        BigDecimal price1 = getPrice(priceForProduct1);
        BigDecimal price2 = getPrice(priceForProduct2);
        BigDecimal price3 = getPrice(priceForProduct3);
        return price1.add(price2).add(price3);
    }

    // Get the total price displayed at the bottom
    public BigDecimal getDisplayedTotalPrice() {
        String totalText = driver.findElement(totalPrice).getText().replace("$", "").trim();
        return new BigDecimal(totalText);
    }
}
