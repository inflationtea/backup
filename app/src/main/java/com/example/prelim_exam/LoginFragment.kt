package com.example.prelim_exam

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.prelim_exam.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentLoginBinding>(inflater,R.layout.fragment_login,
        container, false)

        val navController = findNavController()
        binding.btnRegister.setOnClickListener { view: View ->
            navController.navigate(R.id.action_loginFragment_to_registerFragment)
        }
        binding.btnLogin.setOnClickListener {
            val username = binding.editUsername.text.toString()
            val password = binding.editPassword.text.toString()

            if(username == "Beatrix" && password == "hello123"){
                navController.navigate(R.id.action_loginFragment_to_homeFragment)
            }else{
                Toast.makeText(requireActivity(),"Incorrect username or password!",Toast.LENGTH_LONG).show()
            }
        }
        return binding.root
    }



}