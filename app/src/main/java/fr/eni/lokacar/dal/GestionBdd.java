package fr.eni.lokacar.dal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import fr.eni.lokacar.bo.Location;
import fr.eni.lokacar.bo.Vehicule;
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

        //on met les requetes sql dans des strings

        String requeteAgence =
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
                ");";

        //on l'execute
        sqLiteDatabase.execSQL(requeteAgence);

        //on met un log car il est facile de faire des erreurs a cet endroit
        Log.d(TAG, "Creation table agence : " + requeteAgence);



        String requeteEmploye =
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
                " TEXT, " +
                EmployeContract.COL_IDAGENCE +
                " INTEGER, FOREIGN KEY ( " +
                EmployeContract.COL_IDAGENCE +
                " ) REFERENCES " +
                AgenceContract.TABLE_NAME +
                " ( " +
                EmployeContract.COL_IDAGENCE +
                " ) " +
                ");";

        //on l'execute
        sqLiteDatabase.execSQL(requeteEmploye);

        //on met un log car il est facile de faire des erreurs a cet endroit
        Log.d(TAG, "Creation table employe : " + requeteEmploye);



        String requeteVehicule =
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
                VehiculeContract.COL_IDAGENCE +
                " INTEGER, FOREIGN KEY ( " +
                VehiculeContract.COL_IDAGENCE +
                " ) REFERENCES " +
                AgenceContract.TABLE_NAME +
                " ( " +
                VehiculeContract.COL_IDAGENCE +
                " ) " +
                ");";

        //on l'execute
        sqLiteDatabase.execSQL(requeteVehicule);

        //on met un log car il est facile de faire des erreurs a cet endroit
        Log.d(TAG, "Creation table vehicule : " + requeteVehicule);



        String requeteClient =
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
                ClientContract.COL_IDVEHICULE +
                " INTEGER, FOREIGN KEY ( " +
                ClientContract.COL_IDVEHICULE +
                " ) REFERENCES " +
                VehiculeContract.TABLE_NAME +
                " ( " +
                ClientContract.COL_IDVEHICULE +
                " ) " +
                ");";

        //on l'execute
        sqLiteDatabase.execSQL(requeteClient);

        //on met un log car il est facile de faire des erreurs a cet endroit
        Log.d(TAG, "Creation table client : " + requeteClient);



        String requeteLocation =
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
                LocationContract.COL_IDCLIENT +
                " INTEGER, FOREIGN KEY ( " +
                LocationContract.COL_IDCLIENT +
                " ) REFERENCES " +
                ClientContract.TABLE_NAME +
                " ( " +
                LocationContract.COL_IDCLIENT +
                " ) " +
                LocationContract.COL_IDVEHICULE +
                " INTEGER, FOREIGN KEY ( " +
                LocationContract.COL_IDVEHICULE +
                " ) REFERENCES " +
                VehiculeContract.TABLE_NAME +
                " ( " +
                LocationContract.COL_IDVEHICULE +
                " ) " +
                ");";

        //on l'execute
        sqLiteDatabase.execSQL(requeteLocation);

        //on met un log car il est facile de faire des erreurs a cet endroit
        Log.d(TAG, "Creation table location : " + requeteLocation);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}