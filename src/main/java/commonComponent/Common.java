package commonComponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.CartPage;
import pageObjects.OrderPage;

/**
 * Common class contains reusable utility methods for page interaction.
 * It supports navigation between common pages and waiting for element states.
 * Implements the Page Object Model design pattern.
 */
public class Common {
	WebDriver driver;
	WebDriverWait wait;

	/**
	 * Constructor initializes the WebDriver and PageFactory elements.
	 * 
	 * @param driver the WebDriver instance passed from the test or parent class.
	 */
	public Common(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// WebElement representing the Cart page navigation header
	@FindBy(css = "[routerlink*='cart']")
	WebElement cartHeader;

	// WebElement representing the Orders page navigation header
	@FindBy(css = "[routerlink*='myorders']")
	WebElement OrderHeader;

	/**
	 * Waits for an element to become visible using its locator.
	 * 
	 * @param findByElement the By locator of the element to wait for.
	 */
	public void waitForElementToAppear(By findByElement) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findByElement));
	}

	/**
	 * Waits for a specific WebElement to become visible.
	 * 
	 * @param element the WebElement to wait for.
	 */
	public void waitForElementToAppear(WebElement element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * Waits for a specific WebElement to become invisible.
	 * Useful for waiting until loading spinners or overlays disappear.
	 * 
	 * @param element the WebElement to wait to disappear.
	 */
	public void WaitForElementToDisappear(WebElement element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	/**
	 * Navigates to the Cart Page by clicking on the cart header link.
	 * 
	 * @return a new instance of the CartPage.
	 */
	public CartPage goToCartPage() {
		cartHeader.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}

	/**
	 * Navigates to the Order Page by clicking on the order header link.
	 * 
	 * @return a new instance of the OrderPage.
	 */
	public OrderPage goToOrderPage() {
		OrderHeader.click();
		OrderPage orderPage = new OrderPage(driver);
		return orderPage;
	}

	/**
	 * Waits for an element (located by a By locator) to become clickable.
	 * Useful before performing click actions to avoid ElementNotInteractable exceptions.
	 * 
	 * @param findByElement the By locator of the element to wait for.
	 */
	public void WaitForElementToClickable(By findByElement) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(findByElement));
	}
}
