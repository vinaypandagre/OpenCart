package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utils.CommonEvents;
import utils.Constants;


public class AddtoCart {
    WebDriver driver;
    CommonEvents common;

	
	@FindBy(linkText = "HP LP3065")
	public
	WebElement pname;
	
	@FindBy(xpath = "//button[@id='button-cart']")
	public WebElement cartbtn;
	@FindBy(xpath = "//*[@id=\"content\"]/div[3]/div/div/div[2]/div[2]/button[1]")
	public
	WebElement cartbtn1;
	@FindBy(xpath = "//a[@title='Checkout']//i[@class='fa fa-share']")
	public WebElement checkoutbtn;
	
	
	   public AddtoCart(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        common = new CommonEvents(driver);
    }
	   
	    public void productd()  {
	        common.clickElement(pname);

	    }
	    public void addcart()  {
	        common.clickElement(cartbtn);

	    }
	    public void addcart1()  {
	        common.clickElement(cartbtn1);

	    }
	    
	    public void checkout()  {
	        common.clickElement(checkoutbtn);

	    }
	
}
