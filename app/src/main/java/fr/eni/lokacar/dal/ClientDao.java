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
        cv.put(ClientContract.COL_NOMCLIENT,item.getNomClient());
        cv.put(ClientContract.COL_PRENOMCLIENT,item.getPrenomClient());
        cv.put(ClientContract.COL_ADRESSECLIENT,item.getAdresseClient());
        cv.put(ClientContract.COL_CODEPOSTALCLIENT,item.getCodePostalClient());
        cv.put(ClientContract.COL_VILLECLIENT,item.getVilleClient());
        cv.put(ClientContract.COL_TELEPHONECLIENT,item.getTelephoneClient());
        cv.put(ClientContract.COL_EMAILCLIENT,item.getEmailClient());



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
                                ClientContract.COL_IDCLIENT,
                                ClientContract.COL_NOMCLIENT,
                                ClientContract.COL_PRENOMCLIENT,
                                ClientContract.COL_ADRESSECLIENT,
                                ClientContract.COL_CODEPOSTALCLIENT,
                                ClientContract.COL_VILLECLIENT,
                                ClientContract.COL_TELEPHONECLIENT,
                                ClientContract.COL_EMAILCLIENT},
                        null,
                        null,
                        null,
                        null,
                        ClientContract.COL_NOMCLIENT);

        while (resultatDeLaRequete.moveToNext()) {

            //on cree autant de clients qu'il y a de lignes
            Client client = new Client();
            client.setNomClient(resultatDeLaRequete.getString(ClientContract.NUM_COL_NOMCLIENT));
            client.setPrenomClient(resultatDeLaRequete.getString(ClientContract.NUM_COL_PRENOMCLIENT));
            client.setAdresseClient(resultatDeLaRequete.getString(ClientContract.NUM_COL_ADRESSECLIENT));
            client.setCodePostalClient(resultatDeLaRequete.getInt(ClientContract.NUM_COL_CODEPOSTALCLIENT));
            client.setVilleClient(resultatDeLaRequete.getString(ClientContract.NUM_COL_VILLECLIENT));
            client.setTelephoneClient(resultatDeLaRequete.getInt(ClientContract.NUM_COL_TELEPHONECLIENT));
            client.setEmailClient(resultatDeLaRequete.getString(ClientContract.NUM_COL_EMAILCLIENT));


            //on ajoute les clients nouvellement crees dans une liste
            resultat.add(client);
        }
        resultatDeLaRequete.close();
        return resultat;
    }
}