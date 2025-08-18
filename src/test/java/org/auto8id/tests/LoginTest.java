package org.auto8id.tests;

import org.auto8id.pages.HomePage;
import org.auto8id.pages.SignInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class LoginTest {
    WebDriver driver;
    WebDriverWait wait;
    HomePage homePage;
    SignInPage signInPage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/"); // Replace with your test URL
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        signInPage = new SignInPage(driver);
        homePage = new HomePage(driver);
    }

    @Test
    public void testSuccessfulLogin() {
        // fill login data on sign-in page
        signInPage.loginValidUser("standard_user","secret_sauce");
//        Assert.assertEquals(homePage.getSpanText(), "Products");
    }
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver=null;
        }
    }
}