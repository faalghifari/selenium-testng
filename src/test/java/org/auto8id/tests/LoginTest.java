package org.auto8id.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class LoginTest {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/"); // Replace with your test URL
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void testSuccessfulLogin() {
        // fill login data on sign-in page
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.name("login-button")).click();

        // verify products is appeared after login
        driver.findElement(By.xpath("//span[text()='Products']")).isDisplayed();
        Assert.assertEquals(driver.findElement(By.xpath("//span[text()='Products']")).getText(), "Products");
    }
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver=null;
        }
    }
}