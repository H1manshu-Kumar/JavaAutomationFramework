package cucumber;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mortgageCreditLink.BaseTest.BaseTest;
import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.ConfirmationPage;
import pageObjects.LandingPage;
import pageObjects.ProductCatalogue;

public class SubmitOrderStepDefination extends BaseTest {
	public LandingPage landingPage;
	ProductCatalogue productCatalogue;
	ConfirmationPage confirmationPage;
	String countryName;

	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException {
		landingPage = LaunchApplication();
	}

	@Given("^Logged in with username (.+) and password (.+)$")
	public void Logged_in_with_username_and_password(String username, String password) {
		productCatalogue = landingPage.loginApplication(username, password);
	}

	@When("^I add the product (.+) to Card$")
	public void I_add_the_product_to_Card(String productName) {
		List<WebElement> productList = productCatalogue.getProductList();
		productCatalogue.addProductToCard(productName);
	}

	@When("^Checkout (.+) and submit the order for (.+)$")
	public void Checkout_and_submit_the_order(String productName, String country) {
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		countryName = country;
		checkoutPage.SelectCountry(countryName);
		confirmationPage = checkoutPage.SubmitOrder();
	}

	@Then("{string} Verify message is displayed on ConfirmationPage")
	public void message_displayed_on_ConfirmationPage(String confirmationMessage) {
		String confirmMessage = confirmationPage.GetThankYouMessage(countryName);
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		driver.quit();
	}

}
