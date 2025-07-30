// Declares this class belongs to the 'pageObjects' package
package pageObjects;

// Selenium imports for interacting with the browser and web elements
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonComponent.Common;  // Importing Common class for shared functionality

// Class representing the landing (login) page of the application
public class LandingPage extends Common {
	WebDriver driver;  // WebDriver instance to control the browser

	// Constructor to initialize driver and web elements using PageFactory
	public LandingPage(WebDriver driver) {
		super(driver);  // Call to parent class constructor
		this.driver = driver;
		PageFactory.initElements(driver, this);  // Initialize elements marked with @FindBy
	}

	// WebElement for email input field (replaces driver.findElement(By.id("userEmail")))
	@FindBy(id = "userEmail")
	private WebElement Email;

	// WebElement for password input field
	@FindBy(id = "userPassword")
	private WebElement Password;

	// WebElement for login button
	@FindBy(id = "login")
	private WebElement login;

	// WebElement for capturing error messages (like invalid credentials)
	@FindBy(css = "[class*='flyInOut']")
	private WebElement errorMessage;

	// Method to navigate to the landing page URL
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}

	// Method to perform login with provided email and password
	public ProductCatalogue loginApplication(String email, String password) {
		Email.sendKeys(email);        // Enter email
		Password.sendKeys(password);  // Enter password
		login.click();                // Click login button
		// Navigate to and return the ProductCatalogue page object
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		return productCatalogue;
	}

	// Method to retrieve error message displayed on invalid login
	public String getErrorMessage() {
		waitForElementToAppear(errorMessage);  // Wait for error message to become visible
		return errorMessage.getText();         // Return the error text
	}
}
