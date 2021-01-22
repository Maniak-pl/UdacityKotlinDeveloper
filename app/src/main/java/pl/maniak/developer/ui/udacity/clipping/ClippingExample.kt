package pl.maniak.developer.ui.udacity.clipping

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ClippingExample : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ClippedView(this))
    }
}