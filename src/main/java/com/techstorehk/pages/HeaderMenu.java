package com.techstorehk.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static com.techstorehk.utils.DriverManager.getWebDriver;

public class HeaderMenu {
    public HeaderMenu() {
        PageFactory.initElements(getWebDriver(), this);
    }

    @FindBy(xpath = "//div[@class='nav-center container']//img[@src='./images/logo.png']")
    private WebElement logoImg;

    @FindBy(xpath = "//a[normalize-space()='Free Courses']")
    private WebElement freeCourseTab;

    @FindBy(xpath = "//a[normalize-space()='Resources']")
    private WebElement resourcesTab;

    @FindBy(xpath = "//a[normalize-space()='Corporate Training']")
    private WebElement corporateTrainingTab;

    @FindBy(xpath = "//a[normalize-space()='Become an Instructor']")
    private WebElement becomeInstructorTab;

    @FindBy(xpath = "//a[normalize-space()='Higher Education']")
    private WebElement higherEducationTab;

    @FindBy(xpath = "//i[@class=\"fas fa-user\"]")
    private WebElement userIcon;

    @FindBy(css = "[class=\"fas fa-search\"]")
    private WebElement searchIcon;

    @FindBy(css = "[class='fas fa-shopping-basket']")
    private WebElement shoppingBasketIcon;

    public void verifyHeaderMenuTabs() {
        Assert.assertTrue(logoImg.isDisplayed(), "Logo Image is not displayed !!!");
        Assert.assertTrue(freeCourseTab.isDisplayed(), "Free Courses is not displayed !!!");
        Assert.assertTrue(resourcesTab.isDisplayed(), "Resources is not displayed !!!");
        Assert.assertTrue(corporateTrainingTab.isDisplayed(), "Corporate Training is not displayed !!!");
        Assert.assertTrue(becomeInstructorTab.isDisplayed(), "Become an Instructor is not displayed !!!");
        Assert.assertTrue(higherEducationTab.isDisplayed(), "Higher Education is not displayed !!!");
    }

    public void verifyHeaderIcons() {
        Assert.assertTrue(userIcon.isDisplayed(), "User icon is not displayed !!!");
        Assert.assertTrue(shoppingBasketIcon.isDisplayed(), "Shopping basket icon is not displayed !!!");
        Assert.assertTrue(searchIcon.isDisplayed(), "Search icon is not displayed !!!");
    }

    public void clickOn(String menuItem) {
        switch (menuItem) {
            case "HIGHER EDUCATION":
                higherEducationTab.click();
                break;
            case "BECOME AN INSTRUCTOR":
                becomeInstructorTab.click();
                break;
            case "CORPORATE TRAINING":
                corporateTrainingTab.click();
                break;
            case "RESOURCES":
                resourcesTab.click();
                break;
            case "FREE COURSES":
                freeCourseTab.click();
        }
    }
}
