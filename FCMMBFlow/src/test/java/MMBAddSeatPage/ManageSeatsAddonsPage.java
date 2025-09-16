package MMBAddSeatPage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import UtilityFunction.GeneralFunction;

public class ManageSeatsAddonsPage {

	private static ManageSeatsAddonsPage manageSeatsAddonsPage;

	private ManageSeatsAddonsPage() {

	}

	public static ManageSeatsAddonsPage getManageSeatsAddonsPage() {
		if (manageSeatsAddonsPage == null) {
			manageSeatsAddonsPage = new ManageSeatsAddonsPage();
		}
		return manageSeatsAddonsPage;
	}

	@FindBy(xpath = "//div[@id='bodycontent_divAERBookingActions']/div")
	private List<WebElement> BookingActionsmethod;

	// *[@id="divOBSeg0"]/div[5]/div[4]/ul[4]

	@FindBy(xpath = "//*[@id='divOBSeg0']/div[5]/div[4]/ul/li")
	private List<WebElement> OBSeatLayout;

	private WebElement getOBSeat(String OBSeat) {
		String obseat = "//li[@onclick='Javascript:AddSeat('" + OBSeat + "')']";
		return GeneralFunction.getDriver().findElement(By.xpath(obseat));
	}
	// *[@id="divOBSeg0"]/div[5]/div[4]/ul[4]/li[1]

	public void AddonSelection() {
		WebDriverWait wait = new WebDriverWait(GeneralFunction.getDriver(), Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(Addonelement));
		Addonelement.click();
	}

	@FindBy(xpath = "//*[@id=\"bodycontent_btnAddOnSeats\"]")
	public WebElement Addonelement;

