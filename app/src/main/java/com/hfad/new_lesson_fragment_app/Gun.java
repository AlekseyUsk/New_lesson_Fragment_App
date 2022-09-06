package com.hfad.new_lesson_fragment_app;

import android.os.Parcel;
import android.os.Parcelable;

public class Gun implements Parcelable {
    private int index;

    public Gun(int i) {
        index = i;
    }

    protected Gun(Parcel in) {
        index = in.readInt();
    }

    public Gun(String пистолет, int pistol) {
    }

    public static Creator<Gun> getCREATOR() {
        return CREATOR;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(index);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Gun> CREATOR = new Creator<Gun>() {
        @Override
        public Gun createFromParcel(Parcel in) {
            return new Gun(in);
        }

        @Override
        public Gun[] newArray(int size) {
            return new Gun[size];
        }
    };

    public void setIndex(int index) {
        index = index;
    }

    public int getIndex() {
        return index;
    }
}
