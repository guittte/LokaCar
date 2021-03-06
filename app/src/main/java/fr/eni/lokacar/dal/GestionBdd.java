package fr.eni.lokacar.dal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import fr.eni.lokacar.contracts.AgenceContract;
import fr.eni.lokacar.contracts.BddContract;
import fr.eni.lokacar.contracts.ClientContract;
import fr.eni.lokacar.contracts.EmployeContract;
import fr.eni.lokacar.contracts.LocationContract;
import fr.eni.lokacar.contracts.VehiculeContract;

public class GestionBdd extends SQLiteOpenHelper {

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
                AgenceContract.COL_IDAGENCE +
                " INTEGER PRIMARY KEY AUTOINCREMENT," +
                AgenceContract.COL_NOMAGENCE +
                " TEXT, " +
                AgenceContract.COL_VILLEAGENCE +
                " TEXT, " +
                AgenceContract.COL_CODEPOSTALAGENCE +
                " INTEGER " +
                ");";

        //on l'execute
        sqLiteDatabase.execSQL(requeteAgence);



        String requeteEmploye =
                //creation table employe
                "CREATE TABLE " +
                EmployeContract.TABLE_NAME +
                "(" +
                EmployeContract.COL_IDEMPLOYE +
                " INTEGER PRIMARY KEY AUTOINCREMENT," +
                EmployeContract.COL_NOMEMPLOYE +
                " TEXT, " +
                EmployeContract.COL_PRENOMEMPLOYE +
                " TEXT, " +
                EmployeContract.COL_EMAILEMPLOYE +
                " TEXT, " +
                EmployeContract.COL_MOTDEPASSEEMPLOYE +
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


        String requeteVehicule =
                //creation table vehicule
                "CREATE TABLE " +
                VehiculeContract.TABLE_NAME +
                "(" +
                VehiculeContract.COL_IDVEHICULE +
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


        String requeteClient =
                //creation table client
                "CREATE TABLE " +
                ClientContract.TABLE_NAME +
                "(" +
                ClientContract.COL_IDCLIENT +
                " INTEGER PRIMARY KEY AUTOINCREMENT," +
                ClientContract.COL_NOMCLIENT +
                " TEXT, " +
                ClientContract.COL_PRENOMCLIENT +
                " TEXT, " +
                ClientContract.COL_ADRESSECLIENT +
                " TEXT, " +
                ClientContract.COL_CODEPOSTALCLIENT +
                " INTEGER, " +
                ClientContract.COL_VILLECLIENT +
                " TEXT, " +
                ClientContract.COL_TELEPHONECLIENT +
                " INTEGER, " +
                ClientContract.COL_EMAILCLIENT +
                " TEXT, " +
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


        String requeteLocation =
                //creation table location
                "CREATE TABLE " +
                 LocationContract.TABLE_NAME +
                "(" +
                LocationContract.COL_IDLOCATION +
                " INTEGER PRIMARY KEY AUTOINCREMENT," +
                LocationContract.COL_DATE_DEBUT +
                " TEXT, " +
                LocationContract.COL_DATE_FIN +
                " TEXT, " +
                LocationContract.COL_ETAT_ENTRANT +
                " TEXT, " +
                LocationContract.COL_ETAT_SORTANT +
                " TEXT, " +
                LocationContract.COL_IDVEHICULE +
                " INTEGER," +
                LocationContract.COL_IDCLIENT +
                " INTEGER, FOREIGN KEY ( " +
                LocationContract.COL_IDCLIENT +
                " ) REFERENCES " +
                ClientContract.TABLE_NAME +
                " ( " +
                LocationContract.COL_IDCLIENT +
                " ) " +
                "FOREIGN KEY (" +
                LocationContract.COL_IDVEHICULE +
                ") REFERENCES " +
                VehiculeContract.TABLE_NAME +
                " ("  +
                LocationContract.COL_IDVEHICULE +
                " ) " +
                ");";

        //on l'execute
        sqLiteDatabase.execSQL(requeteLocation);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        String requete = "DROP TABLE IF EXISTS " +
                AgenceContract.TABLE_NAME +
                ", " +
                EmployeContract.TABLE_NAME +
                ", " +
                VehiculeContract.TABLE_NAME +
                ", " +
                ClientContract.TABLE_NAME +
                ", " +
                LocationContract.TABLE_NAME
                ;

        //on supprime la table
        sqLiteDatabase.execSQL(requete);

        //puis on la recree
        onCreate(sqLiteDatabase);
    }
}