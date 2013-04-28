package cz.uhk.mte.android;

import cz.uhk.mte.global.Globals;
import cz.uhk.mte.global.LibraryTabType;
import android.app.Activity;
import android.app.ActivityGroup;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class LibraryOnClickListener implements OnClickListener {

	private int dataObjectID;
	private Context ctx;
	private Class<?> cls;
	private String packageName;
	private boolean tabActivity;
	private LibraryTabType tabType = LibraryTabType.Unknown;
	
	public LibraryOnClickListener(Context context, Class<?> clss, int id, String pName){
		this(context, clss, id, pName, false, LibraryTabType.Unknown);
	}
	
	
	public LibraryOnClickListener(Context context, Class<?> clss, int id, String pName, boolean tab, LibraryTabType tt){
		dataObjectID = id;
		ctx = context;
		cls = clss;
		packageName = pName;
		tabActivity = tab;
		tabType = tt;
	}
	
	@Override
	public void onClick(View v) {
		
		if (tabActivity) {
			startTabActivity();
		}
		else {
			startNewActivity();
		}
	}
	
	private void startTabActivity(){
		ActivityGroup ag = (ActivityGroup) ctx;
		
		if (tabType == LibraryTabType.BooksTab) {
			MainActivity mainActivity = (MainActivity) ag.getParent();
			mainActivity.ChangeTab(tabType, dataObjectID);
		}
		else {
			CategoriesActivity_ categoriesActivity = (CategoriesActivity_) ag;	
			categoriesActivity.loadCategorySetFields(dataObjectID);
		}
	
	}
	
	private void startNewActivity(){
		Intent intent = new Intent(ctx, cls);
		Bundle b = new Bundle();
		b.putParcelable(packageName, new DummyLibraryParcelable(dataObjectID));
		intent.putExtras(b);
		ctx.startActivity(intent);
	}
}
