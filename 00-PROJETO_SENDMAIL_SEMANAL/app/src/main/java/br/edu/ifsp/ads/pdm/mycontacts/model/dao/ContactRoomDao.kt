package br.edu.ifsp.ads.pdm.mycontacts.model.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import br.edu.ifsp.ads.pdm.mycontacts.model.entity.Contact
@Dao
interface ContactRoomDao {
    //INTERFACE de acesso ao banco de dados usando o Room

    companion object Constant {
        const val CONTACT_DATABASE_FILE = "contacts_room"
        const val CONTACT_TABLE = "contact"
        const val ID_COLUMN = "id"
        const val NAME_COLUMN = "name"
    }

    @Insert
    fun createContact(contact: Contact)

    @Query("SELECT * FROM $CONTACT_TABLE WHERE $ID_COLUMN = :id")
    fun retrieveContact(id: Int): Contact?

    @Query("SELECT * FROM $CONTACT_TABLE ORDER BY $NAME_COLUMN")
    fun retrieveContacts():MutableList<Contact>

    @Update
    fun updateContact(contact: Contact): Int

    @Delete
    fun deleteContact(contact: Contact):Int

}