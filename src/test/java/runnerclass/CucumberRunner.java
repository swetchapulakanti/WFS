package runnerclass;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "@SaucePage", features = {"src/test/resources/features"}, glue = {"stepdefinitions"},
plugin =  {"pretty",
"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

public class CucumberRunner extends AbstractTestNGCucumberTests {

}
