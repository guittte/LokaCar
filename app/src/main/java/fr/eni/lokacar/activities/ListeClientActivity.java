package fr.eni.lokacar.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import fr.eni.lokacar.R;
import fr.eni.lokacar.adapters.ClientAdapter;
import fr.eni.lokacar.adapters.VehiculeAdapter;
import fr.eni.lokacar.bo.Client;
import fr.eni.lokacar.bo.Vehicule;
import fr.eni.lokacar.dal.ClientDao;
import fr.eni.lokacar.dal.VehiculeDao;

public class ListeClientActivity extends AppCompatActivity {

    private ArrayList<Client> listeClient;
    private ListView clientListView;
    private ClientAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_client);

        //met l'icone a cote devant le nom de l'application
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.rentalicon32);

        //Creation de la liste
        ClientDao dao = new ClientDao(this);
        ArrayList<Client> liste = dao.getListClient();
        ListView clientListView = (ListView) findViewById(R.id.liste_clients);
        ClientAdapter adapter = new ClientAdapter(this, R.layout.presentation_lignes_client, liste);
        clientListView.setAdapter(adapter);

        clientListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Client client = (Client) adapterView.getItemAtPosition(i);

                Intent intent = new Intent(ListeClientActivity.this,DetailClientActivity.class);
                intent.putExtra("client",client);
                startActivity(intent);
            }
        });
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

    public void onClickBtnAjoutClient(View view) {
        Intent intention = new Intent(getApplicationContext(), AjoutClientActivity.class);
        startActivity(intention);

    }
}
