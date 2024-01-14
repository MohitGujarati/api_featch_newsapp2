package com.example.api_featch_newsapp2.Adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.api_featch_newsapp2.Model.Article_model
import com.example.api_featch_newsapp2.R
import com.google.android.material.button.MaterialButton
import java.io.IOException


class myAdapter(var context: Context, var newsdatalist: ArrayList<Article_model>) :
    RecyclerView.Adapter<myAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {


        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_items, parent, false)
        return ViewHolder(view)


    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val mymodel = newsdatalist[position]
        holder.txttile.text = mymodel.title
        holder.txtdes.text = mymodel.description
        holder.tv_publish.text = " ${mymodel.source.name}"

        Log.i("newsContent","${mymodel.content}")

        val urlString = mymodel.url

        holder.btn.setOnClickListener {
            try {
                context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(urlString)))
            }catch (e:IOException){
                Toast.makeText(context, "Try again later", Toast.LENGTH_SHORT).show()
            }

        }

        Glide.with(context).load(mymodel.urlToImage).into(holder.newsImage)


    }

    override fun getItemCount(): Int {
        return newsdatalist.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var txttile = itemView.findViewById<TextView>(R.id.tv_headline)
        var txtdes = itemView.findViewById<TextView>(R.id.tv_des)
        var tv_publish = itemView.findViewById<TextView>(R.id.tv_publish)
        var newsImage = itemView.findViewById<ImageView>(R.id.newsImage)
        var btn = itemView.findViewById<MaterialButton>(R.id.btnurl)
        var btn_share = itemView.findViewById<MaterialButton>(R.id.btnshare)

    }
}