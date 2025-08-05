package mortgageCreditLink.BaseTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReporterNG;

/**
 * TestNG Listener class for handling test events and logging using ExtentReports.
 * This class listens to test lifecycle events and logs test status (pass/fail),
 * attaches screenshots on failure, and generates a report.
 */
public class Listeners extends BaseTest implements ITestListener {

	WebDriver driver; // WebDriver instance to capture screenshots
	ExtentTest test; // ExtentTest object to log individual test results

	// ExtentReports object initialized from utility class
	ExtentReports extent = ExtentReporterNG.getReportObject();

	// Thread-safe ExtentTest storage to avoid data collision in parallel execution
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	/**
	 * Triggered when a test method starts.
	 * Initializes a new ExtentTest for the method and assigns it to the current thread.
	 */
	@Override
	public void onTestStart(ITestResult result) {
		// Create a new test entry in the Extent Report using method name
		test = extent.createTest(result.getMethod().getMethodName());

		// Store test object in thread-local to ensure thread safety in parallel tests
		extentTest.set(test);
	}

	/**
	 * Triggered when a test method passes.
	 * Logs the PASS status to the report.
	 */
	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Test Passed");
	}

	/**
	 * Triggered when a test*
