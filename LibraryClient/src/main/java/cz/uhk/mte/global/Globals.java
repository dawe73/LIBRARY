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
	public static final int TOP_LEVEL_CATEGORY = 1;
	public static Activity CURRENT_ACTIVITY = null;
	public static final String SERVER_URI = "http://192.168.1.179:8080/mte/";
	public static final String ERROR_MSG = "V aplikaci nastala chyba.";
}
