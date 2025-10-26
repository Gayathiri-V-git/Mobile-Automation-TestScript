package com.MobileTesting.AssessmentOnline;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.MobileTesting.driverUtility.DriverUtility;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class AssessmentOnline {

    @Test
    public void testLocators() {

        // Create Appium driver session
        AppiumDriver driver = DriverUtility.initAndroidDriverSession();

        // Wait object
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        // ✅ Wait until the app's main activity is fully loaded
        System.out.println("Waiting for app to launch...");

        // Adjust the first element you expect on the login screen
        WebElement userIdField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("(//android.widget.AutoCompleteTextView[@resource-id=\"io.clearquote.assessment:id/acInput\"])[1]\n"
                		+ ""))
        );
        System.out.println("User ID field found. Entering username...");
        userIdField.sendKeys("dacb15");

        // Password field
        WebElement passwordField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("(//android.widget.AutoCompleteTextView[@resource-id=\"io.clearquote.assessment:id/acInput\"])[2]\n"
                		+ ""))
        );
        System.out.println("Password field found. Entering password...");
        passwordField.sendKeys("Abcd@123");

        // Login button
        String loginButtonId = "io.clearquote.assessment:id/btnLogin"; // replace with actual ID
        WebElement loginButton = wait.until(
                ExpectedConditions.elementToBeClickable(AppiumBy.id(loginButtonId))
        );
        System.out.println("Login button found. Clicking...");
        loginButton.click();

        // ✅ Optional: wait for a home screen element to confirm login success
        // Example:
        // WebElement homeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("io.clearquote.assessment:id/homeView")));

        System.out.println("Login test completed successfully.");
    }
}