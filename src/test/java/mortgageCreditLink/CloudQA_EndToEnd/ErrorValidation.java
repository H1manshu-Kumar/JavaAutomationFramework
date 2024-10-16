package mortgageCreditLink.CloudQA_EndToEnd;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.sun.net.httpserver.Authenticator.Retry;

import mortgageCreditLink.BaseTest.BaseTest;
import pageObjects.CartPage;
import pageObjects.ProductCatalogue;

public class ErrorValidation extends BaseTest {
	String prodname = "ADIDAS ORIGINAL";
	String country = "INDIA";
	ExtentReports extent;

	@Test(groups = { "ErrorHandling" }, retryAnalyzer = mortgageCreditLink.BaseTest.Retry.class)
	public void LoginErrorValidation() {
		ProductCatalogue productCatalogue = landingPage.loginApplication("test@gmail.com",
				"Password@1234");
		Assert.assertEquals("Login Successfully", landingPage.getErrorMessage());
	}

	@Test
	public void ProductErrorValidation() throws IOException, InterruptedException {

		String prodname = "ADIDAS ORIGINAL";
		String country = "INDIA";
		ProductCatalogue productCatalogue = landingPage.loginApplication("test@gmail.com",
				"Password@1234");

		List<WebElement> productList = productCatalogue.getProductList();
		productCatalogue.addProductToCard(prodname);
		CartPage cartPage = productCatalogue.goToCartPage();

		Boolean match = cartPage.VerifyProductDisplay("Invalid Products");
		Assert.assertFalse(match);

	}
}