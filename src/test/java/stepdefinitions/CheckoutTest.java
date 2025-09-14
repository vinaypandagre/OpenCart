package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CheckoutPage;
import pages.SearchPage;
import factory.DriverFactory;
import io.cucumber.java.*;
import io.cucumber.java.en.*;
import utils.WaitHelper;
public class CheckoutTest {

	WebDriver driver;
	CheckoutPage checkoutPage;
	WaitHelper waitHelper;

	@Before
	public void setup() {
		driver = DriverFactory.getDriver("chrome");
		checkoutPage = new CheckoutPage(driver);
		waitHelper = new WaitHelper(driver, 10);
	}

    @Then("I am Navigate to Checkout Page")
    public void verifyCheckoutNavigation() {
        checkoutPage.selectGuestCheckout();
        waitHelper.waitForUrlContains("checkout");
        Assert.assertTrue(driver.getCurrentUrl().contains("checkout"),
                "❌ Checkout navigation failed");
        System.out.println("✅ Checkout navigation verified");
    }

    @And("I Fill the Billing Details")
    public void verifyBillingDetails() {
        checkoutPage.fillBillingDetails();
        checkoutPage.selectCountryAndZone("India", "Karnataka");

        waitHelper.waitForTextInPage(
            "Please select the preferred shipping method to use on this order"
        );
        Assert.assertTrue(driver.getPageSource().contains(
                "Please select the preferred shipping method to use on this order"),
                "❌ Shipping details entry failed");
        System.out.println("✅ Shipping details entry verified");

        checkoutPage.continueShippingMethod();
    }

    @And("Check For Shipping Method")
    public void verifyPaymentMethodSelection() {
        boolean isSelected = checkoutPage.isShippingMethodSelected();
        Assert.assertTrue(isSelected, "❌ Shipping method radio button is NOT selected by default");
        System.out.println("✅ Shipping method radio button is selected");
    }

    @Then("The Order is Confirmed")
    public void verifyOrderConfirmation() {
        checkoutPage.confirmOrder();
        waitHelper.waitForUrlContains("success");
        Assert.assertTrue(driver.getCurrentUrl().contains("success"),
                "❌ Checkout confirmation failed");
        System.out.println("✅ Checkout navigation verified");
    }
}