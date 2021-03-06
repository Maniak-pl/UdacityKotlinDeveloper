package pl.maniak.developer.ui.udacity.todoapp.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import pl.maniak.developer.ui.udacity.todoapp.data.Task

@Database(entities = [Task::class], version = 1, exportSchema = false)
abstract class ToDoDatabase : RoomDatabase() {

    abstract fun taskDao(): TasksDao
}