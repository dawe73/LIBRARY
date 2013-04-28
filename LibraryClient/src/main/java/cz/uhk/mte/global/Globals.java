package cz.uhk.mte.global;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.os.Parcel;


public class Globals {

	public static final ApplicationType APP_TYPE = ApplicationType.Production;
	
	public static final String PACKAGE_BOOK = "BookDetail";
	public static final String PACKAGE_RESERVATION = "ReservationDetail";
	public static final String PACKAGE_CATEGORY = "CategoryDetail";
	public static final int TOP_LEVEL_CATEGORY = 0;
	public static Activity CURRENT_ACTIVITY = null;
	public static final String SERVER_URI = "http://10.0.2.2:8080/mte/";
}
