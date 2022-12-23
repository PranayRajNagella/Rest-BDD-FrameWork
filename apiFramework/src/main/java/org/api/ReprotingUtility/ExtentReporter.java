package org.api.ReprotingUtility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {

    private static ExtentReports extentReports;

    public static void setUpExtentReport()
    {
        if(extentReports==null) {
            ExtentSparkReporter reporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/src/test/resources/Reports/ExtentReport.html");
            extentReports=new ExtentReports();
            extentReports.attachReporter(reporter);
        }
    }

    public ExtentTest createExtentTest(String Name,String Category)
    {
        return extentReports.createTest(Name, Category);
    }

    public static void endExtentReport()
    {
        extentReports.flush();
    }

}
