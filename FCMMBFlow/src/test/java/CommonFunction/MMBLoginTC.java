package CommonFunction;

import org.testng.annotations.Test;

import UtilityFunction.Constant;
import UtilityFunction.ExcelData;
import UtilityFunction.GeneralFunction;

public class MMBLoginTC extends GeneralFunction {

	ExcelData excelData = new ExcelData();

	@Test
	public void MMBLoginmethod() {

		try {
	
			MMBLoginPage.getMmbLoginPage().BookingPNR(Constant.BookingPNR);
			MMBLoginPage.getMmbLoginPage().Firstname(Constant.Firstname);
			MMBLoginPage.getMmbLoginPage().Lastname(Constant.Lastname);
			MMBLoginPage.getMmbLoginPage().RetreiveDetailscontinue();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			MMBLoginPage.getMmbLoginPage().BookingActions(Constant.Bookingmethod);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
