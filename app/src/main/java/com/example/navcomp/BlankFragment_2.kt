package com.example.navcomp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide


lateinit var name2:TextView
lateinit var about2:TextView
lateinit var Image2:ImageView

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment_2.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragment_2 : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var name= arguments?.getString("name")
        var about=arguments?.getString("about")
        var image=arguments?.getString("image")
        if(name!=null&&image!=null&&about!=null)
            show(view,name, about,image)

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {


        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank_2, container, false)
    }
    fun show(view: View,name:String,description:String,image:String){
        name2 = view.findViewById(R.id.name2)
        about2 = view.findViewById(R.id.description2)
        Image2 = view.findViewById(R.id.image2)
        name2.text = "Name : $name"
        about2.text = "Description : $description"
        Glide.with(view.context).load(image).into(Image2)
    }
}