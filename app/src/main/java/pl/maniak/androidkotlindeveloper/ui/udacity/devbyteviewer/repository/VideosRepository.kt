package pl.maniak.androidkotlindeveloper.ui.udacity.devbyteviewer.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pl.maniak.androidkotlindeveloper.ui.udacity.devbyteviewer.database.VideosDatabase
import pl.maniak.androidkotlindeveloper.ui.udacity.devbyteviewer.database.asDomainModel
import pl.maniak.androidkotlindeveloper.ui.udacity.devbyteviewer.domain.Video
import pl.maniak.androidkotlindeveloper.ui.udacity.devbyteviewer.network.Network
import pl.maniak.androidkotlindeveloper.ui.udacity.devbyteviewer.network.asDatabaseModel

class VideosRepository(private val database: VideosDatabase) {

    val videos: LiveData<List<Video>> =
        Transformations.map(database.videoDao.getVideos()) {
            it.asDomainModel()
        }

    suspend fun refreshVideos() {
        withContext(Dispatchers.IO) {
            val playlist = Network.devbytes.getPlaylist().await()
            database.videoDao.insertAll(*playlist.asDatabaseModel())
        }
    }
}