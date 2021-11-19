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
import com.example.prelim_exam.database.UsersDatabase
import com.example.prelim_exam.database.UsersRepository
import com.example.prelim_exam.databinding.FragmentRegisterBinding
import com.example.prelim_exam.model.RegisterViewModel
import com.example.prelim_exam.model.RegisterViewModelFactory


class RegisterFragment : Fragment() {
    private lateinit var usersViewModel: RegisterViewModel
    private lateinit var binding: FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_register, container, false)

        val application = requireNotNull(this.activity).application

        val dao = UsersDatabase.getInstance(application).usersDatabase
        val repository = UsersRepository(dao)
        val factory = RegisterViewModelFactory(repository)

        usersViewModel = ViewModelProvider(this, factory).get(RegisterViewModel::class.java)
        binding.myViewModel = usersViewModel
        binding.lifecycleOwner = this

        usersViewModel.message.observe(viewLifecycleOwner, Observer {
            it.getContentIfNotHandled()?.let{
                Toast.makeText(activity, it, Toast.LENGTH_LONG).show()
            }
        })
        return binding.root
    }


}