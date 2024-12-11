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

public class TixIDTest {

    AndroidDriver driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("deviceName", "Pixel 2 API 33");
        dc.setCapability("udid", "emulator-5554");
        dc.setCapability("platformName", "Android");
        dc.setCapability("platformVersion", "13");
        dc.setCapability("appPackage", "id.tix.android");
        dc.setCapability("appActivity", "splash.view.SplashActivity");
        dc.setCapability("noReset", true);

        URL url = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver(url, dc);
    }

    @AfterClass
    public void finish() {
        delay(3);
        driver.quit();
    }

    @Test
    public void testSearchMovie() {
        delay(10);

        MobileElement search = (MobileElement) driver.findElement(By.id("et_input"));
        search.click();
        delay(2);

        //driver.findElement(By.id("id.tix.android:id/et_input")).sendKeys("venom");
        search.sendKeys("venom");
        MobileElement searchFirst = (MobileElement) driver.findElement(By.id("tv_search_first"));
        searchFirst.click();
        delay(15);

        String getTitleMovie = driver.findElement(By.id("tv_title_of_movie")).getText();
        Assert.assertTrue(getTitleMovie.contains("VENOM"));
    }

    private void delay(long detik) {
        try {
            Thread.sleep(detik * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
