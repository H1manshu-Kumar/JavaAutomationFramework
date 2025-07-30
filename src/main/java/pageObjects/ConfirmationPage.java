// Declares the class is part of the 'pageObjects' package
package pageObjects;

// Importing necessary Selenium WebDriver and support libraries
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonComponent.Common;  // Importing Common class for shared utilities across page objects

// Page Object class representing the confirmation (Thank You) page
public class ConfirmationPage extends Common {
	WebDriver driver;  // Instance of WebDriver to interact with the browser

	// Constructor to initialize driver and PageFactory WebElements
	public ConfirmationPage(WebDriver driver) {
		super(driver);  // Call parent constructor from Common class
		this.driver = driver;
		PageFactory.initElements(driver, this);  // Initialize WebElements defined with @FindBy
	}

	// WebElement for the Thank You message displayed after order submission
	@FindBy(css = ".hero-primary")
	private WebElement ThankYouMsgLabel;

	// Method to get the text of the Thank You message
	public String GetThankYouMessage(String expectedMessage) {
		return ThankYouMsgLabel.getText();  // Return the actual displayed text
	}
}
