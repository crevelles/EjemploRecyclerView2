package com.example.cristobal.ejemplorecyclerview;

import android.os.Parcel;
import android.os.Parcelable;

/**
 *
 *
 */

public class Item implements Parcelable {

    private String textoSuperior;
    private String textoInferior;
    private int idImagen;

    public Item(int idImagen,String textoSuperior, String textoInferior) {
        this.textoSuperior = textoSuperior;
        this.textoInferior = textoInferior;
        this.idImagen = idImagen;
    }


    public String getTextoSuperior() {
        return textoSuperior;
    }

    public String getTextoInferior() {
        return textoInferior;
    }

    public int getIdImagen() {
        return idImagen;
    }

    protected Item(Parcel in) {
        textoSuperior = in.readString();
        textoInferior = in.readString();
        idImagen = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(textoSuperior);
        dest.writeString(textoInferior);
        dest.writeInt(idImagen);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Item> CREATOR = new Parcelable.Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };
}
