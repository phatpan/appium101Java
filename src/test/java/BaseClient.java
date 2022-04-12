import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import java.net.URL;

public class BaseClient {

    static AppiumDriver<MobileElement> driver;
    private String platform = MobilePlatform.IOS;

    @BeforeTest
    public void setup() {
        try {
            DesiredCapabilities cap = new DesiredCapabilities();
            if(platform == MobilePlatform.ANDROID) {
                cap.setCapability(MobileCapabilityType.DEVICE_NAME, "HUAWEI P30");
                cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
                cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
                cap.setCapability("appPackage", "com.appium.appiumtest");
                cap.setCapability("appActivity", "com.appium.appiumtest.MainActivity");
            } else if(platform == MobilePlatform.IOS) {
                cap.setCapability("automationName", false);
                cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
                //cap.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone Simulator");
                cap.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 13");
                cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "15.4");
                cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
                String app = "/Users/phatpan/Library/Developer/Xcode/DerivedData/AppiumAutomating-bvqmyzvvroxrpjfwrhfpfqcxepid/Build/Products/Debug-iphonesimulator/AppiumAutomating.app";
                cap.setCapability(MobileCapabilityType.APP, app);
                cap.setCapability("bundleId", "com.appium.automating.AppiumAutomating");
            }
            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            driver = new IOSDriver<MobileElement>(url, cap) ;
        } catch (Exception ex) {
            System.out.println("Cause is:" + ex.getCause());
            System.out.println("Message is:" + ex.getMessage());
        }
    }

    @AfterTest
    public void teardown() {
//        driver.quit();
    }
}
