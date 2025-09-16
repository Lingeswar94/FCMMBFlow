package MMBChangeFlightPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MMBItinerary {

	private static MMBItinerary mmbItinerary;
	
	private MMBItinerary() {
		
	}

	public static MMBItinerary getMmbItinerary() {
		if(mmbItinerary==null) {
			mmbItinerary=new MMBItinerary();
		}
		return mmbItinerary;
	}
	
	@FindBy(xpath = "//input[@id='bodycontent_chkConfirm']")
	private  WebElement checkbox;

	@FindBy(xpath = "//input[@id='bodycontent_btnConfirm']")
	private  WebElement confirmbutton;

	public void getcheckbox() {

		checkbox.click();
	}

	public void getconfirmbutton() {
		confirmbutton.click();
	}
	
}
