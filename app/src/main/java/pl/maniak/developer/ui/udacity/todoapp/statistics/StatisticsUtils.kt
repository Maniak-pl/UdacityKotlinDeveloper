package pl.maniak.developer.ui.udacity.todoapp.statistics

import pl.maniak.developer.ui.udacity.todoapp.data.Task

internal fun getActiveAndCompletedStats(tasks: List<Task>?): StatsResult {
    val totalTasks = tasks!!.size
    val numberOfActiveTasks = tasks.count { it.isActive }
    return StatsResult(
        activeTasksPercent = 100f * numberOfActiveTasks / tasks.size,
        completedTasksPercent = 100f * (totalTasks - numberOfActiveTasks) / tasks.size
    )
}

data class StatsResult(val activeTasksPercent: Float, val completedTasksPercent: Float)
