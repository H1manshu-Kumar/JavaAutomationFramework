// Declares that this class is part of the 'pageObjects' package
package pageObjects;

import java.util.List;  // Import for using List collection

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commonComponent.Common;  // Importing Common class for shared utilities

// Page Object Model class representing the "Order Page" in the application
public class OrderPage extends Common {
	WebDriver driver;  // WebDriver instance to interact with the browser

	// Constructor to initialize WebDriver and call parent constructor
	public OrderPage(WebDriver driver) {
		super(driver);         // Initialize parent class (Common)
		this.driver = driver; // Assign local driver instance
	}

	// List of product names from the orders table (3rd column in each row)
	@FindBy(css = "table.table-bordered.table-hover.ng-star-inserted tbody tr td:nth-child(3)")
	private List<WebElement> productNames;

	// WebElement for the Checkout button on the order page
	@FindBy(css = ".totalRow button")
	private WebElement CheckoutButton;

	// Method to verify if a specific product exists in the list of ordered products
	public Boolean VerifyOrderDisplay(String productName) {
		// Using Java Streams to check if any product name matches the provided input (case-insensitive)
		Boolean match = productNames.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
		return match;  // Returns true if match is found, else false
	}
}
