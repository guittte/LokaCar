package fr.eni.lokacar.bo;

import android.os.Parcel;
import android.os.Parcelable;

public class Vehicule implements Parcelable {

    private int idVehicule;
    private String marque;
    private String modele;
    private String description;
    private String immatriculation;
    private float prix;
    private long loue;

    public Vehicule() {
    }

    public Vehicule(int idVehicule, String marque, String modele, String description, String immatriculation, float prix, long loue) {
        this.idVehicule = idVehicule;
        this.marque = marque;
        this.modele = modele;
        this.description = description;
        this.immatriculation = immatriculation;
        this.prix = prix;
        this.loue = loue;
    }

    protected Vehicule(Parcel in) {
        idVehicule = in.readInt();
        marque = in.readString();
        modele = in.readString();
        description = in.readString();
        immatriculation = in.readString();
        prix = in.readFloat();
        loue = in.readLong();
    }

    public static final Creator<Vehicule> CREATOR = new Creator<Vehicule>() {
        @Override
        public Vehicule createFromParcel(Parcel in) {
            return new Vehicule(in);
        }

        @Override
        public Vehicule[] newArray(int size) {
            return new Vehicule[size];
        }
    };

    public int getIdVehicule() {
        return idVehicule;
    }

    public void setIdVehicule(int idVehicule) {
        this.idVehicule = idVehicule;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public long getLoue() {
        return loue;
    }

    public void setLoue(long loue) {
        this.loue = loue;
    }

    @Override
    public String toString() {
        return "Vehicule{" +
                "idVehicule=" + idVehicule +
                ", marque='" + marque + '\'' +
                ", modele='" + modele + '\'' +
                ", description='" + description + '\'' +
                ", immatriculation='" + immatriculation + '\'' +
                ", prix=" + prix +
                ", loue=" + loue + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(idVehicule);
        parcel.writeString(marque);
        parcel.writeString(modele);
        parcel.writeString(description);
        parcel.writeString(immatriculation);
        parcel.writeFloat(prix);
        parcel.writeLong(loue);
    }
}