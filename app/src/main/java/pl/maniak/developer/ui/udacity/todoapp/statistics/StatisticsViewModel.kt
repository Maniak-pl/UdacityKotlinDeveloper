package pl.maniak.developer.ui.udacity.todoapp.statistics

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.launch
import pl.maniak.developer.ui.udacity.todoapp.data.Result
import pl.maniak.developer.ui.udacity.todoapp.data.Result.Error
import pl.maniak.developer.ui.udacity.todoapp.data.Result.Success
import pl.maniak.developer.ui.udacity.todoapp.data.Task
import pl.maniak.developer.ui.udacity.todoapp.data.source.DefaultTasksRepository

class StatisticsViewModel(application: Application) : AndroidViewModel(application) {

    private val tasksRepository = DefaultTasksRepository.getRepository(application)

    private val tasks: LiveData<Result<List<Task>>> = tasksRepository.observeTasks()
    private val _dataLoading = MutableLiveData<Boolean>(false)
    private val stats: LiveData<StatsResult?> = tasks.map {
        if (it is Success) {
            getActiveAndCompletedStats(it.data)
        } else {
            null
        }
    }

    val activeTasksPercent = stats.map {
        it?.activeTasksPercent ?: 0f
    }
    val completedTasksPercent: LiveData<Float> = stats.map { it?.completedTasksPercent ?: 0f }
    val dataLoading: LiveData<Boolean> = _dataLoading
    val error: LiveData<Boolean> = tasks.map { it is Error }
    val empty: LiveData<Boolean> = tasks.map { (it as? Success)?.data.isNullOrEmpty() }

    fun refresh() {
        _dataLoading.value = true
        viewModelScope.launch {
            tasksRepository.refreshTasks()
            _dataLoading.value = false
        }
    }
}