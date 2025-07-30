// Declares that this class belongs to the 'pageObjects' package
package pageObjects;

import java.util.List;  // Importing List interface for handling multiple web elements

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonComponent.Common;  // Importing shared utility class

// Page Object class representing the Product Catalogue (Product Listing) page
public class ProductCatalogue extends Common {
	WebDriver driver;  // WebDriver instance to interact with the browser

	// Constructor to initialize WebDriver and PageFactory elements
	public ProductCatalogue(WebDriver driver) {
		super(driver);  // Call parent class constructor for shared functionality
		this.driver = driver;
		PageFactory.initElements(driver, this);  // Initialize elements marked with @FindBy
	}

	// List of all product elements (each product card)
	@FindBy(css = ".mb-3")
	private List<WebElement> products;

	// Toast message container that appears after adding a product to the cart
	@FindBy(css = "#toast-container")
	private WebElement spinnerLogo;

	// Spinner/loading indicator shown during async operations
	@FindBy(css = ".ng-animating")
	private WebElement spinner;

	// Cart button in the header to go to the shopping cart
	@FindBy(css = "[routerlink*='cart']")
	private WebElement cartButton;

	// Locator for product cards (used for explicit waits)
	private By productName = By.cssSelector(".mb-3");

	// Locator for the "Add to Cart" button inside each product card
	private By addToCardButton = By.cssSelector(".card-body button:last-of-type");

	// Locator for toast message (used to wait for success message)
	private By toastMessage = By.cssSelector("#toast-container");

	// Method to return the list of product WebElements after waiting for them to appear
	public List<WebElement> getProductList() {
		waitForElementToAppear(productName);  // Wait until products are loaded
		return products;  // Return list of product elements
	}

	// Method to get a specific product WebElement by its name
	public WebElement getProductByName(String productName) {
		// Filter product list to find the first matching product (case-insensitive)
		WebElement prod = getProductList().stream()
			.filter(product -> product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(productName))
			.findFirst().orElse(null);
		return prod;
	}
	
	// Method to add a specified product to the cart
	public void addProductToCard(String productName) {
		WebElement prod = getProductByName(productName);  // Get the desired product element
		prod.findElement(addToCardButton).click();        // Click on "Add to Cart" button
		waitForElementToAppear(toastMessage);             // Wait for toast message to confirm action
		WaitForElementToDisappear(spinner);               // Wait for spinner to disappear (i.e., loading complete)
	}
}
