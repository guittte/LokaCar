package fr.eni.lokacar.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import fr.eni.lokacar.R;

public class LoginActivity extends AppCompatActivity {

    Button btn_login;
    EditText et_email, et_mdp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void login(View view) {
        btn_login = (Button) findViewById(R.id.btn_login);
        et_email = (EditText) findViewById(R.id.et_email);
        et_mdp = (EditText) findViewById(R.id.et_mdp);

        btn_login.setOnClickListener(new View.OnClickListener() {
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

