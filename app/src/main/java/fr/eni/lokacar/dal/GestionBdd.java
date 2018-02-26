package fr.eni.lokacar.dal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import fr.eni.lokacar.bo.Location;
import fr.eni.lokacar.contracts.AgenceContract;
import fr.eni.lokacar.contracts.BddContract;
import fr.eni.lokacar.contracts.ClientContract;
import fr.eni.lokacar.contracts.EmployeContract;
import fr.eni.lokacar.contracts.LocationContract;
import fr.eni.lokacar.contracts.VehiculeContract;

public class GestionBdd extends SQLiteOpenHelper {

    private static final String TAG = "***GESTIONBDD***";

    public GestionBdd(Context context) {
        super(context, BddContract.BDD_NAME, null, BddContract.BDD_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        //on met la requete sql dans un string
        String requete =
                //creation table agence
                "CREATE TABLE " +
                AgenceContract.TABLE_NAME +
                "(" +
                AgenceContract.COL_ID +
                " INTEGER PRIMARY KEY AUTOINCREMENT," +
                AgenceContract.COL_NOM +
                " TEXT, " +
                AgenceContract.COL_VILLE +
                " TEXT, " +
                AgenceContract.COL_CODEPOSTAL +
                " INTEGER " +
                ");" +

                //creation table employe
                "CREATE TABLE " +
                EmployeContract.TABLE_NAME +
                "(" +
                EmployeContract.COL_ID +
                " INTEGER PRIMARY KEY AUTOINCREMENT," +
                EmployeContract.COL_NOM +
                " TEXT, " +
                EmployeContract.COL_PRENOM +
                " TEXT, " +
                EmployeContract.COL_EMAIL +
                " TEXT, " +
                EmployeContract.COL_MOTDEPASSE +
                " TEXT " +
                ");" +

                //creation table vehicule
                "CREATE TABLE " +
                VehiculeContract.TABLE_NAME +
                "(" +
                VehiculeContract.COL_ID +
                " INTEGER PRIMARY KEY AUTOINCREMENT," +
                VehiculeContract.COL_MARQUE +
                " TEXT, " +
                VehiculeContract.COL_MODELE +
                " TEXT, " +
                VehiculeContract.COL_DESCRIPTION +
                " TEXT, " +
                VehiculeContract.COL_IMMATRICULATION +
                " TEXT, " +
                VehiculeContract.COL_PRIX +
                " REAl, " +
                VehiculeContract.COL_LOUE +
                " INTEGER " +
                ");" +

                //creation table client
                "CREATE TABLE " +
                ClientContract.TABLE_NAME +
                "(" +
                ClientContract.COL_ID +
                " INTEGER PRIMARY KEY AUTOINCREMENT," +
                ClientContract.COL_NOM +
                " TEXT, " +
                ClientContract.COL_PRENOM +
                " TEXT, " +
                ClientContract.COL_ADRESSE +
                " TEXT, " +
                ClientContract.COL_CODEPOSTAL +
                " INTEGER, " +
                ClientContract.COL_VILLE +
                " TEXT, " +
                ClientContract.COL_TELEPHONE +
                " INTEGER, " +
                ClientContract.COL_EMAIL +
                " TEXT " +
                ");" +

                //creation table location
                "CREATE TABLE " +
                 LocationContract.TABLE_NAME +
                "(" +
                LocationContract.COL_ID +
                " INTEGER PRIMARY KEY AUTOINCREMENT," +
                LocationContract.COL_DATE_DEBUT +
                " TEXT, " +
                LocationContract.COL_DATE_FIN +
                " TEXT, " +
                LocationContract.COL_ETAT_ENTRANT +
                " TEXT, " +
                LocationContract.COL_ETAT_SORTANT +
                " TEXT, " +
                ");";

        //on l'execute
        sqLiteDatabase.execSQL(requete);

        //on met un log car il est facile de faire des erreurs a cet endroit
        Log.d(TAG, "Requete : " + requete);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}