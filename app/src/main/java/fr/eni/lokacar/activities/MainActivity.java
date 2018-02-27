package fr.eni.lokacar.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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
        Vehicule vehicule = new Vehicule();
        //(1,"Mercedes","A200","Etat neuf","930AA44",30.5f,1)
        vehicule.setMarque("seat");
        vehicule.setModele("leon");
        vehicule.setDescription("Etat parfait");
        vehicule.setImmatriculation("AA987CV");
        vehicule.setPrix(17.5f);
        vehicule.setLoue(0);

        VehiculeDao dao = new VehiculeDao(this);
        Toast.makeText(MainActivity.this,"Resultat de l'insert : "
                + dao.insert(vehicule), Toast.LENGTH_SHORT).show();

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

