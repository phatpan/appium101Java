import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test101 extends BaseClient {

    @Test
    public void testValidateLabelAndClickButton() {
        String idIOS = "titleLabel";
        String idAndroid = "com.appium.appiumtest:id/titleLabel";
        String idButtonIOS = "startButton";
        String idButtonAndroid = "com.appium.appiumtest:id/startButton";
        MobileElement titleLabelPage1 = driver.findElement(By.id(idIOS));
        var text = titleLabelPage1.getText();
        Assert.assertTrue(text.equals("Hello Appium"));
        MobileElement btn = driver.findElement(By.id(idButtonIOS));
        btn.click();
    }
}
