package com.giovani.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.giovani.views.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    //Referência para a classe ActivityMainBinding, criando um objeto do seu tipo e Pessoa tbm
    private ActivityMainBinding amb;
    private Pessoa pessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Começa a lógica a partir daqui após iniciar a ActivityMainBinding

        //instanciar o objeto da classe ActivityMainBinding
        amb = ActivityMainBinding.inflate(getLayoutInflater());

        //quem monta a classe agora é a ActivityMainBinding -> Pega o arquivo root da activity
        setContentView(amb.getRoot());


        //----LISTENNERS--//

        //salvar o form
        amb.salvarBt.setOnClickListener(view -> {
            //inicializando uma pessoa com seu construtor
            pessoa = new Pessoa(
                    amb.nomeEt.getText().toString(),
                    amb.sobrenomeEt.getText().toString(),
                    amb.emailEt.getText().toString(),
                    amb.estadoCivilSp.getSelectedItem().toString(),
                    //((TextView) amb.estadoCivilSp.getSelectedView()).getText().toString(),//converte o item do spinner pra TextView e pega o texto -> (getText() só funciona em objetos TextView)
                    amb.femininoRb.isChecked()? amb.femininoRb.getText().toString() : amb.masculinoRb.getText().toString()
            );
            //exibindo essas infos ao clicar bo botão salvar:
            Toast.makeText(this, pessoa.toString(), Toast.LENGTH_SHORT).show();

        });

        //limpar o form
        amb.limparBt.setOnClickListener(view -> {
            amb.nomeEt.setText("");
            amb.sobrenomeEt.setText("");
            amb.emailEt.setText("");
            amb.estadoCivilSp.setSelection(0); //posição 0 do array de strings do spinner
            amb.femininoRb.setChecked(true);
            pessoa = null;
        });




    }



}