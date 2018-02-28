package fr.eni.lokacar.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

import fr.eni.lokacar.R;
import fr.eni.lokacar.adapters.VehiculeAdapter;
import fr.eni.lokacar.bo.Agence;
import fr.eni.lokacar.bo.Client;
import fr.eni.lokacar.bo.Employe;
import fr.eni.lokacar.bo.Location;
import fr.eni.lokacar.bo.Vehicule;
import fr.eni.lokacar.dal.AgenceDao;
import fr.eni.lokacar.dal.ClientDao;
import fr.eni.lokacar.dal.EmployeDao;
import fr.eni.lokacar.dal.LocationDao;
import fr.eni.lokacar.dal.VehiculeDao;

public class MainActivity extends AppCompatActivity {


    private ArrayList<Vehicule> liste;
    private ListView vehiculeListView;
    private VehiculeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Creation de la liste
        initList();
        vehiculeListView = (ListView) findViewById(R.id.liste_vehicules);
        adapter = new VehiculeAdapter(this, R.layout.presentation_lignes, liste);
        vehiculeListView.setAdapter(adapter);

    }

    private void initList(){

        liste = new ArrayList<>();
        liste.add(new Vehicule(1,"Mercedes","A200","Etat neuf","930AA44",30.5f,1));
        liste.add(new Vehicule(2,"BMW","123D","Etat neuf","930BB74",35.5f,1));
        liste.add(new Vehicule(3,"Volkswagen","Golf","Etat neuf","847BC12",23.5f,1));
    }

    public void onClickBtnInsertBdd(View view) {

        Location location = new Location();
        location.setDateDebutLocation("01/03/18");
        location.setDateFinLocation("08/03/18");
        location.setEtatLieuxEntrant("RAS");

        LocationDao dao = new LocationDao(this);
        Toast.makeText(MainActivity.this,"Resultat de l'insert : "
                + dao.insert(location), Toast.LENGTH_SHORT).show();
        /*
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

        Employe employe = new Employe();
        employe.setNomEmploye("Rousteau");
        employe.setPrenomEmploye("Anais");
        employe.setEmailEmploye("anais@eni.fr");
        employe.setMotDePasse("gerant");

        EmployeDao dao = new EmployeDao(this);
        Toast.makeText(MainActivity.this,"Resultat de l'insert : "
                + dao.insert(employe), Toast.LENGTH_SHORT).show();


        Agence agence = new Agence();
        agence.setNomAgence("Nantes Ouest");
        agence.setVilleAgence("Saint Herblain");
        agence.setCodePostalAgence(44800);

        AgenceDao dao = new AgenceDao(this);
        Toast.makeText(MainActivity.this,"Resultat de l'insert : "
                + dao.insert(agence), Toast.LENGTH_SHORT).show();
*/
        /*
        Vehicule vehicule = new Vehicule();
        vehicule.setMarque("BMW");
        vehicule.setModele("123D");
        vehicule.setDescription("Etat parfait");
        vehicule.setImmatriculation("FD965PO");
        vehicule.setPrix(35.5f);
        vehicule.setLoue(0);

        VehiculeDao dao = new VehiculeDao(this);
        Toast.makeText(MainActivity.this,"Resultat de l'insert : "
                + dao.insert(vehicule), Toast.LENGTH_SHORT).show();

        Intent intention = new Intent(this, AjoutVehiculeActivity.class);
        startActivity(intention);
                                    AgenceContract.COL_IDAGENCE,
                                AgenceContract.COL_NOMAGENCE,
                                AgenceContract.COL_VILLEAGENCE,
                                AgenceContract.COL_CODEPOSTALAGENCE},
        */

    }

    /*
        listeView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Vehicule vehicule = (Vehicule) adapterView.getItemAtPosition(i);

                Intent intent = new Intent(ActivitListeArticle.this,MainActivity.class);
                intent.putExtra("article",article);
                startActivity(intent);
            }
        });*/
}

