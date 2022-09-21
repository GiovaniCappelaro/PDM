package com.giovani.pdm.ciclopdm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(amb.root) //a view usada sera a view root da amb
    }
}

