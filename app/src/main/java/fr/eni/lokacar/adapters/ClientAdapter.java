package fr.eni.lokacar.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import fr.eni.lokacar.R;
import fr.eni.lokacar.bo.Client;

public class ClientAdapter extends ArrayAdapter<Client> {

    private int presentation_lignes_client;
    private List<Client> liste;
    private Context context;

    public ClientAdapter(Context context, int resource, List<Client> liste) {
        super(context, resource, liste);
        this.context = context;
        this.liste = liste;
        this.presentation_lignes_client = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (null == convertView) {
            //Dézippeur pour dézipper les fichiers zippé.
            LayoutInflater pompe = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //Je dézippe le fichier xml representant la ligne et ça le transforme en View
            convertView = pompe.inflate(presentation_lignes_client, parent, false);
            //Je recupere la donnée me permettant de remplir la ligne
            final Client client = liste.get(position);
            if (client != null){
                //Dans la view il y a des textviews
                //Je recupere ces textview sous forme d'objet
                final TextView marque = (TextView) convertView.findViewById(R.id.tv_ligne_nom_client);
                final TextView modele = (TextView) convertView.findViewById(R.id.tv_ligne_prenom);

                //Je remplis la ligne
                marque.setText(client.getNomClient());
                modele.setText(client.getPrenomClient());
            }
        }
        //Et je la retourne
        Log.i("ARO"," ClientAdapter " +convertView);
        return convertView;
    }

    public int getCount(){
        if (liste != null)return liste.size();
        return 0;
    }
}