	public WebElement name(String OBSeat) {
		String obseat = "//li[@onclick='Javascript:AddSeat('" + OBSeat + "')']";
		WebDriverWait wait = new WebDriverWait(GeneralFunction.getDriver(), Duration.ofSeconds(20));
		WebElement seatElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(obseat)));
		seatElement.click();
		return seatElement;
	}

	public void getselectmethod(String BookingActions) {

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

	private WebElement Inboundseat() {
		WebElement reseat = GeneralFunction.getDriver().findElement(By.xpath("//a[@data-toggle='collapse']"));
		reseat.click();
		return reseat;

	}

	public void SeatSelection(String ADTCount, String ChCount, String OBMainSeat, String OBAdultSeat,
			String OBChildSeat, String IBMainSeat, String IBAdultSeat, String IBChildSeat, boolean isReturnseat,
			String Trip) {

		int trip = Integer.parseInt(Trip);

		if (Trip.equals("0")) {
			OBSeatselection(OBMainSeat, OBAdultSeat, OBChildSeat, ADTCount, ChCount);
		} else {
			System.out.println("Not selected Seat for Outbound segment");
		}

		if (Trip.equals("1")) {
			Inboundseat();
			IBSeatselection(IBMainSeat, IBAdultSeat, IBChildSeat, ADTCount, ChCount);
		} else {
			System.out.println("Not selected Seat for Inbound segment");
		}

		if (Trip.equals("2")) {
			OBSeatselection(OBMainSeat, OBAdultSeat, OBChildSeat, ADTCount, ChCount);
			IBSeatselection(IBMainSeat, IBAdultSeat, IBChildSeat, ADTCount, ChCount);
		} else {
			System.out.println("Not selected Seat for both segment");
		}

	}

	public void OBSeatselection(String OBMainSeat, String OBAdultSeat, String OBChildSeat, String ADTCount,
			String ChCount) {

		int ADTCount1 = Integer.parseInt(ADTCount);
		int Ch = Integer.parseInt(ChCount);

		int Adult = ADTCount1 + 1;
		int Total = Adult + Ch;

		int currentADTseat = 0;
		int currentChseat = 0;
		for (int i = 0; i < Total; i++) {
			if (currentADTseat < Adult) {
				if (currentADTseat == 0) {

					// name(OBMainSeat);
					getOBSeat(OBMainSeat).click();
				} else {
					getOBSeat(OBAdultSeat).click();
				}
				currentADTseat++;
			} else if (currentChseat < Ch) {
				getOBSeat(OBChildSeat).click();
				currentChseat++;
			} else {
				System.out.println("Seat is not selected");
			}
		}

	}

	public void IBSeatselection(String IBMainSeat, String IBAdultSeat, String IBChildSeat, String ADTCount,
			String ChCount) {
		WebDriverWait wait = new WebDriverWait(GeneralFunction.getDriver(), Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfAllElements(OBSeatLayout));

		int ADTCount1 = Integer.parseInt(ADTCount);
		int Ch = Integer.parseInt(ChCount);

		int Adult = ADTCount1 + 1;
		int Total = Adult + Ch;

		int currentADTseat = 0;
		int currentChseat = 0;
		for (int i = 0; i < Total; i++) {
			if (currentADTseat < Adult) {
				if (currentADTseat == 0) {
					getOBSeat(IBMainSeat).click();
				} else {
					getOBSeat(IBAdultSeat).click();
				}
				currentADTseat++;
			} else if (currentChseat < Ch) {
				getOBSeat(IBChildSeat).click();
				currentChseat++;
			} else {
				System.out.println("Seat is not selected");
			}
		}

	}

//---------------------------------------------------------------------------------------------------------------------------------
	public void SeatSelection1(String ADTCount, String ChCount, String OBMainSeat, String OBAdultSeat,
			String OBChildSeat, String IBMainSeat, String IBAdultSeat, String IBChildSeat, boolean isReturnseat,
			String Trip) {

		int trip = Integer.parseInt(Trip);

// Outbound Seat Selection
		if (Trip.equals("0") || Trip.equals("2")) {
			OBSeatselection1(OBMainSeat, OBAdultSeat, OBChildSeat, ADTCount, ChCount);
		} else {
			System.out.println("Not selected Seat for Outbound segment");
		}

// Inbound Seat Selection
		if (Trip.equals("1") || Trip.equals("2")) {
			Inboundseat1(); // Expand Inbound Section
			IBSeatselection1(IBMainSeat, IBAdultSeat, IBChildSeat, ADTCount, ChCount);
		} else {
			System.out.println("Not selected Seat for Inbound segment");
		}
	}

	public void OBSeatselection1(String OBMainSeat, String OBAdultSeat, String OBChildSeat, String ADTCount,
			String ChCount) {

// Validate and parse inputs
		int adultCount = ADTCount != null && !ADTCount.trim().isEmpty() ? Integer.parseInt(ADTCount) : 0;
		int childCount = ChCount != null && !ChCount.trim().isEmpty() ? Integer.parseInt(ChCount) : 0;

		System.out.println("Adult Count: " + adultCount);
		System.out.println("Child Count: " + childCount);

// Select Main Seat
		selectSeat1(OBMainSeat);

// Select Adult Seats
		for (int i = 0; i < adultCount; i++) {
			selectSeat1(OBAdultSeat);
		}

// Select Child Seats
		for (int i = 0; i < childCount; i++) {
			selectSeat1(OBChildSeat);
		}
	}

	public void IBSeatselection1(String IBMainSeat, String IBAdultSeat, String IBChildSeat, String ADTCount,
			String ChCount) {

		int adultCount = Integer.parseInt(ADTCount);
		int childCount = Integer.parseInt(ChCount);

// Select Main Seat
		selectSeat1(IBMainSeat);

// Select Adult Seats
		for (int i = 0; i < adultCount; i++) {
			selectSeat1(IBAdultSeat);
		}

// Select Child Seats
		for (int i = 0; i < childCount; i++) {
			selectSeat1(IBChildSeat);
		}
	}

	private void selectSeat1(String seatCode) {
		try {
// Escape quotes in XPath
			// "//li[@onclick='Javascript:AddSeat('" + OBSeat + "')']";
			String seatXPath = "//li[@onclick='Javascript:AddSeat('" + seatCode + "')']";
			WebDriverWait wait = new WebDriverWait(GeneralFunction.getDriver(), Duration.ofSeconds(20));
			WebElement seatElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(seatXPath)));
			seatElement.click();
			System.out.println("Selected seat: " + seatCode);
		} catch (Exception e) {
			System.out.println("Failed to select seat: " + seatCode);
			e.printStackTrace();
		}
	}

	private void Inboundseat1() {
		try {
			WebElement reseat = GeneralFunction.getDriver().findElement(By.xpath("//a[@data-toggle='collapse']"));
			reseat.click();
			System.out.println("Inbound section expanded");
		} catch (Exception e) {
			System.out.println("Failed to expand Inbound section");
			e.printStackTrace();
		}
	}

}
