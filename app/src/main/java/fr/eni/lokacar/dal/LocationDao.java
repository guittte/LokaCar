package fr.eni.lokacar.dal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import fr.eni.lokacar.bo.Location;
import fr.eni.lokacar.contracts.LocationContract;

public class LocationDao {

    private SQLiteDatabase connexion = null;

    public LocationDao(Context context){

        GestionBdd gestionBdd = new GestionBdd(context);
        connexion = gestionBdd.getWritableDatabase();
    }

    /**
     * CREATE
     * permet d'inserer une location dans la bdd
     * @param item location a inserer
     * @return identifiant de la location inseree
     */
    public long insert(Location item){

        ContentValues cv = new ContentValues();
        cv.put(LocationContract.COL_DATE_DEBUT,item.getDateDebutLocation());
        cv.put(LocationContract.COL_DATE_FIN,item.getDateFinLocation());
        cv.put(LocationContract.COL_ETAT_ENTRANT,item.getEtatLieuxEntrant());
        cv.put(LocationContract.COL_ETAT_SORTANT,item.getEtatLieuxSortant());



        return connexion.insert(LocationContract.TABLE_NAME, null, cv);
    }

    /**
     * READ
     * @return resultat
     */
    public ArrayList<Location> get(){

        ArrayList<Location> resultat = new ArrayList<Location>();

        Cursor resultatDeLaRequete =
                connexion.query(
                        LocationContract.TABLE_NAME,
                        new String[]{
                                LocationContract.COL_IDLOCATION,
                                LocationContract.COL_DATE_DEBUT,
                                LocationContract.COL_DATE_FIN,
                                LocationContract.COL_ETAT_ENTRANT,
                                LocationContract.COL_ETAT_SORTANT},
                        null,
                        null,
                        null,
                        null,
                        LocationContract.COL_DATE_DEBUT);

        while (resultatDeLaRequete.moveToNext()) {

            //on cree autant de locations qu'il y a de lignes
            Location location = new Location();
            location.setDateDebutLocation(resultatDeLaRequete.getString(LocationContract.NUM_COL_DATE_DEBUT));
            location.setDateFinLocation(resultatDeLaRequete.getString(LocationContract.NUM_COL_DATE_FIN));
            location.setEtatLieuxEntrant(resultatDeLaRequete.getString(LocationContract.NUM_COL_ETAT_ENTRANT));
            location.setEtatLieuxSortant(resultatDeLaRequete.getString(LocationContract.NUM_COL_ETAT_SORTANT));


            //on ajoute les locations nouvellement creees dans une liste
            resultat.add(location);
        }
        resultatDeLaRequete.close();
        return resultat;
    }
}