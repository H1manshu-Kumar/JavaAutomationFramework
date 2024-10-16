package mortgageCreditLink.CloudQA_EndToEnd;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class StandaloneTest {

	public static void main(String[] args) throws InterruptedException {
		String prodname = "ADIDAS ORIGINAL";
		System.setProperty("webdriver.chrome.driver",
				"D:\\Automation\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		Actions action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("test@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Password@1234");
		driver.findElement(By.id("login")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));

		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		WebElement prod = products.stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(prodname))
				.findFirst().orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();

		List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean match = cartProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(prodname));
		Assert.assertTrue(match);
		driver.findElement(By.cssSelector(".totalRow button")).click();

		action.sendKeys(driver.findElement(By.xpath("//*[@placeholder='Select Country']")), "IND").build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btnn.action__submit.ng-star-inserted")));
		action = new Actions(driver);
		action.moveToElement(driver.findElement(By.cssSelector(".action__submit"))).click().build().perform();
		String confirmActualMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(confirmActualMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		Assert.assertEquals(driver.findElement(By.cssSelector(".hero-primary")).getText(), "Thankyou for the order.");

		Thread.sleep(2000);
		driver.quit();

	}
}