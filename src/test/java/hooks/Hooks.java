package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import factory.DriverFactory;
import utils.WaitHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hooks {

    private static WebDriver driver;      
    private static WaitHelper waitHelper; 
    private static final Logger log = LoggerFactory.getLogger(Hooks.class);

    @Before
    public void setUp() {
        driver = DriverFactory.getDriver("chrome");
        waitHelper = new WaitHelper(driver, 10);
        log.info("🚀 Test Started: Browser launched successfully");
        System.out.println("Test Started");
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
        log.info("🛑 Test Closed: Browser closed");
        System.out.println("Test Closed");
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
