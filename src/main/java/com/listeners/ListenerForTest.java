package com.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.*;
import org.testng.xml.XmlSuite;

import java.util.List;

public class ListenerForTest implements ISuiteListener, ITestListener ,IReporter {
    private static final Logger logger = LoggerFactory.getLogger(ListenerForTest.class);
    @Override
    public void onStart(ISuite iSuite) {
        Reporter.log("startSuite");

    }

    @Override
    public void onFinish(ISuite iSuite) {
        Reporter.log("finishSuite");

    }

    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("Test Passed");

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("test failed");

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
        final String contextName = iTestContext.getName();
        logger.info("context {} in suite {} has started", contextName, iTestContext.getSuite().getName());
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        final String contextName = iTestContext.getName();
        logger.info("context {} in suite {} has finished", contextName, iTestContext.getSuite().getName());
    }

    @Override
    public void generateReport(List<XmlSuite> list, List<ISuite> list1, String s) {

    }
}
