package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import pages.HomePage;
import pages.LoginPage;
import pages.PatientPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class PatientsByAdminStepDefs {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    PatientPage patientPage = new PatientPage();

//
//    @Given("user is on the home page")
//    public void userIsOnTheHomePage() {
//        Driver.getDriver().get(ConfigurationReader.getProperty("medunna_login_url"));
//    }
//
//    @When("user clicks on the user icon")
//    public void userClicksOnTheUserIcon() {
//        homePage.userIcon.click();
//    }

    @And("user clicks on the sign in link")
    public void userClicksOnTheSignInLink() {
        homePage.signInButton.click();
    }

    @And("user enters valid username and password")
    public void userEntersValidUsernameAndPassword() {

        loginPage.usernameBox.sendKeys("irfan_team83");
        loginPage.passwordBox.sendKeys("Irfan_83");
    }


    @Then("user clicks on sign in button")
    public void userClicksOnSignInButton() {
        loginPage.signInButton.click();
    }


    @Given("user clicks on Items&Titles button")
    public void userClicksOnItemsTitlesButton() {
        Driver.waitAndClick(homePage.itemsAndTitlesButton, 1);
        homePage.itemsAndTitlesButton.click();


    }

    @Then("user clicks on Patients button")
    public void userClicksOnPatientsButton() {
        homePage.patientButton.click();
    }

    @Given("user clicks on create new patient button")
    public void userClicksOnCreateNewPatientButton() {
        ReusableMethods.waitForClickablility(patientPage.createNewPatientButton, 15);
        patientPage.createNewPatientButton.click();

    }

    @And("user enters valid patient credential and clicks save button")
    public void userEntersValidPatientCredentialAndClicksSaveButton() {
        patientPage.firstNameBox.sendKeys("Irfan");
        patientPage.lastNameBox.sendKeys("Team83");
        patientPage.birthDateBox.sendKeys("00198405050505");
        patientPage.emailBox.sendKeys("trial_patient@gmail.com");
        patientPage.phoneBox.sendKeys("1234567890");
        Select select = new Select(patientPage.genderBox);
        ReusableMethods.selectRandomTextFromDropdown(select);
        select = new Select(patientPage.bloodGroupBox);
        ReusableMethods.selectRandomTextFromDropdown(select);
        patientPage.addressBox.sendKeys("abcd");
        patientPage.descriptionBox.sendKeys("abcd");
        select = new Select(patientPage.userBox);
        ReusableMethods.selectRandomTextFromDropdown(select);
        select = new Select(patientPage.countryBox);
        select.selectByVisibleText("USA");
        select = new Select(patientPage.stateBox);
        select.selectByVisibleText("California");
        patientPage.saveButton.submit();

    }

    @Then("user should see patient created message")
    public void userShouldSeePatientCreatedMessage() {

        Assert.assertTrue(ReusableMethods.waitForVisibility(patientPage.successMessage, 5).isDisplayed());
    }
}


