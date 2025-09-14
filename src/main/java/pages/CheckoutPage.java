package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.*;

import java.util.Random;

public class CheckoutPage {

    WebDriver driver;
    CommonEvents common;


    // ---------------------- CART & CHECKOUT ----------------------

//    // Cart button
//    @FindBy(xpath = "//*[@id='content']/div[3]/div/div/div[2]/div[2]/button[1]")
//    WebElement cartButton;
//
//    // Second cart button (on product detail page)
//    @FindBy(xpath = "//button[@id='button-cart']")
//    WebElement secondCartButton;

    // Checkout button
    @FindBy(xpath = "//a[@title='Checkout']//i[@class='fa fa-share']")
    WebElement checkoutButton;

    // ---------------------- CHECKOUT OPTION ----------------------
 // Guest checkout radio button
    @FindBy(xpath = "//input[@value='guest']")
    WebElement guestRadioBtn;
    
    // Continue button (Account selection)
    @FindBy(id = "button-account")
    WebElement accountContinueBtn;

    // ---------------------- BILLING ADDRESS ----------------------

    @FindBy(xpath = "//input[@id='input-payment-firstname']")
    WebElement firstName;

    @FindBy(xpath = "//input[@id='input-payment-lastname']")
    WebElement lastName;

    @FindBy(xpath = "//input[@id='input-payment-email']")
    WebElement email;

    @FindBy(xpath = "//input[@id='input-payment-telephone']")
    WebElement telephone;

    @FindBy(xpath = "//input[@id='input-payment-address-1']")
    WebElement address;

    @FindBy(xpath = "//fieldset[@id='address']")
    WebElement addressFieldset;

    @FindBy(xpath = "//input[@id='input-payment-city']")
    WebElement city;

    @FindBy(xpath = "//input[@id='input-payment-postcode']")
    WebElement postcode;

    // ---------------------- ADDRESS DROPDOWNS ----------------------

    @FindBy(xpath = "//select[@id='input-payment-country']")
    WebElement countryDropdown;

    @FindBy(xpath = "//select[@id='input-payment-zone']")
    WebElement zoneDropdown;

    // Continue button (Guest checkout)
    @FindBy(xpath = "//input[@id='button-guest']")
    WebElement guestContinueBtn;

    // ---------------------- DELIVERY METHOD ----------------------  
    
    @FindBy(xpath = "//input[@id='button-shipping-method']")
    WebElement shippingMethodContinueBtn;

 // ---------------------- PAYMENT METHOD ------------------------
    @FindBy(xpath = "//*[@id=\"collapse-payment-method\"]/div/div[1]/label/input")
    WebElement modeofpay;
    
    @FindBy(xpath = "//input[@name='agree']")
    WebElement termsCheckbox;

    @FindBy(xpath = "//input[@id='button-payment-method']")
    WebElement paymentMethodContinueBtn;

    // ---------------------- CONFIRM ORDER ----------------------

    @FindBy(xpath = "//input[@id='button-confirm']")
    WebElement confirmOrderBtn;

    // ---------------------- CONSTRUCTOR ----------------------

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        common = new CommonEvents(driver);
    }

    // ---------------------- ACTION METHODS ----------------------

    public void selectGuestCheckout() {
        common.clickElement(guestRadioBtn);
        common.clickElement(accountContinueBtn);
    }

    // ===== Fill Billing Details with Random Data =====
    public void fillBillingDetails() {
        common.enterText(firstName, "John");
        common.enterText(lastName, "Doe");
        common.enterText(email, "johndoe@testmail.com");
        common.enterText(telephone, "9876543210");
        common.enterText(address, "123 Test Street");
        common.enterText(city, "Bangalore");
        common.enterText(postcode, "560001");
    }


    public void selectCountryAndZone(String country, String zone)  {
        common.selectByText(countryDropdown, country);
        common.selectByText(zoneDropdown, zone);
        common.clickElement(guestContinueBtn);
    }
    


    public void continueShippingMethod() {
    	
        common.clickElement(shippingMethodContinueBtn);
    }
    
    public boolean isShippingMethodSelected() {
        common.clickElement(termsCheckbox);
        return modeofpay.isSelected();
    }

    public void confirmOrder() {

        common.clickElement(paymentMethodContinueBtn);
        common.clickElement(confirmOrderBtn);
        common.waitForUrlContains("success", Constants.EXPLICIT_WAIT_TIME);
    }
}
