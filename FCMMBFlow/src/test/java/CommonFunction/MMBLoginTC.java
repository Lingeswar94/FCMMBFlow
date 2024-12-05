package CommonFunction;

import org.testng.annotations.Test;

import UtilityFunction.ExcelData;
import UtilityFunction.GeneralFunction;

public class MMBLoginTC extends GeneralFunction {

	ExcelData excelData = new ExcelData();

	@Test
	public void MMBLoginmethod() {

		try {

			MMBLoginPage.getMmbLoginPage().BookingPNR(excelData.getMMBData("Login", 1, 1));
			MMBLoginPage.getMmbLoginPage().Firstname(excelData.getMMBData("Login", 2, 1));
			MMBLoginPage.getMmbLoginPage().Lastname(excelData.getMMBData("Login", 3, 1));
			MMBLoginPage.getMmbLoginPage().RetreiveDetailscontinue();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
