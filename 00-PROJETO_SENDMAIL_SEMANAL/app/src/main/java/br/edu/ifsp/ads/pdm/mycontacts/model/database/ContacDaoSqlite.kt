package br.edu.ifsp.ads.pdm.mycontacts.model.database

import android.content.ContentValues
import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import br.edu.ifsp.ads.pdm.mycontacts.R
import br.edu.ifsp.ads.pdm.mycontacts.model.entity.Contact
import br.edu.ifsp.ads.pdm.mycontacts.model.dao.ContactDao
import java.sql.SQLException

class ContacDaoSqlite(context: Context): ContactDao {
    //criar uma conexão(ainda não é uma)
    companion object Constant {
        private const val CONTACT_DATABASE_FILE = "contacts"
        private const val CONTACT_TABLE = "contact"
        private const val ID_COLUMN = "id"
        private const val NAME_COLUMN = "name"
        private const val ADDRESS_COLUMN = "address"
        private const val PHONE_COLUMN = "phone"
        private const val EMAIL_COLUMN = "email"

        private const val CREATE_CONTACT_TABLE_STATEMENT =
            "CREATE TABLE IF NOT EXISTS $CONTACT_TABLE ( " +
                    " $ID_COLUMN INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    " $NAME_COLUMN TEXT NOT NULL, " +
                    " $ADDRESS_COLUMN TEXT NOT NULL, " +
                    " $PHONE_COLUMN TEXT NOT NULL, " +
                    " $EMAIL_COLUMN TEXT NOT NULL ); "
    }

    //Referencia para o banco de dados sqlite:
    private val contactSqliteDatabase: SQLiteDatabase
    init{
        //criar ou abrir o banco:
        contactSqliteDatabase = context.openOrCreateDatabase(
            CONTACT_DATABASE_FILE,
            MODE_PRIVATE,
            null
        )
        try {
            //criar a tabela dentro do banco criado
            contactSqliteDatabase.execSQL(CREATE_CONTACT_TABLE_STATEMENT)
        }
        catch (se: SQLException){
            Log.e(context.getString(R.string.app_name), se.toString()) //exibe qual foi o erro
        }
    }


    //transformar objeto contato em hashmap:
    private fun Contact.toContentValues() = with(ContentValues()) {
        put(NAME_COLUMN, name)
        put(ADDRESS_COLUMN, address)
        put(PHONE_COLUMN, phone)
        put(EMAIL_COLUMN, email)
        this
    }

    private fun Cursor.rowToContact() = Contact(
        getInt(getColumnIndexOrThrow(ID_COLUMN)),
        getString(getColumnIndexOrThrow(NAME_COLUMN)),
        getString(getColumnIndexOrThrow(ADDRESS_COLUMN)),
        getString(getColumnIndexOrThrow(PHONE_COLUMN)),
        getString(getColumnIndexOrThrow(EMAIL_COLUMN)),
    ) //monta o objeto contact com os itens da tabela pelo indice



    //métodos obrigatórios:
    override fun createContact(contact: Contact) = contactSqliteDatabase.insert(
            CONTACT_TABLE,
            null, //pra não passar o insert em linha
            contact.toContentValues()
        ).toInt()


    override fun retrieveContact(id: Int): Contact? {
        val cursor = contactSqliteDatabase.rawQuery(
            "SELECT * FROM $CONTACT_TABLE WHERE $ID_COLUMN = ?",
            arrayOf(id.toString())
        )
        val contact = if(cursor.moveToFirst()){
            cursor.rowToContact()
        }
        else{
            null
        }
        cursor.close()
        return contact
    }

    override fun retrieveContacts(): MutableList<Contact> {
        val contactList = mutableListOf<Contact>() //lista de contatos para ser populada e retornada
        //consulta de todos os contatos no banco:
        val cursor = contactSqliteDatabase.rawQuery(
            "SELECT * FROM $CONTACT_TABLE ORDER BY $NAME_COLUMN",
            null
        )
        //objeto cursor devolve os dados(percorre a tabela) em forma de objeto - moveToNext() vai passando pelas linhas e
        while(cursor.moveToNext()){
            contactList.add(cursor.rowToContact()) //chama a função
        }

        return contactList

    }

    override fun updateContact(contact: Contact) = contactSqliteDatabase.update(
        CONTACT_TABLE, //qual tabela
        contact.toContentValues(), //quais dados
        "$ID_COLUMN = ?", //onde (WHERE - em qual coluna no caso)
        arrayOf(contact.id.toString()) //argumentos do where

    )

    override fun deleteContact(id: Int) = contactSqliteDatabase.delete(
        CONTACT_TABLE,
        "$ID_COLUMN = ?", //onde (WHERE - em qual coluna no caso)
        arrayOf(id.toString())
    )

}