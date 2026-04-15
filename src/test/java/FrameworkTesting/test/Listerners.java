package FrameworkTesting.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import FrameworkTesting.resources.ExtentReportNG;

public class Listerners extends BaseTest implements ITestListener {
	ExtentTest test;
	ExtentReports extent = ExtentReportNG.reportGen();
	ThreadLocal<ExtentTest> extenTest = new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		extenTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extenTest.get().log(Status.PASS, "Test pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// test.log(Status.FAIL, "Test fail");
		extenTest.get().fail(result.getThrowable());

		try {

			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());

		} catch (Exception e1) {
			e1.printStackTrace();
		}

		String filepath = null;
		try {

			filepath = getScreenshot(result.getMethod().getMethodName(), driver);

		} catch (IOException e) {
			e.printStackTrace();
		}
		extenTest.get().addScreenCaptureFromBase64String(filepath, result.getMethod().getMethodName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// not implemented
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// not implemented
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		onTestFailure(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// not implemented
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}
}
