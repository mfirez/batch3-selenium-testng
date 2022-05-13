package com.eurotech.tests.day27.extentreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.eurotech.utilities.ConfigurationReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExtentReportTest {

    // This class is used to start and build reports
    ExtentReports report;

    // This class is used to create HTML report file
    ExtentHtmlReporter htmlReporter;

    // This class defines a test, enables adding logs, authors, test steps
    ExtentTest extentLogger;


    @BeforeMethod
    public void setUp() {

        // initialize the class
        report = new ExtentReports();

        String projectPath = System.getProperty("user.dir");
        String path = projectPath + "/test-output/report.html";

        //Initialize the HTML reporter with the report path
        htmlReporter = new ExtentHtmlReporter(path);

        // Attach the HTML report to the report object
        report.attachReporter(htmlReporter);

        // Tittle in report
        htmlReporter.config().setReportName("EuroTech Login Test");

        // Set environment information
        report.setSystemInfo("Environment","QA");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS",System.getProperty("os name"));

    }


    @AfterMethod
    public void tearDown() {
        //This is when the report created
        report.flush();
    }


    @Test
    public void test1() {

        extentLogger = report.createTest("TC001 Deneme Testi");

        // Test Steps
        extentLogger.info("Open Chrome Browser");

        extentLogger.info("Go to eurotech.study");

        extentLogger.info("Enter teacher credentials");

        extentLogger.info("Click Login Button");

        extentLogger.info("Verify logged in");

        extentLogger.pass("TC001 is passed");

    }


}
