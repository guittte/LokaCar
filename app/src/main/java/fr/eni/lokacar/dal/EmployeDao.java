package fr.eni.lokacar.dal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import fr.eni.lokacar.bo.Employe;
import fr.eni.lokacar.contracts.EmployeContract;

public class EmployeDao {

    private SQLiteDatabase connexion = null;

    public EmployeDao(Context context){

        GestionBdd gestionBdd = new GestionBdd(context);
        connexion = gestionBdd.getWritableDatabase();
    }

    /**
     * CREATE
     * permet d'inserer un employe dans la bdd
     * @param item employe a inserer
     * @return identifiant de l'employe insere
     */
    public long insert(Employe item){

        ContentValues cv = new ContentValues();
        cv.put(EmployeContract.COL_NOM,item.getNomEmploye());
        cv.put(EmployeContract.COL_PRENOM,item.getPrenomEmploye());
        cv.put(EmployeContract.COL_EMAIL,item.getEmailEmploye());
        cv.put(EmployeContract.COL_MOTDEPASSE,item.getMotDePasse());



        return connexion.insert(EmployeContract.TABLE_NAME, null, cv);
    }

    /**
     * READ
     * @return resultat
     */
    public ArrayList<Employe> get(){

        ArrayList<Employe> resultat = new ArrayList<Employe>();

        Cursor resultatDeLaRequete =
                connexion.query(
                        EmployeContract.TABLE_NAME,
                        new String[]{
                                EmployeContract.COL_ID,
                                EmployeContract.COL_NOM,
                                EmployeContract.COL_PRENOM,
                                EmployeContract.COL_EMAIL,
                                EmployeContract.COL_MOTDEPASSE},
                        null,
                        null,
                        null,
                        null,
                        EmployeContract.COL_NOM);

        while (resultatDeLaRequete.moveToNext()) {

            //on cree autant d'employes qu'il y a de lignes
            Employe employe = new Employe();
            employe.setNomEmploye(resultatDeLaRequete.getString(EmployeContract.NUM_COL_NOM));
            employe.setPrenomEmploye(resultatDeLaRequete.getString(EmployeContract.NUM_COL_PRENOM));
            employe.setEmailEmploye(resultatDeLaRequete.getString(EmployeContract.NUM_COL_EMAIL));
            employe.setMotDePasse(resultatDeLaRequete.getString(EmployeContract.NUM_COL_MOTDEPASSE));


            //on ajoute les employes nouvellement crees dans une liste
            resultat.add(employe);
        }
        resultatDeLaRequete.close();
        return resultat;
    }
}