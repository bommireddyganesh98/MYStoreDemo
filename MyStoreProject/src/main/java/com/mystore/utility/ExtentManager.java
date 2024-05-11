package com.mystore.utility;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    
    // Declare ExtentSparkReporter, ExtentReports, and ExtentTest objects
    public static ExtentSparkReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest test;
    
    // Method to initialize ExtentReports and set up the report
    public static void setExtent() throws IOException {
        // Initialize ExtentSparkReporter with the report location
        htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/ExtentReport/" + "MyReport.html");
        
        // Load the XML configuration file if needed
        htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");
        
        // Initialize ExtentReports and attach the ExtentSparkReporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        
        // Set system information to be displayed in the report
        extent.setSystemInfo("HostName", "MyHost");
        extent.setSystemInfo("ProjectName", "MyStoreProject");
        extent.setSystemInfo("Tester", "Ganesh");
        extent.setSystemInfo("OS", "Win10");
        extent.setSystemInfo("Browser", "Chrome");
    }
    
    // Method to flush the report and close the ExtentReports instance
    public static void endReport() {
        extent.flush();
    }
}
