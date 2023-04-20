package com.example.api_featch_newsapp2.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.api_featch_newsapp2.Model.Article_model
import com.example.api_featch_newsapp2.R

class myAdapter(var context: Context, var newsdatalist: ArrayList<Article_model>) :
    RecyclerView.Adapter<myAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {


        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_items, parent, false)
        return ViewHolder(view)


    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var mymodel = newsdatalist[position]
        holder.txttile.text = mymodel.source.name
        holder.txtdes.text = mymodel.description

        var urlString = mymodel.url

        Glide.with(context).load(mymodel.urlToImage).into(holder.newsImage)


    }

    override fun getItemCount(): Int {
        return newsdatalist.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var txttile = itemView.findViewById<TextView>(R.id.tv_headline)
        var txtdes = itemView.findViewById<TextView>(R.id.tv_des)
        var newsImage = itemView.findViewById<ImageView>(R.id.newsImage)
        var btn = itemView.findViewById<Button>(R.id.btnurl)
        var btn_share = itemView.findViewById<Button>(R.id.btnshare)

    }
}