package pl.maniak.androidkotlindeveloper.ui.udacity.trackmysleepquality.sleepdetail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pl.maniak.androidkotlindeveloper.ui.udacity.trackmysleepquality.database.SleepDatabaseDao
import pl.maniak.androidkotlindeveloper.ui.udacity.trackmysleepquality.database.SleepNight

class SleepDetailViewModel(
    private val sleepNightKey: Long = 0L,
    dataSource: SleepDatabaseDao
) : ViewModel() {

    val database = dataSource

    private val night = MediatorLiveData<SleepNight>()

    fun getNight() = night

    init {
        night.addSource(database.getNightWithId(sleepNightKey), night::setValue)
    }

    private val _navigateToSleepTracker = MutableLiveData<Boolean?>()

    val navigateToSleepTracker: LiveData<Boolean?>
        get() = _navigateToSleepTracker

    fun doneNavigating() {
        _navigateToSleepTracker.value = null
    }

    fun onClose() {
        _navigateToSleepTracker.value = true
    }
}