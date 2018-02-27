package fr.eni.lokacar.dal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import fr.eni.lokacar.bo.Vehicule;
import fr.eni.lokacar.contracts.VehiculeContract;

public class VehiculeDao {

    private SQLiteDatabase connexion = null;

    public VehiculeDao(Context context){

        GestionBdd gestionBdd = new GestionBdd(context);
        connexion = gestionBdd.getWritableDatabase();
    }

    /**
     * CREATE
     * permet d'inserer un vehicule dans la bdd
     * @param item Vehicule a inserer
     * @return identifiant du vehicule insere
     */
    public long insert(Vehicule item){

        ContentValues cv = new ContentValues();
        cv.put(VehiculeContract.COL_MARQUE,item.getMarque());
        cv.put(VehiculeContract.COL_MODELE,item.getModele());
        cv.put(VehiculeContract.COL_DESCRIPTION,item.getDescription());
        cv.put(VehiculeContract.COL_IMMATRICULATION,item.getImmatriculation());
        cv.put(VehiculeContract.COL_PRIX,item.getPrix());
        cv.put(VehiculeContract.COL_LOUE,item.getLoue());


        return connexion.insert(VehiculeContract.TABLE_NAME, null, cv);
    }

    /**
     * READ
     * @return resultat
     */
    public ArrayList<Vehicule> get(){

        ArrayList<Vehicule> resultat = new ArrayList<Vehicule>();

        Cursor resultatDeLaRequete =
                connexion.query(
                        VehiculeContract.TABLE_NAME,
                        new String[]{
                                VehiculeContract.COL_ID,
                                VehiculeContract.COL_MARQUE,
                                VehiculeContract.COL_MODELE,
                                VehiculeContract.COL_DESCRIPTION,
                                VehiculeContract.COL_IMMATRICULATION,
                                VehiculeContract.COL_PRIX,
                                VehiculeContract.COL_LOUE},
                        null,
                        null,
                        null,
                        null,
                        VehiculeContract.COL_MARQUE);

        while (resultatDeLaRequete.moveToNext()) {

            //on cree autant de Vehicules qu'il y a de lignes
            Vehicule vehicule = new Vehicule();
            vehicule.setMarque(resultatDeLaRequete.getString(VehiculeContract.NUM_COL_MARQUE));
            vehicule.setModele(resultatDeLaRequete.getString(VehiculeContract.NUM_COL_MODELE));
            vehicule.setModele(resultatDeLaRequete.getString(VehiculeContract.NUM_COL_DESCRIPTION));
            vehicule.setModele(resultatDeLaRequete.getString(VehiculeContract.NUM_COL_IMMATRICULATION));
            vehicule.setModele(resultatDeLaRequete.getString(VehiculeContract.NUM_COL_PRIX));
            vehicule.setModele(resultatDeLaRequete.getString(VehiculeContract.NUM_COL_LOUE));


            //on ajoute les Vehicules nouvellement crees dans une liste
            resultat.add(vehicule);
        }
        resultatDeLaRequete.close();
        return resultat;
    }
}