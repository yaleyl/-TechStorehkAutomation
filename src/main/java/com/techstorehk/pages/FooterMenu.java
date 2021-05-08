package com.techstorehk.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.techstorehk.utils.DriverManager.getWebDriver;

public class FooterMenu {
    public FooterMenu() {
        PageFactory.initElements(getWebDriver(), this);
    }


    List<List<String>> listOfFooterMenu = Arrays.asList(Arrays.asList("About Us", "Privacy Policy", "Terms & Conditions", "Contact Us", "Site Map"), Arrays.asList("My Account", "Order History", "Wish List", "blogletter", "Returns"), Arrays.asList("Youtube", "Twitter", "Instagram", "Facebook"));

    List<String> listOfFooterHeaderList = Arrays.asList("INFORMATION", "MY ACCOUNT", "FOLLOW US", "CONTACT US");

    public void verifyFooterHeaders() {
        for (String footerHeader: listOfFooterHeaderList) {
           WebElement ele = getWebDriver().findElement(By.xpath(String.format("//h3[normalize-space()='%s']", footerHeader)));
            Assert.assertTrue(ele.isDisplayed(), footerHeader + " is not displayed !!!");
        }
    }

    public void verifyFooterMenuFor() {
        int i =0;
        for (String footerMenu: listOfFooterHeaderList) {
            List<String> actualItems = new ArrayList<>();
            List<WebElement> eleList = getWebDriver().findElements(By.xpath(String.format("//h3[normalize-space()='%s']//following-sibling::a", footerMenu)));
            for (WebElement ele: eleList) {
                actualItems.add(ele.getText());
            }
            actualItems.retainAll(Collections.singleton(listOfFooterHeaderList.get(i)));
            Assert.assertTrue(actualItems.size()==0);
            i++;
        }

    }
}
