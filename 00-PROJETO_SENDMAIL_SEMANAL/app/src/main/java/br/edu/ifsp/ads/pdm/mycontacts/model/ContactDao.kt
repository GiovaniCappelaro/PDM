package br.edu.ifsp.ads.pdm.mycontacts.model

interface ContactDao {
    //INTERFACE de acesso ao banco de dados

    fun createContact(contact: Contact):Int

    fun retrieveContact(id: Int):Contact?

    fun retrieveContacts():MutableList<Contact>

    fun updateContact(contact: Contact): Int

    fun deleteContact(id: Int):Int

}