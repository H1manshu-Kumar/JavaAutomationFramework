package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonComponent.Common;

public class ConfirmationPage extends Common {
	WebDriver driver;

	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".hero-primary")
	private WebElement ThankYouMsgLabel;

	public String GetThankYouMessage(String expectedMessage) {
		return ThankYouMsgLabel.getText();
	}

}
