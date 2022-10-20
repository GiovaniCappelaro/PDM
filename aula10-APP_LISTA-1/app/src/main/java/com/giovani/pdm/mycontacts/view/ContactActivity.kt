package com.giovani.pdm.mycontacts.view

//por hora lida com salvar um novo contato

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.giovani.pdm.mycontacts.databinding.ActivityContactBinding
import com.giovani.pdm.mycontacts.databinding.ActivityMainBinding
import com.giovani.pdm.mycontacts.model.Constant.EXTRA_CONTACT
import com.giovani.pdm.mycontacts.model.Contact
import kotlin.random.Random

class ContactActivity : AppCompatActivity() {

    private val acb: ActivityContactBinding by lazy {
        ActivityContactBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(acb.root)

        //listenner no botão de salvar:
        acb.saveBt.setOnClickListener{
            val contact = Contact(
                id = Random(System.currentTimeMillis()).nextInt(),
                name = acb.nameEt.text.toString(),
                address = acb.addressEt.text.toString(),
                phone = acb.phoneEt.text.toString(),
                email = acb.emailEt.text.toString()
            )//criar objeto contato


            //devolver objeto contato pra main activity através de intent
            val resultIntent = Intent()
            resultIntent.putExtra(EXTRA_CONTACT, contact)
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}