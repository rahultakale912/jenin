package TestRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/Features/Pandia.feature"},
glue= {"Stepdefinition"},
dryRun = false

)
public class runner {
	
	
}
