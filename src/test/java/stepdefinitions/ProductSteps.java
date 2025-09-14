package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import io.cucumber.java.*;
import io.cucumber.java.en.*;
import factory.DriverFactory;
import pages.AddtoCart;
import pages.SearchPage;
import utils.WaitHelper;

public class ProductSteps {

    WebDriver driver;
    WaitHelper waitHelper;
    AddtoCart addtocart;

    // ---------------------- Setup ----------------------
    @Before
    public void setUp() {
        driver = DriverFactory.getDriver("chrome");
        waitHelper = new WaitHelper(driver, 10);
    }

    // ---------------------- Search Product ----------------------
    @When("I search Product {string}")
    public void searching_product(String productName) {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.search(productName);
    }

    @When("I search another Product {string}")
    public void search_another_product(String productName) {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.search(productName);
    }

    // ---------------------- Click Product Link ----------------------
    @And("Click On The Product Link")
    public void click_on_product_link() {
        addtocart = new AddtoCart(driver);
        addtocart.productd();
    }



    // ---------------------- Add To Cart ----------------------
    @When("I Click on Add to Cart")
    public void add_to_cart() {
        addtocart.addcart();
    }
    
    @When("I Click on Add to Cart1")
    public void  add_to_cart1() {
    	addtocart.addcart1();
    }
    
    @And("I Click On Checkout")
    public void checkoutcart() {
    	addtocart.checkout();
    }


    // ---------------------- Verify Multiple Products ----------------------
   
    
    
    @Then("Verifying multiple products in cart")
    public void verifying_multiple_products_in_cart() {
        String[] products = {"HP LP3065", "iPhone"};
        for (String product : products) {
            WebElement item = driver.findElement(By.linkText(product));
            waitHelper.waitForVisibility(item);
            Assert.assertTrue(item.isDisplayed(), "❌ " + product + " not found in cart");
        }
    }

    // ---------------------- Tear Down ----------------------
    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
