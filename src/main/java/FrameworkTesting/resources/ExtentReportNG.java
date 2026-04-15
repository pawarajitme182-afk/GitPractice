package FrameworkTesting.resources;



import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {

	public static ExtentReports reportGen() {

		String path = System.getProperty("user.dir") + "\\Reports\\index.html";

		ExtentSparkReporter reporter = new ExtentSparkReporter(path);

		reporter.config().setReportName("Test file report");
		reporter.config().setDocumentTitle("Test Result");

		ExtentReports extent = new ExtentReports();

		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Ajit Pawar");
		return extent;
	}

}
