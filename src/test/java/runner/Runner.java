package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/resources/script.feature",
glue = {"src/test/java/runner/Steps.java"})
public class Runner extends AbstractTestNGCucumberTests {
}