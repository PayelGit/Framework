package stepDefinitions;

import Base.BaseClass;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pageObjects.LoginPageObjects;

public class LoginStepDefinitions extends BaseClass {


    private LoginPageObjects loginPageObjects;

    @Given("user is in login page")
    public void user_is_in_login_page() {
        /*Load the configuration file.*/
        loadConfig();
        initializeBrowser();
        /*Initialize loginPageObjects after ensuring driver is initialized*/
        loginPageObjects = new LoginPageObjects(driver);
        driver.get(prop.getProperty("url"));
    }

    @When("user enters {string} and {string}")
    public void user_enters_and(String username, String password) {
        loginPageObjects.loginToTheApplication(username, password);
    }

    @Then("user verifies {string} and {string}")
    public void user_verifies_and(String url, String status) {
        if(status.equalsIgnoreCase("success")) {
            Assert.assertTrue(loginPageObjects.getCurrentURL().contains(url));
        }
//        Assert.assertTrue(loginPageObjects.verifyErrorMessage().contains("Invalid")||loginPageObjects.verifyErrorMessage().contains("required"));
    }
}
