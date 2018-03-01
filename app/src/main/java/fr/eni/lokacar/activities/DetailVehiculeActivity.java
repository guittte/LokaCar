package fr.eni.lokacar.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import fr.eni.lokacar.R;
import fr.eni.lokacar.bo.Vehicule;

public class DetailVehiculeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_vehicule);
        Vehicule voiture = getIntent().getParcelableExtra("vehicule");
    }


}
