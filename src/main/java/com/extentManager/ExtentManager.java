package com.extentManager;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.base.BaseClass;

public class ExtentManager {
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest test;

    public static void setExtent() {
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/ExtentReport/"+"MyReport_"+ BaseClass.getCurrentTime() +".html");

        htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "/src/extent-config.xml");

//        If you use xml for config the report, you do not need to these code below
//        htmlReporter.config().setDocumentTitle("Automation Test Report");
//        htmlReporter.config().setReportName("Electronic Ecommerce Test Automation Report");
//        htmlReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        extent.setSystemInfo("HostName", "MyHost");
        extent.setSystemInfo("Project Name", "Ecommerce Website");
        extent.setSystemInfo("Tester", "Hitendra");
        extent.setSystemInfo("OS", "Win10");
        extent.setSystemInfo("Browser", "Chrome");
    }

    public  static void endReport() {
        extent.flush();
    }
}
