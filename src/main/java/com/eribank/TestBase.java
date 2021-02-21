package com.eribank;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestBase{
    public static AndroidDriver<MobileElement> driver;

    public void launchApplication(){
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability("deviceName","27aef533");
        desiredCapabilities.setCapability("platformName","android");
        desiredCapabilities.setCapability("appPackage","com.experitest.ExperiBank");
        desiredCapabilities.setCapability("appActivity","LoginActivity");
        desiredCapabilities.setCapability("noReset","true");

        URL url = null;
        try {
            url = new URL("http://127.0.0.1:4723/wd/hub");
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        driver = new AndroidDriver<MobileElement>(url, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public AndroidDriver<MobileElement> getDriver(){
        return driver;
    }

    @BeforeMethod
    public void beforeMethod(){
        launchApplication();
    }

    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }
}
