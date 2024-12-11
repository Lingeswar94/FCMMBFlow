package CommonFunction;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


import UtilityFunction.ExcelData;
import UtilityFunction.GeneralFunction;


public class MMBPaymentTC extends GeneralFunction {

	ExcelData excelData = new ExcelData();

	 Logger logger=Logger.getLogger(MMBPaymentTC.class);
	@Test
	public void getPayment() {
		WebDriverWait wait = new WebDriverWait(GeneralFunction.getDriver(), Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(MMBPaymentPage.getmmbPaymentPage().CCpayment));
		 logger.info("Application moved to Payment Page ");
		try {

			MMBPaymentPage.getmmbPaymentPage().SelectPayment();
			wait.until(ExpectedConditions.visibilityOf(MMBPaymentPage.getmmbPaymentPage().Paymentcardname));
			MMBPaymentPage.getmmbPaymentPage().carddetails(excelData.getPaymentMMBData("MMBPaymentDetails", 2, 1),
					excelData.getPaymentMMBData("MMBPaymentDetails", 3, 1),
					excelData.getPaymentMMBData("MMBPaymentDetails", 4, 1));
			MMBPaymentPage.getmmbPaymentPage().Expirationyear(excelData.getPaymentMMBData("MMBPaymentDetails", 5, 1));
			 logger.info("User has completed Payment details ");
		} catch (Exception e) {
			 logger.error(e.getMessage());
		}
		try {

			MMBPaymentPage.getmmbPaymentPage().Billingdataclear();
			MMBPaymentPage.getmmbPaymentPage().Billingdetails(excelData.getBillingMMBData("MMBPaymentDetails", 10, 1),
					excelData.getBillingMMBData("MMBPaymentDetails", 11, 1),
					excelData.getBillingMMBData("MMBPaymentDetails", 12, 1),
					excelData.getBillingMMBData("MMBPaymentDetails", 13, 1),
					excelData.getBillingMMBData("MMBPaymentDetails", 14, 1),
					excelData.getBillingMMBData("MMBPaymentDetails", 15, 1));
			MMBPaymentPage.getmmbPaymentPage().selectCountry(excelData.getBillingMMBData("MMBPaymentDetails", 16, 1));
			 logger.info("User has completed Billing details ");
			MMBPaymentPage.getmmbPaymentPage().paymentcontinue();
			 logger.info("Application moved to Payment is Processing");
			String success = MMBPaymentPage.getmmbPaymentPage().Successmessage.getText();
			 logger.info(success);
		} catch (Exception e) {
			 logger.error(e.getMessage());
		}
	}
}
