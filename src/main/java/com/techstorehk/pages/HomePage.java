package com.techstorehk.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.techstorehk.utils.CommonMethod.waitAndClick;
import static com.techstorehk.utils.DriverManager.getWebDriver;

public class HomePage {
    public HomePage() {
        PageFactory.initElements(getWebDriver(), this);
    }

    @FindBy(xpath = "//div[@class='nav-center container']//img[@src='./images/logo.png']")
    private WebElement logoImage;

    @FindBy(css = ".popup-close")
    private WebElement closePopUpBtn;

    @FindBy(xpath = "//div[@class=\"card-footer\"]//h3")
    private List<WebElement> footerCardHeaders;

    public void verifyHomePage() {
        try {
            closePopUpBtn.isDisplayed();
            waitAndClick(closePopUpBtn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertTrue(logoImage.isDisplayed(), "Logo Image is not displayed !!!");
    }

    public void verifyHigherEducation() {
        List<String> expectedList = Arrays.asList("AWS", "Python", "Being Scrum Pro");
        Set<String> setOfActualCards = new HashSet<>();
        for (WebElement ele : footerCardHeaders) {
            setOfActualCards.add(ele.getText());
        }
        Assert.assertTrue(setOfActualCards.size() > 0, "Not getting any higher education section !!!");
    }

    public void verifyFacilityContainer() {
        List<String> listOfFacilities = Arrays.asList("FREE BOOTCAMPS", "100% MONEY BACK GUARANTEE", "MANY PAYMENT GATEWAYS", "24/7 ONLINE SUPPORT");
        for (String facility : listOfFacilities) {
            WebElement element = getWebDriver().findElement(By.xpath(String.format("//div[@class=\"facility-box\"]/p[normalize-space()='%s']", facility)));
            Assert.assertTrue(element.isDisplayed(), facility + " is visible !!!");
        }
    }
}
