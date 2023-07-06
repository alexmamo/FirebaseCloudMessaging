package ro.alexmamo.firebasecloudmessaging.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import dagger.hilt.android.AndroidEntryPoint
import ro.alexmamo.firebasecloudmessaging.core.TEXT
import ro.alexmamo.firebasecloudmessaging.core.Utils.Companion.print
import ro.alexmamo.firebasecloudmessaging.domain.model.Response.Failure
import ro.alexmamo.firebasecloudmessaging.domain.model.Response.Loading
import ro.alexmamo.firebasecloudmessaging.domain.model.Response.Success

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<MainActivityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = TEXT,
                    fontSize = 18.sp
                )
            }
            SubscribeToLowStockTopic()
        }
    }

    @Composable
    private fun SubscribeToLowStockTopic() {
        when(val subscribeToLowStockTopicResponse = viewModel.subscribeToLowStockTopicResponse) {
            is Loading -> Unit
            is Success -> Unit
            is Failure -> print(subscribeToLowStockTopicResponse.e)
        }
    }
}