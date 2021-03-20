package com.example.android.rvtutorial




import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.marginTop
import androidx.recyclerview.widget.RecyclerView

import net.developers.ttamasha.R
import net.developers.ttamasha.databinding.ListItemverticalBinding


class AllEventsAdapter

    :RecyclerView.Adapter<ArtistViewHolder>(){

lateinit var context:Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistViewHolder {
context=parent.context
        return ArtistViewHolder(
                parent.context.getSystemService(LayoutInflater::class.java).inflate(
                        R.layout.list_itemvertical,
                        parent,
                        false
                )
        )
    }

    override fun getItemCount(): Int {

   return 10
    }

    override fun onBindViewHolder(holder: ArtistViewHolder, position: Int) {
        ListItemverticalBinding.bind(holder.itemView).apply {

            if(position==0|| position==6)
            imageview.setBackgroundResource(R.drawable.vu)

        }
    }




}

class ArtistViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {



}
