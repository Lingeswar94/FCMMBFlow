package MMBChangeFlightTC;


import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import MMBChangeFlightPage.MMBDateChange;
import UtilityFunction.Constant;
import UtilityFunction.ExcelData;
import UtilityFunction.GeneralFunction;


public class MMBChangeDateSelection extends GeneralFunction {
	ExcelData excelData = new ExcelData();
	Logger logger=Logger.getLogger(MMBChangeDateSelection.class);
	@Test
	public void ChangeDateSelectionmethod() {
		try {
			logger.info("Application moved to Changedate Selection page ");
			MMBDateChange.getmmbdatechange().getsegmentselection(Constant.Trip,
					Constant.OBSegmentMonth,
					Constant.OBSegmentDate,
					Constant.OBSegmentYear,
					Constant.IBSegmentMonth,
					Constant.IBSegmentDate,
					Constant.IBSegmentYear);
			logger.info("Given Change date Scenario  ");
		} catch (Exception e) {
			logger.error(e.getMessage());
			logger.error("Flight(s) do not operate on the date you have searched.");
		}
		try {
			MMBDateChange.getmmbdatechange().btnContinue();
		} catch (Exception e) {
			logger.error(e.getMessage());
			logger.error("Flight(s) do not operate on the date you have searched.");
		}
	}
	
}
