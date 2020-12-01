package pl.maniak.androidkotlindeveloper.ui.corelogic

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_constraint_layout.*
import pl.maniak.androidkotlindeveloper.R

class ConstraintLayoutFragment : Fragment(R.layout.fragment_constraint_layout) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
    }

    private fun initListener() {
        text16.setOnClickListener {
            text16.text = "A - long text"
            text17.text = "B"
        }
        text17.setOnClickListener {
            text16.text = "A"
            text17.text = "B - long text"
        }
    }
}