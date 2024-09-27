package com.automation.test;

import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;
import com.automation.utils.DriverManager;
import com.automation.utils.configReader;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;

public class BaseTest {
//    WebDriver driver;

    LoginPage loginPage;
    HomePage homePage;
    private ExtentReports extent;
    public static ExtentTest test;
    private static ExtentSparkReporter sparkReporter;



    @BeforeMethod
    public void setUp(ITestContext context) throws MalformedURLException {
        String reportPath=System.getProperty("user.dir")+"\\reports\\extentReport.html";
        sparkReporter =new ExtentSparkReporter(reportPath);
        sparkReporter.config().setTheme(Theme.DARK);

        extent=new ExtentReports();
        test=extent.createTest("verify user can login");
        test.info("navigating to another page");

//        extent = ExtendManager.getInstance();
//        test = extent.createTest(getClass().getSimpleName());
//        test = extent.createTest("YourTestName");
//        driver=new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        configReader.initConfig();
        DriverManager.createDriver();
//        loginPage=new LoginPage(driver);
//         homePage=new HomePage(driver);
        loginPage=new LoginPage();
         homePage=new HomePage();

    }

//    @Test
//    public void yourTestMethod() {
//        // Your test logic
////        test.log(Status.INFO, "This step shows usage of log(status, details)");
////        test.log(Status.PASS, "This step shows usage of log(status, details)");
//    }

    @AfterMethod
    public void cleanUp(){
        extent.attachReporter(sparkReporter);
        extent.flush();
        DriverManager.getDriver().quit();
    }

    public String screenshot() throws IOException {
        TakesScreenshot ts=(TakesScreenshot) DriverManager.getDriver();
        File file=ts.getScreenshotAs(OutputType.FILE);
        String filePath="src/test/resources"+"/screenshot.png";
        FileUtils.copyFile(file,new File(filePath));
        return System.getProperty("user.dir")+"/"+filePath;
    }
}
