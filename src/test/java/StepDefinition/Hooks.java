package StepDefinition;

import Utilities.CommonUtils;
import Utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Hooks {

    WebDriver  driver = Driver.getDriver(CommonUtils.getProperty("browser"));

    public Hooks() throws IOException {
    }

    @Before
    public void  setup () throws IOException {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("Before Scenario");
    }

    @After
    public void tearDown (Scenario scenario) throws IOException {
        if (scenario.isFailed()){
            CommonUtils.takeScreenshot(driver, "Test Scenario");
        }
       //  driver.close();
    }
}
