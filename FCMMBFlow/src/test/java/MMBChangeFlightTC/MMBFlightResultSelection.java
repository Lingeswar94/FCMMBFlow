package MMBChangeFlightTC;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import MMBChangeFlightPage.MMBFlightresult;
import UtilityFunction.Constant;
import UtilityFunction.ExcelData;
import UtilityFunction.GeneralFunction;



public class MMBFlightResultSelection extends GeneralFunction {


		Logger logger = Logger.getLogger(MMBFlightResultSelection.class);
		ExcelData excelData = new ExcelData();

		@Test
		public void Flightresult() {
			logger.info("Application moved to MMBCabin Fare Selection ");
			WebDriverWait wait = new WebDriverWait(GeneralFunction.getDriver(), Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOfAllElements(MMBFlightresult.getMmbFlightresult().OBFareselection));

			try {
				MMBFlightresult.getMmbFlightresult().Fareselecting(Constant.OBSegmentCabinFare,Constant.IBSegmentCabinFare);
				MMBFlightresult.getMmbFlightresult().FlightContiune();
				logger.info("Application has selected Cabin Fare : ");
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		}
		
}
