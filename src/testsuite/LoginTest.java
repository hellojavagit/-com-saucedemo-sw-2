package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setup(){
        openBrowser(baseUrl);
    }
    @Test
    public void UserShouldLoginSuccessfullyWithValidCredentials(){
        //sending usename fields
        WebElement userNameField = driver.findElement(By.id("user-name"));
        userNameField.sendKeys("standard_user");
        //sending password fields
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("secret_sauce");
        //clicking the login button
        WebElement loginLink = driver.findElement(By.name("login-button"));
        loginLink.click();

    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        //sending the email fields  by using locator id
        WebElement userNameField = driver.findElement(By.id("user-name"));
        userNameField.sendKeys("standard_user");
        // sending the password fields by using name as locator
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("secret_sauce");
        //clicking the login button
        WebElement loginLink = driver.findElement(By.name("login-button"));
        loginLink.click();
        //verifying the number of elements on the page
    List<WebElement> productNo = driver.findElements(By.className("inventory_item"));
    int totalProducts = productNo.size();
    int expectedNumber = 6;
        Assert.assertEquals("Products numbers not matching", expectedNumber, totalProducts);

    }
    //closing the browser
    @After
    public void tearDown(){
       closeBrowser();
    }
}
