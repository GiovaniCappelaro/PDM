package com.giovani.pdm.mycontacts.adapter

import android.content.Context
import android.content.Context.LAYOUT_INFLATER_SERVICE
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.giovani.pdm.mycontacts.R
import com.giovani.pdm.mycontacts.databinding.TileContactBinding
import com.giovani.pdm.mycontacts.model.Contact

class ContactAdapter (
    context: Context,
    private val contactList: MutableList<Contact>) : ArrayAdapter<Contact>(context, R.layout.tile_contact, contactList){
    //private data class Tile
    private lateinit var tcb: TileContactBinding

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val contact = contactList[position]
        var contactTileView = convertView

        //tratar solicitação de view
        if(contactTileView == null){
            //inflo uma nova celula e a que pedi não existe
            tcb = TileContactBinding.inflate(
                context.getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater,
                parent,
                false

            )
           /* val view = (context.getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater).inflate(
                R.layout.tile_contact,
                parent,
                false
            ) */
            contactTileView = tcb.root
        }
        tcb.nameTv.text = contact.name
        tcb.emailTv.text = contact.email

        return contactTileView
    }
}

//tile = "telha" -> Cada item da lista