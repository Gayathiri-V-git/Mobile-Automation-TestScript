package com.MobileTesting.driverUtility;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.AppiumDriver;

public class DriverUtility {

    public static AppiumDriver driver;

    public static AppiumDriver initAndroidDriverSession() {

    	UiAutomator2Options options = new UiAutomator2Options();
    	options.setDeviceName("pixel_9");
    	options.setUdid("emulator-5554");
    	options.setPlatformName("Android");
    	options.setAutomationName("UiAutomator2");

    	// APK path
    	String appPath = System.getProperty("user.dir") + "/src/test/resources/cq-inspections-internal-4.0.6.apk";
    	options.setApp(appPath);

    	// Robust launch settings
    	options.setAppWaitDuration(Duration.ofSeconds(120)); 
    	options.setAppWaitActivity("*"); 
    	options.setFullReset(true); 
    	options.setNoReset(false); 
    	
        try {
            // Appium server URL
            URL serverUrl = new URI("http://127.0.0.1:4723").toURL();
            // Create driver session
            driver = new AndroidDriver(serverUrl, options);
            System.out.println("Session started. Session ID: " + driver.getSessionId());
        } catch (MalformedURLException | URISyntaxException e) {
            e.printStackTrace();
        }

        return driver;
    }
}