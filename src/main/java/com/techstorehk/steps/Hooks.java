package com.techstorehk.steps;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import static com.techstorehk.utils.DriverManager.*;

public class Hooks {

    @Before
    public void beforeSuitMethod() {
        initDriver();
    }

    @After
    public void cleanUp(Scenario scenario) {
        tearDown(scenario);
    }
}
