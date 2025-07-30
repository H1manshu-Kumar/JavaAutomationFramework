// Declares that this class is part of the 'pageObjects' package
package pageObjects;

// Required Selenium classes and support libraries
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonComponent.Common;  // Importing common functionality shared across page classes

// Class representing the Checkout Page, extending Common class for shared utilities
public class CheckoutPage extends Common {
	WebDriver driver;  // WebDriver instance to interact with the browser

	// Constructor initializes the WebDriver and PageFactory elements
	public CheckoutPage(WebDriver driver) {
		super(driver);  // Calls constructor of parent Common class
		this.driver = driver;
		PageFactory.initElements(driver, this);  // Initializes WebElements with PageFactory
	}

	// WebElement for the Submit (Place Order) button using CSS selector
	@FindBy(css = ".action__submit")
	private WebElement submit;

	// WebElement for the Country input field
	@FindBy(xpath = "//*[@placeholder='Select Country']")
	private WebElement Country;

	// WebElement for the country suggestion item to select (second item in the list)
	@FindBy(xpath = "(//button[contains(@class,'ta-item')])[2]")
	private WebElement SelectCountry;

	// By locator for the list of country suggestions (used for wait logic)
	By results = By.cssSelector(".ta-results");

	// By locator for the actual Place Order button
	By PlaceOrderButton = By.cssSelector(".btnn.action__submit.ng-star-inserted");

	// Method to select a country during checkout
	public void SelectCountry(String countryName) {
		Actions a = new Actions(driver);  // Create Actions instance to perform keyboard input
		a.sendKeys(Country, countryName).build().perform();  // Type country name in input field
		waitForElementToAppear(results);  // Wait until the country suggestion list appears
		SelectCountry.click();  // Click the second country suggestion
	}

	// Method to submit the order and return the ConfirmationPage
	public ConfirmationPage SubmitOrder() {
		Actions action = new Actions(driver);  // Create Actions instance
		// Move to the 'Place Order' button and click using Actions class
		action.moveToElement(driver.findElement(PlaceOrderButton)).click().build().perform();
		// Return a new instance of ConfirmationPage
		return new ConfirmationPage(driver);
	}
}
