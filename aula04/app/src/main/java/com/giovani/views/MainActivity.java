package com.giovani.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

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

        //quem monta a classe agora é a ActivityMainBinding -> Pega o arquivo root da activity
        setContentView(amb.getRoot());

        //função de limpar o form
        amb.limparBt.setOnClickListener(view -> {
            amb.nomeEt.setText("");
            amb.sobrenomeEt.setText("");
            amb.emailEt.setText("");
            amb.estadoCivilSp.setSelection(0); //posição 0 do array de strings do spinner

        });
    }



}