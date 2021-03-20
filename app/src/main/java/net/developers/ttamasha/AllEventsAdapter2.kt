package com.example.android.rvtutorial




import android.content.Context
import android.content.Intent
import android.os.CountDownTimer
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import net.developers.ttamasha.R
import net.developers.ttamasha.databinding.ListItemverticalBinding
import java.lang.String
import java.util.concurrent.TimeUnit


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



        ListItemverticalBinding.bind(holder.itemView).apply {
            object : CountDownTimer(300000, 1000) {
                override fun onTick(millis: Long) {
                    val hms = String.format(
                        "%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis),
                        TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(
                            TimeUnit.MILLISECONDS.toHours(
                                millis
                            )
                        ),
                        TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(
                            TimeUnit.MILLISECONDS.toMinutes(millis)
                        )
                    )

                    starts.setText("Starts in " +hms)
                    //here you can have your logic to set text to edittext
                }

                override fun onFinish() {
                    //mTextField.setText("done!")
                }
            }.start()

        }


}

class ArtistViewHolderb(itemView: View): RecyclerView.ViewHolder(itemView) {


}
}

