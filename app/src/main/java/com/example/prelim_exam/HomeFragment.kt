package com.example.prelim_exam

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.prelim_exam.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentHomeBinding>(inflater,
        R.layout.fragment_home, container, false)

        binding.btnAbout.setOnClickListener {
            view: View -> view.findNavController().navigate(R.id.action_homeFragment_to_aboutFragment)
        }
        binding.btnContent.setOnClickListener {
                view: View -> view.findNavController().navigate(R.id.action_homeFragment_to_contentFragment)
        }
        binding.btnFaq.setOnClickListener {
                view: View -> view.findNavController().navigate(R.id.action_homeFragment_to_faqFragment)
        }
        binding.Post.setOnClickListener {
                view: View -> view.findNavController().navigate(R.id.action_homeFragment_to_postFragment)
        }
        binding.Display.setOnClickListener {
                view: View -> view.findNavController().navigate(R.id.action_homeFragment_to_displayFragment)
        }
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item,requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

}