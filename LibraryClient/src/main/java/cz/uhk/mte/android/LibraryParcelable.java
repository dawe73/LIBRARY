package cz.uhk.mte.android;

import cz.uhk.mte.entity.ILibraryEntity;
import android.os.Parcel;
import android.os.Parcelable;

public class LibraryParcelable<T extends ILibraryEntity> implements Parcelable  {

	private T dataObject;
	

	public T getDataObject() {
		return dataObject;
	}

	public void setDataObject(T dataObject) {
		this.dataObject = dataObject;
	}
	

	
	public LibraryParcelable(T data){
		this.dataObject = data;
	}
	
	public LibraryParcelable(Parcel parcel){
		//this.dataObject = parcel.readValue(loader)
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int arg1) {
		
		parcel.writeValue(dataObject);
	}
	
	public static final Parcelable.Creator<LibraryParcelable> CREATOR = new Parcelable.Creator<LibraryParcelable>() {
        public LibraryParcelable createFromParcel(Parcel data) {
            return new LibraryParcelable(data);
        }

        public LibraryParcelable[] newArray(int size) {
            return new LibraryParcelable[size];
        }
    };

}
