package MMBChangeFlightPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class MMBChangeFlightAddon {

	private static MMBChangeFlightAddon mmbChangeFlightAddon;

	public MMBChangeFlightAddon() {

	}

	public static MMBChangeFlightAddon getMmbChangeFlightAddon() {
		if (mmbChangeFlightAddon == null) {
			mmbChangeFlightAddon = new MMBChangeFlightAddon();
		}
		return mmbChangeFlightAddon;
	}

	@FindBy(xpath = "//input[@id='btnProceedBooking']")
	public static WebElement btnContinue;

	public void getcontine() {
		btnContinue.click();
	}
}
