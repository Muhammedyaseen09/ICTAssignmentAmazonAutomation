package Listeners_Page;

import Launch_Browser.BrowserLaunch;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.IOException;



public class ReportPage implements ITestListener {

    public ExtentReports reports;
    public ExtentSparkReporter extentSparkReporter;
    public ExtentTest extentTest;

    public void onStart(ITestContext context) {


        String path=System.getProperty("user.dir");
        reports=new ExtentReports();
        extentSparkReporter=new ExtentSparkReporter(path+"\\report\\report.html");
        reports.attachReporter(extentSparkReporter);


    }

    public void onTestSuccess(ITestResult result) {
        extentTest=reports.createTest(result.getName());
        extentTest.log(Status.PASS, result.getName());
        try {
            extentTest.addScreenCaptureFromPath(BrowserLaunch.takeScreenshot());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void onTestFailure(ITestResult result) {

        extentTest=reports.createTest(result.getName());
        extentTest.log(Status.FAIL,result.getName());

            try {
                extentTest.addScreenCaptureFromPath(BrowserLaunch.takeScreenshot());
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

    }

    public void onTestSkipped(ITestResult result) {
        extentTest=reports.createTest(result.getName());
        extentTest.log(Status.SKIP,result.getName());
    }

    public void onFinish(ITestContext context) {
        reports.flush();
    }

}
