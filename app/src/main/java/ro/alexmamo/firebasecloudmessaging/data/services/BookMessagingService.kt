package ro.alexmamo.firebasecloudmessaging.data.services

import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import androidx.core.app.NotificationManagerCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import ro.alexmamo.firebasecloudmessaging.R
import ro.alexmamo.firebasecloudmessaging.core.BOOK_ID
import ro.alexmamo.firebasecloudmessaging.core.CHANNEL_ID
import ro.alexmamo.firebasecloudmessaging.core.CHANNEL_NAME
import ro.alexmamo.firebasecloudmessaging.core.Utils.Companion.log

@SuppressLint("MissingPermission")
class BookMessagingService : FirebaseMessagingService() {
    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        sendNotification(message)
    }

    private fun sendNotification(message: RemoteMessage) {
        if (message.notification != null) {
            val title = message.notification?.title.toString()
            val body = message.notification?.body.toString()

            val channel = NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_HIGH)
            getSystemService(NotificationManager::class.java).createNotificationChannel(channel)
            val notification = Notification.Builder(this, CHANNEL_ID)
                .setContentTitle(title)
                .setContentText(body)
                .setSmallIcon(android.R.drawable.ic_menu_manage)
                .setColor(getColor(R.color.purple_700))
                .setAutoCancel(true)
                .build()
            NotificationManagerCompat.from(this).notify(1, notification)
        }
        if (message.data.isNotEmpty()) {
            val bookId = message.data[BOOK_ID]
            log(bookId)
        }
    }

    override fun onNewToken(token: String) {
        log(token)
    }
}