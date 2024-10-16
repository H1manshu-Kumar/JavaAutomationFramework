package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commonComponent.Common;

public class OrderPage extends Common{
	WebDriver driver;
	
	public OrderPage(WebDriver driver){
		super(driver);
		this.driver=driver;		
	}
	
	@FindBy(css="table.table-bordered.table-hover.ng-star-inserted tbody tr td:nth-child(3)")
	private List<WebElement> productNames;
	
	@FindBy(css=".totalRow button")
	private WebElement CheckoutButton;
	
	public Boolean VerifyOrderDisplay(String productName) {
		Boolean match = productNames.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
		return match;
	}

}
