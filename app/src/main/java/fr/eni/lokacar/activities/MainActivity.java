package fr.eni.lokacar.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import fr.eni.lokacar.R;
import fr.eni.lokacar.adapters.VehiculeAdapter;
import fr.eni.lokacar.bo.Vehicule;
import fr.eni.lokacar.dal.VehiculeDao;

public class MainActivity extends AppCompatActivity {


    private ArrayList<Vehicule> liste;
    private ListView vehiculeListView;
    private VehiculeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //met l'icone a cote devant le nom de l'application
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.rentalicon32);

        //Creation de la liste
        VehiculeDao dao = new VehiculeDao(this);
        ArrayList<Vehicule> liste = dao.getListVehicule();
        ListView vehiculeListView = (ListView) findViewById(R.id.liste_vehicules);
        VehiculeAdapter adapter = new VehiculeAdapter(this, R.layout.presentation_lignes, liste);
        vehiculeListView.setAdapter(adapter);

        vehiculeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Vehicule vehicule = (Vehicule) adapterView.getItemAtPosition(i);

                Intent intent = new Intent(MainActivity.this, DetailVehiculeActivity.class);
                intent.putExtra("vehicule", vehicule);
                startActivity(intent);

            }
        });
    }


    public void onClickBtnAjoutVehicule(View view) {

        Intent intention = new Intent(this, AjoutVehiculeActivity.class);
        startActivity(intention);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //ajoute les entrées de menu_test à l'ActionBar
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    private void menuVehicule() {
        Intent intention = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intention);
    }

    private void menuclient() {
        Intent intention = new Intent(getApplicationContext(), ListeClientActivity.class);
        startActivity(intention);
    }

    private void deconnexion() {
        Intent intention = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intention);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
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