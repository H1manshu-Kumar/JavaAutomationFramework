package mortgageCreditLink.CloudQA_EndToEnd;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import mortgageCreditLink.BaseTest.BaseTest;
import pageObjects.CartPage;
import pageObjects.ProductCatalogue;

// This class contains test methods to perform negative/error validation scenarios 
public class ErrorValidation extends BaseTest {

	// Expected product name and country for test data
	String prodname = "ADIDAS ORIGINAL";
	String country = "INDIA";

	ExtentReports extent;

	// Test to validate login error message when credentials are invalid
	@Test(groups = { "ErrorHandling" }, retryAnalyzer = mortgageCreditLink.BaseTest.Retry.class)
	public void LoginErrorValidation() {
		// Attempt login with incorrect credentials
		ProductCatalogue productCatalogue = landingPage.loginApplication("test@gmail.com", "Password@1234");
		
		// Verify the actual error message (intentionally failing assertion for demonstration)
		Assert.assertEquals("Login Successfully", landingPage.getErrorMessage());
	}

	// Test to validate error scenario when incorrect product is asserted in the cart
	@Test
	public void ProductErrorValidation() throws IOException, InterruptedException {

		// Login with test credentials
		ProductCatalogue productCatalogue = landingPage.loginApplication("test@gmail.com", "Password@1234");

		// Get the list of all products
		List<WebElement> productList = productCatalogue.getProductList();

		// Add a specific product to cart
		productCatalogue.addProductToCard(prodname);

		// Navigate to the cart page
		CartPage cartPage = productCatalogue.goToCartPage();

		// Verify that an incorrect product (intentionally wrong name) is not present in the cart
		Boolean match = cartPage.VerifyProductDisplay("Invalid Products");

		// Assert that the incorrect product is NOT found in the cart
		Assert.assertFalse(match);
	}
}
