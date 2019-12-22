package com.wanafood.testcases;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.wanafood.utilities.VideoClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class WanaFoodApp_Launch {
	public AndroidDriver<WebElement> driver;

	String urlTitle = "TimeDynamo";
	public static ExtentHtmlReporter htmlReport;
	public static ExtentReports extentReport;
	public static ExtentTest extentTest;
	public static ExtentColor color;
	String test = "testSrcshot";
	VideoClass sr;

	@BeforeSuite
	public void htmlReportSetup() {

		// htmlReport=new ExtentHtmlReporter(file);
		htmlReport = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "/test-output/Wanafood_TestCases" + ".html");
		extentReport = new ExtentReports();
		extentReport.attachReporter(htmlReport);
		htmlReport.config().setReportName("TimeDynamoWebApp_RegreessionTesting");
		htmlReport.config().setDocumentTitle("TimeDynamoWeb");
		htmlReport.config().setTheme(Theme.STANDARD);
		htmlReport.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		htmlReport.config().setDocumentTitle("Extent report");
		htmlReport.config().setReportName("TimeDynamo");
		extentReport.setSystemInfo("HostName", "tvisha-desktop");
		extentReport.setSystemInfo("Filename", "TimeDynamo_LocalWebApp");

	}

	@BeforeTest
	public void webStart() throws MalformedURLException {
		sr=new VideoClass();
		sr.startRecording("test");
		extentTest=extentReport.createTest("APP LAUNCH");
		
		
		File file=new File("src");
		File f=new File(file,"wanaFoodAgnt14.apk");
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.APP, f.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator");
		cap.setCapability("autoGrantPermissions", true);
		cap.setCapability("unicodeKeyboard", true);
		cap.setCapability("setKeyboard", true);
		cap.setCapability("appPackage", "com.ongo.wana_food_agent");
		cap.setCapability("appActivity", "com.ongo.wana_food_agent.SplashScreenActivity");
		driver=new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		
	}

	@AfterTest
	public void htmlClose() {
		System.out.println("============Scenario completed===========");

		sr.stopRecording();
		// driver.close();
		// System.err.println("recording stopped");
		extentReport.flush();
		System.out.println("Execution Done!!!");

	}

	@AfterMethod
	public void getResult(ITestResult result) throws IOException, InterruptedException {
		if (result.getStatus() == ITestResult.FAILURE) {

			System.err.println("recording stopped");
			extentTest.log(Status.INFO,
					"<video width=\"320\" height=\"240\" controls>\n" + "  <source src=\"./mp4Result/" + "testvideo"
							+ sr.videoName + "\" type=\"video/mp4\">\n"
							+ "Your browser does not support the video tag.\n" + "</video>");
			extentTest.addScreenCaptureFromPath(getScreenshot(driver, test));
			Thread.sleep(2000);
			// MarkupHelper is used to display the output in different colors
			extentTest.log(Status.FAIL,
					MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));

		} else if (result.getStatus() == ITestResult.SKIP) {
			extentTest.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
			extentTest.log(Status.SKIP,
					MarkupHelper.createLabel(result.getThrowable() + " - Test Case Skipped", ExtentColor.ORANGE));
		} else if (result.getStatus() == ITestResult.SUCCESS) {

			extentTest.log(Status.PASS,
					MarkupHelper.createLabel(result.getName() + " - Test Case Passed", ExtentColor.GREEN));
			Thread.sleep(1300);

			extentTest.log(Status.INFO,
					"<video width=\"320\" height=\"240\" controls>\n" + "  <source src=\"./mp4Result/" + "testvideo"
							+ sr.videoName + "\" type=\"video/mp4\">\n"
							+ "Your browser does not support the video tag.\n" + "</video>");

		}
	}

	private String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots"
		// under src folder
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName
				+ ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
	
	public void setexplicitwait(AndroidElement ele) {
		WebDriverWait wait=new WebDriverWait(driver, 12);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

}
