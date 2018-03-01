package fr.eni.lokacar.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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
}
