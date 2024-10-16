package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/cucumber", glue = "src/test/java/cucumber", monochrome = true, plugin = {
		"html:target/cucumber.html" })
public class TestRunner extends AbstractTestNGCucumberTests{

}
