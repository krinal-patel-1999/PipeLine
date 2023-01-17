package com.example.pipeline.forgotPassword

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pipeline.R
import com.example.pipeline.databinding.FragmentCountryCodeBinding
import com.example.pipeline.model.Country
import java.util.*


class CountryCodeFragment : Fragment() {

    lateinit var binding: FragmentCountryCodeBinding
    lateinit var adapter: CountryAdapter
    private var countrylist: MutableList<Country> = ArrayList()






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_country_code, container, false)


        countrylist.add(Country(R.drawable.unitedstates, "United States", "+1"))
        countrylist.add(Country(R.drawable.canada, "Canada", "+1"))
        countrylist.add(Country(R.drawable.brazil, "Brazil", "+55"))
        countrylist.add(Country(R.drawable.unitedkingdom, "United Kingdom", "+44"))
        countrylist.add(Country(R.drawable.germany, "Germany", "+49"))
        countrylist.add(Country(R.drawable.netherlands, "Netherlands", "+31"))
        countrylist.add(Country(R.drawable.india, "India", "+91"))

        adapter = CountryAdapter(countrylist, requireContext())
        binding.recyclerCountryCode.layoutManager = LinearLayoutManager(context)
        binding.recyclerCountryCode.adapter = adapter


        binding.etSearchin.doOnTextChanged { text, _, _, _ ->
            val query = text.toString().toLowerCase(Locale.getDefault())
            filterWithQuery(query)
        }



        binding.tvCancle.setOnClickListener {
            findNavController().popBackStack()
        }

        return binding.root
    }


    private fun filterWithQuery(query: String) {
        if (query.isNotEmpty()) {
            val filteredList: List<Country> = onFilterChanged(query)
            attachAdapter(filteredList)
        } else if (query.isEmpty()) {
            attachAdapter(countrylist)
        }
    }

    private fun onFilterChanged(filterQuery: String): List<Country> {
        val filteredList = ArrayList<Country>()
        for (flag in countrylist) {
            if (flag.countrytitle.toLowerCase(Locale.getDefault()).contains(filterQuery)) {
                filteredList.add(flag)
            }
        }
        return filteredList
    }


    private fun attachAdapter(list: List<Country>) {
       adapter= CountryAdapter(list as MutableList<Country>, requireActivity())
        binding.recyclerCountryCode.adapter = adapter
    }


}


