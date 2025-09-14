package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.*;
public class OrderHistoryPage {
	WebDriver driver;
	CommonEvents common;
	
	@FindBy(linkText = "View your order history")
	WebElement orderh;

	
    public OrderHistoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        common = new CommonEvents(driver);
    }

    public void order() {
    	common.clickElement(orderh);
    }}