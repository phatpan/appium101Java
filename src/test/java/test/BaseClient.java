package test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.net.URL;

public class BaseClient {

    static AppiumDriver<MobileElement> driver;

    @BeforeTest
    public void setup() {
        try {
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability("deviceName", "HUAWEI P30");
            cap.setCapability("udid", "53F5T19327002616");
            cap.setCapability("platformVersion", "10");
            cap.setCapability("platformName", "Android");
            cap.setCapability("appPackage", "com.appium.appiumtest");
            cap.setCapability("appActivity", "com.appium.appiumtest.MainActivity");

            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            driver = new AppiumDriver<MobileElement>(url, cap) ;
        } catch (Exception ex) {
            System.out.println("Cause is:" + ex.getCause());
            System.out.println("Message is:" + ex.getMessage());
        }
    }

    @Test
    public void sampleTest() {
        System.out.println("I am");
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }
}
