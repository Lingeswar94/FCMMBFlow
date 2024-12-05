package CommonFunction;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import UtilityFunction.GeneralFunction;

public class MMBLoginPage {

	private static MMBLoginPage mmbLoginPage;

	private MMBLoginPage() {

	}

	public static MMBLoginPage getMmbLoginPage() {
		if (mmbLoginPage == null) {
			mmbLoginPage = new MMBLoginPage();
		}

		return mmbLoginPage;
	}

	@FindBy(xpath = "//div[@id='bodycontent_divAERBookingActions']/input")
	private  List<WebElement> bookingactionitems;

	@FindBy(xpath = "//input[@id='txtPNR']")
	private WebElement bookingPNR;

	@FindBy(xpath = "//input[@id='txtFirstName']")
	private WebElement FirstName;

	@FindBy(xpath = "//input[@id='txtLastName']")
	private WebElement LastName;

	@FindBy(xpath = "//input[@id='btnRetreiveDetails']")
	private WebElement RetreiveDetails;

	public void BookingPNR(String PNR) {
		bookingPNR.sendKeys(PNR);
	}

	public void Firstname(String firstname) {
		FirstName.sendKeys(firstname);
	}

	public void Lastname(String lastname) {
		LastName.sendKeys(lastname);
	}

	public void RetreiveDetailscontinue() {
		RetreiveDetails.click();
	}
	
	public void BookingActions(String Flowname) {
		try {
			// Avoid index out-of-bound by using < instead of <=
			int size = bookingactionitems.size();
			for (int i = 0; i < size; i++) {
				String AEBookingname = bookingactionitems.get(i).getAttribute("value");
				if (Flowname.equalsIgnoreCase(AEBookingname)) {
					bookingactionitems.get(i).click();
					// After clicking, exit the loop
					return;
				}
			}
			// Call the method to handle the flow after clicking
			// name( index, Month, date);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
