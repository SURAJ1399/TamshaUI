package net.developers.ttamasha.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android.rvtutorial.AllEventsAdapter
import com.example.android.rvtutorial.AllEventsAdapter2
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.CoroutineScope
import net.developers.ttamasha.R
import net.developers.ttamasha.model.GetEventsItem
import net.developers.ttamasha.viewmodel.GetEventViewModel

@AndroidEntryPoint
class HomeFragment : Fragment() {


    lateinit var allEventsAdapter: AllEventsAdapter
    lateinit var alleventsrecycler:RecyclerView
    lateinit var nestedScrollView:NestedScrollView
    lateinit var allEventsAdapter2: AllEventsAdapter2
    lateinit var alleventsrecycler2:RecyclerView
    var isLoading=false
    private lateinit var scrollListener: RecyclerView.OnScrollListener
    val getEventsViewModel:GetEventViewModel by activityViewModels()
    lateinit var layoutManager:GridLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_home, container, false)
        alleventsrecycler=root.findViewById(R.id.alleventsrecycler)
        nestedScrollView=root.findViewById(R.id.nestedscrollvieww)
        allEventsAdapter= AllEventsAdapter()
        layoutManager= GridLayoutManager(activity,2)
        alleventsrecycler?.layoutManager = layoutManager
        alleventsrecycler?.adapter = allEventsAdapter

        alleventsrecycler2=root.findViewById(R.id.alleventsrecycler2)
        allEventsAdapter2= AllEventsAdapter2()
        alleventsrecycler2?.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false)
        alleventsrecycler2?.adapter = allEventsAdapter2
        alleventsrecycler.setHasFixedSize(true);
        alleventsrecycler.setItemViewCacheSize(30)

        nestedScrollView.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener { v: NestedScrollView, scrollX: Int, scrollY: Int, oldScrollX: Int, oldScrollY: Int ->
            if (v.getChildAt(v.childCount - 1) != null) {
                if (scrollY >= v.getChildAt(v.childCount - 1)
                        .measuredHeight - v.measuredHeight &&
                    scrollY > oldScrollY
                ) {
                    //code to fetch more data for endless scrolling
                    val visibleItemcount=layoutManager.childCount
                    val pastvisibleItemcount=layoutManager.findLastCompletelyVisibleItemPosition()
                    val total =allEventsAdapter.itemCount
             //       Toast.makeText(context,pastvisibleItemcount.toString()+" "+visibleItemcount.toString()+" "+total,Toast.LENGTH_SHORT).show()
                    if(!isLoading)
                    {
                    if(pastvisibleItemcount+visibleItemcount>=total)
                    {   ///Toast.makeText(context,"No Data Found",Toast.LENGTH_SHORT).show()
                         progress.visibility=View.VISIBLE
                         getmoreEvents()

                    }
                    }
                }
            }
        } )


        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getmoreEvents()

        getEventsViewModel.tags.observe({lifecycle}){
            if(it==null)
            {   Toast.makeText(context,"No Data Found",Toast.LENGTH_SHORT).show()
               // progress.visibility = View.GONE
                isLoading = false
            }
            else {
                allEventsAdapter.updatealb(it as ArrayList<GetEventsItem>)
            //  progress.visibility = View.GONE
                isLoading = false
            }
            }

    }

    fun getmoreEvents(){

        isLoading=true

        getEventsViewModel.fetchevents()
        progress.visibility=View.VISIBLE
      // Toast.makeText(context,allEventsAdapter.itemCount.toString(),Toast.LENGTH_SHORT).show()



    }

}