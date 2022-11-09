package br.edu.ifsp.ads.pdm.mycontacts.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import br.edu.ifsp.ads.pdm.mycontacts.databinding.ActivityContactBinding
import br.edu.ifsp.ads.pdm.mycontacts.model.Constant.EXTRA_CONTACT
import br.edu.ifsp.ads.pdm.mycontacts.model.Constant.VIEW_CONTACT
import br.edu.ifsp.ads.pdm.mycontacts.model.Contact
import kotlin.random.Random

class ContactActivity : AppCompatActivity() {
    private val acb: ActivityContactBinding by lazy {
        ActivityContactBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(acb.root)

        val recievedContact = intent.getParcelableExtra<Contact>(EXTRA_CONTACT)

        recievedContact?.let { _recievedContact ->
            with(acb){
                nameEt.setText(_recievedContact.name)
                addressEt.setText(_recievedContact.address)
                phoneEt.setText(_recievedContact.phone)
                emailEt.setText(_recievedContact.email)
            }

        } //_recievedContact é o objeto de contato em si
        //intent pra visualizar o contato:
        val viewContact = intent.getBooleanExtra(VIEW_CONTACT, false)
        if(viewContact){
            acb.nameEt.isEnabled = false
            acb.addressEt.isEnabled = false
            acb.phoneEt.isEnabled = false
            acb.emailEt.isEnabled = false

            acb.saveBt.visibility = View.GONE  //esconde o botão de salvar por n precisar dele aqui
        }

        acb.saveBt.setOnClickListener {
            val contact = Contact(
                id = recievedContact?.id?: Random(System.currentTimeMillis()).nextInt(),
                name = acb.nameEt.text.toString(),
                address = acb.addressEt.text.toString(),
                phone = acb.phoneEt.text.toString(),
                email = acb.emailEt.text.toString(),
            )
            val resultIntent = Intent()
            resultIntent.putExtra(EXTRA_CONTACT, contact)
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}