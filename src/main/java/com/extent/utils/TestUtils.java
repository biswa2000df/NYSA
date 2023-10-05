package com.extent.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.extent.base.TestBase;

public class TestUtils {
	WebDriver driver;
	public TestUtils(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	
	public ExtentHtmlReporter htmlReport;
	public static ExtentReports extent;
	public static ExtentTest test;
	static String year;
	static String time;
	
	
	
	public String takeScreenShot() throws IOException {
		Date date = new Date();
		SimpleDateFormat tm = new SimpleDateFormat("yyyy-MM-dd");
		year = tm.format(date);
		SimpleDateFormat tm1 = new SimpleDateFormat("hh_mm_ss");
		time = tm1.format(date);
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destFile = System.getProperty("user.dir") + File.separator  +"Screenshot" + File.separator  + year + File.separator + time + ".png";
		FileUtils.copyFile(srcFile, new File(destFile));
		return destFile;
	}
	
	public void ScreenshotPathFormat() {
		Date date = new Date();
		SimpleDateFormat tm = new SimpleDateFormat("yyyy-MM-dd");
		year = tm.format(date);
		SimpleDateFormat tm1 = new SimpleDateFormat("hh_mm_ss");
		time = tm1.format(date);
	}
	
	
	
	public void testCaseCreate(String tc) {
		test = extent.createTest(tc);
	}
	
	
	public void extentReport() throws IOException {
		ScreenshotPathFormat();
		String path = System.getProperty("user.dir") + "/REPORT_NYSA";
		String finalPath = path + File.separator + year + File.separator;
		new File(finalPath).mkdirs();
		htmlReport = new ExtentHtmlReporter(finalPath + time + ".html");

		htmlReport.config().setDocumentTitle("Automation Report");// Title of the report
		htmlReport.config().setReportName("Functional Report");// Name of the report
		htmlReport.config().setTheme(Theme.STANDARD);
		extent = new ExtentReports();
		extent.setSystemInfo("Comapny Name", "NYSA");
		extent.setSystemInfo("Project Name", "ISHINE");
		extent.setSystemInfo("Test Lead", "Prabhat Padhy");
		extent.attachReporter(htmlReport);
		extent.setSystemInfo("OS", "Window11");
		extent.setSystemInfo("Tester Name", "Biswajit");
		extent.setSystemInfo("Browser", "Chrome");
		
	}

	
	public void passTestCase(String passDesc) throws IOException {
		test.log(Status.INFO, MarkupHelper.createLabel(passDesc, ExtentColor.GREEN));
		test.log(Status.PASS, "", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
	}

	public void failTestCase(String failDesc) throws IOException {
		test.log(Status.INFO, MarkupHelper.createLabel(failDesc, ExtentColor.RED));
		test.log(Status.FAIL, "", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
	}
	
	
	public void ExtentFlush() {
		extent.flush();
	}
}
