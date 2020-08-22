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
import com.sample.navigationdemo.databinding.FragmentEmailBinding
import kotlinx.android.synthetic.main.fragment_email.*


class emailFragment : Fragment() {

    private lateinit var binding: FragmentEmailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_email,container,false)

        binding.emailFragmentSubmitButton.setOnClickListener {

            if(editTextEmail.text.toString().isNotEmpty()){
                var userName = requireArguments().getString("userName")
                var bundle = bundleOf("userEmail" to binding.editTextEmail.text.toString(), "userName" to userName )

                it.findNavController().navigate(R.id.action_emailFragment_to_welcomeFragment,bundle)
            }
            else{
                Toast.makeText(activity,"Please enter email",Toast.LENGTH_SHORT).show()
            }

        }

        return binding.root
    }


}