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
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.prelim_exam.database.Inquiry
import com.example.prelim_exam.database.InquiryDatabase
import com.example.prelim_exam.database.InquiryRepository
import com.example.prelim_exam.database.UsersDatabase
import com.example.prelim_exam.databinding.FragmentDisplayBinding
import com.example.prelim_exam.model.DisplayViewModel
import com.example.prelim_exam.model.DisplayViewModelFactory


class DisplayFragment : Fragment() {
    private lateinit var displayViewModel: DisplayViewModel
    private lateinit var binding: FragmentDisplayBinding
    private lateinit var adapter: MyRecyclerViewAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_display, container, false)

        val application = requireNotNull(this.activity).application

        val dao = InquiryDatabase.getInstance(application).inquiryDatabase
        val repository = InquiryRepository(dao)
        val factory = DisplayViewModelFactory(repository)

        displayViewModel = ViewModelProvider(this,factory).get(DisplayViewModel::class.java)
        binding.myViewModel = displayViewModel
        binding.lifecycleOwner = this

        displayViewModel.message.observe(viewLifecycleOwner, Observer{
            it.getContentIfNotHandled()?.let{
                Toast.makeText(activity, it, Toast.LENGTH_LONG).show()
            }
        })
        initRecyclerView()
        return binding.root
    }
    private fun initRecyclerView(){
        binding.inquiryRecyclerView.layoutManager = LinearLayoutManager(activity)
        adapter = MyRecyclerViewAdapter { selectedItem: Inquiry -> listItemClicked(selectedItem)}
        binding.inquiryRecyclerView.adapter = adapter
        displayInquiryList()
    }
    private fun displayInquiryList(){
        displayViewModel.getPostInquiry().observe(viewLifecycleOwner, Observer{
            adapter.setList(it)
            adapter.notifyDataSetChanged()
        })
    }
    private fun listItemClicked(inquiry: Inquiry){

    }


}