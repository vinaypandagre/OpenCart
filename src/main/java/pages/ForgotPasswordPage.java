package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.*;
public class ForgotPasswordPage {
	WebDriver driver;
	CommonEvents common;
	
	@FindBy(linkText = "Forgotten Password")
	WebElement forgotpassword;
	
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement email ;
	
	@FindBy(xpath = "//input[@value = 'Continue']")
	WebElement submit;


	
    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        common = new CommonEvents(driver);
    }

    public void forgotp(String emailVal) {
    	common.clickElement(forgotpassword);
    	common.enterText(email, emailVal);
    	common.clickElement(submit);
    	
        
    }
	
	
	

}
