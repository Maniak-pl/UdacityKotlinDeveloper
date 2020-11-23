package pl.maniak.androidkotlindeveloper.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import pl.maniak.androidkotlindeveloper.R
import pl.maniak.androidkotlindeveloper.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        binding.apply {
            homeApp02Btn.setOnClickListener { findNavController().navigate(R.id.action_nav_home_to_aboutMeFragment) }
            homeApp03.setOnClickListener { findNavController().navigate(R.id.action_nav_home_to_colorMyViewsFragment) }
        }
        return binding.root
    }
}