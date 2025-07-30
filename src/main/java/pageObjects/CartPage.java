// Package declaration for organizing related classes
package pageObjects;

// Importing necessary Java and Selenium libraries
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonComponent.Common;  // Importing Common class for shared functionalities

// CartPage class representing the shopping cart page, extending Common class for shared behavior
public class CartPage extends Common {
	WebDriver driver;  // Instance of WebDriver to interact with the browser
	
	// Constructor to initialize driver and PageFactory elements
	public CartPage(WebDriver driver) {
		super(driver);  // Calling the constructor of the parent Common class
		this.driver = driver;
		PageFactory.initElements(driver, this);  // Initializing WebElements with PageFactory
	}
	
	// Locating all product names present in the cart section
	@FindBy(css=".cartSection h3")
	private List<WebElement> cartProducts;
	
	// Locating the Checkout button element in the total row
	@FindBy(css=".totalRow button")
	private WebElement CheckoutButton;
	
	// Method to verify if a given product is displayed in the cart
	public Boolean VerifyProductDisplay(String productName) {
		// Using stream API to check if any product name matches the input (case-insensitive)
		Boolean match = cartProducts.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	// Method to click on the Checkout button and navigate to the CheckoutPage
	public CheckoutPage goToCheckout() {
		CheckoutButton.click();  // Click on checkout
		CheckoutPage checkoutPage = new CheckoutPage(driver);  // Create a new CheckoutPage object
		return checkoutPage;  // Return the new page object
	}
}
