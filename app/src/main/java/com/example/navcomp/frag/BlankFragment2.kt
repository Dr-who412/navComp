package com.example.navcomp.frag

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.navcomp.R

class BlankFragment2 : Fragment() {
    lateinit var nameView: TextView
    lateinit var imageView : ImageView
    lateinit var descriptionView:TextView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var name = arguments?.getString("name")
        var image = arguments?.getString("image")
        var description = arguments?.getString("description")
        if(name!=null&&image!=null&&description!=null)
            showData(view,name,description,image)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank2, container, false)
    }
    fun showData(view: View,name:String,description:String,image:String){
        nameView = view.findViewById(R.id.name2)
        imageView = view.findViewById(R.id.image2)
        descriptionView = view.findViewById(R.id.description2)
        nameView.text = "Name : $name"
        descriptionView.text = "Description : $description"
        Glide.with(view.context).load(image).into(imageView)
    }
}