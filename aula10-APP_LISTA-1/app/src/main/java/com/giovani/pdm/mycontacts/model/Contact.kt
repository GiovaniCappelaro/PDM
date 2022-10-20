package com.giovani.pdm.mycontacts.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

//CLASSE PARA DADOS QUE VAI REPRESENTAR OS CONTATOS Q SERÃO ADD A UMA LISTA (ACTIVITY)

@Parcelize
data class Contact(
    val id: Int,
    var name: String,
    var address: String,
    var phone: String,
    var email: String,

): Parcelable
/*Parcelize é para poder mandar objetos de uma activity pra outra nas intents
-> Torna serializavel
 */


