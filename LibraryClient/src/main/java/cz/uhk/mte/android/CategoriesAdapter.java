package cz.uhk.mte.android;

import java.text.MessageFormat;
import java.util.List;

import cz.uhk.mte.entity.CategoryAndroid;
import cz.uhk.mte.global.Globals;
import cz.uhk.mte.global.LibraryTabType;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;


public class CategoriesAdapter extends ArrayAdapter<CategoryAndroid> {

	private Context ctx;
	private boolean isTabActivity = true;
	
	public CategoriesAdapter(Context context, List<CategoryAndroid> objects) {
		super(context, 0, 0, objects);
		ctx = context;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		CategoryAndroid dataObject = getItem(position);

		if(convertView == null) {
			convertView = View.inflate(getContext(), R.layout.layout_category_listing_item, null);
		}
			
		if(dataObject != null) {
			TextView tvTitle = (TextView)convertView.findViewById(R.id.tvCategoryItemTitle);
			TextView tvBookCount = (TextView)convertView.findViewById(R.id.tvCategoryItemBookCount);
				
			tvTitle.setText(dataObject.getTitle());
			tvBookCount.setText(MessageFormat.format(tvBookCount.getText().toString(), dataObject.getBooksCount()));
				
			Button btnShowBooks = (Button) convertView.findViewById(R.id.btnCategoryItemBooks);
			
			btnShowBooks.setOnClickListener(new LibraryOnClickListener(ctx, BooksActivity_.class, dataObject.getID(), Globals.PACKAGE_CATEGORY, isTabActivity, LibraryTabType.BooksTab));
			convertView.setOnClickListener(new LibraryOnClickListener(ctx, CategoriesActivity_.class, dataObject.getID(), Globals.PACKAGE_CATEGORY, isTabActivity, LibraryTabType.CategoriesTab));
		}

		return convertView;
	}
}
