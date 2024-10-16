package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonComponent.Common;

public class LandingPage extends Common{
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// WebElement userEmail = driver.findElement(By.id("userEmail"));

	// PageFactory
	@FindBy(id = "userEmail")
	private WebElement Email;

	@FindBy(id = "userPassword")
	private WebElement Password;

	@FindBy(id = "login")
	private WebElement login;
	
	@FindBy(css = "[class*='flyInOut']")
	private WebElement errorMessage;


	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}

	public ProductCatalogue loginApplication(String email, String password) {
		Email.sendKeys(email);
		Password.sendKeys(password);
		login.click();
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		return productCatalogue;
	}
	
	public String getErrorMessage() {
		waitForElementToAppear(errorMessage);
		return errorMessage.getText();
	}

}
