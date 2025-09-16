package MMBAddSeatTC;

import org.testng.annotations.Test;

import CommonFunction.MMBLoginPage;
import MMBAddSeatPage.ManageSeatsAddonsPage;
import UtilityFunction.Constant;
import UtilityFunction.GeneralFunction;

public class MMBSelectAddonSelection extends GeneralFunction {

	
	
	
	@Test
	public void selectseat() {
		try {
			MMBLoginPage.getMmbLoginPage().AddonSelection();
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		
		try {
			ManageSeatsAddonsPage.getManageSeatsAddonsPage().SeatSelection(Constant.ADTCount, Constant.ChCount, Constant.OBMainSeat, Constant.OBAdultSeat, Constant.OBChildSeat, Constant.IBMainSeat, Constant.IBAdultSeat, Constant.IBChildSeat, Constant.isReturnseat, Constant.Trip);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
		
	}
}
