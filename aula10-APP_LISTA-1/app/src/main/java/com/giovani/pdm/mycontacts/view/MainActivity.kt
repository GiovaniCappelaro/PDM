package com.giovani.pdm.mycontacts.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.giovani.pdm.mycontacts.R
import com.giovani.pdm.mycontacts.databinding.ActivityMainBinding
import com.giovani.pdm.mycontacts.model.Constant.EXTRA_CONTACT
import com.giovani.pdm.mycontacts.model.Contact

class MainActivity : AppCompatActivity() {

    private val amb: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    //criar DATA SOURCE (alimenta o adapter pra chamar as novas celulas):
    private val contactList: MutableList<Contact> = mutableListOf()

    //adapter:
    private val contactAdapter: ArrayAdapter<String> by lazy {
        ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            contactList.map { it.name }//converte cada contato pra String
        )
    }

    //chamar a tela de contato (Create Activity Result Launcher) --> usado na Oncreate
    private lateinit var carl: ActivityResultLauncher<Intent>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(amb.root)

        fillContactList()
        amb.contactsLv.adapter = contactAdapter //diz q o listView vai usar o adapter 'contactAdapter'

        //chamar a tela de contato
        carl = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult(),
        ) {
            result ->
            if(result.resultCode == RESULT_OK){ //se clicou em salvar
                val contact = result.data?.getParcelableExtra<Contact>(EXTRA_CONTACT) //pega o contato em si da lista
                contact?.let { _contact ->
                    contactList.add(_contact) //add contato na lista de contato
                    contactAdapter.add(_contact.name) //add contato na lista do data Source
                    contactAdapter.notifyDataSetChanged() //notifica o adapter
                }
            }
        }

    }

    //funções pra lidar com menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId){
            R.id.addContactMi -> {
                carl.launch(Intent(this, ContactActivity::class.java)) //cria intent pra abrir a contact activity
                true
            }
            else -> {false}
        }
    }


    //função preencher lista de contatos(TEMPORÁRIO)
    private fun fillContactList(){
        for (i in 1 .. 10 ){
            contactList.add(
                Contact(
                    id = i,
                    name = "Nome $i",
                    address= "Endereço $i",
                    phone="Telefone $i",
                    email="email $i"
                )
            )
        }
    }
}