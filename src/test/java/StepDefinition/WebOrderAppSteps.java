package StepDefinition;

import Pages.WebOrdersLoginPage;
import Utilities.CommonUtils;
import Utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class WebOrderAppSteps {

    WebDriver driver = Driver.getDriver("chrome");
    WebOrdersLoginPage webOrdersLoginPage = new WebOrdersLoginPage(driver);

    public WebOrderAppSteps() throws IOException {
    }

    @Given("User navigates to WebOrders application")
    public void user_navigates_to_web_orders_application() {
        driver.get(CommonUtils.getProperty("WebOrdersURL"));
    }

    @When("User provides username {string} and password {string}")
    public void user_provides_username_and_password(String username, String password) {
        webOrdersLoginPage.logIn(username, password);

    }

    @Then("User validates that application {string} logged in")
    public void user_validates_that_application_logged_in(String condition) {
        if (condition.equalsIgnoreCase("is")) {
            String expectedTitle = "Web Orders";
            String actualTitle = driver.getTitle();
            Assert.assertEquals("Actual title: " + actualTitle + "" +
                    "Didn't match with expected title" +
                    expectedTitle, expectedTitle, actualTitle);
        }else if (condition.equalsIgnoreCase("is not")) {
            String expectedErrorMessage = "Invalid login or Password";
            String actualErrorMessage = webOrdersLoginPage.errorMessage.getText();
            Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
        }
    }
}

