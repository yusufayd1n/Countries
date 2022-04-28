package com.example.countrylist.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.countrylist.R
import com.example.countrylist.model.CountryModel
import com.example.countrylist.model.CountryModelItem
import kotlinx.android.synthetic.main.country_row.view.*
import kotlin.math.acos

class CountryAdapter(val activity: Activity): RecyclerView.Adapter<CountryAdapter.ViewHolder>() {
    private var countryList:List<CountryModelItem>?=null

    fun setCountryList(countryList:List<CountryModelItem>){
        this.countryList=countryList
    }

    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val flag=view.flag
        val countryName=view.countryName
        val countryCapital=view.countryCapital
        val countryRegion=view.countryRegion
        val countryPopulation=view.countryPopulation

        fun bind(data:CountryModelItem, activity: Activity){
            countryName.text=data.name.common + "(" + data.cca2+")"
            countryCapital.text="Capital: "+ data.capital
            countryRegion.text="Region: "+data.region
            countryPopulation.text="Population: "+data.population
            Glide.with(activity).load(data.flags.png).into(flag)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.country_row,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryAdapter.ViewHolder, position: Int) {
        holder.bind(countryList?.get(position)!!,activity)
    }

    override fun getItemCount(): Int {
        if(countryList==null){
            return 0
        }else{
            return countryList!!.size
        }

    }
}