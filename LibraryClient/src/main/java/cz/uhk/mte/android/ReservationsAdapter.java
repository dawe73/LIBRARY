package cz.uhk.mte.android;


import java.text.MessageFormat;
import java.util.ArrayList;

import cz.uhk.mte.entity.ReservationAndroid;
import cz.uhk.mte.global.Helpers;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ReservationsAdapter extends ArrayAdapter<ReservationAndroid> {

	public ReservationsAdapter(Context context, ArrayList<ReservationAndroid> objects) {
		super(context, 0, 0, objects);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		ReservationAndroid dataObject = getItem(position);

		if(convertView == null) {
			convertView = View.inflate(getContext(), R.layout.layout_reservation_listing_item, null);
		}
		
		if(dataObject != null) {
			TextView tvReservationDate = (TextView)convertView.findViewById(R.id.tvReservationItemDate);
			TextView tvBookTitle = (TextView)convertView.findViewById(R.id.tvReservationItemBookTitle);
			TextView tvNameEmail = (TextView) convertView.findViewById(R.id.tvReservationItemNameMail);
			
			tvBookTitle.setText(dataObject.getBookTitle());
			tvReservationDate.setText(MessageFormat.format("Platnost do: {0}", Helpers.GetHumanFriendlyDate(dataObject.getDateTo(), true)));
			tvNameEmail.setText(MessageFormat.format("{0} {1} [ {2} ]", dataObject.getName(), dataObject.getSurname(), dataObject.getEmail()));
		}

		return convertView;
	}
}
