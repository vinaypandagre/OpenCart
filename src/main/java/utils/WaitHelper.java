package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

import org.testng.Assert;

public class WaitHelper {

    private WebDriver driver;
    private WebDriverWait wait;

    public WaitHelper(WebDriver driver, long timeoutInSeconds) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
    }

    public WebElement waitForVisibility(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForText(WebElement element, String text) {
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public void waitForTextInPage(String text) {
        wait.until(driver -> driver.getPageSource().contains(text));
    }

    public void waitForUrlContains(String fragment) {
        wait.until(ExpectedConditions.urlContains(fragment));
    }

    public void waitForElementSelected(WebElement element) {
        wait.until(ExpectedConditions.elementToBeSelected(element));
    }

    public void waitForAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
    }

 // ========================== Wait and Assert By Link Text ==========================
    public void waitAndAssertDisplayed(String elementName) {
        WebElement element = driver.findElement(By.linkText(elementName));
        waitForVisibility(element);  // wait until visible
        Assert.assertTrue(element.isDisplayed(), "❌ " + elementName + " not found");
        System.out.println("✅ " + elementName + " is displayed");
    }

    // Overload for multiple link texts
    public void waitAndAssertDisplayed(List<String> elementNames) {
        for (String elementName : elementNames) {
            waitAndAssertDisplayed(elementName);
        }
    }
}

