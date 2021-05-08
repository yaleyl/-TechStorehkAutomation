package com.techstorehk.utils;

import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.techstorehk.utils.PropertyUtils.getPropertyByKey;
import static com.techstorehk.utils.PropertyUtils.loadProperties;

public class DriverManager {
    static WebDriver driver;

    public static WebDriver getWebDriver() {
        if (driver != null) {
            return driver;
        } else {
            initDriver();
        }
        return driver;
    }

    public static void initDriver() {
        loadProperties();
        switch (getPropertyByKey("browser").toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                break;
        }

        if (getPropertyByKey("platform").equals("mobile")) {
            driver = new ChromeDriver(getChromeOptionForMobile());
        } else {
            driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public static ChromeOptions getChromeOptionForMobile() {
        Map<String, String> mobileEmulation = new HashMap<String, String>();
        mobileEmulation.put("deviceName", getPropertyByKey("deviceName"));
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
        return chromeOptions;
    }

    public static void openNewTab() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
    }

    public static void quit() {
        driver.quit();
        driver = null;
    }

    public static void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            // Take a screenshot...
            final byte[] screenshot = ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
            // embed it in the report.
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        driver.quit();
        driver = null;
    }
}
