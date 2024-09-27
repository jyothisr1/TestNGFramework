package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(id ="user-name" )
    WebElement usernameInput;

    @FindBy(id ="password" )
    WebElement passwordInput;

    @FindBy(id ="login-button" )
    WebElement signInButton;

//    WebDriver driver;

    public LoginPage(){
//        super(driver);
//        this.driver=driver;
    }

    public void openWebsite(){
        driver.get("https://www.saucedemo.com/");
    }

    public void doLogin(String username,String password){
//        WebElement usernameInput = driver.findElement(By.id("user-name"));
//        WebElement passwordInput = driver.findElement(By.id("password"));
//        WebElement signInButton = driver.findElement(By.id("login-button"));

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        signInButton.click();
    }

    public boolean isLoginPageDisplayed(){
//        WebElement usernameInput = driver.findElement(By.id("user-name"));
//        WebElement passwordInput = driver.findElement(By.id("password"));
        return usernameInput.isDisplayed() && passwordInput.isDisplayed();
    }
}
