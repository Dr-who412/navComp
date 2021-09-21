package com.example.navcomp

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvmtask.Data.modeldata
import com.example.navcomp.frag.BlankFragment_1Directions

class CustomAdapter(var data:ArrayList<modeldata>, var productsFragment: View) : RecyclerView.Adapter<CustomAdapter.ViewHolder>(){
    class ViewHolder(itemView:View) :RecyclerView.ViewHolder(itemView){

        val name : TextView = itemView.findViewById(R.id.name2)
        val description : TextView = itemView.findViewById(R.id.description2)
        val image : ImageView = itemView.findViewById(R.id.image2)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_row,parent,false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var list = data[position]

        holder.name.text = "     ${list.name}   "
        holder.description.text = "about :    ${list.description}"
        Glide.with(productsFragment).load(list.image_url).into(holder.image)
        holder.itemView.setOnClickListener {
            var action = BlankFragment_1Directions.actionBlankFragment1ToBlankFragment2(list.name,list.image_url,list.description)
            Navigation.findNavController(productsFragment).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return  data.size
    }
}