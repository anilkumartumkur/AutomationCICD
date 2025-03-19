package Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="E:\\RahulShetty Automation\\ProjectRealTimeAutomation\\src\\test\\java\\Cucumber",glue="rahulshettyacademy.stepDefinitions",
monochrome=true,tags="Regression",plugin = {"html:target/Cucumber.html"})
public class TestNGRunner extends AbstractTestNGCucumberTests{

	
}
