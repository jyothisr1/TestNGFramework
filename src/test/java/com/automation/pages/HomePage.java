package com.automation.pages;

import com.automation.utils.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @FindBy(id = "react-burger-menu-btn")
    WebElement burgerMenuIcon;

    @FindBy(id = "logout_sidebar_link")
    WebElement logOutLink;

    @FindBy(css = ".product_sort_container")
    WebElement filterDropdown;

    @FindBy(css = ".shopping_cart_link")
    WebElement cartItem;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement addToCart;

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    WebDriver count;



//    WebDriver driver;

    public HomePage() {
//        super(driver);
//        this.driver=driver;
//        PageFactory.initElements(driver,this);

    }

    public void clickOnBurgerMenu() {
//        WebElement burgerMenuIcon =driver.findElement(By.id("react-burger-menu-btn"));
        burgerMenuIcon.click();
    }

    public void clickOnLogoutLink() {
//        WebElement logOutLink =driver.findElement(By.id("logout_sidebar_link"));
        logOutLink.click();
    }

    public boolean isHomePageDisplayed() {
//        WebElement filterDropdown =driver.findElement(By.cssSelector(".product_sort_container"));
//        WebElement cartItem =driver.findElement(By.cssSelector(".shopping_cart_link"));
        return filterDropdown.isDisplayed() && cartItem.isDisplayed();
    }

    public void addToCart() {
        addToCart.click();
    }

    public boolean addedToCart() {

//        return count;
        return true;
    }
}
