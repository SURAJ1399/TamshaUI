package com.example.android.rvtutorial




import android.content.Context
import android.os.CountDownTimer
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import net.developers.ttamasha.R
import net.developers.ttamasha.databinding.ListItemverticalBinding
import net.developers.ttamasha.model.GetEventsItem

import java.lang.String
import java.util.concurrent.TimeUnit


class AllEventsAdapter

    :RecyclerView.Adapter<ArtistViewHolder>(){

lateinit var context:Context
  var events:ArrayList<GetEventsItem> = ArrayList()
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

   return events.size
    }

    override fun onBindViewHolder(holder: ArtistViewHolder, position: Int) {




        ListItemverticalBinding.bind(holder.itemView).apply {
//            object : CountDownTimer(300000, 1000) {
//                override fun onTick(millis: Long) {
////                    val hms = String.format(
////                        "%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis),
////                        TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(
////                            TimeUnit.MILLISECONDS.toHours(
////                                millis
////                            )
////                        ),
////                        TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(
////                            TimeUnit.MILLISECONDS.toMinutes(millis)
////                        )
////                    )
//
//                    starts.setText("Starts in 00:00:00")
//                    //here you can have your logic to set text to edittext
//                }
//
//                override fun onFinish() {
//                    //mTextField.setText("done!")
//                }
//            }.start()
//            if(position==0|| position==5 ||position==9)
//            {
//                green.visibility=View.VISIBLE
//                entry.visibility=View.GONE
//                starts.visibility=View.INVISIBLE
//
//            }
            eventName.setText(events.get(position).eventName)
            name.setText("Host ID:- "+events.get(position).eventHost)
            entryFee.setText("Entry ₹ "+events.get(position).entryFee)
            Glide.with(context).load(events.get(position).imageURL)
                .into(profileImageSmall)
            Glide.with(context).load(events.get(position).imageURL)
                .into(profileImage)

            val sdf = java.text.SimpleDateFormat("yyyy-MM-dd")
           val date = java.util.Date(events.get(position).eventTime)

            evDate.setText(sdf.format(date))

        }
    }
    fun updatealb(_events:ArrayList<GetEventsItem>)
    {
        Log.i("resp",_events.size.toString())
        events.addAll(_events)
        notifyDataSetChanged()
    //notifyItemInserted(events.size-1)
    }



}

class ArtistViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {



}
