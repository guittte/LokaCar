package fr.eni.lokacar.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

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

                Intent intent = new Intent(MainActivity.this,DetailVehiculeActivity.class);
                intent.putExtra("vehicule",vehicule);
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

    private void menuVehicule(){
        Intent intention = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intention);
    }

    private void menuclient(){
        Intent intention = new Intent(getApplicationContext(),ListeClientActivity.class);
        startActivity(intention);


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



/*Location location = new Location();
        location.setDateDebutLocation("01/03/18");
        location.setDateFinLocation("08/03/18");
        location.setEtatLieuxEntrant("RAS");

        LocationDao dao = new LocationDao(this);
        Toast.makeText(MainActivity.this,"Resultat de l'insert : "
                + dao.insert(location), Toast.LENGTH_SHORT).show();

        Client client = new Client();
        client.setNomClient("Lambert");
        client.setPrenomClient("Emilie");
        client.setAdresseClient("pas loin de Beaulieu");
        client.setCodePostalClient(44000);
        client.setVilleClient("NantesCity");
        client.setTelephoneClient(0201234567);
        client.setEmailClient("emilie@eni.fr");

        ClientDao dao = new ClientDao(this);
        Toast.makeText(MainActivity.this,"Resultat de l'insert : "
                + dao.insert(client), Toast.LENGTH_SHORT).show();

        Agence agence = new Agence();
        agence.setNomAgence("Nantes Ouest");
        agence.setVilleAgence("Saint Herblain");
        agence.setCodePostalAgence(44800);

        AgenceDao dao = new AgenceDao(this);
        Toast.makeText(MainActivity.this,"Resultat de l'insert : "
                + dao.insert(agence), Toast.LENGTH_SHORT).show();

        Employe employe = new Employe();
        employe.setNomEmploye("Gourmelin");
        employe.setPrenomEmploye("Guillaume");
        employe.setEmailEmploye("guillaume@eni.fr");
        employe.setMotDePasse("gerant");

        EmployeDao dao = new EmployeDao(this);
        Toast.makeText(MainActivity.this,"Resultat de l'insert : "
                + dao.insert(employe), Toast.LENGTH_SHORT).show();

        Vehicule vehicule = new Vehicule();
        vehicule.setMarque("Renault");
        vehicule.setModele("Twingo");
        vehicule.setDescription("Couleur aubergine");
        vehicule.setImmatriculation("9616YY44");
        vehicule.setPrix(8.5f);
        vehicule.setLoue(0);


        VehiculeDao dao = new VehiculeDao(this);
        Toast.makeText(MainActivity.this,"Resultat de l'insert : "
                + dao.insert(vehicule), Toast.LENGTH_SHORT).show();
*/
