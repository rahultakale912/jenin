package TestRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/Features/Batchfile.feature"},
glue= {"Stepdefinition"},
dryRun = false,
tags={"@dateverify"}

)
public class runner {
	
	
}
