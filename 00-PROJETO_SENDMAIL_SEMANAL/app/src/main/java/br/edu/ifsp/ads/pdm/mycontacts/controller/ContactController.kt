package br.edu.ifsp.ads.pdm.mycontacts.controller

import br.edu.ifsp.ads.pdm.mycontacts.model.database.ContacDaoSqlite
import br.edu.ifsp.ads.pdm.mycontacts.model.entity.Contact
import br.edu.ifsp.ads.pdm.mycontacts.model.dao.ContactDao
import br.edu.ifsp.ads.pdm.mycontacts.view.MainActivity

class ContactController(private val mainActivity: MainActivity) {
    private val contactDaoImpl: ContactDao = ContacDaoSqlite(mainActivity)

    fun insertContact(contact: Contact) = contactDaoImpl.createContact(contact)

    fun getContact(id: Int) = contactDaoImpl.retrieveContact(id)

    fun getContacts() {

        Thread(){
            val returnedList = contactDaoImpl.retrieveContacts()
            mainActivity.updateContactList(returnedList)
        }.start()

        val returnedList = contactDaoImpl.retrieveContacts()
        mainActivity.updateContactList(returnedList)
    }

    fun editContact(contact: Contact) = contactDaoImpl.updateContact(contact)

    fun removeContact(id: Int) = contactDaoImpl.deleteContact(id)
}