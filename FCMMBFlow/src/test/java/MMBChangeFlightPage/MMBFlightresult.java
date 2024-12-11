package MMBChangeFlightPage;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class MMBFlightresult {
	private static MMBFlightresult mmbFlightresult;
	//Logger logger = Logger.getLogger(MMBFlightresult.class);
	private MMBFlightresult() {

	}

	public static MMBFlightresult getMmbFlightresult() {
		if (mmbFlightresult == null) {
			mmbFlightresult = new MMBFlightresult();
		}
		return mmbFlightresult;
	}

	@FindBy(xpath = "//div[@id='divOBFlightResults']/div/div/ul/li")
	public List<WebElement> OBFareselection;

	@FindBy(xpath = "//div[@id='divIBFlightResults']/div/div/ul/li")
	private List<WebElement> IBFareselection;

	@FindBy(xpath = "//*[@id='btnContinue']")
	private WebElement flightcontinue;

	public void Fareselecting(String OBfareClass, String IBfareClass) {

		// Outbound flight selection
		selectFare(OBFareselection, OBfareClass);

		// If it's a return trip, select fare for inbound flight as well
		if (!IBFareselection.isEmpty()) {
			selectFare(IBFareselection, IBfareClass);
		}
	}

	private void selectFare(List<WebElement> flightResults, String fareClass) {
		int flightCount = flightResults.size();
		boolean fareFound = false;

		for (int i = 0; i < flightCount && !fareFound; i++) {
			WebElement fare = flightResults.get(i);
			String fareClassAttr = fare.getAttribute("class");
			String[] cabin = fareClassAttr.split(" ");

			if (cabin[0].equalsIgnoreCase(fareClass)) {
				fare.click();
				fareFound = true;
				return;
			}

		}

		if (!fareFound) {
			//logger.error("Fare class not found: " + fareClass);
		}
	}

	public void FlightContiune() {
		flightcontinue.click();
	}
}
