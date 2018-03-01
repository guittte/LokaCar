package fr.eni.lokacar.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import fr.eni.lokacar.R;
import fr.eni.lokacar.bo.Client;

public class DetailClientActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_client);

        //met l'icone a cote devant le nom de l'application
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.rentalicon32);

        Client client = getIntent().getParcelableExtra("client");

        TextView tvMarque = (TextView) findViewById(R.id.tv_marque);
        tvMarque.setText(client.getMarque());

        TextView tvModele = (TextView) findViewById(R.id.tv_modele);
        tvModele.setText(client.getModele());

        TextView tvImmatriculation = (TextView) findViewById(R.id.tv_immatriculation);
        tvImmatriculation.setText(client.getImmatriculation());

        TextView tvDescription = (TextView) findViewById(R.id.tv_description);
        tvDescription.setText(client.getDescription());

        TextView tvPrix = (TextView) findViewById(R.id.tv_prix);
        tvPrix.setText(String.valueOf(client.getPrix()));

        Log.e("ARO","DetailClientActivity"+ client);

    }
}