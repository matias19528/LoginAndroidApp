package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Comunicacion{

    private ProgressBar pgbEjecutando;
    private Button btnIngresar;
    private TextView txtUser, txtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pgbEjecutando = findViewById(R.id.pgbEjecutanto);
        btnIngresar = findViewById(R.id.btnIngresar);
        txtUser = findViewById(R.id.txtUsername);
        txtPass = findViewById(R.id.txtPassword);
        Button btnEjecutar = findViewById(R.id.btnIngresar);
        btnEjecutar.setOnClickListener(new View.OnClickListener() {
        @Override
                public void onClick(View view) {
                new TareaA(MainActivity.this).execute(txtUser.getText().toString(),
                    txtPass.getText().toString(), 3000);
                }
        });
    }

    @Override
    public void toggleProgressBar(boolean status) {
        if (status) {
            pgbEjecutando.setVisibility(View.VISIBLE);
        } else {
            pgbEjecutando.setVisibility(View.GONE);
        }
    }

    @Override
    public void lanzarActividad(Class<?> tipoActividad) {
        Intent intent = new Intent(this, tipoActividad);
        startActivity(intent);
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}