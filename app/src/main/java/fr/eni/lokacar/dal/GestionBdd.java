package fr.eni.lokacar.dal;

import android.content.Context;

import fr.eni.lokacar.contracts.BddContract;

public class GestionBdd {

    private static final String TAG = "***GESTIONBDD***";

    public GestionBdd(Context context) {
        super(context, BddContract.BDD_NAME, null, BddContract.BDD_VERSION);
    }
}