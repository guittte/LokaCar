package fr.eni.lokacar.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
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
        tvTel.setText(String.valueOf(client.getTelephoneClient()));

        TextView tvEmail = (TextView) findViewById(R.id.tv_email);
        tvEmail.setText(client.getEmailClient());

        TextView tvAdresse = (TextView) findViewById(R.id.tv_adresse);
        tvAdresse.setText(client.getAdresseClient());

        TextView tvCp = (TextView) findViewById(R.id.tv_codepostal);
        tvCp.setText(String.valueOf(client.getCodePostalClient()));

        TextView tvVille = (TextView) findViewById(R.id.tv_ville);
        tvVille.setText(client.getVilleClient());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //ajoute les entrées de menu_test à l'ActionBar
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    private void menuVehicule(){
        Intent intention = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intention);
    }

    private void menuclient(){
        Intent intention = new Intent(getApplicationContext(), ListeClientActivity.class);
        startActivity(intention);
    }

    private void deconnexion(){
        Intent intention = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intention);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.it_menu_voiture:
                menuVehicule();
                break;
            case R.id.it_menu_client:
                menuclient();
                break;
            case R.id.it_menu_login:
                deconnexion();
                break;
        }
        return true;
    }
}