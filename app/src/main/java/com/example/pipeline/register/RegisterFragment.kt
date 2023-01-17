package com.example.pipeline.register

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.pipeline.R
import com.example.pipeline.`interface`.Backpased
import com.example.pipeline.databinding.FragmentRegisterBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import java.util.*


class RegisterFragment : Fragment() {
    lateinit var binding: FragmentRegisterBinding

    val myClaender = Calendar.getInstance()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_register, container, false)

        binding.toolbarUseredit.tvProfile.text = "Registration"
        binding.toolbarUseredit.imgArrow.setOnClickListener {
            findNavController().popBackStack()

        }
        binding.etRegDob.setOnClickListener {
            clickDatepicker()
        }
        binding.etRegGender.setOnClickListener {
            showdilog()
        }

        return binding.root
    }

    private fun clickDatepicker() {
        val year = myClaender.get(Calendar.YEAR)
        val month = myClaender.get(Calendar.MONTH)
        val day = myClaender.get(Calendar.DAY_OF_MONTH)

        val dpd = DatePickerDialog(
            requireContext(),
            DatePickerDialog.OnDateSetListener { view, year, month, dayofMonth ->
                var mt = month + 1
                binding.etRegDob.text = "${dayofMonth.toString() + "/" + mt + "/" + year}"

            },
            year,
            month,
            day
        )
        dpd.datePicker.maxDate = System.currentTimeMillis()
        dpd.show()

    }



    @SuppressLint("SetTextI18n")
    fun showdilog() {
        val dialog = BottomSheetDialog(requireContext())
        val view = layoutInflater.inflate(R.layout.bottomsheet_gender, null)
        dialog.setContentView(view)
        val selectGender = view.findViewById<TextView>(R.id.tv_select_gender)
        val male = view.findViewById<TextView>(R.id.tv_male)
        val female = view.findViewById<TextView>(R.id.tv_female)
        val nonBinary = view.findViewById<TextView>(R.id.tv_nonBinnary)
        val prefernoans = view.findViewById<TextView>(R.id.tv_noAnswer)
        male.setOnClickListener {
            binding.etRegGender.text = "Male"
            dialog.dismiss()

        }
        female.setOnClickListener {
            binding.etRegGender.text = "Female"
            dialog.dismiss()
        }
        nonBinary.setOnClickListener {
            binding.etRegGender.text = "Non-Binary"
            dialog.dismiss()
        }
        prefernoans.setOnClickListener {
            binding.etRegGender.text = "Prefer not to answer"
            dialog.dismiss()
        }

        dialog.show()
    }


}