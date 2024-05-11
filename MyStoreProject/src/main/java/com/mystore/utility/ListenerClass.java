package com.mystore.utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.mystore.actions.Action;
import com.mystore.base.BaseClass;

public class ListenerClass extends ExtentManager implements ITestListener {

    // Create an instance of the Action class
    Action action = new Action();

    // Method invoked when a test starts
    public void onTestStart(ITestResult result) {
        // Create a new test in ExtentReports
        test = extent.createTest(result.getName());
    }

    // Method invoked when a test succeeds
    public void onTestSuccess(ITestResult result) {
        // Check if the test status is SUCCESS
        if (result.getStatus() == ITestResult.SUCCESS) {
            // Log the test as PASS in ExtentReports
            test.log(Status.PASS, "Pass Test case is: " + result.getName());
        }
    }

    // Method invoked when a test fails
    public void onTestFailure(ITestResult result) {
        // Check if the test status is FAILURE
        if (result.getStatus() == ITestResult.FAILURE) {
            // Log the test as FAIL in ExtentReports and provide a red label
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
            
            // Capture a screenshot of the failed test
            String imgPath = Action.screenShot(BaseClass.getDriver(), result.getName());
            
            // Attach the screenshot to the Extent report
            test.fail("ScreenShot is Attached", MediaEntityBuilder.createScreenCaptureFromPath(imgPath).build());
        }
    }

    // Method invoked when a test is skipped
    public void onTestSkipped(ITestResult result) {
        // Check if the test status is SKIP
        if (result.getStatus() == ITestResult.SKIP) {
            // Log the test as SKIP in ExtentReports
            test.log(Status.SKIP, "Skipped Test case is: " + result.getName());
        }
    }

    // Method invoked when a test fails within success percentage
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // No implementation needed for this method
    }

    // Method invoked when the test suite starts
    public void onStart(ITestContext context) {
        // No implementation needed for this method
    }

    // Method invoked when the test suite finishes
    public void onFinish(ITestContext context) {
        // No implementation needed for this method
    }
}
