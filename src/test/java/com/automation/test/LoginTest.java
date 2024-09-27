package com.automation.test;

import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;
import com.automation.utils.configReader;
import com.aventstack.extentreports.Status;
import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class LoginTest extends BaseTest{

    @Test
    public void verifyUserCanLoginWithValidCredential(){
//        driver.get("https://www.saucedemo.com/");
//        WebElement usernameInput = driver.findElement(By.id("user-name"));
//        WebElement passwordInput = driver.findElement(By.id("password"));
//        WebElement signInButton = driver.findElement(By.id("login-button"));
//
//        usernameInput.sendKeys("standard_user");
//        passwordInput.sendKeys("secret_sauce");
//        signInButton.click();

//        LoginPage loginPage=new LoginPage();

//        WebElement filterDropdown =driver.findElement(By.cssSelector(".product_sort_container"));
//        WebElement cartItem =driver.findElement(By.cssSelector(".shopping_cart_link"));

//        Assert.assertTrue(filterDropdown.isDisplayed(),"filter is not displayed");
//        Assert.assertTrue(cartItem.isDisplayed(),"cart is not displayed");

//        WebElement burgerMenuIcon =driver.findElement(By.id("react-burger-menu-btn"));
//        burgerMenuIcon.click();
//
//        WebElement logOutLink =driver.findElement(By.id("logout_sidebar_link"));
//        logOutLink.click();
//
//        Assert.assertTrue(loginPage.isLoginPageDisplayed(),"username input and password is not displayed");

//        Assert.assertTrue(usernameInput.isDisplayed(),"username input is not displayed");
//        Assert.assertTrue(passwordInput.isDisplayed(),"password input is not displayed");
    }

    @Test
    public void verifyUserCanLogOut() throws IOException {



//        LoginPage loginPage=new LoginPage(driver);

        loginPage.openWebsite();
//        test.addScreenCaptureFromPath(screenshot());
        loginPage.doLogin(configReader.getConfigValue("login.username"),configReader.getConfigValue("login.password"));

        test.addScreenCaptureFromPath(screenshot());

//        HomePage homePage=new HomePage(driver);
        Assert.assertTrue(homePage.isHomePageDisplayed(),"not displayed");

        homePage.clickOnBurgerMenu();
        homePage.clickOnLogoutLink();

        Assert.assertTrue(loginPage.isLoginPageDisplayed(),"login page is not displayed");

        test.log(Status.INFO, "Logged out successfully");
        test.log(Status.PASS, "User logout test passed");

    }
}
