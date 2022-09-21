package com.giovani.pdm.ciclopdm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.giovani.pdm.ciclopdm.databinding.ActivityMainBinding

//sem modificador 'open', uma classe não pode ser herdada

// ':' substitui o extends ou implements do java

class MainActivity : AppCompatActivity() {

    //criar instancia de um Objeto ActivityMainBinding
    //lateinit var são vars q serão inicializadas depois
    private lateinit var amb: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //PRECISA chamar o inflator pra minha var de activityMainBinding após o onCreate:
        amb = ActivityMainBinding.inflate(layoutInflater)

        setContentView(R.layout.activity_main)
    }
}

