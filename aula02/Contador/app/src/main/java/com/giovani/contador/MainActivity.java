package com.giovani.contador;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

        //Listeners:

        amb.inicialSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                contador = (i == 0) ? 0 : (i==1) ? 5 : 10;  //sequencia de ternarios pro valor do contador (i é a posição do array)
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
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