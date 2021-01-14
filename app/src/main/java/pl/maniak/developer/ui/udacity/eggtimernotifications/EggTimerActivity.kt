package pl.maniak.developer.ui.udacity.eggtimernotifications

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import pl.maniak.developer.R
import pl.maniak.developer.ui.udacity.eggtimernotifications.ui.EggTimerFragment

class EggTimerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_egg_timer)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, EggTimerFragment.newInstance())
                .commitNow()
        }
    }
}