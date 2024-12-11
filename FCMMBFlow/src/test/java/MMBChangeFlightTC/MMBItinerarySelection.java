package MMBChangeFlightTC;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

import MMBChangeFlightPage.MMBItinerary;
import UtilityFunction.GeneralFunction;


public class MMBItinerarySelection extends GeneralFunction {

Logger logger=Logger.getLogger(MMBItinerarySelection.class);
	
	@Test
	public void VerifyItinerary() {
		logger.info("Application moved to VerifyItinerary Page ");
		try {
			MMBItinerary.getMmbItinerary().getcheckbox();
			MMBItinerary.getMmbItinerary().getconfirmbutton();
			Alert alert = GeneralFunction.getDriver().switchTo().alert();
			alert.accept();

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
}
