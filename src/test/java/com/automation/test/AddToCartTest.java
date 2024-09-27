package com.automation.test;

import com.automation.pages.HomePage;
import com.automation.utils.configReader;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseTest{

    @Test
    public void verifyAddToCart() throws InterruptedException {
        loginPage.openWebsite();
        loginPage.doLogin(configReader.getConfigValue("login.username"),configReader.getConfigValue("login.password"));

        homePage.addToCart();
//        Thread.sleep(3000);
    }
}
