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
import fr.eni.lokacar.bo.Client;
import fr.eni.lokacar.bo.Vehicule;
import fr.eni.lokacar.dal.ClientDao;
import fr.eni.lokacar.dal.VehiculeDao;

public class AjoutClientActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_client);


    //met l'icone a cote devant le nom de l'application
    getSupportActionBar().setDisplayShowHomeEnabled(true);
    getSupportActionBar().setIcon(R.drawable.rentalicon32);
    }

    public void onClickBtnInsertBdd(View view) {

        Client client = new Client();

        //on recupere les valeurs de l'ihm
        EditText etNom = (EditText) findViewById(R.id.et_ajout_nom);
        EditText etPrenom = (EditText) findViewById(R.id.et_ajout_prenom);
        EditText etAdresse = (EditText) findViewById(R.id.et_ajout_adresse);
        EditText etCodePostal = (EditText) findViewById(R.id.et_ajout_codepostal);
        EditText etVille = (EditText) findViewById(R.id.et_ajout_ville);
        EditText etTelephone = (EditText) findViewById(R.id.et_ajout_telephone);
        EditText etEmail = (EditText) findViewById(R.id.et_ajout_email);

        //mettre les valeurs de l'ihm récuperees dans des variables
        String nom = etNom.getText().toString();
        String prenom = etPrenom.getText().toString();
        String adresse = etAdresse.getText().toString();
        int codePostal = Integer.parseInt(etCodePostal.getText().toString());
        String ville = etVille.getText().toString();
        int telephone = Integer.parseInt(etTelephone.getText().toString());
        String email = etEmail.getText().toString();


        client.setNomClient(nom);
        client.setPrenomClient(prenom);
        client.setAdresseClient(adresse);
        client.setCodePostalClient(codePostal);
        client.setVilleClient(ville);
        client.setTelephoneClient(telephone);
        client.setEmailClient(email);


        ClientDao dao = new ClientDao(this);
        long id = dao.insert(client);

        Toast.makeText(this, "Resultat de l'insert : " +
                id, Toast.LENGTH_SHORT).show();

        Intent intention = new Intent(this, ListeClientActivity.class);
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



public void onClickBtnInsertclientBdd(View view) {
    }
}
