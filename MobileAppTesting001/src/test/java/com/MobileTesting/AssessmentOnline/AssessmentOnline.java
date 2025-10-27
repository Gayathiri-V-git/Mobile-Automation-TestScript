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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));

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
        String loginButtonId = "io.clearquote.assessment:id/btnLogin"; 
        WebElement loginButton = wait.until(
                ExpectedConditions.elementToBeClickable(AppiumBy.id(loginButtonId))
        );
        System.out.println("Login button found. Clicking...");
        loginButton.click();

       
        System.out.println("Login test completed successfully.");
        
        try {
            WebDriverWait sysWait = new WebDriverWait(driver, Duration.ofSeconds(30));

            // Allow media/files access
            WebElement allowBtn = sysWait.until(
                ExpectedConditions.elementToBeClickable(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button"))
            );
            allowBtn.click();
            System.out.println("Clicked Allow button for media access");
        } catch (Exception e) {
            System.out.println("No media permission popup detected.");
        }
        
     // Wait object
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(2000));
        
        //Create Inspection
        WebElement inspectionIcon = wait1.until(
                ExpectedConditions.elementToBeClickable(AppiumBy.id("io.clearquote.assessment:id/ivInspection"))
        );
        System.out.println("Inspection icon found. Clicking...");
        inspectionIcon.click();
        
        try {
            WebElement locationAllowBtn = driver.findElement(
                AppiumBy.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button"));
            locationAllowBtn.click();
            System.out.println("Clicked Allow for location access");
        } catch (Exception e) {
            System.out.println("No location permission popup detected.");
        }
        
     // 🔹 VIN entry field
        WebElement vinField = wait1.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.id("io.clearquote.assessment:id/acInput")));
        System.out.println("VIN field found. Entering VIN...");
        vinField.sendKeys("TESTUSWEBUI002000");
        
     // Wait object
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(30));

        // 🔹 Next Step button (1st page)
        WebElement nextStep1 = wait1.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.id("io.clearquote.assessment:id/btnNextStep")));
        System.out.println("Next Step (1st page) button found. Clicking...");
        nextStep1.click();
        
        // Wait object
        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(30));

        // 🔹 Next Step button (2nd page)
        WebElement nextStep2 = wait1.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.id("io.clearquote.assessment:id/btnNextStep")));
        System.out.println("Next Step (2nd page) button found. Clicking...");
        nextStep2.click();

        
        // Wait object
        WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(30));
        
        
        // === Image Capture Section ===
        for (int i = 1; i <= 5; i++) {
            WebElement captureImage = wait1.until(ExpectedConditions.elementToBeClickable(
                    AppiumBy.id("io.clearquote.assessment:id/btnCaptureImage")));
            System.out.println("Capturing image #" + i + "...");
            captureImage.click();

            // optional wait between captures
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 🔹 Done button (after image capture)
        WebElement doneButton = wait1.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.id("io.clearquote.assessment:id/btnDone")));
        System.out.println("Done button found. Clicking...");
        doneButton.click();

        System.out.println("✅ Inspection flow completed successfully.");
    }
}