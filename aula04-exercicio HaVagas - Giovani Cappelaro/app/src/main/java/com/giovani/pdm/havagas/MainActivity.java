package com.giovani.pdm.havagas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.giovani.pdm.havagas.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    //Objetos da classe ActivityMainBinding e Candidato
    private ActivityMainBinding amb;
    private Candidato candidato;


    //(ex aula07) - var LOG_TAG pra ver o state:
    private static String LOG_TAG = "HAVAGAS_LOG_TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        //instanciar o objeto da classe ActivityMainBinding
        amb = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(amb.getRoot()); //view vai ser a definida como root da Activity


        /*---------LISTENNERS---------*/


        //Salvar e exibir dados do Form
        amb.salvarBt.setOnClickListener( view -> {

            //construtor de Candidato - ITENS COMUNS A TODOS
            candidato = new Candidato(
                    amb.nomeCompletoEt.getText().toString(),
                    amb.emailEt.getText().toString(),
                    amb.telefoneEt.getText().toString(),
                    amb.masculinoRb.isChecked() ? amb.masculinoRb.getText().toString() : amb.femininoRb.getText().toString(),
                    amb.dataDeNascimentoEt.getText().toString(),
                    amb.formacaoSp.getSelectedItem().toString(),
                    amb.vagasInteresse.getText().toString()
            );

            //Atribuir atributos ESPECÍFICOS:

            //celular:
            if(amb.addCelularCb.isChecked()){
                candidato.setCelular( amb.celularEt.getText().toString() ); //setar celular se estiver checado
            }

            //Formação:
            if( (amb.formacaoSp.getSelectedItemPosition() == 0) || (amb.formacaoSp.getSelectedItemPosition() == 1) ){
                candidato.setAnoFormatura(amb.anoDeFormaturaEt.getText().toString());

                candidato.setAnoConclusao(null);
                candidato.setInstituicao(null);
                candidato.setTituloMonografia(null);
                candidato.setOrientador(null);
            }
            if( (amb.formacaoSp.getSelectedItemPosition() == 2) || (amb.formacaoSp.getSelectedItemPosition() == 3) ){
                candidato.setAnoConclusao(amb.anoDeConclusaoEt.getText().toString());
                candidato.setInstituicao(amb.instituicaoEt.getText().toString());
            }
            if( (amb.formacaoSp.getSelectedItemPosition() == 4) || (amb.formacaoSp.getSelectedItemPosition() == 5) ){
                candidato.setAnoConclusao(amb.anoDeConclusaoEt.getText().toString());
                candidato.setInstituicao(amb.instituicaoEt.getText().toString());
                candidato.setTituloMonografia(amb.tituloMonografiaEt.getText().toString());
                candidato.setOrientador(amb.Orientador.getText().toString());

            }

            //Exibir
            Toast.makeText(this, candidato.toString(), Toast.LENGTH_SHORT).show();

        });



        //Limpar o form
        amb.limparBt.setOnClickListener(view -> {
            amb.nomeCompletoEt.setText("");
            amb.emailEt.setText("");
            amb.desejoAtualizacoesCb.setChecked(false);
            amb.telefoneEt.setText(null);   //ver se null serve pra numero mesmo
            amb.isTelefoneComercialCb.setChecked(false);
            amb.addCelularCb.setChecked(false);
            amb.masculinoRb.setChecked(true);
            amb.dataDeNascimentoEt.setText("");
            amb.formacaoSp.setSelection(0);
            amb.vagasInteresse.setText("");
            candidato = null;   //zerar o objeto
        });


        /*Aparição de botões 'gone'*/

        // -> Add celular - input
        /*HELPS: https://stackoverflow.com/questions/8386832/android-checkbox-listener
                 https://alvinalexander.com/source-code/android/android-checkbox-listener-setoncheckedchangelisteneroncheckedchangelistener-exam/
         */

        amb.addCelularCb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(compoundButton.isChecked()){
                    amb.celularEt.setVisibility(View.VISIBLE);
                }else{
                    amb.celularEt.setVisibility(View.GONE);
                }
            }
        });


        //Baseados na formação: (talves precise ser tudo IF, sem ELSE)

        amb.formacaoSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if( (i == 0) || (i == 1) ){
                    amb.anoDeFormaturaEt.setVisibility(view.VISIBLE);   //fundamental e medio

                    amb.anoConclusaoInstituicaoLl.setVisibility(view.GONE);
                    amb.tituloMonografiaOrientadorLl.setVisibility(view.GONE);  //esconde dos outros
                }
                else if( (i == 2) || (i == 3) ){
                    amb.anoConclusaoInstituicaoLl.setVisibility(view.VISIBLE);  //Graduação e especialização

                    amb.anoDeFormaturaEt.setVisibility(view.GONE);
                    amb.tituloMonografiaOrientadorLl.setVisibility(view.GONE); //esconde dos outros
                }
                else if( (i == 4) || (i == 5) ){
                    amb.anoConclusaoInstituicaoLl.setVisibility(view.VISIBLE);
                    amb.tituloMonografiaOrientadorLl.setVisibility(view.VISIBLE);

                    amb.anoDeFormaturaEt.setVisibility(view.GONE);                  //mostra todos menos ano de formatura (só pra fund. e medio)
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



    }

    //EXERCICIO AULA 07 - Salvar e restaurar

    //salvar (guardar os daados preenchidos)
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(LOG_TAG, "Saved Instance State");

        //salvar o EditText de nome:
        EditText editNome =  amb.nomeCompletoEt;
        CharSequence dadosEditNome = editNome.getText();
        outState.putCharSequence("EditNomeSave", dadosEditNome); //key, value

        //salvar o EditText de e-mail:
        EditText editEmail = amb.emailEt;
        CharSequence dadosEditEmail = editEmail.getText();
        outState.putCharSequence("EditEmailSave", dadosEditEmail);

        /*...colocar os outros na ordem */

        //salvar EditText do Telefone
        EditText editTelefone = amb.telefoneEt;
        CharSequence dadosEditTelefone = editTelefone.getText();
        outState.putCharSequence("EditTelefoneSave", dadosEditTelefone);

        //salvar EditText do Celular
        EditText editCelular = amb.celularEt;
        CharSequence dadosEditCelular = editCelular.getText();
        outState.putCharSequence("EditCelularSave", dadosEditCelular);

        //salvar EditText do DataNasc
        EditText editDataNasc = amb.dataDeNascimentoEt;
        CharSequence dadosEditDataNasc = editDataNasc.getText();
        outState.putCharSequence("EditDataNascSave", dadosEditDataNasc);

        //salvar EditText do AnoFormatura
        EditText editAnoFormatura = amb.anoDeFormaturaEt;
        CharSequence dadosEditAnoFormatura = editAnoFormatura.getText();
        outState.putCharSequence("EditAnoFormatura", dadosEditAnoFormatura);

        //salvar EditText do ano de conclusão
        EditText editAnoConclusao = amb.anoDeConclusaoEt;
        CharSequence dadosEditAnoConclusao = editAnoConclusao.getText();
        outState.putCharSequence("EditAnoConclusao", dadosEditAnoConclusao);

        //salvar EditText da instituicao
        EditText editInstituicao = amb.instituicaoEt;
        CharSequence dadosEditInstituicao = editInstituicao.getText();
        outState.putCharSequence("EditInstituicao", dadosEditInstituicao);

        //salvar EditText do titulo monografia
        EditText editTituloMonografia = amb.tituloMonografiaEt;
        CharSequence dadosEditTituloMonografia = editTituloMonografia.getText();
        outState.putCharSequence("EditTituloMonografia", dadosEditTituloMonografia);

        //salvar EditText do orientador
        EditText editOrientador= amb.Orientador;
        CharSequence dadosEditOrientador = editOrientador.getText();
        outState.putCharSequence("EditOrientador", dadosEditOrientador);

        //salvar EditText vags de interesse
        EditText editVagasInteresse= amb.vagasInteresse;
        CharSequence dadosEditVagasInteresse = editVagasInteresse.getText();
        outState.putCharSequence("EditVagasInteresse", dadosEditVagasInteresse);

    }

    //restaurar


    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(LOG_TAG, "Restored Instance State");

        //restaurar os dados salvos do EditText nome:
        CharSequence dadosSalvosEditNome = savedInstanceState.getCharSequence("EditNomeSave"); //recupera o dado salvo pela key
        EditText myEditNome =  amb.nomeCompletoEt;
        myEditNome.setText(dadosSalvosEditNome);    //seta o dado salvo no app

        //restaurar os dados salvos do EditText e-mail:
        CharSequence dadosSalvosEditEmail = savedInstanceState.getCharSequence("EditEmailSave");
        EditText myEditEmail = amb.emailEt;
        myEditEmail.setText(dadosSalvosEditEmail);

        /*...colocar os outros na ordem */

        //restaurar os dados salvos do EditText telefone:
        CharSequence dadosSalvosEditTelefone = savedInstanceState.getCharSequence("EditTelefoneSave");
        EditText myEditTelefone = amb.telefoneEt;
        myEditTelefone.setText(dadosSalvosEditTelefone);


        //restaurar os dados salvos do EditText celular:
        CharSequence dadosSalvosEditCelular = savedInstanceState.getCharSequence("EditCelularSave");
        EditText myEditCelular = amb.celularEt;
        myEditCelular.setText(dadosSalvosEditCelular);

        //restaurar os dados salvos do EditText dataNasc:
        CharSequence dadosSalvosEditDataNasc = savedInstanceState.getCharSequence("EditDataNascSave");
        EditText myEditDataNasc = amb.dataDeNascimentoEt;
        myEditDataNasc.setText(dadosSalvosEditDataNasc);

        //restaurar os dados salvos do EditText ano de formatura:
        CharSequence dadosSalvosEditAnoFormatura = savedInstanceState.getCharSequence("EditAnoFormatura");
        EditText myEditAnoFormatura = amb.anoDeFormaturaEt;
        myEditAnoFormatura.setText(dadosSalvosEditAnoFormatura);

        //restaurar os dados salvos do EditText ano de conclusao:
        CharSequence dadosSalvosEditAnoConclusao = savedInstanceState.getCharSequence("EditAnoConclusao");
        EditText myEditAnoConclusao = amb.anoDeFormaturaEt;
        myEditAnoConclusao.setText(dadosSalvosEditAnoConclusao);

        //restaurar os dados salvos do EditText instituicao:
        CharSequence dadosSalvosEditInstituicao = savedInstanceState.getCharSequence("EditInstituicao");
        EditText myEditInstituicao = amb.instituicaoEt;
        myEditInstituicao.setText(dadosSalvosEditInstituicao);

        //restaurar os dados salvos do EditText titulo monografia:
        CharSequence dadosSalvosEditTituloMonografia = savedInstanceState.getCharSequence("EditTituloMonografia");
        EditText myEditTituloMonografia = amb.tituloMonografiaEt;
        myEditTituloMonografia.setText(dadosSalvosEditTituloMonografia);

        //restaurar os dados salvos do EditText orientador:
        CharSequence dadosSalvosEditOrientador = savedInstanceState.getCharSequence("EditOrientador");
        EditText myEditOrientador = amb.Orientador;
        myEditOrientador.setText(dadosSalvosEditOrientador);

        //restaurar os dados salvos do EditText vags de interesse:
        CharSequence dadosSalvosEditVagasInteresse= savedInstanceState.getCharSequence("EditVagasInteresse");
        EditText myEditVagasInteresse = amb.vagasInteresse;
        myEditVagasInteresse.setText(dadosSalvosEditVagasInteresse);

    }
}