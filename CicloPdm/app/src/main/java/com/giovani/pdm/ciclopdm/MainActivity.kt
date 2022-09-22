package com.giovani.pdm.ciclopdm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.*
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

    //tudo no comp. object é estático
    private companion object {
        const val TAG = "CICLO_PDM_TAG"
    }


    //métodos CICLO DE VIDA
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(amb.root) //a view usada sera a view root da amb
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

}

