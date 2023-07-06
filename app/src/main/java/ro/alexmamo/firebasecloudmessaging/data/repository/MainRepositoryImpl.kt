package ro.alexmamo.firebasecloudmessaging.data.repository

import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.coroutines.tasks.await
import ro.alexmamo.firebasecloudmessaging.core.LOW_STOCK
import ro.alexmamo.firebasecloudmessaging.domain.model.Response.Failure
import ro.alexmamo.firebasecloudmessaging.domain.model.Response.Success
import ro.alexmamo.firebasecloudmessaging.domain.repository.MainRepository
import javax.inject.Singleton

@Singleton
class MainRepositoryImpl constructor(
    private val messaging: FirebaseMessaging
) : MainRepository {
    override suspend fun subscribeToLowStockTopic() = try {
        messaging.subscribeToTopic(LOW_STOCK).await()
        Success(true)
    } catch (e: Exception) {
        Failure(e)
    }
}