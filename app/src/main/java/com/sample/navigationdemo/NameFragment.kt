package com.sample.navigationdemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.sample.navigationdemo.databinding.FragmentNameBinding


class NameFragment : Fragment() {

    private lateinit var binding: FragmentNameBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_name, container, false)
        //var input = requireArguments().getString("user_input")
        //binding.textView.text = input.toString()

        binding.nextButton.setOnClickListener {
            if(binding.editTextPersonName.toString().isNotEmpty()) {
                var bundle = bundleOf("userName" to binding.editTextPersonName.text.toString())
                it.findNavController().navigate(R.id.action_secondFragment_to_emailFragment, bundle)
            }else{
                Toast.makeText(activity,"Please enter name",Toast.LENGTH_SHORT).show()
            }

        }
        return binding.root
    }


}