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
import com.example.prelim_exam.database.InquiryDatabase
import com.example.prelim_exam.database.InquiryRepository
import com.example.prelim_exam.databinding.FragmentPostBinding
import com.example.prelim_exam.model.PostViewModel
import com.example.prelim_exam.model.PostViewModelFactory

class PostFragment : Fragment() {
    private lateinit var inquiryViewModel: PostViewModel
    private lateinit var binding: FragmentPostBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_post, container, false)
        val application = requireNotNull(this.activity).application

        val dao = InquiryDatabase.getInstance(application).inquiryDatabase
        val repository = InquiryRepository(dao)
        val factory = PostViewModelFactory(repository)

        inquiryViewModel = ViewModelProvider(this, factory).get(PostViewModel::class.java)
        binding.myViewModel = inquiryViewModel
        binding.lifecycleOwner = this

        inquiryViewModel.message.observe(viewLifecycleOwner, Observer {
            it.getContentIfNotHandled()?.let {
                Toast.makeText(activity, it, Toast.LENGTH_LONG).show()
            }
        })
        return binding.root
    }


}