package fr.eni.lokacar.dal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import fr.eni.lokacar.bo.Client;
import fr.eni.lokacar.contracts.ClientContract;

public class ClientDao {

    private SQLiteDatabase connexion = null;

    public ClientDao(Context context){

        GestionBdd gestionBdd = new GestionBdd(context);
        connexion = gestionBdd.getWritableDatabase();
    }

    /**
     * CREATE
     * permet d'inserer un client dans la bdd
     * @param item client a inserer
     * @return identifiant du client insere
     */
    public long insert(Client item){

        ContentValues cv = new ContentValues();
        cv.put(ClientContract.COL_NOM,item.getNomClient());
        cv.put(ClientContract.COL_PRENOM,item.getPrenomClient());
        cv.put(ClientContract.COL_ADRESSE,item.getAdresseClient());
        cv.put(ClientContract.COL_CODEPOSTAL,item.getCodePostalClient());
        cv.put(ClientContract.COL_VILLE,item.getVilleClient());
        cv.put(ClientContract.COL_TELEPHONE,item.getTelephoneClient());
        cv.put(ClientContract.COL_EMAIL,item.getEmailClient());



        return connexion.insert(ClientContract.TABLE_NAME, null, cv);
    }

    /**
     * READ
     * @return resultat
     */
    public ArrayList<Client> get(){

        ArrayList<Client> resultat = new ArrayList<Client>();

        Cursor resultatDeLaRequete =
                connexion.query(
                        ClientContract.TABLE_NAME,
                        new String[]{
                                ClientContract.COL_ID,
                                ClientContract.COL_NOM,
                                ClientContract.COL_PRENOM,
                                ClientContract.COL_ADRESSE,
                                ClientContract.COL_CODEPOSTAL,
                                ClientContract.COL_VILLE,
                                ClientContract.COL_TELEPHONE,
                                ClientContract.COL_EMAIL},
                        null,
                        null,
                        null,
                        null,
                        ClientContract.COL_NOM);

        while (resultatDeLaRequete.moveToNext()) {

            //on cree autant de clients qu'il y a de lignes
            Client client = new Client();
            client.setNomClient(resultatDeLaRequete.getString(ClientContract.NUM_COL_NOM));
            client.setPrenomClient(resultatDeLaRequete.getString(ClientContract.NUM_COL_PRENOM));
            client.setAdresseClient(resultatDeLaRequete.getString(ClientContract.NUM_COL_ADRESSE));
            client.setCodePostalClient(resultatDeLaRequete.getInt(ClientContract.NUM_COL_CODEPOSTAL));
            client.setVilleClient(resultatDeLaRequete.getString(ClientContract.NUM_COL_VILLE));
            client.setTelephoneClient(resultatDeLaRequete.getInt(ClientContract.NUM_COL_TELEPHONE));
            client.setEmailClient(resultatDeLaRequete.getString(ClientContract.NUM_COL_EMAIL));


            //on ajoute les clients nouvellement crees dans une liste
            resultat.add(client);
        }
        resultatDeLaRequete.close();
        return resultat;
    }
}