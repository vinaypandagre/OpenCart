package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonEvents;

public class HomePage {

    WebDriver driver;
    CommonEvents common;

    @FindBy(xpath = "//span[@class='caret']")
    WebElement myAccountDropdown;

    @FindBy(xpath = "//a[normalize-space()='Register']")
    WebElement registerLink;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        common = new CommonEvents(driver);
    }

    public void goToRegisterPage() {
        common.clickElement(myAccountDropdown);
        common.clickElement(registerLink);
    }
    @FindBy(xpath = "//a[normalize-space()='Login']")
    WebElement loginLink;

    public void goToLoginPage() {
        common.clickElement(myAccountDropdown);
        common.clickElement(loginLink);
    }
}
