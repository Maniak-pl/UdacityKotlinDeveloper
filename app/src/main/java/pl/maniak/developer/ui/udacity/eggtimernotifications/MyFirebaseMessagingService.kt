package pl.maniak.developer.ui.udacity.eggtimernotifications

import android.app.NotificationManager
import androidx.core.content.ContextCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import pl.maniak.developer.ui.udacity.eggtimernotifications.util.sendNotification
import timber.log.Timber

class MyFirebaseMessagingService : FirebaseMessagingService() {

    companion object {
        private const val TAG = "MyFirebaseMsgService"
    }

    // [START receive_message]
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        // Not getting messages here? See why this may be: https://goo.gl/39bRNJ
        Timber.tag(TAG).d("From: ${remoteMessage.from}")

        // TODO Step 3.5 check messages for data
        // Check if message contains a data payload.
        remoteMessage.data.let {
            Timber.tag(TAG).d("Message data payload: " + remoteMessage.data)
        }

        // TODO Step 3.6 check messages for notification and call sendNotification
        // Check if message contains a notification payload.
        remoteMessage.notification?.let {
            Timber.tag(TAG).d("Message Notification Body: ${it.body}")
            sendNotification(it.body!!)
        }
    }
    // [END receive_message]

    //TODO Step 3.2 log registration token
    // [START on_new_token]
    override fun onNewToken(token: String) {
        Timber.tag(TAG).d("Refreshed token: $token")

        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.
        sendRegistrationToServer(token)
    }
    // [END on_new_token]

    private fun sendRegistrationToServer(token: String?) {
        // TODO: Implement this method to send token to your app server.
    }

    /**
     * Create and show a simple notification containing the received FCM message.
     *
     * @param messageBody FCM message body received.
     */
    private fun sendNotification(messageBody: String) {
        val notificationManager = ContextCompat.getSystemService(applicationContext,
            NotificationManager::class.java) as NotificationManager
        notificationManager.sendNotification(messageBody, applicationContext)
    }
}