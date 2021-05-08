package com.techstorehk.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static com.techstorehk.utils.WebElementUtils.waitForElementToClickable;
import static com.techstorehk.utils.WebElementUtils.waitForElementToPresent;

public class CommonMethod {

    public static void waitAndClick(WebElement element) {
        waitForElementToClickable(element);
        element.click();
    }

    public static void waitAndSendKeys(WebElement element, String value) {
        waitForElementToPresent(element);
        element.clear();
        element.sendKeys(value);
    }

    public static void selectFromDropDown(WebElement element, String value) {
        waitForElementToPresent(element);
        Select select = new Select(element);
        select.selectByValue(value);
    }
}
