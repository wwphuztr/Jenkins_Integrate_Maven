package com.listener;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.base.BaseClass;
import com.extentManager.ExtentManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class ListenerClass extends ExtentManager implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        if (result.getStatus() == ITestResult.SUCCESS) {
            ExtentManager.test.log(Status.PASS, "Pass Test Case is: " + result.getName());
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            ExtentManager.test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "- Test Case Fail", ExtentColor.RED));
            ExtentManager.test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + "- Test Case Fail", ExtentColor.RED));

            String pathString = BaseClass.screenShot(BaseClass.driver, result.getName());
            try {
                ExtentManager.test.addScreenCaptureFromPath(pathString);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        if (result.getStatus() == ITestResult.SKIP) {
            ExtentManager.test.log(Status.SKIP, "Skipped Test Case is: " + result.getName());
        }
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }
}
