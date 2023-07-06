package ro.alexmamo.firebasecloudmessaging.domain.repository

import ro.alexmamo.firebasecloudmessaging.domain.model.Response

typealias SubscribeToLowStockTopicResponse = Response<Boolean>

interface MainRepository {
    suspend fun subscribeToLowStockTopic(): SubscribeToLowStockTopicResponse
}