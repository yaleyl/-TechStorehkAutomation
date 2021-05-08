package com.techstorehk.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.techstorehk.utils.DriverManager.getWebDriver;

public class WebElementUtils {
    static WebDriverWait wait = new WebDriverWait(getWebDriver(), 20);

    public static void waitForElementToPresent(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static void waitForElementToClickable(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static void clickElementUsingJS(WebElement element) {
        waitForElementToClickable(element);
        JavascriptExecutor executor = (JavascriptExecutor) getWebDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    public static boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
