package com.example.prelim_exam

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.prelim_exam.database.Inquiry
import com.example.prelim_exam.databinding.ListItemBinding

class MyRecyclerViewAdapter(private val clickListener: (Inquiry) -> Unit) :
    RecyclerView.Adapter<MyViewHolder>() {
    private val inquiryList = ArrayList<Inquiry>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return inquiryList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(inquiryList[position], clickListener)
    }

    fun setList(inquiry: List<Inquiry>) {
        inquiryList.clear()
        inquiryList.addAll(inquiry)

    }

}

class MyViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(inquiry: Inquiry, clickListener: (Inquiry) -> Unit) {
        binding.txtName.text= "Inquiry Name: " + inquiry.inqName
        binding.txtSubject.text = "Inquiry Type: " + inquiry.inqSubj
        binding.txtInquiry.text = "Comment: " + inquiry.inqPost

        binding.listItemLayout.setOnClickListener {
            clickListener(inquiry)
        }
    }
}