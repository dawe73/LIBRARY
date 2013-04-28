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
import android.app.ActivityGroup;
import android.app.ProgressDialog;
import android.content.Intent;
import android.test.UiThreadTest;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

@EActivity(R.layout.activity_book_detail)
public class BookDetailActivity extends Activity {
	
	private BookAndroid book;
	private ProgressDialog wait;
	
	@ViewById(R.id.tvDetailTitleFill)
	TextView tvTitle;
	
	@ViewById(R.id.tvDetailCategoryTitleFill)
	TextView tvCategory;
	
	@ViewById(R.id.tvDetailMainAuthorsFill)
	TextView tvAuthors;
	
	@ViewById(R.id.tvDetailKeywordsFill)
	TextView tvKeywords;
	
	@ViewById(R.id.tvDetailIsbnFill)
	TextView tvIsbn;
	
	@ViewById(R.id.tvDetailPageCountFill)
	TextView tvPageCount;
	
	@ViewById(R.id.tvDetailPrinterInfoFill)
	TextView tvPrinter;
	
	@ViewById(R.id.tvDetailReleaseFill)
	TextView tvRelease;
	
	@ViewById(R.id.tvDetailCountFill)
	TextView tvCount;

	
	@Click(R.id.btnReserve)
	void btnReservationClick(){
		Intent intent = new Intent(BookDetailActivity.this, ReservationInsertActivity_.class);
		Bundle b = new Bundle();
		b.putParcelable(Globals.PACKAGE_BOOK, new DummyLibraryParcelable(book.getID()));
		intent.putExtras(b);
		startActivity(intent);
		finish();
	}
	
	@Click(R.id.btnChangeB)
	void btnChangeBClick(){
		finish();
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@AfterViews
	void init(){

		getBookSetFields();
	}
	
	@UiThread
	void setFields(BookAndroid b){
		
		if (b != null) {
			tvTitle.setText(b.getTitle());
			tvCategory.setText(b.getCategoryTitle());
			tvAuthors.setText(b.getMainAuthors());
			tvKeywords.setText(b.getKeywords());
			tvIsbn.setText(b.getISBN());
			tvPageCount.setText(Integer.toString(b.getPageCount()));
			tvPrinter.setText(b.getPrinterInfo());
			tvRelease.setText(Helpers.GetHumanFriendlyDate(b.getRelease(), false));
			tvCount.setText(MessageFormat.format("{0}/{1}", b.getAvailableCount(), b.getCount()));
		}
	}
	
	@Background
	void getBookSetFields() {
		showWait();
		book = Helpers.GetBookFromParcelable(getIntent());
		hideWait();
		
		setFields(book);
	}
	
	@UiThread
	void showWait(){
		wait = ProgressDialog.show(this, "Naèítání dat", "Èekejte prosím...");
	}
	
	@UiThread
	void hideWait() {
		if (wait != null) {
			wait.dismiss();
		}
	}
}