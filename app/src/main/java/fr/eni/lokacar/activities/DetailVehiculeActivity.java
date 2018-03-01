package fr.eni.lokacar.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import fr.eni.lokacar.R;
import fr.eni.lokacar.bo.Vehicule;

public class DetailVehiculeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_vehicule);
        Vehicule vehicule = getIntent().getParcelableExtra("vehicule");

        TextView tvMarque = (TextView) findViewById(R.id.tv_marque);
        tvMarque.setText(vehicule.getMarque());

        TextView tvModele = (TextView) findViewById(R.id.tv_modele);
        tvModele.setText(vehicule.getModele());

        TextView tvImmatriculation = (TextView) findViewById(R.id.tv_immatriculation);
        tvImmatriculation.setText(vehicule.getImmatriculation());

        TextView tvDescription = (TextView) findViewById(R.id.tv_description);
        tvDescription.setText(vehicule.getDescription());

        TextView tvPrix = (TextView) findViewById(R.id.tv_prix);
        tvPrix.setText(String.valueOf(vehicule.getPrix()));

        Log.e("GGO","DetailVehiculeActivity"+ vehicule);


    }


    public void onClickBtnSuppBdd(View view) {

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
/*
    private void menuclient(){
        Intent intention = new Intent(getApplicationContext(), SearchActivity.class);
        startActivity(intention);
    }*/

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
            /*case R.id.it_menu_client:
                menuclient();
                break;*/
            case R.id.it_menu_login:
                deconnexion();
                break;
        }
        return true;
    }
}
