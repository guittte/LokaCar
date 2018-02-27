package fr.eni.lokacar.dal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import fr.eni.lokacar.bo.Agence;
import fr.eni.lokacar.contracts.AgenceContract;

public class AgenceDao {

    private SQLiteDatabase connexion = null;

    public AgenceDao(Context context){

        GestionBdd gestionBdd = new GestionBdd(context);
        connexion = gestionBdd.getWritableDatabase();
    }

    /**
     * CREATE
     * permet d'inserer une agence dans la bdd
     * @param item agence a inserer
     * @return identifiant de l'agence inseree
     */
    public long insert(Agence item){

        ContentValues cv = new ContentValues();
        cv.put(AgenceContract.COL_NOMAGENCE,item.getNomAgence());
        cv.put(AgenceContract.COL_VILLEAGENCE,item.getVilleAgence());
        cv.put(AgenceContract.COL_CODEPOSTALAGENCE,item.getCodePostalAgence());

        return connexion.insert(AgenceContract.TABLE_NAME, null, cv);
    }

    /**
     * READ
     * @return resultat
     */
    public ArrayList<Agence> get(){

        ArrayList<Agence> resultat = new ArrayList<Agence>();

        Cursor resultatDeLaRequete =
                connexion.query(
                        AgenceContract.TABLE_NAME,
                        new String[]{
                                AgenceContract.COL_IDAGENCE,
                                AgenceContract.COL_NOMAGENCE,
                                AgenceContract.COL_VILLEAGENCE,
                                AgenceContract.COL_CODEPOSTALAGENCE},
                        null,
                        null,
                        null,
                        null,
                        AgenceContract.COL_NOMAGENCE);

        while (resultatDeLaRequete.moveToNext()) {

            //on cree autant d'agences qu'il y a de lignes
            Agence agence = new Agence();
            agence.setNomAgence(resultatDeLaRequete.getString(AgenceContract.NUM_COL_NOMAGENCE));
            agence.setVilleAgence(resultatDeLaRequete.getString(AgenceContract.NUM_COL_VILLEAGENCE));
            agence.setCodePostalAgence(resultatDeLaRequete.getInt(AgenceContract.NUM_COL_CODEPOSTALAGENCE));


            //on ajoute les agences nouvellement creees dans une liste
            resultat.add(agence);
        }
        resultatDeLaRequete.close();
        return resultat;
    }
}