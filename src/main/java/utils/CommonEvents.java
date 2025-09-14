package utils;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonEvents {

    WebDriver driver;

    public CommonEvents(WebDriver driver) {
        this.driver = driver;
    }

    // ===== Basic Actions =====
    public void enterText(WebElement element, String text) {
        WebElement webelement = waitForVisibilityOfElement(element, Constants.EXPLICIT_WAIT_TIME);
        webelement.clear();
        webelement.sendKeys(text);
    }

    public void clickElement(WebElement element) {
        WebElement webelement = waitForElement(element, Constants.EXPLICIT_WAIT_TIME);
        webelement.click();
    }

    // ===== Dropdown Handling =====
    public void selectByText(WebElement element, String text) {
        WebElement webelement = waitForElement(element, Constants.EXPLICIT_WAIT_TIME);
        new Select(webelement).selectByVisibleText(text);
    }

    public void selectByValue(WebElement element, String value) {
        WebElement webelement = waitForElement(element, Constants.EXPLICIT_WAIT_TIME);
        new Select(webelement).selectByValue(value);
    }

    public void selectByIndex(WebElement element, int index) {
        WebElement webelement = waitForElement(element, Constants.EXPLICIT_WAIT_TIME);
        new Select(webelement).selectByIndex(index);
    }

    public String getSelectedOption(WebElement element) {
        WebElement webelement = waitForElement(element, Constants.EXPLICIT_WAIT_TIME);
        return new Select(webelement).getFirstSelectedOption().getText();
    }

    // ===== Mouse Actions =====
    public void mouseHoverAndClick(WebElement element) {
        WebElement webelement = waitForVisibilityOfElement(element, Constants.EXPLICIT_WAIT_TIME);
        Actions action = new Actions(driver);
        action.moveToElement(webelement).click().build().perform();
    }

    // ===== Utility Methods =====
    public boolean elementIsDisplayed(WebElement element) {
        try {
            WebElement webelement = waitForVisibilityOfElement(element, Constants.EXPLICIT_WAIT_TIME);
            return webelement.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getText(WebElement element) {
        WebElement webelement = waitForVisibilityOfElement(element, Constants.EXPLICIT_WAIT_TIME);
        return webelement.getText();
    }

    // ===== Wait Helpers =====
    public WebElement waitForElement(WebElement element, long durationInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement waitForVisibilityOfElement(WebElement element, long durationInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    // ===== URL Wait Helper =====
    public void waitForUrlContains(String urlFragment, long durationInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
        wait.until(ExpectedConditions.urlContains(urlFragment));
    }
}
