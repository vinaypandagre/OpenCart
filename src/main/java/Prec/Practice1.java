package Prec;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Practice1 {
	public static void main(String[] args) throws InterruptedException {

		System.out.println("Checkout Test Started");

		// Launch Chrome
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Open product page directly
		driver.get("https://tutorialsninja.com/demo/index.php?route=product/search&search=HP%20LP3065");

		// Step 1: Add product to cart
		WebElement addToCartBtn = driver
				.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div/div/div[2]/div[2]/button[1]"));
		addToCartBtn.click();
		Thread.sleep(2000);

		// Cart button after selecting product
		WebElement CartBtn = driver.findElement(By.id("button-cart"));
		CartBtn.click();
		Thread.sleep(2000);

		// Step 2: Click on cart and go to checkout
		WebElement checkoutBtn = driver.findElement(By.xpath("//a[@title='Checkout']//i[@class='fa fa-share']"));
		checkoutBtn.click();
		Thread.sleep(2000);

		// Step 3: Select Guest Checkout
		WebElement guestRadio = driver.findElement(By.xpath("//input[@value='guest']"));
		guestRadio.click();
		Thread.sleep(1000);

		WebElement continueBtn = driver.findElement(By.id("button-account"));
		continueBtn.click();
		Thread.sleep(2000);

		// ================= After Guest Continue =================

		// Step 4: Fill Billing Details
		driver.findElement(By.id("input-payment-firstname")).sendKeys("John");
		driver.findElement(By.id("input-payment-lastname")).sendKeys("Doe");
		driver.findElement(By.id("input-payment-email")).sendKeys("johndoe@testmail.com");
		driver.findElement(By.id("input-payment-telephone")).sendKeys("9876543210");
		driver.findElement(By.id("input-payment-address-1")).sendKeys("123 Test Street");
		driver.findElement(By.id("input-payment-city")).sendKeys("Bangalore");
		driver.findElement(By.id("input-payment-postcode")).sendKeys("560001");

		// Step 5: Select Country & Zone using Select class
		Select country = new Select(driver.findElement(By.id("input-payment-country")));
		country.selectByVisibleText("India");
		Thread.sleep(2000);

		Select zone = new Select(driver.findElement(By.id("input-payment-zone")));
		zone.selectByVisibleText("Karnataka");
		Thread.sleep(2000);

		// Click checkbox "shipping same as billing"
		try {
			WebElement shippingCheckbox = driver
					.findElement(By.xpath("//input[@name='shipping_address' or @value='existing']"));
			if (!shippingCheckbox.isSelected()) {
				shippingCheckbox.click();
			}
		} catch (Exception e) {
			System.out.println("Shipping same as billing checkbox not found or already selected.");
		}

		// Continue guest checkout (billing step)
		WebElement billingContinue = driver.findElement(By.id("button-guest"));
		billingContinue.click();
		Thread.sleep(2000);

		// Step 6: Delivery Method
		WebElement shippingContinue = driver.findElement(By.id("button-shipping-method"));
		shippingContinue.click();
		Thread.sleep(2000);

		// Step 7: Payment Method
		WebElement agreeCheckbox = driver.findElement(By.name("agree"));
		agreeCheckbox.click();

		WebElement paymentContinue = driver.findElement(By.id("button-payment-method"));
		paymentContinue.click();
		Thread.sleep(2000);

		// Step 8: Confirm Order
		WebElement confirmOrder = driver.findElement(By.id("button-confirm"));
		confirmOrder.click();
		Thread.sleep(2000);

		System.out.println(" Order placed successfully!");

		//driver.quit();
	}
}
