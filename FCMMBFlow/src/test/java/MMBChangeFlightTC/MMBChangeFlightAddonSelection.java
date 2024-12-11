package MMBChangeFlightTC;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import MMBChangeFlightPage.MMBChangeFlightAddon;
import UtilityFunction.GeneralFunction;

public class MMBChangeFlightAddonSelection extends GeneralFunction {

	@Test
	public void ChangeAddonpage() {

		WebDriverWait wait = new WebDriverWait(GeneralFunction.getDriver(), Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(MMBChangeFlightAddon.getMmbChangeFlightAddon().btnContinue));
		// logger.info("Application moved to MMBChangeFlight Addon method ");
		try {
			MMBChangeFlightAddon.getMmbChangeFlightAddon().getcontine();
			// logger.info("Booking without Addon for MMB Changeflight");
		} catch (Exception e) {
			// logger.error(e.getMessage());
		}
	}
}
