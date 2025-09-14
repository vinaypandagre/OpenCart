package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utils.CommonEvents;

public class SearchPage {
    WebDriver driver;
    CommonEvents common;

    @FindBy(xpath = "//input[@placeholder='Search']")
    WebElement searchInput;

    @FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
    WebElement searchicon;
    

    @FindBy(xpath = "//select[@name='category_id']")
    WebElement categoryDropdown;
    
    @FindBy(xpath = "//input[@id='button-search']")
    WebElement searchbutton;
    

    @FindBy(linkText = "Phones & PDAs")
    WebElement Cat;

    // Sorting dropdown
    @FindBy(xpath = "//select[@id='input-sort']")
    WebElement sortDropdown;
   
    @FindBy(css = ".price")
    List<WebElement> productPrices;
    

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        common = new CommonEvents(driver);
    }

    public void search(String searchText) {
        common.enterText(searchInput, searchText);
        common.clickElement(searchicon);
    }
    public void selectCategory(String text)  {
        common.selectByText(categoryDropdown, text);
        common.clickElement(searchbutton);

    }
    
    public void pricesort(String text)  {
    	common.clickElement(Cat);
        common.selectByText(sortDropdown, text);
    }

    
 // ===== Utility: Get all product prices as numbers =====
    public List<Double> getAllProductPrices() {
        List<Double> prices = new ArrayList<>();

        for (WebElement el : productPrices) {
            String priceText = el.getText().replaceAll("[$,]", "").trim();
            if (!priceText.isEmpty()) {
                try {
                    // Handle ranges like "100 - 200" by taking the first value
                    double price = Double.parseDouble(priceText.split("\\s+")[0]);
                    prices.add(price);
                } catch (NumberFormatException e) {
                    System.out.println("⚠️ Could not parse price: " + priceText);
                }
            }
        }

        return prices;
    }
}