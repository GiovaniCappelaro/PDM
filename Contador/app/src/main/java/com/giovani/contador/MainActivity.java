package com.giovani.contador;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.giovani.contador.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    //criar referências para os objetos do xml:
    private ActivityMainBinding amb;
    /*private TextView contadorTv;
    private Button cliqueBt;
    private EditText inicialEt; */
    private int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        amb = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(amb.getRoot());

        //setContentView(R.layout.activity_main);

        /*contadorTv = findViewById(R.id.contadorTv); //acha a view de xml q tem esse id
        cliqueBt = findViewById(R.id.cliqueBt);
        inicialEt = findViewById(R.id.inicialEt);*/

        //Listeners:

        amb.inicialCb.setOnClickListener( (view) -> {
            if(amb.inicialCb.isChecked()){
                contador = Integer.parseInt(amb.inicialCb.getText().toString());
            }//Se marcar o checkbox do valor, o contador começa valendo o valor do checkbox
        });

        amb.cliqueBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contador ++;
                amb.contadorTv.setText(String.valueOf(contador));
            }
        });


    }
}