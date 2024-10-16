package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonComponent.Common;

public class ProductCatalogue extends Common {
	WebDriver driver;

	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// WebElement productName = driver.findElement(By.cssSelector(".mb-3"));
	// List<WebElement> cartItem = driver.findElements(By.cssSelector(".mb-3"));

	@FindBy(css = ".mb-3")
	private List<WebElement> products;

	@FindBy(css = "#toast-container")
	private WebElement spinnerLogo;

	@FindBy(css = ".ng-animating")
	private WebElement spinner;

	@FindBy(css = "[routerlink*='cart']")
	private WebElement cartButton;
	
	private By productName = By.cssSelector(".mb-3");
	private By addToCardButton = By.cssSelector(".card-body button:last-of-type");
	private By toastMessage = By.cssSelector("#toast-container");

	public List<WebElement> getProductList() {
		waitForElementToAppear(productName);
		return products;
	}

	public WebElement getProductByName(String productName) {
		WebElement prod = getProductList().stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(productName))
				.findFirst().orElse(null);
		return prod;
	}
	
	public void addProductToCard(String productName) {
		WebElement prod = getProductByName(productName);
		prod.findElement(addToCardButton).click();
		waitForElementToAppear(toastMessage);
		WaitForElementToDisappear(spinner);
	}


	
	
	
	
	
	
	
	
	
	
}
