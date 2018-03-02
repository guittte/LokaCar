package fr.eni.lokacar.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import fr.eni.lokacar.R;
import fr.eni.lokacar.bo.Vehicule;
import fr.eni.lokacar.dal.VehiculeDao;

public class AjoutVehiculeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_vehicule);

        //met l'icone a cote devant le nom de l'application
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.rentalicon32);
    }

    public void onClickBtnInsertBdd(View view) {

        Vehicule vehicule = new Vehicule();

        //on recupere les valeurs de l'ihm
        EditText etMarque = (EditText) findViewById(R.id.et_ajout_marque);
        EditText etModele = (EditText) findViewById(R.id.et_ajout_modele);
        EditText etDescription = (EditText) findViewById(R.id.et_description);
        EditText etImmatriculation = (EditText) findViewById(R.id.et_immatriculation);
        EditText etTarif = (EditText) findViewById(R.id.et_tarif);

        //mettre les valeurs de l'ihm récuperees dans des variables
        String marque = etMarque.getText().toString();
        String modele = etModele.getText().toString();
        String description = etDescription.getText().toString();
        String immatriculation = etImmatriculation.getText().toString();
        Float tarif = Float.valueOf(etTarif.getText().toString());

        vehicule.setMarque(marque);
        vehicule.setModele(modele);
        vehicule.setDescription(description);
        vehicule.setImmatriculation(immatriculation);
        vehicule.setPrix(Float.parseFloat(String.valueOf(tarif)));
        vehicule.setLoue(0);

        VehiculeDao dao = new VehiculeDao(this);
        long id = dao.insert(vehicule);

        Toast.makeText(this, "Resultat de l'insert : " +
                id, Toast.LENGTH_SHORT).show();

        Intent intention = new Intent(this, MainActivity.class);
        startActivity(intention);
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
