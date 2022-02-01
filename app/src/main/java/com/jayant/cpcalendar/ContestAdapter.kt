package com.jayant.cpcalendar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContestAdapter(var contestList: ArrayList<ContestData>, var key: String) : RecyclerView.Adapter<ContestViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContestViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_contest, parent, false)
        return ContestViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContestViewHolder, position: Int) {

        holder.contestName.text = contestList[position].title
        holder.contestSite.text = contestList[position].site
    }

    override fun getItemCount(): Int {
        return contestList.size
    }
}

class ContestViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var contestName : TextView = itemView.findViewById(R.id.contest_name)
    var contestSite : TextView = itemView.findViewById(R.id.contest_site)
}