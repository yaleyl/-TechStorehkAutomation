package com.techstorehk.steps;


import io.cucumber.java.en.Given;

import static com.techstorehk.utils.DriverManager.getWebDriver;
import static com.techstorehk.utils.PropertyUtils.getPropertyByKey;

public class CommonSteps {
    @Given("^User open techstorehk website$")
    public void user_open_techstorehk_website() {
        getWebDriver().get(getPropertyByKey("application.url"));
    }
}
