package com.example.AppiumExample;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumDriverConfig {
    public final AppiumDriver driver;
    private static AppiumDriverConfig instance;

    public static AppiumDriverConfig getInstance() {
        if (AppiumDriverConfig.instance == null) {
            AppiumDriverConfig.instance = new AppiumDriverConfig();
        }

        return AppiumDriverConfig.instance;
    }

    private AppiumDriverConfig() {

        File apkFile = new File("C:\\Users\\mocbe\\Desktop\\Projects\\appium-example\\src\\main\\resources\\alura_esporte.apk");

        URL urlAppium = null;

        try {
            urlAppium = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.APP, apkFile.getAbsolutePath());
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");


        driver = new AppiumDriver(urlAppium, desiredCapabilities);
    }
}
