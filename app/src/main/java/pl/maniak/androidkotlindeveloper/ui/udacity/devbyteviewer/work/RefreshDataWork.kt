package pl.maniak.androidkotlindeveloper.ui.udacity.devbyteviewer.work

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.bumptech.glide.load.HttpException
import pl.maniak.androidkotlindeveloper.ui.udacity.devbyteviewer.database.getDatabase
import pl.maniak.androidkotlindeveloper.ui.udacity.devbyteviewer.repository.VideosRepository

class RefreshDataWorker(appContext: Context, params: WorkerParameters) :
    CoroutineWorker(appContext, params) {

    /**
     * A coroutine-friendly method to do your work.
     */
    override suspend fun doWork(): Result {
        val database = getDatabase(applicationContext)
        val repository = VideosRepository(database)
        return try {
            repository.refreshVideos()
            Result.success()
        } catch (e: HttpException) {
            Result.retry()
        }
    }
}