package com.giovani.pdm.ciclopdm

import android.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.LayoutDirection
import android.util.Log
import android.util.Log.*
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import com.giovani.pdm.ciclopdm.databinding.ActivityMainBinding

//sem modificador 'open', uma classe não pode ser herdada

// ':' substitui o extends ou implements do java

class MainActivity : AppCompatActivity() {

    //criar instancia de um Objeto ActivityMainBinding
    /*lazy permite inicializar a amb ANTES do método onCreate()
        -> Só realmente inicializa o objeto quando devolver algo. No caso, quando a var amb for chamada no código
     */
    private val amb: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    //var objeto do tipo EditText (usado abaixo p criar um EditText dinamico)
    private lateinit var dinamicoEt: EditText

    //tudo no comp. object é estático
    private companion object {
        const val TAG = "CICLO_PDM_TAG"
        const val VALOR_ET_DINAMICO = "VALOR_ET_DINAMICO"
    }


    //métodos CICLO DE VIDA
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(amb.root) //a view usada sera a view root da amb

        //criar um layout na lógica invés de no XML (tempo de execução)
        dinamicoEt = EditText(this)
        val layoutParams: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        layoutParams.setMargins(0,10,0,0)
        dinamicoEt.layoutParams = layoutParams
        dinamicoEt.hint = "Edit text dinamico"
        amb.root.addView(dinamicoEt)  //add a view 'dinamicoEt' às views da aplicação


        Log.v(TAG, "onCreate: Iniciando ciclo COMPLETO") //printa coisas no logCat
    }

    override fun onStart() {
        super.onStart()
        Log.v(TAG, "onStart: Iniciando ciclo VISÍVEL")
    }

    override fun onResume() {
        super.onResume()
        Log.v(TAG, "onResume: Iniciando ciclo FOREGROUND")
    }//FOREGROUND = 1o plano

    //opicional aplicar esse:
    override fun onRestart() {
        super.onRestart()
        Log.v(TAG, "onRestart: preparando  execução onStart")
    }

    override fun onPause() {
        super.onPause()
        Log.v(TAG, "onPause: Finalizando ciclo FOREGROUND")
    }

    override fun onStop() {
        super.onStop()
        Log.v(TAG, "onStop: Finalizando ciclo VISÍVEL")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v(TAG, "onDestroy: Finalizando ciclo COMPLETO")
    }

    //salvar estado
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(VALOR_ET_DINAMICO, dinamicoEt.text.toString())
        Log.v(TAG, "onSaveInstanceState: Salvando ET dinamico")
    }


    //restaurar dados ao retornar à activity:
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val valorSalvo: String = savedInstanceState.getString(VALOR_ET_DINAMICO, "")
        dinamicoEt.setText(valorSalvo)
        Log.v(TAG, "onRestoreInstanceState: Restaurando ET dinamico")
    }


}

