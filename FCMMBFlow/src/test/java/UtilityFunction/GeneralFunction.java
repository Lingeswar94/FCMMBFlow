package UtilityFunction;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import CommonFunction.MMBLoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GeneralFunction {

	public static Properties properties;
	public static WebDriver driver;
	public static ExcelData excelData;

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

		//String Browser = properties.getProperty("Browserproperty");
		String Browser=System.getProperty("Browserproperty");
		String url = properties.getProperty("Url");
		if (GeneralFunction.getDriver() == null) {
			if (Browser.equalsIgnoreCase("Chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();

			} else if (Browser.equalsIgnoreCase("Firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			} else if (Browser.equalsIgnoreCase("IE")) {
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
			} else {
				System.out.println("Browser is not Support for MMB Change flight flow ");
			}

			GeneralFunction.getDriver().get(url);
			GeneralFunction.getDriver().manage().window().maximize();
			GeneralFunction.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
		initElement();
	}

	public void initElement() {
		PageFactory.initElements(GeneralFunction.getDriver(), MMBLoginPage.getMmbLoginPage());
		/*
		 * PageFactory.initElements(CommonFuntion.getDriver(),
		 * MMBDateChange.getmmbdatechange());
		 * PageFactory.initElements(CommonFuntion.getDriver(),
		 * MMBFlightresult.getMmbFlightresult());
		 * PageFactory.initElements(CommonFuntion.getDriver(),
		 * MMBChangeFlightAddon.getMmbChangeFlightAddon());
		 * PageFactory.initElements(CommonFuntion.getDriver(),
		 * MMBItineraryPage.getItineraryPage());
		 * PageFactory.initElements(CommonFuntion.getDriver(),
		 * MMBPaymentPage.getmmbPaymentPage());
		 * PageFactory.initElements(CommonFuntion.getDriver(),
		 * MMBAddonSelection.getMmbAddonSelection());
		 * PageFactory.initElements(CommonFuntion.getDriver(),
		 * MMBAddonPricecheck.getMmbAddonPricecheck());
		 */
	}

	@AfterSuite
	public void Teardown() {
		// GeneralFunction.getDriver().quit();
	}

}
