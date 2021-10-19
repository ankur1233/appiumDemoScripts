package com.freeData;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestBase{
    public static AndroidDriver<MobileElement> driver;

    public void launchApplication(){
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability("autoGrantPermissions",true);
        desiredCapabilities.setCapability("unicodeKeyboard", true);
        desiredCapabilities.setCapability("resetKeyboard", true);

        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1.0");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "honor");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "best_freeinternet.free_internetdata_50GB_internet_prank.FreeData_guidenew.NameActivity");
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "best_freeinternet.free_internetdata_50GB_internet_prank.FreeData_guidenew");

        //desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/kotakcherry/Downloads/test.apk");

        // desiredCapabilities.setCapability("noReset","true");

        URL url = null;
        try {
            url = new URL("http://127.0.0.1:4723/wd/hub");
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        driver = new AndroidDriver<MobileElement>(url, desiredCapabilities);
       // driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
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
