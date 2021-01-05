package pl.maniak.androidkotlindeveloper.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import pl.maniak.androidkotlindeveloper.R
import pl.maniak.androidkotlindeveloper.databinding.FragmentHomeBinding
import pl.maniak.androidkotlindeveloper.ui.udacity.dessertpusher.DessertPusherActivity
import pl.maniak.androidkotlindeveloper.ui.udacity.devbyteviewer.ui.DevByteActivity
import pl.maniak.androidkotlindeveloper.ui.udacity.guesstheword.GuessTheWordActivity
import pl.maniak.androidkotlindeveloper.ui.udacity.marsrealestate.MarsRealEstateActivity
import pl.maniak.androidkotlindeveloper.ui.udacity.trackmysleepquality.SleepQualityActivity
import pl.maniak.androidkotlindeveloper.ui.udacity.trivia.TriviaActivity

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        binding.apply {
            homeAppU02.setOnClickListener { findNavController().navigate(R.id.action_nav_home_to_aboutMeFragment) }
            homeAppU03.setOnClickListener { findNavController().navigate(R.id.action_nav_home_to_colorMyViewsFragment) }
            homeAppU04.setOnClickListener { startActivity(Intent(requireContext(), TriviaActivity::class.java)) }
            homeAppU05.setOnClickListener { startActivity(Intent(requireContext(), DessertPusherActivity::class.java)) }
            homeAppU06.setOnClickListener { startActivity(Intent(requireContext(), GuessTheWordActivity::class.java)) }
            homeAppU07.setOnClickListener { startActivity(Intent(requireContext(), SleepQualityActivity::class.java)) }
            homeAppU08.setOnClickListener { startActivity(Intent(requireContext(), MarsRealEstateActivity::class.java)) }
            homeAppU09.setOnClickListener { startActivity(Intent(requireContext(), DevByteActivity::class.java)) }
            homeAppC01.setOnClickListener { findNavController().navigate(R.id.action_nav_home_to_constraintLayoutFragment) }
        }
        return binding.root
    }
}