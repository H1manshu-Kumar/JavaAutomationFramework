package mortgageCreditLink.BaseTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import pageObjects.LandingPage;

public class BaseTest {

	public WebDriver driver; // WebDriver instance used across the test
	public LandingPage landingPage; // LandingPage object to interact with the application

	/**
	 * Initializes WebDriver based on browser configuration from system property or properties file.
	 * Supports Chrome browser with setup. Firefox and Edge stubs are present.
	 */
	public WebDriver initializeDriver() throws IOException {
		// Load properties from external configuration file
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\GlobalData.properties");
		prop.load(fis);

		// Get browser name from system property if present, otherwise use config file
		String browserName = System.getProperty("browser") != null ? System.getProperty("browser")
				: prop.getProperty("browser");

		// Setup Chrome WebDriver with options
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"D:\\Automation\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*"); // Allow remote connections
			driver = new ChromeDriver(options);
		} else if (browserName.equalsIgnoreCase("firefox")) {
			// TODO: Add setup for Firefox driver
		} else if (browserName.equalsIgnoreCase("edge")) {
			// TODO: Add setup for Edge driver
		}

		// Implicit wait and window maximize settings
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		return driver;
	}

	/**
	 * Launches the application before every test method.
	 * @return LandingPage object to interact with the application
	 */
	@BeforeMethod(alwaysRun = true)
	public LandingPage LaunchApplication() throws IOException {
		driver = initializeDriver(); // Initialize browser driver
		landingPage = new LandingPage(driver); // Create LandingPage object with driver
		landingPage.goTo(); // Navigate to application URL
		return landingPage;
	}

	/**
	 * Tears down the browser after each test method.
	 * Waits 1.5 seconds before quitting to allow observation.
	 */
	@AfterMethod(alwaysRun = true)
	public void tearDown() throws InterruptedException {
		Thread.sleep(1500); // Small delay for UI inspection before closing
		driver.quit(); // Close the browser
	}

	/**
	 * Reads a JSON file and converts it to a list of key-value pairs (HashMap).
	 * Useful for data-driven testing using JSON files.
	 * 
	 * @param filePath path to the JSON file
	 * @return List of HashMaps with the test data
	 * @throws IOException if file read fails
	 */
	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
		// Read JSON file content as a String
		String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);

		// Convert JSON string to list of HashMaps using Jackson ObjectMapper
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;
	}

	/**
	 * Takes a screenshot of the current browser window.
	 * Saves the screenshot in the /Screenshots directory.
	 *
	 * @param testcaseName name of the test case for the screenshot file
	 * @param driver WebDriver instance used to capture the screenshot
	 * @return Absolute path of the saved screenshot file
	 * @throws IOException if screenshot capture or file write fails
	 */
	public String takeScreenshot(String testcaseName, WebDriver driver) throws IOException {
		// Capture screenshot using Selenium's TakesScreenshot interface
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE); // Temporary screenshot file

		// Destination path to save screenshot
		File destFile = new File(System.getProperty("user.dir") + "\\Screenshots\\" + testcaseName + ".png");

		// Copy screenshot to destination
		FileUtils.copyFile(srcFile, destFile);

		// Return the absolute path of the saved screenshot
		return System.getProperty("user.dir") + "\\Screenshots\\" + testcaseName + ".png";
	}
}
