package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.*;
public class ProfilePage {
	WebDriver driver;
	CommonEvents common;
	
	@FindBy(linkText = "Edit your account information")
	WebElement profileupdate;
	
	@FindBy(xpath ="//input[@id='input-firstname']")
	WebElement fname1 ;
	
	@FindBy(xpath = "//input[@value = 'Continue']")
	WebElement submit;


	
    public ProfilePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        common = new CommonEvents(driver);
    }

    public void pupdate(String newname)  {
    	common.clickElement(profileupdate);
    	common.enterText(fname1, newname);
    	common.clickElement(submit);

        
    }
	
	
	

}
