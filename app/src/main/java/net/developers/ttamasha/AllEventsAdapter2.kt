package com.example.android.rvtutorial




import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import net.developers.ttamasha.R
import net.developers.ttamasha.databinding.ListItemverticalBinding


class AllEventsAdapter2

    :RecyclerView.Adapter<AllEventsAdapter2.ArtistViewHolderb>(){

lateinit var context:Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistViewHolderb {
context=parent.context
        return ArtistViewHolderb(
                parent.context.getSystemService(LayoutInflater::class.java).inflate(
                        R.layout.list_item,
                        parent,
                        false
                )
        )
    }

    override fun getItemCount(): Int {

   return 10
    }

    override fun onBindViewHolder(holder: ArtistViewHolderb, position: Int) {






}

class ArtistViewHolderb(itemView: View): RecyclerView.ViewHolder(itemView) {


}
}

