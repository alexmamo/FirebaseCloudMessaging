package ro.alexmamo.firebasecloudmessaging.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ro.alexmamo.firebasecloudmessaging.domain.model.Response.Loading
import ro.alexmamo.firebasecloudmessaging.domain.model.Response.Success
import ro.alexmamo.firebasecloudmessaging.domain.repository.MainRepository
import ro.alexmamo.firebasecloudmessaging.domain.repository.SubscribeToLowStockTopicResponse
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val repo: MainRepository
): ViewModel() {
    var subscribeToLowStockTopicResponse by mutableStateOf<SubscribeToLowStockTopicResponse>(Success(false))

    init {
        subscribeToTopic()
    }

    private fun subscribeToTopic() = viewModelScope.launch {
        subscribeToLowStockTopicResponse = Loading
        subscribeToLowStockTopicResponse = repo.subscribeToLowStockTopic()
    }
}