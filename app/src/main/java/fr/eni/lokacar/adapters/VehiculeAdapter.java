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
import fr.eni.lokacar.bo.Vehicule;

public class VehiculeAdapter extends ArrayAdapter<Vehicule> {
    private int presentation_lignes;
    private List<Vehicule> liste;
    private Context context;

    public VehiculeAdapter(Context context, int resource, List<Vehicule> liste) {
        super(context, resource, liste);
        this.context = context;
        this.liste = liste;
        this.presentation_lignes = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
    if (null == convertView) {
        //Dézippeur pour dézipper les fichiers zippé.
        LayoutInflater pompe = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //Je dézippe le fichier xml representant la ligne et ça le transforme en View
        convertView = pompe.inflate(presentation_lignes, parent, false);
        //Je recupere la donnée me permettant de remplir la ligne
        final Vehicule vehicule = liste.get(position);
            if (vehicule != null){
                //Dans la view il y a des textviews
                //Je recupere ces textview sous forme d'objet
                final TextView marque = (TextView) convertView.findViewById(R.id.tv_ligne_marque_vehicule);
                final TextView modele = (TextView) convertView.findViewById(R.id.tv_ligne_modele);
                //TextView tvEtatLoc = (TextView) laLigne.findViewById(R.id.tv_ligne_etat_location);

                //Je rempli la ligne
                marque.setText(vehicule.getMarque());
                modele.setText(vehicule.getModele());
                //tvEtatLoc.setText(etatAchat);
            }
    }
        //Et je la retourne
        Log.i("GGOURMEL","pompe" +convertView);
        return convertView;
    }

    public int getCount(){
        if (liste != null)return liste.size();
        return 0;
    }
}