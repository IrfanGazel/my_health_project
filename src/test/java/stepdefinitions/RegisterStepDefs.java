package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePage;
import pages.RegisterPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class RegisterStepDefs {

    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();


    @Given("user is on the home page")
    public void userIsOnTheHomePage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("medunna_login_url"));
    }

    @When("user clicks on the user icon")
    public void userClicksOnTheUserIcon() {
        homePage.userIcon.click();
    }

    @And("user clicks on the register link")
    public void userClicksOnTheRegisterLink() {
        homePage.registerButton.click();
    }

    @Then("user should be on the register page and should see the register title")
    public void userShouldBeOnTheRegisterPageAndShouldSeeTheRegisterTitle() {
        Assert.assertEquals("Registration", registerPage.registrationText.getText());
    }

    @And("user sends SSN number as {string}")
    public void userSendsSSNNumberAs(String arg0) {
        registerPage.ssnBox.sendKeys("654-54-5440");
    }

    @And("user sends first name as {string}")
    public void userSendsFirstNameAs(String arg0) {
        registerPage.firstNameBox.sendKeys("team83_user_04");
    }

    @And("user sends last name as {string}")
    public void userSendsLastNameAs(String arg0) {
        registerPage.lastNameBox.sendKeys("user_04");
    }
}
