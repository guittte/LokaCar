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
        cv.put(EmployeContract.COL_NOMEMPLOYE,item.getNomEmploye());
        cv.put(EmployeContract.COL_PRENOMEMPLOYE,item.getPrenomEmploye());
        cv.put(EmployeContract.COL_EMAILEMPLOYE,item.getEmailEmploye());
        cv.put(EmployeContract.COL_MOTDEPASSEEMPLOYE,item.getMotDePasse());



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
                                EmployeContract.COL_IDEMPLOYE,
                                EmployeContract.COL_NOMEMPLOYE,
                                EmployeContract.COL_PRENOMEMPLOYE,
                                EmployeContract.COL_EMAILEMPLOYE,
                                EmployeContract.COL_MOTDEPASSEEMPLOYE},
                        null,
                        null,
                        null,
                        null,
                        EmployeContract.COL_NOMEMPLOYE);

        while (resultatDeLaRequete.moveToNext()) {

            //on cree autant d'employes qu'il y a de lignes
            Employe employe = new Employe();
            employe.setNomEmploye(resultatDeLaRequete.getString(EmployeContract.NUM_COL_NOMEMPLOYE));
            employe.setPrenomEmploye(resultatDeLaRequete.getString(EmployeContract.NUM_COL_PRENOMEMPLOYE));
            employe.setEmailEmploye(resultatDeLaRequete.getString(EmployeContract.NUM_COL_EMAILEMPLOYE));
            employe.setMotDePasse(resultatDeLaRequete.getString(EmployeContract.NUM_COL_MOTDEPASSEEMPLOYE));


            //on ajoute les employes nouvellement crees dans une liste
            resultat.add(employe);
        }
        resultatDeLaRequete.close();
        return resultat;
    }
}