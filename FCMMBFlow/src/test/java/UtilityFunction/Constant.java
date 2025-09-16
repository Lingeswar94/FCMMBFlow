package UtilityFunction;

public class Constant {

	public static String Browserproperty = System.getProperty("Browserproperty");
	public static String BookingPNR = System.getProperty("BookingPNR");
	public static String Firstname = System.getProperty("Firstname");
	public static String Lastname = System.getProperty("Lastname");
	public static String Bookingmethod = System.getProperty("Bookingmethod");
	public static String Trip = System.getProperty("Trip");
	public static String OBSegmentMonth = System.getProperty("OBSegmentMonth");
	public static String OBSegmentDate = System.getProperty("OBSegmentDate");
	public static String OBSegmentYear = System.getProperty("OBSegmentYear");
	public static String IBSegmentMonth = System.getProperty("IBSegmentMonth");
	public static String IBSegmentDate = System.getProperty("IBSegmentDate");
	public static String IBSegmentYear = System.getProperty("IBSegmentYear");
	public static String OBSegmentCabinFare = System.getProperty("OBSegmentCabinFare");
	public static String IBSegmentCabinFare = System.getProperty("IBSegmentCabinFare");
	public static String suiteXmlFile = "src/test/resources/XmlFiles/" + System.getProperty("suiteXmlFile");
	public static String Addonmethod = System.getProperty("Addonmethod");
	public static String ADTCount = System.getProperty("ADTCount");
	public static String ChCount = System.getProperty("ChCount");
	public static String OBMainSeat=System.getProperty("OBMainSeat");
	public static String OBAdultSeat=System.getProperty("OBAdultSeat");
	public static String OBChildSeat=System.getProperty("OBChildSeat");
	public static String IBMainSeat=System.getProperty("IBMainSeat");
	public static String IBAdultSeat=System.getProperty("IBAdultSeat");
	public static String IBChildSeat=System.getProperty("IBChildSeat");
	public static boolean isReturnseat=Boolean.parseBoolean(System.getProperty("isReturnseat"));
	
}
