package com.example.project.BDD;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/BDD", // Path to the feature files
        glue = "com.example.project.BDD",     // Path to the step definition classes
        plugin = {"pretty", "html:target/cucumber-reports.html"}, // Optional: for reporting
        monochrome = true
)
public class TestRunner {
    // This class remains empty. It's just a placeholder for the Cucumber runner.
}