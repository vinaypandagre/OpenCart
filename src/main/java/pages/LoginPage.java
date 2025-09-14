package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonEvents;

public class LoginPage {
	 WebDriver driver;
	    CommonEvents common;

	    @FindBy(xpath = "//input[@id='input-email']")
	    WebElement email;

	    @FindBy(xpath = "//input[@id='input-password']")
	    WebElement password;

	    @FindBy(xpath = "//input[@value='Login']")
	    WebElement loginbtn;

	    
	    public LoginPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	        common = new CommonEvents(driver);
	    }

	    public void login(String emailVal,String passVal) {
	        common.enterText(email, emailVal);
	        common.enterText(password, passVal);
	        common.clickElement(loginbtn);
	    }
	
}
