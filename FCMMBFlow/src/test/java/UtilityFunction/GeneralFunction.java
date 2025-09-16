package UtilityFunction;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import CommonFunction.MMBLoginPage;
import CommonFunction.MMBPaymentPage;
import MMBChangeFlightPage.MMBChangeFlightAddon;
import MMBChangeFlightPage.MMBDateChange;
import MMBChangeFlightPage.MMBFlightresult;
import MMBChangeFlightPage.MMBItinerary;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GeneralFunction {

	public static Properties properties;
	public static WebDriver driver;
	public static ExcelData excelData;

	Logger logger=Logger.getLogger(GeneralFunction.class);
	
	public static WebDriver getDriver() {
		return driver;
	}

	public static Properties loadbrowser() {

		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream("./src/test/resources/Config/Config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		properties = new Properties();
		try {
			properties.load(fileInputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return properties;
	}

	@BeforeSuite
	public void BrowserSelection() {

		loadbrowser();

		PropertyConfigurator.configure("./src/test/resources/Config/Log4j.properties");
		// String Browser = properties.getProperty("Browserproperty");
		logger.info("Application Start for MMB ManageBooking Flow :");
		String url = properties.getProperty("Url");
		logger.info("Application moved to Selecting Browser for execute ");
		if (GeneralFunction.getDriver() == null) {
			if (Constant.Browserproperty.equalsIgnoreCase("Chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				logger.info("Application has selected :" + Constant.Browserproperty);
			} else if (Constant.Browserproperty.equalsIgnoreCase("Firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				logger.info("Application has selected :" + Constant.Browserproperty);
			} else if (Constant.Browserproperty.equalsIgnoreCase("IE")) {
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				logger.info("Application has selected :" + Constant.Browserproperty);
			} else {
				logger.info("Application hasn't selected browser");
			}

			GeneralFunction.getDriver().get(url);
			GeneralFunction.getDriver().manage().window().maximize();
			GeneralFunction.getDriver().manage().timeouts().getImplicitWaitTimeout().getSeconds();
		}
		initElement();
	}

	public void initElement() {
		PageFactory.initElements(GeneralFunction.getDriver(), MMBLoginPage.getMmbLoginPage());

		PageFactory.initElements(GeneralFunction.getDriver(), MMBDateChange.getmmbdatechange());
		PageFactory.initElements(GeneralFunction.getDriver(), MMBFlightresult.getMmbFlightresult());
		PageFactory.initElements(GeneralFunction.getDriver(), MMBChangeFlightAddon.getMmbChangeFlightAddon());
		PageFactory.initElements(GeneralFunction.getDriver(), MMBItinerary.getMmbItinerary());
		PageFactory.initElements(GeneralFunction.getDriver(), MMBPaymentPage.getmmbPaymentPage());
	//	PageFactory.initElements(GeneralFunction.getDriver(), MMBAddonSelection.getMmbAddonSelection());
	//	PageFactory.initElements(GeneralFunction.getDriver(), MMBAddonPricecheck.getMmbAddonPricecheck());

	}

	@AfterSuite
	public void Teardown() {
		// GeneralFunction.getDriver().quit();
		logger.info("MMB booking was successfully executed ");
	}

}

