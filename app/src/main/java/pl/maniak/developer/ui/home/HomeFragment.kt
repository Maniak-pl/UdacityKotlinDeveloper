package pl.maniak.developer.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import pl.maniak.developer.R
import pl.maniak.developer.databinding.FragmentHomeBinding
import pl.maniak.developer.ui.udacity.animation.PropertyAnimation
import pl.maniak.developer.ui.udacity.clipping.ClippingExample
import pl.maniak.developer.ui.udacity.customfancontroller.CustomFanController
import pl.maniak.developer.ui.udacity.dessertpusher.DessertPusherActivity
import pl.maniak.developer.ui.udacity.devbyteviewer.ui.DevByteActivity
import pl.maniak.developer.ui.udacity.eggtimernotifications.EggTimerActivity
import pl.maniak.developer.ui.udacity.gdgfinder.GdgFinderActivity
import pl.maniak.developer.ui.udacity.guesstheword.GuessTheWordActivity
import pl.maniak.developer.ui.udacity.marsrealestate.MarsRealEstateActivity
import pl.maniak.developer.ui.udacity.minipaint.MiniPaintActivity
import pl.maniak.developer.ui.udacity.motionlayout.MotionLayoutActivity
import pl.maniak.developer.ui.udacity.trackmysleepquality.SleepQualityActivity
import pl.maniak.developer.ui.udacity.treasure.HuntMainActivity
import pl.maniak.developer.ui.udacity.trivia.TriviaActivity
import pl.maniak.developer.ui.udacity.wander.WanderActivity

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        binding.apply {
            homeAppU02.setOnClickListener { findNavController().navigate(R.id.action_nav_home_to_aboutMeFragment) }
            homeAppU03.setOnClickListener { findNavController().navigate(R.id.action_nav_home_to_colorMyViewsFragment) }
            homeAppU04.setOnClickListener { startActivity(TriviaActivity::class.java) }
            homeAppU05.setOnClickListener { startActivity(DessertPusherActivity::class.java) }
            homeAppU06.setOnClickListener { startActivity(GuessTheWordActivity::class.java) }
            homeAppU07.setOnClickListener { startActivity(SleepQualityActivity::class.java) }
            homeAppU08.setOnClickListener { startActivity(MarsRealEstateActivity::class.java) }
            homeAppU09.setOnClickListener { startActivity(DevByteActivity::class.java) }
            homeAppU10.setOnClickListener { startActivity(GdgFinderActivity::class.java) }
            homeAppU11.setOnClickListener { startActivity(EggTimerActivity::class.java) }
            homeAppU12.setOnClickListener { startActivity(CustomFanController::class.java) }
            homeAppU13.setOnClickListener { startActivity(MiniPaintActivity::class.java) }
            homeAppU14.setOnClickListener { startActivity(ClippingExample::class.java) }
            homeAppU15.setOnClickListener { startActivity(PropertyAnimation::class.java) }
            homeAppU16.setOnClickListener { startActivity(MotionLayoutActivity::class.java) }
            homeAppU17.setOnClickListener { startActivity(WanderActivity::class.java) }
            homeAppU18.setOnClickListener { startActivity(HuntMainActivity::class.java) }
            homeAppC01.setOnClickListener { findNavController().navigate(R.id.action_nav_home_to_constraintLayoutFragment) }
        }
        return binding.root
    }

    private fun startActivity(cls: Class<*>?) {
        startActivity(Intent(requireContext(), cls))
    }
}