package stepdefinitions;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import factory.DriverFactory;
import pages.*;
import utils.WaitHelper;

import io.cucumber.java.en.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import hooks.Hooks;
public class UserRegistrationSteps {

    WebDriver driver;
    HomePage homePage;
    RegistrationPage regPage;
    LoginPage loginPage;
    ForgotPasswordPage forgotPage;
    ProfilePage profilePage;
    OrderHistoryPage orderPage;
    WaitHelper waitHelper;


    // ---------------------- Common ----------------------
    @Given("I am on the home page")
    public void i_am_on_the_home_page() {
    	driver = DriverFactory.getDriver("chrome");
        driver.get("https://tutorialsninja.com/demo/");
        homePage = new HomePage(driver);
        waitHelper = new WaitHelper(driver, 10);
    }

    // ---------------------- Registration ----------------------
    @When("I navigate to the registration page")
    public void i_navigate_to_the_registration_page() {
        homePage.goToRegisterPage();
        regPage = new RegistrationPage(driver);
    }

    @And("I register with valid details")
    public void i_register_with_valid_details() {
        regPage.register(
            "John",
            "Doe",
            "testuser" + System.currentTimeMillis() + "@gmail.com",
            "9876543210",
            "Password123"
        );
    }

    // ---------------------- Login ----------------------
    @When("I navigate to the login page")
    public void i_navigate_to_the_login_page() {
        homePage.goToLoginPage();
        loginPage = new LoginPage(driver);
    }

    @And("I login with valid credentials")
    public void i_login_with_valid_credentials() {
        loginPage.login("testuser1889@gmail.com", "Qwert123");
    }

    @And("I login with invalid credentials")
    public void i_login_with_invalid_credentials() {
        loginPage.login("wronguser@gmail.com", "WrongPassword123");
    }

    // ---------------------- Forgot Password ----------------------
    @When("I request password reset for {string}")
    public void i_request_password_reset_for(String email) {
        homePage.goToLoginPage(); // ensure on login page
        forgotPage = new ForgotPasswordPage(driver);
        forgotPage.forgotp(email);
    }

    // ---------------------- Profile Update & Order History ----------------------
    @Given("I am logged in")
    public void i_am_logged_in() {
    	i_am_on_the_home_page();
    	i_navigate_to_the_login_page();
    	i_login_with_valid_credentials();
    	       
    }

    @When("I update my profile with {string}")
    public void i_update_my_profile_with(String name) {
    	profilePage = new ProfilePage(driver);
        profilePage.pupdate(name);
    }

    @And("I check my order history")
    public void i_check_my_order_history() {
    	orderPage = new OrderHistoryPage(driver);
        orderPage.order();
    }

    // ---------------------- Assertions ----------------------
    
    // By page Souces 
    @Then("I should see text {string}")
    public void verifyTextOnPage(String expectedText) {
        waitHelper.waitForTextInPage(expectedText);
    }
    //---------------Single Product-------------------
//    @Then("I should see the link {string}")
//    public void verifysinglelink(String productName) {
//        waitHelper.waitAndAssertDisplayed(productName);
//    }
    //------------ Multiple Product by link text------------------
    @Then("I should see the link of:")
    public void verifymultiplelink(io.cucumber.datatable.DataTable dataTable) {
        List<String> name = dataTable.asList(String.class);
        waitHelper.waitAndAssertDisplayed(name);
    }

    
    
    // ---------------------- Teardown ----------------------
//    @After
//    public void teardown() {
//        DriverFactory.quitDriver();
//    }
    }

