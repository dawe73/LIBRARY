package cz.uhk.mte.android;

import java.text.MessageFormat;
import java.util.ArrayList;

import cz.uhk.mte.global.Globals;
import cz.uhk.mte.entity.BookAndroid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.provider.Settings.Global;
import android.sax.StartElementListener;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

public class BooksAdapter extends ArrayAdapter<BookAndroid>  {

	private Context ctx;
	
	public BooksAdapter(Context context, ArrayList<BookAndroid> objects) {
		super(context, 0, 0, objects);
		ctx = context;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		final BookAndroid dataObject = getItem(position);

		//Log.d("listView", dataObject.getTitle() + " " + Integer.toString(dataObject.getID()) + " / " + Integer.toString(position));
		
		if(convertView == null) {
			convertView = View.inflate(getContext(), R.layout.layout_book_listing_item, null);
		}
		
		if(dataObject != null) {
			
			TextView tvTitle = (TextView)convertView.findViewById(R.id.tvBookItemBookTitle);
			TextView tvBookCounts = (TextView)convertView.findViewById(R.id.tvBookItemBookCount);
			TextView tvBookAuthor = (TextView)convertView.findViewById(R.id.tvBookItemAuthor);			
			
			tvTitle.setText(dataObject.getTitle());
			tvBookCounts.setText(MessageFormat.format("{0}/{1}", dataObject.getAvailableCount(), dataObject.getCount()));
			tvBookAuthor.setText(dataObject.getMainAuthors());
			
			Button btnDetail = (Button)convertView.findViewById(R.id.btnBookItemReserve);
			
			btnDetail.setOnClickListener(new LibraryOnClickListener(ctx, ReservationInsertActivity_.class, dataObject.getID(), Globals.PACKAGE_BOOK));
			
			convertView.setOnClickListener(new LibraryOnClickListener(ctx, BookDetailActivity_.class, dataObject.getID(), Globals.PACKAGE_BOOK));
		}

		return convertView;
	}
}
