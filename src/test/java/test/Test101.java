package test;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test101 extends BaseClient {

    @Test
    public static void testValidateLabelAndClickButton() {
        MobileElement titleLabelPage1 = driver.findElement(By.id("com.appium.appiumtest:id/titleLabel"));
        var text = titleLabelPage1.getText();
        Assert.assertTrue(text.equals("Hello Appium"));
        MobileElement btn = driver.findElement(By.id("com.appium.appiumtest:id/startButton"));
        btn.click();
    }
}
