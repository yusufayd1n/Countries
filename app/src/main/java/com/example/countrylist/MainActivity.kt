package com.example.countrylist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu

import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.countrylist.adapter.CountryAdapter
import com.example.countrylist.model.CountryModelItem
import com.example.countrylist.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var recyclerViewAdapter:CountryAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
        initViewModel()
    }



    private fun initRecyclerView(){
        countryListRecyclerView.layoutManager=LinearLayoutManager(this)
        recyclerViewAdapter= CountryAdapter(this)
        countryListRecyclerView.adapter=recyclerViewAdapter
    }

    private fun initViewModel(){
        val viewModel:MainViewModel=ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getLiveDataObserver().observe(this, Observer {
            if(it!=null){

                recyclerViewAdapter.setCountryList(it)
                recyclerViewAdapter.notifyDataSetChanged()
            }else{
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show()
            }
        })
        viewModel.makeAPICall()
    }
}