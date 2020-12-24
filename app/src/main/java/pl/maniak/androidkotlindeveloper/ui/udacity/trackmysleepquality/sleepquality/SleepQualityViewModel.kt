package pl.maniak.androidkotlindeveloper.ui.udacity.trackmysleepquality.sleepquality

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import pl.maniak.androidkotlindeveloper.ui.udacity.trackmysleepquality.database.SleepDatabaseDao

class SleepQualityViewModel(private val sleepNightKey: Long = 0L, val database: SleepDatabaseDao) :
    ViewModel() {

    private val _navigateToSleepTracker = MutableLiveData<Boolean?>()

    val navigateToSleepTracker: LiveData<Boolean?>
        get() = _navigateToSleepTracker

    /**
     * Call this immediately after navigating to [SleepTrackerFragment]
     */
    fun doneNavigating() {
        _navigateToSleepTracker.value = null
    }

    /**
     * Sets the sleep quality and updates the database.
     *
     * Then navigates back to the SleepTrackerFragment.
     */
    fun onSetSleepQuality(quality: Int) {
        viewModelScope.launch {
            val tonight = database.get(sleepNightKey) ?: return@launch
            tonight.sleepQuality = quality
            database.update(tonight)

            // Setting this state variable to true will alert the observer and trigger navigation.
            _navigateToSleepTracker.value = true
        }
    }
}