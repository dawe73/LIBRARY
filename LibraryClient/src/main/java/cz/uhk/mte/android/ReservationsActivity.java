package cz.uhk.mte.android;

import java.util.ArrayList;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Background;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.UiThread;
import com.googlecode.androidannotations.annotations.ViewById;

import cz.uhk.mte.entity.ReservationAndroid;
import cz.uhk.mte.global.Globals;
import cz.uhk.mte.service.ReservationService;

import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.view.Menu;
import android.widget.ListView;

@EActivity(R.layout.activity_reservations)
public class ReservationsActivity extends FragmentActivity {

	public static final int LOADER_ID = 1;
	private ProgressDialog wait; 
	private ReservationService service;
	
	@ViewById(R.id.lvReservations)
	ListView lvReservations;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Globals.CURRENT_ACTIVITY = this;
		service = new ReservationService();
	}
	
 

	@AfterViews
	void init(){
		loadBindData();
	}
	
	@Background
	void loadBindData(){
		showWait("Naèítání rezervací");
		bindData(loadData());
		hideWait();
	}
	
	private ArrayList<ReservationAndroid> loadData(){
		
		return service.GetMyReservations();
	}
	
	@UiThread
	void bindData(ArrayList<ReservationAndroid> data){
		
		ReservationsAdapter reservationsAdapter = new ReservationsAdapter(ReservationsActivity.this, data); 
		
		lvReservations.setAdapter(reservationsAdapter);
	}

	@UiThread
	void showWait(String message){
		wait = ProgressDialog.show(this, message, "Èekejte prosím...");
	}
	
	@UiThread
	void hideWait() {
		if (wait != null) {
			wait.dismiss();
		}
	}
}
