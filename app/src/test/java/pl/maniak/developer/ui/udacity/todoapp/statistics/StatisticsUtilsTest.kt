package pl.maniak.developer.ui.udacity.todoapp.statistics

import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.*
import org.junit.Test
import pl.maniak.developer.ui.udacity.todoapp.data.Task

class StatisticsUtilsTest {

    // If there's no completed task and one active task,
    // then there are 100% percent active tasks and 0% completed tasks.
    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsHundredZero() {

        // GIVEN a list of tasks with a single, active, task
        val tasks = listOf<Task>(
            Task("title", "desc", isCompleted = false)
        )

        // WHEN you call getActiveAndCompleteStats
        val result = getActiveAndCompletedStats(tasks)

        // THEN there are 0% completed tasks and 100% active tasks
        assertThat(result.completedTasksPercent, `is`(0f))
        assertThat(result.activeTasksPercent, `is`(100f))
    }

    // If there's 2 completed tasks and 3 active tasks,
    // then there are 40% percent completed tasks and 60% active tasks.
    @Test
    fun getActiveAndCompletedStats_both_returnsFortySixty() {

        // Create an active tasks (the false makes this active)
        val tasks = listOf<Task>(
            Task("title", "desc", isCompleted = true),
            Task("title", "desc", isCompleted = true),
            Task("title", "desc", isCompleted = false),
            Task("title", "desc", isCompleted = false),
            Task("title", "desc", isCompleted = false)
        )
        // Call our function
        val result = getActiveAndCompletedStats(tasks)

        // Check the result
        assertEquals(result.completedTasksPercent, 40f)
        assertEquals(result.activeTasksPercent, 60f)
    }

    @Test
    fun getActiveAndCompletedStats_empty_returnsZeros() {

        val tasks = emptyList<Task>()

        val result = getActiveAndCompletedStats(tasks)

        assertEquals(result.completedTasksPercent, 0f)
        assertEquals(result.activeTasksPercent, 0f)
    }

    @Test
    fun getActiveAndCompletedStats_error_returnsZeros() {

        val tasks = null

        val result = getActiveAndCompletedStats(tasks)

        assertEquals(result.completedTasksPercent, 0f)
        assertEquals(result.activeTasksPercent, 0f)
    }
}