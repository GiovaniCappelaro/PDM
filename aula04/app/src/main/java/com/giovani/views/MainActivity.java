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

        //setContentView(R.layout.activity_main); //chama meu layout activity_main
    }

    //metodo com forma diferente de fazer o listener
    public void onClickSalvar(View botao){
        Toast.makeText(this, "clicou no salvar", Toast.LENGTH_SHORT).show();
    };

}