package com.example.pipeline.forgotPassword

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.pipeline.R
import com.example.pipeline.databinding.RecyclerCountryCodeBinding
import com.example.pipeline.model.Country
import com.google.gson.Gson
import java.util.*

class CountryAdapter(val countrylist:MutableList<Country>,val context:Context): RecyclerView.Adapter<CountryAdapter.MyViewhHolder>() {


    lateinit var binding: RecyclerCountryCodeBinding
    var countryFilterList: MutableList<Country> = ArrayList<Country>()

    init {
        countryFilterList.addAll(countrylist)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewhHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        binding = DataBindingUtil.inflate(inflater, R.layout.recycler_country_code, parent, false)
        return MyViewhHolder(binding.root)
    }

    override fun onBindViewHolder(holder: MyViewhHolder, position: Int) {
        val countryFilter = countryFilterList[position]
        Log.d("krinal123", "countryBind" + Gson().toJson(countryFilterList))
        binding.tvCountryTitle.text = countryFilter.countrytitle
        binding.tvCountryNumber.text = countryFilter.countryno
        binding.imgCountry.setImageResource(countryFilter.countryimg)
        binding.countryCard.setOnClickListener { view ->
            val bundle = Bundle()
            bundle.putString("countryno", countrylist[position].countryno)
            bundle.putInt("imgflag", countrylist[position].countryimg)
            val fram = ForgotPasswordFragment()
            fram.arguments = bundle
            view.findNavController()
                .navigate(R.id.action_countryCodeFragment_to_forgotPasswordFragment, bundle)

//            holder.itemView.context.applicationContext.

        }

    }

    override fun getItemCount(): Int {
        return countryFilterList.size
    }

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }

    class MyViewhHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}












