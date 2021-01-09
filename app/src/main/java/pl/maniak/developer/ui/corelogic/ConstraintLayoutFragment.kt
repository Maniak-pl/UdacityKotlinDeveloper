package pl.maniak.developer.ui.corelogic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import pl.maniak.developer.R
import pl.maniak.developer.databinding.FragmentConstraintLayoutBinding

class ConstraintLayoutFragment : Fragment() {

    private lateinit var binding: FragmentConstraintLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_constraint_layout, container, false)
        binding.apply {
            text16.setOnClickListener {
                text16.text = "A - long text"
                text17.text = "B"
            }
            text17.setOnClickListener {
                text16.text = "A"
                text17.text = "B - long text"
            }
        }
        return binding.root
    }
}