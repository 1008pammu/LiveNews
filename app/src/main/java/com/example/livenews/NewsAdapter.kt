package com.example.livenews

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class NewsAdapter(val list: List<String>,private val listener: NewsItemClicked):RecyclerView.Adapter<NewsAdapter.NewsViewholder>() {


    class NewsViewholder(itemView: View):RecyclerView.ViewHolder(itemView){
var news_title=itemView.findViewById<TextView>(R.id.news_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewholder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.news_holder,parent,false)
        val viewholder=NewsViewholder(view)
        view.setOnClickListener {

            listener.OnItemClicked(list[viewholder.adapterPosition])
        }

        return viewholder
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: NewsViewholder, position: Int) {
      holder.news_title.text=list[position].toString()
    }
}
interface NewsItemClicked{
    fun OnItemClicked(item :String){ }
}