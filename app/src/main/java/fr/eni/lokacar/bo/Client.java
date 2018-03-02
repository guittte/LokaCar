package fr.eni.lokacar.bo;

import android.os.Parcel;
import android.os.Parcelable;

public class Client implements Parcelable {

    private int idClient;
    private String nomClient;
    private String prenomClient;
    private String adresseClient;
    private int codePostalClient;
    private String villeClient;
    private int telephoneClient;
    private String emailClient;

    public Client() {
    }

    public Client(int idClient, String nomClient, String prenomClient, String adresseClient, int codePostalClient, String villeClient, int telephoneClient, String emailClient) {
        this.idClient = idClient;
        this.nomClient = nomClient;
        this.prenomClient = prenomClient;
        this.adresseClient = adresseClient;
        this.codePostalClient = codePostalClient;
        this.villeClient = villeClient;
        this.telephoneClient = telephoneClient;
        this.emailClient = emailClient;
    }

    protected Client(Parcel in) {
        idClient = in.readInt();
        nomClient = in.readString();
        prenomClient = in.readString();
        adresseClient = in.readString();
        codePostalClient = in.readInt();
        villeClient = in.readString();
        telephoneClient = in.readInt();
        emailClient = in.readString();
    }

    public static final Creator<Client> CREATOR = new Creator<Client>() {
        @Override
        public Client createFromParcel(Parcel in) {
            return new Client(in);
        }

        @Override
        public Client[] newArray(int size) {
            return new Client[size];
        }
    };

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getPrenomClient() {
        return prenomClient;
    }

    public void setPrenomClient(String prenomClient) {
        this.prenomClient = prenomClient;
    }

    public String getAdresseClient() {
        return adresseClient;
    }

    public void setAdresseClient(String adresseClient) {
        this.adresseClient = adresseClient;
    }

    public int getCodePostalClient() {
        return codePostalClient;
    }

    public void setCodePostalClient(int codePostalClient) {
        this.codePostalClient = codePostalClient;
    }

    public String getVilleClient() {
        return villeClient;
    }

    public void setVilleClient(String villeClient) {
        this.villeClient = villeClient;
    }

    public int getTelephoneClient() {
        return telephoneClient;
    }

    public void setTelephoneClient(int telephoneClient) {
        this.telephoneClient = telephoneClient;
    }

    public String getEmailClient() {
        return emailClient;
    }

    public void setEmailClient(String emailClient) {
        this.emailClient = emailClient;
    }

    @Override
    public String toString() {
        return "Client{" +
                "idClient=" + idClient +
                ", nomClient='" + nomClient + '\'' +
                ", prenomClient='" + prenomClient + '\'' +
                ", adresseClient='" + adresseClient + '\'' +
                ", codePostalClient=" + codePostalClient +
                ", villeClient='" + villeClient + '\'' +
                ", telephoneClient=" + telephoneClient +
                ", emailClient='" + emailClient + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(idClient);
        parcel.writeString(nomClient);
        parcel.writeString(prenomClient);
        parcel.writeString(adresseClient);
        parcel.writeInt(codePostalClient);
        parcel.writeString(villeClient);
        parcel.writeInt(telephoneClient);
        parcel.writeString(emailClient);
    }
}