package mortgageCreditLink.CloudQA_EndToEnd;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import mortgageCreditLink.BaseTest.BaseTest;
import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.ConfirmationPage;
import pageObjects.OrderPage;
import pageObjects.ProductCatalogue;

public class SubmitOrder extends BaseTest {
	String productName;

	@Test(dataProvider = "getData", groups = { "Purchase" })
	public void SubmitOrderTest(HashMap<String, String> input) throws IOException, InterruptedException {

		productName = "ADIDAS ORIGINAL";
		String country = "INDIA";
		ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));

		List<WebElement> productList = productCatalogue.getProductList();
		productCatalogue.addProductToCard(input.get("product"));
		CartPage cartPage = productCatalogue.goToCartPage();

		Boolean match = cartPage.VerifyProductDisplay(input.get("product"));
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.SelectCountry(country);
		ConfirmationPage confirmationPage = checkoutPage.SubmitOrder();
		Thread.sleep(1500);
		String confirmMessage = confirmationPage.GetThankYouMessage(country);
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}

	@Test(dependsOnMethods = { "SubmitOrderTest" })
	public void OrderHistoryTest() {
		ProductCatalogue productCatalogue = landingPage.loginApplication("test@gmail.com",
				"Password@1234");
		OrderPage orderPage = productCatalogue.goToOrderPage();
		Assert.assertTrue(orderPage.VerifyOrderDisplay(productName));
	}

	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "\\src\\test\\java\\mortgageCreditLink\\data\\PurchaseOrder.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };

//		
//		
//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("email", "test@gmail.com");
//		map.put("password", "Password@1234");
//		map.put("product", "ADIDAS ORIGINAL");
//
//		HashMap<String, String> map2 = new HashMap<String, String>();
//		map.put("email", "test@gmail.com");
//		map.put("password", "Password@1234");
//		map.put("product", "ZARA COAT 3");		
	}

//	@DataProvider
//	public Object[][] getData() {
//		return new Object[][] { { "test@gmail.com", "Password@1234", "ADIDAS ORIGINAL" },
//				{ "test@gmail.com", "Password@1234", "ZARA COAT 3" } };
//	}

}
