package com.techstorehk.steps;

import com.techstorehk.pages.FooterMenu;
import com.techstorehk.pages.HeaderMenu;
import com.techstorehk.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageSteps {

    HomePage homePage = new HomePage();
    HeaderMenu headerMenu = new HeaderMenu();
    FooterMenu footerMenu = new FooterMenu();

    @Then("^Verify user is on homepage$")
    public void verifyUserOnHomePage() {
        homePage.verifyHomePage();
    }

    @And("^Verify header menu tabs on homepage$")
    public void verifyHeaderMenuTabs() {
       headerMenu.verifyHeaderMenuTabs();
    }

    @And("^Verify header icon of the header menu")
    public void verifyHeaderMenuIcon() {
        headerMenu.verifyHeaderIcons();
    }

    @And("^Verify footer menu headings on homepage$")
    public void verifyFooterMenu() {
        footerMenu.verifyFooterHeaders();
    }

    @And("^Verify footer menu sub-section links$")
    public void verifyInformationFooterMenu() {
        footerMenu.verifyFooterMenuFor();
    }

    @When("User click on {string} form menu")
    public void userClickOnFormMenu(String menuItem) {
        headerMenu.clickOn(menuItem);
    }

    @Then("Verify Higher education section")
    public void verifyHigherEducationSection() {
        homePage.verifyHigherEducation();
    }

    @And("Verify Facility Items")
    public void verifyFacilityContainerItems() {
        homePage.verifyFacilityContainer();
    }
}
