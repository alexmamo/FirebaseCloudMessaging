package ro.alexmamo.firebasecloudmessaging.di

import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.ktx.messaging
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ro.alexmamo.firebasecloudmessaging.data.repository.MainRepositoryImpl
import ro.alexmamo.firebasecloudmessaging.domain.repository.MainRepository

@Module
@InstallIn(ViewModelComponent::class)
class AppModule {
    @Provides
    fun provideFirebaseMessaging() = Firebase.messaging

    @Provides
    fun provideMainRepository(
        messaging: FirebaseMessaging
    ): MainRepository = MainRepositoryImpl(
        messaging = messaging
    )
}