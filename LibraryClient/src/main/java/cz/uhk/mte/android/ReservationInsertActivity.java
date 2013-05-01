package cz.uhk.mte.android;

import java.text.MessageFormat;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Background;
import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.UiThread;
import com.googlecode.androidannotations.annotations.ViewById;

import cz.uhk.mte.entity.BookAndroid;
import cz.uhk.mte.global.Globals;
import cz.uhk.mte.global.Helpers;
import cz.uhk.mte.service.BookService;
import cz.uhk.mte.service.ReservationService;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

@EActivity(R.layout.activity_reservation_insert)
public class ReservationInsertActivity extends Activity {

	private BookAndroid book;
	private ProgressDialog wait;
	
	@ViewById(R.id.txtReservationInsertName)
	EditText txtName;
	
	@ViewById(R.id.txtReservationInsertSurname)
	EditText txtSurname;
	
	@ViewById(R.id.txtReservationInsertEmail)
	EditText txtEmail;
	
	@ViewById(R.id.btnInsert)
	Button btnReserve;
	
	@ViewById(R.id.tvReservationInsertBookTitle)
	TextView tvBookTitle;
	
	@ViewById(R.id.tvReservationInsertError)
	TextView tvError;
	
	@ViewById(R.id.tvReservationInsertNameValid)
	TextView tvNameValid;
	
	@ViewById(R.id.tvReservationInsertSurnameValid)
	TextView tvSurnameValid;
	
	@ViewById(R.id.tvReservationInsertEmailValid)
	TextView tvEmailValid;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	
	}

	@AfterViews
	void init(){
		clearValidFields();
		getBookSetFields();
	}

	@Click(R.id.btnInsert)
	void btnReserveClick(){ 
		
		processReservation();
	}
	
	private boolean insertReservation() {
		clearValidFields();
		
		if (validateFields()) {
			ReservationService reservationService = new ReservationService();
			
			int bookID = book.getID();
			String bookTitle = book.getTitle();
			String name = txtName.getText().toString();
			String surname = txtSurname.getText().toString();
			String email = txtEmail.getText().toString();
			
			return reservationService.InsertReservation(bookID, bookTitle, name, surname, email);
		}
		return false;
	}
	
	
	private boolean validateFields(){
		
		boolean email = false;
		boolean name = false;
		boolean surname = false;
		
		if (txtEmail.getText().toString().equals("")){
			email = true;
		}
		if (txtName.getText().toString().equals("")) {
			name = true;
		}
		if (txtSurname.getText().toString().equals("")) {
			surname = true;
		}
		
		if (!txtEmail.getText().toString().matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")) {
			email = true;
		}
		
		if (email || name || surname) {
			setValidFields(name, surname, email);
			return false;
		}
		
		return true;
	}
	
	@UiThread
	void setValidFields(boolean name, boolean surname, boolean email){
		if (name) { tvNameValid.setText("*"); }
		if (surname) { tvSurnameValid.setText("*"); }
		if (email) { tvEmailValid.setText("*"); }
	}
	
	@UiThread
	void clearValidFields(){
		tvEmailValid.setText("");
		tvNameValid.setText("");
		tvSurnameValid.setText("");
	}
	
	@Background
	void processReservation(){
		showWait("Vyøizování rezervace");
		if (insertReservation()) {
			Intent intent = new Intent(ReservationInsertActivity.this, MainActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			hideWait();
			startActivity(intent);
			finish();
		}
		else {
			hideWait();
			displayErrorMessage();
		}
	}
	
	@UiThread
	void displayErrorMessage() {
		tvError.setText("Rezervace se nezdaøila.");
	}
	
	@UiThread
	void setFields(BookAndroid b){
		if (b != null) {
			tvBookTitle.setText(b.getTitle());
		}
		else {
			tvBookTitle.setText("Chyba v aplikaci");
			hideWait();
			showErrorAlert();
		}
	}
	
	@Background
	void getBookSetFields() {
		
		showWait("Naèítání dat");
		book = Helpers.GetBookFromParcelable(getIntent());
		hideWait();
		
		setFields(book);
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
	
	@UiThread
	void showErrorAlert(){
		AlertDialog ad = new AlertDialog.Builder(this).create();  
		ad.setCancelable(false); // This blocks the 'BACK' button  
		ad.setMessage(Globals.ERROR_MSG);  
		ad.setButton("OK", new DialogInterface.OnClickListener() {  
		    @Override  
		    public void onClick(DialogInterface dialog, int which) {  
		        dialog.dismiss();                      
		    }  
		});  
		ad.show(); 
	}
}
