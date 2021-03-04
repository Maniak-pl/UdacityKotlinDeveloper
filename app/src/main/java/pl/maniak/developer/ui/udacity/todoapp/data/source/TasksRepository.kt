package pl.maniak.developer.ui.udacity.todoapp.data.source

import androidx.lifecycle.LiveData
import pl.maniak.developer.ui.udacity.todoapp.data.Result
import pl.maniak.developer.ui.udacity.todoapp.data.Task

interface TasksRepository {
    suspend fun getTasks(forceUpdate: Boolean = false): Result<List<Task>>

    suspend fun refreshTasks()

    fun observeTasks(): LiveData<Result<List<Task>>>

    suspend fun refreshTask(taskId: String)

    fun observeTask(taskId: String): LiveData<Result<Task>>

    suspend fun getTask(taskId: String, forceUpdate: Boolean = false): Result<Task>

    suspend fun saveTask(task: Task)

    suspend fun completeTask(task: Task)

    suspend fun completeTask(taskId: String)

    suspend fun activateTask(task: Task)

    suspend fun activateTask(taskId: String)

    suspend fun clearCompletedTasks()

    suspend fun deleteAllTasks()

    suspend fun deleteTask(taskId: String)
}