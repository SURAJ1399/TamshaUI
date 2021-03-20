package net.developers.ttamasha.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android.rvtutorial.AllEventsAdapter
import com.example.android.rvtutorial.AllEventsAdapter2
import net.developers.ttamasha.R

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
lateinit var allEventsAdapter: AllEventsAdapter
    lateinit var alleventsrecycler:RecyclerView
    lateinit var allEventsAdapter2: AllEventsAdapter2
    lateinit var alleventsrecycler2:RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        alleventsrecycler=root.findViewById(R.id.alleventsrecycler)
        allEventsAdapter= AllEventsAdapter()
        alleventsrecycler?.layoutManager = GridLayoutManager(activity,2)
        alleventsrecycler?.adapter = allEventsAdapter

        alleventsrecycler2=root.findViewById(R.id.alleventsrecycler2)
        allEventsAdapter2= AllEventsAdapter2()
        alleventsrecycler2?.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false)
        alleventsrecycler2?.adapter = allEventsAdapter2

        return root
    }
}