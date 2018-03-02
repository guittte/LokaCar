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

        TextView tvNom = (TextView) findViewById(R.id.tv_nom);
        tvNom.setText(client.getNomClient());

        TextView tvPrenom = (TextView) findViewById(R.id.tv_prenom);
        tvPrenom.setText(client.getPrenomClient());

        TextView tvTel = (TextView) findViewById(R.id.tv_telephone);
        tvTel.setText(client.getTelephoneClient());

        TextView tvEmail = (TextView) findViewById(R.id.tv_email);
        tvEmail.setText(client.getEmailClient());

        TextView tvAdresse = (TextView) findViewById(R.id.tv_adresse);
        tvAdresse.setText(String.valueOf(client.getAdresseClient()));

        TextView tvCp = (TextView) findViewById(R.id.tv_codepostal);
        tvCp.setText(String.valueOf(client.getCodePostalClient()));

        TextView tvVille = (TextView) findViewById(R.id.tv_ville);
        tvVille.setText(String.valueOf(client.getVilleClient()));

        Log.e("ARO","DetailClientActivity"+ client);

    }
}