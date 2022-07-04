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
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_001x_RegisterStepDefs {

    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();

    Actions actions = new Actions(Driver.getDriver());

    Faker faker = new Faker();

    @And("user sends an username")
    public void userSendsAnUsernameAs() {
        registerPage.usernameBox.sendKeys(faker.name().username());
    }

    @And("user sends a valid email")
    public void userSendsAValidEmail() {
        registerPage.emailBox.sendKeys(faker.internet().emailAddress());
    }

    @And("user sends a valid password")
    public void userSendsAValidPassword() {
        registerPage.newPasswordBox.sendKeys("team83_user_74");
    }

    @And("user sends a valid confirm password")
    public void userSendsAValidConfirmPassword() {
        registerPage.confirmPasswordBox.sendKeys("team83_user_74");
    }




}

