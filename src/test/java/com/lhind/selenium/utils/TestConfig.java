package com.lhind.selenium.utils;

import java.time.Duration;
import org.openqa.selenium.By;

public class TestConfig {

    // Base URL for the application
    public static final String BASE_URL = "https://demo.nopcommerce.com/";

    // Timeout duration for WebDriverWait
    public static final Duration TIMEOUT = Duration.ofSeconds(10);



    // RegisterPage Locators
    public static final By registerButton = By.xpath("//a[@class='ico-register' and contains(@href, '/register')]");
    public static final By pageTitle = By.xpath("//div[@class='page-title']");
    public static final By genderFemale = By.xpath("//input[@id='gender-female']");
    public static final By firstName = By.xpath("//input[@id='FirstName']");
    public static final By lastName = By.xpath("//input[@id='LastName']");
    public static final By dobDay = By.xpath("//select[@name='DateOfBirthDay']/option[@value='3']");
    public static final By dobMonth = By.xpath("//select[@name='DateOfBirthMonth']/option[@value='10']");
    public static final By dobYear = By.xpath("//select[@name='DateOfBirthYear']/option[@value='1983']");
    public static final By email = By.xpath("//input[@id='Email']");
    public static final By company = By.xpath("//input[@id='Company']");
    public static final By password = By.xpath("//input[@id='Password']");
    public static final By confirmPassword = By.xpath("//input[@id='ConfirmPassword']");
    public static final By registerSubmitButton = By.xpath("//button[@id='register-button']");
    public static final By logoutButton = By.xpath("//a[@href='/logout']");
    public static final By successMessage = By.xpath("//div[@class='result' and text()='Your registration completed']");

    // DashboardPage Locators
    public static final By computersMenu = By.xpath("//ul[@class='top-menu notmobile']//a[@href='/computers' and text()='Computers ']");
    public static final By notebooksLink = By.xpath("//ul[@class='sublist first-level']//a[@href='/notebooks']");
    public static final By displayDropdown = By.xpath("//select[@id='products-pagesize']");
    public static final By option9 = By.xpath("//select[@id='products-pagesize']//option[@value='9']");
    public static final By filter16GB = By.xpath("//input[@id=\"attribute-option-10\"]");
    public static final By addToWishlistBtn = By.xpath("(//button[text()='Add to wishlist'])[2]");
    public static final By productAddedToWishlistMsg = By.xpath("//p[@class='content' and contains(text(), 'The product has been added to your')]");
    public static final By addToCartBtn4 = By.xpath("(//button[text()='Add to cart'])[4]");
    public static final By addToCartBtn5 = By.xpath("(//button[text()='Add to cart'])[5]");
    public static final By addToCartBtn6 = By.xpath("(//button[text()='Add to cart'])[6]");
    public static final By wishlistQty = By.xpath("//span[@class='wishlist-qty' and contains(text(), '2')]");
    public static final By cartQty = By.xpath("//span[@class='cart-qty' and contains(text(), '3')]");

    // EmptyShopping Cart Locators
    public static final  By cartItemCount = By.xpath("//a[@href='/cart']//span[@class='cart-qty']");
    public static final  By removeButton = By.xpath("(//button[@class='remove-btn'])[1]");
    public static final  By emptyCartMessage = By.xpath("//div[@class='no-data']");
    public static final  By cartItemsTable = By.xpath("//table[@class='cart']//tbody//tr");

    // Login Locators
    public static final By loginLink = By.xpath("//a[@class='ico-login' and text()='Log in']");
    public static final By emailField = By.xpath("//input[@id='Email']");
    public static final By passwordField = By.xpath("//input[@id='Password']");
    public static final By loginButton = By.xpath("//button[@class='button-1 login-button' and text()='Log in']");
    public static final By welcomeMessage = By.xpath("//div[@class='topic-block-title']/h2");

    // ShoppingCart Locators
    public static final By shoppingCartMenu = By.xpath("//li[@id='topcartlink']//a[@href='/cart']");
    public static final By goToCartButton = By.xpath("//button[@class='button-1 cart-button']");
    public static final By shoppingCartTitle = By.xpath("//div[@class='page-title' and contains(text(),'Shopping cart')]");
    public static final By updateCartButton = By.xpath("//button[@id='updatecart']");
    public static final By continueShoppingButton = By.xpath("//button[@class=\"button-2 continue-shopping-button\"]");
    public static final By estimateShippingButton = By.xpath("//a[@id='open-estimate-shipping-popup' and @class='estimate-shipping-button']");
    public static final By priceForProduct1 = By.xpath("(//span[@class='product-subtotal'])[1]");
    public static final By priceForProduct2 = By.xpath("(//span[@class='product-subtotal'])[2]");
    public static final By priceForProduct3 = By.xpath("(//span[@class='product-subtotal'])[3]");
    public static final By totalPrice = By.xpath("//tr[@class='order-total']//td[@class='cart-total-right']");
    
    
}


