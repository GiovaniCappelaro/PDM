package br.edu.ifsp.ads.pdm.mycontacts.controller

import br.edu.ifsp.ads.pdm.mycontacts.model.ContacDaoSqlite
import br.edu.ifsp.ads.pdm.mycontacts.model.Contact
import br.edu.ifsp.ads.pdm.mycontacts.model.ContactDao
import br.edu.ifsp.ads.pdm.mycontacts.view.MainActivity

class ContactController(mainActivity: MainActivity) {
    private val contactDaoImpl: ContactDao = ContacDaoSqlite(mainActivity)

    fun insertContact(contact: Contact) = contactDaoImpl.createContact(contact)

    fun getContact(id: Int) = contactDaoImpl.retrieveContact(id)

    fun getContacts() = contactDaoImpl.retrieveContacts()

    fun editContact(contact: Contact) = contactDaoImpl.updateContact(contact)

    fun removeContact(id: Int) = contactDaoImpl.deleteContact(id)
}