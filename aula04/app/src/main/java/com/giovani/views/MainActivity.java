package com.giovani.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.giovani.views.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    //Referência para a classe ActivityMainBinding, criando um objeto do seu tipo
    private ActivityMainBinding amb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Começa a lógica a partir daqui após iniciar a ActivityMainBinding

        //instanciar a classe activity
        amb = ActivityMainBinding.inflate(getLayoutInflater());


        setContentView(R.layout.activity_main); //chama meu layout activity_main
    }
}