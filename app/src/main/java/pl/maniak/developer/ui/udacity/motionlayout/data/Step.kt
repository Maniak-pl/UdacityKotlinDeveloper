package pl.maniak.developer.ui.udacity.motionlayout.data

import android.app.Activity
import kotlin.reflect.KClass

data class Step(
    val number: String,
    val name: String,
    val caption: String,
    val activity: KClass<out Activity>,
    val highlight: Boolean = false,
)