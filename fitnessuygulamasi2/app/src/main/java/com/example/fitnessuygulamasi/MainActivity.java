package com.example.fitnessuygulamasi;

import  androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText mail, sifre;
    Button girisyap;

    String dogruEposta = "ebru@hotmail.com";
    String dogruSifre = "ebru123";

    String eposta, sifresi;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mail=findViewById(R.id.edtxtposta);
        sifre=findViewById(R.id.edtxtsifre);
        girisyap=findViewById(R.id.btngirisyap);


        girisyap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String eposta = mail.getText().toString();
                String sifresi = sifre.getText().toString();

                if (eposta.equals(dogruEposta) && sifresi.equals(dogruSifre)) {
                    Intent i = new Intent(MainActivity.this, FitnessEkraniActivity.class);
                    startActivity(i);

                    Toast.makeText(MainActivity.this, "Giriş başarılı!", Toast.LENGTH_SHORT).show();

                } else {

                    Toast.makeText(MainActivity.this, "Hatalı e-posta veya şifre!", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}