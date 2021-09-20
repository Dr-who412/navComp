package com.example.navcomp.frag

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.navcomp.CustomAdapter
import com.example.navcomp.MyViewModel
import com.example.navcomp.R

class BlankFragment_1 : Fragment() {

    lateinit var recyclerView: RecyclerView
    lateinit var cardView: CardView
    lateinit var adapter: CustomAdapter
    lateinit var nav: Navigation
    var myViewModel : MyViewModel = MyViewModel()
    lateinit var swipe: SwipeRefreshLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        makeView(view)
        swipe = view.findViewById(R.id.swipe)
        swipe.setOnRefreshListener {
            makeView(view)
            Toast.makeText(view.context,"Refresh done",Toast.LENGTH_SHORT).show()
            swipe.isRefreshing = false
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.blank_fragment_1_fragment, container, false)

    }

    fun makeView(view: View) {
        myViewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        myViewModel.getProducts()
        myViewModel.getProduct().observe(viewLifecycleOwner, Observer {
            recyclerView = view.findViewById(R.id.card2)
            adapter = CustomAdapter(it,view)
            recyclerView.layoutManager  = LinearLayoutManager(view.context)
            recyclerView.adapter = adapter
        })

        myViewModel.error_message.observe(viewLifecycleOwner , Observer {
            Toast.makeText(view.context , it, Toast.LENGTH_SHORT).show()

        })
    }
}
