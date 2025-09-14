package stepdefinitions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import pages.*;
import utils.WaitHelper;
import factory.*;
import io.cucumber.java.*;
import io.cucumber.java.en.*;

public class ProductSearchandFilter {

    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    WaitHelper waitHelper;

    @Before
    public void setUp() {
        driver = DriverFactory.getDriver("chrome");
        waitHelper = new WaitHelper(driver, 10);
    }

 

    @And("Select Category")
    public void category() {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.selectCategory("Components");
    }

    @And("Select Price High to Low")
    public void verifyPriceSortingHighToLow() {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.pricesort("Price (High > Low)");
    }
    
    @Then("Sorting High to Low")
    public void verifysorting1(){
        SearchPage searchPage = new SearchPage(driver);
        List<Double> uiPrices = searchPage.getAllProductPrices();
        List<Double> expected = new ArrayList<>(uiPrices);
        expected.sort(Collections.reverseOrder());

        Assert.assertEquals(uiPrices, expected, "❌ Prices are not sorted High → Low!");
        System.out.println("✅ Prices sorted High → Low successfully");
    }

    @And("Select Price Low to High")
    public void verifyPriceSortingLowToHigh() {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.pricesort("Price (Low > High)");
    }
    
        @Then("Sorting Low to High")
        public void verifysorting2(){
        SearchPage searchPage = new SearchPage(driver);
        List<Double> uiPrices = searchPage.getAllProductPrices();
        List<Double> expected = new ArrayList<>(uiPrices);
        expected.sort(Comparator.naturalOrder());

        Assert.assertEquals(uiPrices, expected, "❌ Prices are not sorted Low → High!");
        System.out.println("✅ Prices sorted Low → High successfully");
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
