package com.jayant.cpcalendar

import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class ContestAdapter(var contestList: ArrayList<ContestData>, var key: String) : RecyclerView.Adapter<ContestViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContestViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_contest, parent, false)
        return ContestViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContestViewHolder, position: Int) {

        holder.contestName.text = contestList[position].title
        holder.contestSite.text = contestList[position].site

        holder.contestRow.setOnClickListener {
//            Log.d("debug", contestList[position].url)
//            Toast.makeText(holder.contestName.context, contestList[position].url, Toast.LENGTH_SHORT).show()
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(contestList[position].url))
            holder.contestSite.context.startActivity(browserIntent)

//            when(key) {
//                "codeforces" -> {
//                    if(key == "CodeForces") {
//                        contestList.add(ContestData(contestName,siteName))
//                    }
//                }
//                "codechef" -> {
//                    if(key == "CodeChef") {
//                        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.codechef.com/contests?itm_medium=navmenu&itm_campaign=allcontests"))
//                        holder.contestSite.context.startActivity(browserIntent)
//                    }
//                }
//                "hackerrank" -> {
//                    if(key == "HackerRank") {
//                        contestList.add(ContestData(contestName, siteName))
//                    }
//                }
//                "hackerearth" -> {
//                    if(key == "HackerEarth") {
//                        contestList.add(ContestData(contestName, siteName))
//                    }
//                }
//                "leetcode" -> {
//                    if(key == "LeetCode")
//                        contestList.add(ContestData(contestName, siteName))
//
//                }
//                "atcoder" -> {
//                    if(key == "AtCoder") {
//                        contestList.add(ContestData(contestName, siteName))
//                    }
//                }
//                else -> {
//                    contestList.add(ContestData(contestName, siteName))
//                }
//            }

//            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.codechef.com/contests?itm_medium=navmenu&itm_campaign=allcontests"))
//            holder.contestSite.context.startActivity(browserIntent)
        }
    }

    override fun getItemCount(): Int {
        return contestList.size
    }
}

class ContestViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var contestName : TextView = itemView.findViewById(R.id.contest_name)
    var contestSite : TextView = itemView.findViewById(R.id.contest_site)
    var contestRow : CardView = itemView.findViewById(R.id.contest_row)
}