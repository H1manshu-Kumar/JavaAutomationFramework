package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonComponent.Common;

public class CheckoutPage extends Common {
	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".action__submit")
	private WebElement submit;

	@FindBy(xpath = "//*[@placeholder='Select Country']")
	private WebElement Country;

	@FindBy(xpath = "(//button[contains(@class,'ta-item')])[2]")
	private WebElement SelectCountry;

	By results = By.cssSelector(".ta-results");
	By PlaceOrderButton = By.cssSelector(".btnn.action__submit.ng-star-inserted");

	public void SelectCountry(String countryName) {
		Actions a = new Actions(driver);
		a.sendKeys(Country, countryName).build().perform();
		waitForElementToAppear(results);
		SelectCountry.click();
	}

	public ConfirmationPage SubmitOrder() {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(PlaceOrderButton)).click().build().perform();
		return new ConfirmationPage(driver);
	}

}
