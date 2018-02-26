package fr.eni.lokacar.dal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import fr.eni.lokacar.contracts.BddContract;
import fr.eni.lokacar.contracts.VehiculeContract;

public class GestionBdd extends SQLiteOpenHelper {

    private static final String TAG = "***GESTIONBDD***";

    public GestionBdd(Context context) {
        super(context, BddContract.BDD_NAME, null, BddContract.BDD_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        //on met la requete sql dans un string
        String requete = "CREATE TABLE " +
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
                " INTEGER, " +
                VehiculeContract.COL_PHOTO +
                " BLOB " +
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