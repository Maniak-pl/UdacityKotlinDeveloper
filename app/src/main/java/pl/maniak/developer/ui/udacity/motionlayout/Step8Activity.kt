package pl.maniak.developer.ui.udacity.motionlayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import pl.maniak.developer.R

class Step8Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_step8)

        coordinateMotion()
    }

    private fun coordinateMotion() {
        // TODO: set progress of MotionLayout based on an AppBarLayout.OnOffsetChangedListener
    }
}