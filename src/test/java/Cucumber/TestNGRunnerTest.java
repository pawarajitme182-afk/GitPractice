package Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features ="src/test/java/Cucumber", glue="FrameworkTesting.StepDefiner",monochrome = true, tags = "@regression",
plugin = {"html:target/cucumber.html"})
public class TestNGRunnerTest extends AbstractTestNGCucumberTests {

}
