package com.example.nounou.tp1;

import android.os.Parcel;
import android.os.Parcelable;


public class ParcelableObject implements Parcelable {


    private String name;
    private String surname;
    private String dateOfBirth;
    private String town;


    public ParcelableObject(String name, String dateOfBirth, String surname, String town) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.surname = surname;
        this.town = town;
    }



    public ParcelableObject(Parcel in){
        String[] data = new String[4];

        in.readStringArray(data);
        this.name = data[0];
        this.surname = data[1];
        this.dateOfBirth = data[2];
        this.town = data[3];
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[] {this.name,
                this.surname,
                this.dateOfBirth,this.town});
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public ParcelableObject createFromParcel(Parcel in) {
            return new ParcelableObject(in);
        }

        public ParcelableObject[] newArray(int size) {
            return new ParcelableObject[size];
        }
    };
}
