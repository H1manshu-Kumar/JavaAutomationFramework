package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	static ExtentReports extent;

	// This method sets up and returns an ExtentReports object for generating test reports
	public static ExtentReports getReportObject() {
		// Define the path where the report will be generated
		String reportPath = System.getProperty("user.dir") + "\\reports\\index.html";

		// Create a reporter instance to generate the report at the specified path
		ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);

		// Set the name and title for the report
		reporter.config().setReportName("Web Automation Reports");
		reporter.config().setDocumentTitle("Test Results");

		// Create ExtentReports instance and attach the reporter to it
		extent = new ExtentReports();
		extent.attachReporter(reporter);

		// Add additional information to the report (e.g., tester name)
		extent.setSystemInfo("Tester", "QA 1");

		// Return the configured ExtentReports object
		return extent;
	}
}
