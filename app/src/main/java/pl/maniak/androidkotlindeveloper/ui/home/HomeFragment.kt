package pl.maniak.androidkotlindeveloper.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import pl.maniak.androidkotlindeveloper.R
import pl.maniak.androidkotlindeveloper.databinding.FragmentHomeBinding
import pl.maniak.androidkotlindeveloper.ui.udacity.dessertpusher.DessertPusherActivity
import pl.maniak.androidkotlindeveloper.ui.udacity.guesstheword.GuessTheWordActivity
import pl.maniak.androidkotlindeveloper.ui.udacity.trivia.TriviaActivity

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
            homeAppU02.setOnClickListener { findNavController().navigate(R.id.action_nav_home_to_aboutMeFragment) }
            homeAppU03.setOnClickListener { findNavController().navigate(R.id.action_nav_home_to_colorMyViewsFragment) }
            homeAppU04.setOnClickListener { startActivity(Intent(requireContext(), TriviaActivity::class.java)) }
            homeAppU05.setOnClickListener { startActivity(Intent(requireContext(), DessertPusherActivity::class.java)) }
            homeAppU06.setOnClickListener { startActivity(Intent(requireContext(), GuessTheWordActivity::class.java)) }
            homeAppC01.setOnClickListener { findNavController().navigate(R.id.action_nav_home_to_constraintLayoutFragment) }
        }
        return binding.root
    }
}