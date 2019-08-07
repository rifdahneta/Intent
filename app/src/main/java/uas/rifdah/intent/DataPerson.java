package uas.rifdah.intent;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

public class DataPerson implements Parcelable {
    String nama;
    Integer umur;
    String alamat;
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Integer getUmur() {
        return umur;
    }

    public void setUmur(Integer umur) {
        this.umur = umur;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }


    public DataPerson(String nama, Integer umur, String alamat) {
        this.nama = nama;
        this.umur = umur;
        this.alamat = alamat;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nama);
        dest.writeValue(this.umur);
        dest.writeString(this.alamat);
    }

    protected DataPerson(Parcel in) {
        this.nama = in.readString();
        this.umur = (Integer) in.readValue(Integer.class.getClassLoader());
        this.alamat = in.readString();
    }

    public static final Parcelable.Creator<DataPerson> CREATOR = new Parcelable.Creator<DataPerson>() {
        @Override
        public DataPerson createFromParcel(Parcel source) {
            return new DataPerson(source);
        }

        @Override
        public DataPerson[] newArray(int size) {
            return new DataPerson[size];
        }
    };
}
