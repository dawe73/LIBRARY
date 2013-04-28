package cz.uhk.mte.android;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class DummyLibraryParcelable implements Parcelable {

	private int dataObjectID;
	
	public int getDataObjectID() {
		return dataObjectID;
	}

	public void setDataObjectID(int dataObjectID) {
		this.dataObjectID = dataObjectID;
	}
	
	public DummyLibraryParcelable(int dataObjectID){
		this.dataObjectID = dataObjectID;
		Log.d("dummy", "content of dummy parcel " + Integer.toString(dataObjectID));
	}
	
	
	public DummyLibraryParcelable(Parcel parcel){
		this.dataObjectID = parcel.readInt();
		Log.d("dummy", "content of new parcel " + Integer.toString(parcel.readInt()));
	}
	
	@Override
	public int describeContents() {

		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int arg1) {
		
		parcel.writeInt(dataObjectID);
	}

	public static final Parcelable.Creator<DummyLibraryParcelable> CREATOR = new Parcelable.Creator<DummyLibraryParcelable>() {
        public DummyLibraryParcelable createFromParcel(Parcel data) {
            return new DummyLibraryParcelable(data);
        }

        public DummyLibraryParcelable[] newArray(int size) {
            return new DummyLibraryParcelable[size];
        }
    };
}
