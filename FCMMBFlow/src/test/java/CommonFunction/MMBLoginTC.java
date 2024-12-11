package CommonFunction;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import UtilityFunction.Constant;
import UtilityFunction.ExcelData;
import UtilityFunction.GeneralFunction;

public class MMBLoginTC extends GeneralFunction {

	ExcelData excelData = new ExcelData();
	Logger logger = Logger.getLogger(MMBLoginTC.class);

	@Test
	public void MMBLoginmethod() {
		logger.info("Application Enter the MMBLogin Page");

		try {

			MMBLoginPage.getMmbLoginPage().BookingPNR(Constant.BookingPNR);
			MMBLoginPage.getMmbLoginPage().Firstname(Constant.Firstname);
			MMBLoginPage.getMmbLoginPage().Lastname(Constant.Lastname);
			MMBLoginPage.getMmbLoginPage().RetreiveDetailscontinue();
			logger.info("Application successfully login with BookingPNR :" + Constant.BookingPNR);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		try {
			MMBLoginPage.getMmbLoginPage().BookingActions(Constant.Bookingmethod);

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
}
