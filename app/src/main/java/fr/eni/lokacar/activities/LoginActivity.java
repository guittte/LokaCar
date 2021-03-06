package fr.eni.lokacar.activities;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import fr.eni.lokacar.R;

public class LoginActivity extends AppCompatActivity {

    Button btnlogin;
    EditText et_email, et_mdp;
    SQLiteOpenHelper dbhelper;
    SQLiteDatabase db;
    Cursor cursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //met l'icone a cote devant le nom de l'application
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.rentalicon32);
        }

    public void login(View view) {
        btnlogin = (Button) findViewById(R.id.btn_login);
        et_email = (EditText) findViewById(R.id.et_email);
        et_mdp = (EditText) findViewById(R.id.et_mdp);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et_email.getText().toString().equals("anais@eni.fr") &&
                        et_mdp.getText().toString().equals("admin")) {
                    Toast.makeText(getApplicationContext(),
                            "Redirection...", Toast.LENGTH_SHORT).show();
                    Intent intention = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intention);
                } else {
                    Toast.makeText(getApplicationContext(), "Saisie erronée", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}


