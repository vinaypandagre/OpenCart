package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonEvents;

public class RegistrationPage {

    WebDriver driver;
    CommonEvents common;

    @FindBy(xpath = "//input[@id='input-firstname']")
    WebElement firstName;

    @FindBy(xpath = "//input[@id='input-lastname']")
    WebElement lastName;

    @FindBy(xpath = "//input[@id='input-email']")
    WebElement email;

    @FindBy(xpath = "//input[@id='input-telephone']")
    WebElement telephone;

    @FindBy(xpath = "//input[@id='input-password']")
    WebElement password;

    @FindBy(xpath = "//input[@id='input-confirm']")
    WebElement confirmPassword;

    @FindBy(xpath = "//input[@value='0']")
    WebElement newsletterNo;

    @FindBy(xpath = "//input[@name='agree']")
    WebElement agree;

    @FindBy(xpath = "//input[@value='Continue']")
    WebElement continueButton;
    

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        common = new CommonEvents(driver);
    }

    public void register(String fName, String lName, String emailVal, String phone, String passVal) {
        common.enterText(firstName, fName);
        common.enterText(lastName, lName);
        common.enterText(email, emailVal);
        common.enterText(telephone, phone);
        common.enterText(password, passVal);
        common.enterText(confirmPassword, passVal);
        common.clickElement(newsletterNo);
        common.clickElement(agree);
        common.clickElement(continueButton);
    }
}
