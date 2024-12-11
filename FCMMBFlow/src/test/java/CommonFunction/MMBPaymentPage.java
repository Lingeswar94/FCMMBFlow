package CommonFunction;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;



public class MMBPaymentPage {

	
	private static MMBPaymentPage mmbPaymentPage;

	private MMBPaymentPage() {

	}

	public static MMBPaymentPage getmmbPaymentPage() {
		if (mmbPaymentPage == null) {
			mmbPaymentPage = new MMBPaymentPage();
		}
		return mmbPaymentPage;
	}

	@FindBy(xpath = "//label[@for='bodycontent_ucBookingPayment_rdolstPaymentMethods_0']")
	public WebElement CCpayment;

	@FindBy(xpath = "//*[@id='bodycontent_ucBookingPayment_ucCardDetails_txtFName']")
	public WebElement Paymentcardname;

	@FindBy(xpath = "//select[@id='bodycontent_ucBookingPayment_ucCardDetails_ddlYear']")
	private WebElement Expirydate;

	@FindBy(xpath = "//*[@id='bodycontent_ucBookingPayment_ucCardDetails_txtCardNumber']")
	private WebElement Cardno;

	@FindBy(xpath = "//input[@id='bodycontent_ucBookingPayment_ucCardDetails_txtCVVCode']")
	private WebElement CVV;

	@FindBy(xpath = "//input[@id='bodycontent_ucBookingPayment_ucBillingDetails_txtFName']")
	private WebElement BillingName;

	@FindBy(xpath = "//input[@id='bodycontent_ucBookingPayment_ucBillingDetails_txtLName']")
	private WebElement billinglastname;

	@FindBy(xpath = "//input[@id='bodycontent_ucBookingPayment_ucBillingDetails_txtAdd1']")
	private WebElement Address;

	@FindBy(xpath = "//input[@id='bodycontent_ucBookingPayment_ucBillingDetails_txtCity']")
	private WebElement city;

	@FindBy(id = "bodycontent_ucBookingPayment_ucBillingDetails_ddlCountry")
	private WebElement country;
	@FindBy(xpath = "//input[@id='bodycontent_ucBookingPayment_ucBillingDetails_txtPostCode']")
	private WebElement Postcode;

	@FindBy(xpath = "//input[@id='bodycontent_ucBookingPayment_ucBillingDetails_txtMobileNo']")
	private WebElement Contact;

	@FindBy(xpath = "//input[@id='bodycontent_ucBookingPayment_btnMakePayment']")
	private WebElement MakePayment;
	
	@FindBy(xpath="//span[@id='bodycontent_lblErrorMsgs']")
	public WebElement Successmessage;

	public void SelectPayment() {
		CCpayment.click();
	}

	public void carddetails(String CCcardname, String Cardnumber, String CCVno) {
		
		Paymentcardname.sendKeys(CCcardname);
		Cardno.sendKeys(Cardnumber);
		CVV.sendKeys(CCVno);
		
	}

	public void Expirationyear(String expyear) {
		Select select = new Select(Expirydate);
		select.selectByValue(expyear);
	}

	public void Billingdataclear() {
		BillingName.clear();
		billinglastname.clear();
	}

	public void Billingdetails(String Billingname, String billlastname, String Addressdetails, String citydetails,
			String Post, String contactno) {

		BillingName.sendKeys(Billingname);
		billinglastname.sendKeys(billlastname);
		Address.sendKeys(Addressdetails);
		city.sendKeys(citydetails);
		Postcode.sendKeys(Post);
		Contact.sendKeys(contactno);
	}

	public void selectCountry(String selectedCountry) {
		Select select = new Select(country);
		select.selectByVisibleText(selectedCountry);
	}

	public void paymentcontinue() {
		MakePayment.click();
	}
	
	public void getsuccessmessage(String success) {
	 success =Successmessage.getText();
	}
}
