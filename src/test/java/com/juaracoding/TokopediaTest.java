package com.juaracoding;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TokopediaTest {

    AndroidDriver driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("deviceName", "Pixel 2 API 33");
        dc.setCapability("udid", "emulator-5554");
        dc.setCapability("platformName", "Android");
        dc.setCapability("platformVersion", "13");
        dc.setCapability("appPackage", "com.tokopedia.tkpd");
        dc.setCapability("appActivity", "com.tokopedia.tkpd.ConsumerSplashScreen");
        dc.setCapability("noReset", true);

        URL url = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver(url, dc);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void test() {
    }

    private void delay(long detik) {
        try {
            Thread.sleep(detik * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

