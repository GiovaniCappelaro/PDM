package br.edu.ifsp.ads.pdm.mycontacts.view

import android.content.Intent
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.AdapterContextMenuInfo
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.ads.pdm.mycontacts.R
import br.edu.ifsp.ads.pdm.mycontacts.adapter.ContactAdapter
import br.edu.ifsp.ads.pdm.mycontacts.controller.ContactController
import br.edu.ifsp.ads.pdm.mycontacts.controller.ContactRoomController
import br.edu.ifsp.ads.pdm.mycontacts.databinding.ActivityMainBinding
import br.edu.ifsp.ads.pdm.mycontacts.model.Constant.EXTRA_CONTACT
import br.edu.ifsp.ads.pdm.mycontacts.model.Constant.VIEW_CONTACT
import br.edu.ifsp.ads.pdm.mycontacts.model.entity.Contact

class MainActivity : AppCompatActivity() {
    private val amb: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    // Data source
    private val contactList: MutableList<Contact> = mutableListOf() //contactList inicia vazia

    // Adapter
    private lateinit var contactAdapter: ContactAdapter

    private lateinit var carl: ActivityResultLauncher<Intent>

    //controller (para sqlite -> agor Room):
    private val contactController: ContactRoomController by lazy {
        ContactRoomController(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(amb.root)

        contactAdapter = ContactAdapter(this, contactList)
        amb.contactsLv.adapter = contactAdapter

        carl = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult(),
        ) { result ->
            if (result.resultCode == RESULT_OK) {
                val contact = result.data?.getParcelableExtra<Contact>(EXTRA_CONTACT)
                contact?.let { _contact->

                    if(_contact.id != null){
                        val position = contactList.indexOfFirst { it.id == _contact.id }
                        if(position != -1){
                            contactController.editContact(_contact)
                        }
                    }
                    else{
                        contactController.insertContact(_contact)
                    }
                }
            }


        }

        registerForContextMenu(amb.contactsLv) //vincular a listView pra funcionar o contextMenu

        //listener pra click rapido:
        amb.contactsLv.onItemClickListener = object: AdapterView.OnItemClickListener{
            override fun onItemClick(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val contact = contactList[position]
                //intent pra pegar o contato pelo clik rapido e mandar pra lista:
                val contactIntent = Intent(this@MainActivity, ContactActivity::class.java)
                contactIntent.putExtra(EXTRA_CONTACT, contact)
                contactIntent.putExtra(VIEW_CONTACT, true)
                startActivity(contactIntent)
            }
        }

        //buscar contatos no banco
        contactController.getContacts()

    }

    //metodos tratar do menu

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.addContactMi -> {
                carl.launch(Intent(this, ContactActivity::class.java))
                true
            }
            else -> { false }
        }
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        menuInflater.inflate(R.menu.context_menu_main, menu) //inflar o menu de contexto(aparece ao segurar)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val position = (item.menuInfo as AdapterContextMenuInfo ).position //pegar posição do item do menu
        val contact = contactList[position]
        return when(item.itemId){
            R.id.removeContactMi -> {
                //remove o contato da lista:
                contactController.removeContact(contact) //remover contato do banco ANTES DE REMOVER DA LISTA
                contactList.removeAt(position)
                contactAdapter.notifyDataSetChanged()  //avisar o data source da exclusão
                true
            }
            R.id.editContactMi ->{
                val contactIntent = Intent(this, ContactActivity::class.java)
                contactIntent.putExtra(EXTRA_CONTACT, contact)
                contactIntent.putExtra(VIEW_CONTACT, false)
                carl.launch(contactIntent)
                true
            }
            else -> {false}
        }
    }

    //função de callback falsa
    fun updateContactList(_contacList: MutableList<Contact>){
        contactList.clear()
        contactList.addAll(_contacList)
        contactAdapter.notifyDataSetChanged()
    }

}