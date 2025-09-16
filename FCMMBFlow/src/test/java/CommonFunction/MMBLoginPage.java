package CommonFunction;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	private List<WebElement> bookingactionitems;

	@FindBy(xpath = "//input[@id='txtPNR']")
	private WebElement bookingPNR;

	@FindBy(xpath = "//input[@id='txtFirstName']")
	private WebElement FirstName;

	@FindBy(xpath = "//input[@id='txtLastName']")
	private WebElement LastName;

	@FindBy(xpath = "//input[@id='btnRetreiveDetails']")
	private WebElement RetreiveDetails;

	@FindBy(xpath = "//input ")
	private List<WebElement> BookingActionsmethod;
	// *[@id="bodycontent_btnChangeFlight"]
	@FindBy(xpath = "//div[@class='content noPad']/div/table/tbody/tr/td")
	private List<WebElement> Paxcount;

	public void AddonSelection() {
		WebDriverWait wait = new WebDriverWait(GeneralFunction.getDriver(), Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(Addonelement));
		Addonelement.click();
	}

	@FindBy(xpath = "//*[@id=\"bodycontent_btnAddOnSeats\"]")
	public WebElement Addonelement;

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

	public void BookingActions(String BookingActions) {
		try {
			// Avoid index out-of-bound by using < instead of <=
			int size = bookingactionitems.size();
			for (int i = 0; i < size; i++) {
				String AEBookingname = bookingactionitems.get(i).getAttribute("value");
				String[] method = AEBookingname.split(" ");
				if (method[0].equalsIgnoreCase(BookingActions)) {
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

	public void getMMBAddonmethod(String BookingActions) {

		int size = BookingActionsmethod.size();
		for (int i = 0; i < size; i++) {
			String method = BookingActionsmethod.get(i).getAttribute("value");
			String[] ma = method.split(" ");
			if (ma[1].equalsIgnoreCase(BookingActions)) {
				BookingActionsmethod.get(i).click();
				break;
			}
		}
	}

	public void getPaxcount() {
		int ADTcount = 0; // Store Adult count
		int Chcount = 0;
		String Paxnum = GeneralFunction.getDriver().findElement(By.xpath("//td[@class='tab-05']")).getText();
		String PaxType = GeneralFunction.getDriver().findElement(By.xpath("//td[@class='tab-1']")).getText();
		int ADT = 0;
		int Ch = 0;
		int size = Paxcount.size();
		for (int i = 0; i < size; i++) {
			if (PaxType.equalsIgnoreCase("Adult")) {
				ADT++;
			} else if (PaxType.equalsIgnoreCase("Child")) {
				Ch++;
			}
		}
		ADTcount = ADT;
		Chcount = Ch;
		System.out.println("Number of Adults: " + ADTcount);
		System.out.println("Number of Children: " + Chcount);
	}

}
