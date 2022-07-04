package stepdefinitions.uistepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.HomePage;
import pages.RegisterPage;
import pojos.US_01_Registrant;
import utilities.Driver;

public class US_001_RegisterStepDefs {

    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();

    Actions actions = new Actions(Driver.getDriver());

    Faker faker = new Faker();

    US_01_Registrant US01Registrant = new US_01_Registrant();




    @And("user clicks on the register link")
    public void userClicksOnTheRegisterLink() {
        homePage.registerButton.click();
    }

    @Then("user should be on the register page and should see the register title")
    public void userShouldBeOnTheRegisterPageAndShouldSeeTheRegisterTitle() {
        Assert.assertEquals("Registration", registerPage.registrationText.getText());
    }

    @And("user sends SSN number")
    public void userSendsSSNNumberAs() {
        registerPage.ssnBox.sendKeys(faker.idNumber().ssnValid());
    }

    @And("user sends first name")
    public void userSendsFirstNameAs() {
        registerPage.firstNameBox.sendKeys(faker.name().firstName());
    }

    @And("user sends last name")
    public void userSendsLastNameAs() {
        registerPage.lastNameBox.sendKeys(faker.name().lastName());
    }

    @Then("close the browser")
    public void closeTheBrowser() {
        Driver.closeDriver();

    }

    @Given("user does not send SSN number")
    public void userDoesNotSendSSNNumber() {
        registerPage.ssnBox.sendKeys("");
    }

    @Then("user should see the SNN-error message")
    public void userShouldSeeTheSNNErrorMessage() {
        Assert.assertTrue(registerPage.ssnErrorMessage.isDisplayed());
    }

    @And("user does not send first name")
    public void userDoesNotSendFirstName() {
        registerPage.firstNameBox.sendKeys("");
    }


    @Then("user should see the FirstName error message")
    public void userShouldSeeTheFirstNameErrorMessage() {
        Assert.assertTrue(registerPage.firstNameErrorMessage.isDisplayed());
    }

    @And("user does not send last name")
    public void userDoesNotSendLastName() {
        registerPage.lastNameBox.sendKeys("");
        actions.sendKeys(Keys.TAB).build().perform();
    }

    @Then("user should see the LastName error message")
    public void userShouldSeeTheLastNameErrorMessage() {
        Assert.assertTrue(registerPage.lastNameErrorMessage.isDisplayed());
    }

    @When("user sends invalid SSN number as {string}")
    public void userSendsInValidSSNNumberAs(String ssn) {
        registerPage.ssnBox.sendKeys(ssn);
    }

    @Then("user should see the SNN-invalid message")
    public void userShouldSeeTheSNNInvalidMessage() {
        Assert.assertTrue(registerPage.ssnInvalidErrorMessage.isDisplayed());
    }
}

