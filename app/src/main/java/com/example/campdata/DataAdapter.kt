package com.example.campdata

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.campdata.data.Programs


class CampdataAdapter ( var Programs:List<Programs>) :RecyclerView.Adapter<CampdataAdapter.Campdataholder>() {


    //viewholder class
    inner class Campdataholder(itemview : View)  : RecyclerView.ViewHolder(itemview){
        val tvprogramname =itemview.findViewById<TextView>(R.id.tv_programname)
        var tvcode =itemview.findViewById<TextView>(R.id.tv_code)
//        var icplus =itemview.findViewById<ImageView>(R.id.img_plus)
//        var icminus =itemview.findViewById<ImageView>(R.id.img_minus)
//        var icdelete =itemview.findViewById<ImageView>(R.id.img_delete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Campdataholder{
        //layout to inflate to the recycler view
        val view = LayoutInflater.from(parent.context).inflate(R.layout.program_item,parent,false)
        return Campdataholder(view)
    }

    override fun onBindViewHolder(holder: Campdataholder, position: Int) {
        //set values or listeners for the views
        var currentprogram=Programs[position]

        holder.tvprogramname.text=currentprogram.Name
        holder.tvcode.text=currentprogram.Code




    }

    override fun getItemCount(): Int {
        return Programs.size
    }
}