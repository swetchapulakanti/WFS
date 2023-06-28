package stepdefinitions;
import java.util.Properties;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.factory.DriverFactory;
import com.pages.baseclass;
import com.util.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class hooks {
	
	private DriverFactory driverFactory;
	private	WebDriver driver;
	private ConfigReader configReader;
	Properties prop;
	
	 @Before(order=0)
	    public  void getProperty() {
		 configReader= new ConfigReader();
		 prop=configReader.init_prop();
		 
	 }
	 @Before(order=1)
	    public  void launchBrowser() {
		 String browsername =prop.getProperty("browser");
		 driverFactory= new DriverFactory();
		 driver=driverFactory.init_driver(browsername);
		 
	 }
		 

	@After(order=1)
	public void takeScreenshotOnFailure(Scenario scenario) {

	if (scenario.isFailed()) {
	String screenshotName=scenario.getName().replaceAll("", "_");
	byte[] src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	scenario.attach(src, "image/png", screenshotName);
	}

	}

	@After(order = 0)
	public void tearDown() {
	driver.quit();

	}
}
