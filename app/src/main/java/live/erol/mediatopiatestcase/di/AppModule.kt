package live.erol.mediatopiatestcase.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import live.erol.mediatopiatestcase.utils.Logger
import live.erol.mediatopiatestcase.utils.SPref
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    const val url = "https://media.meditopia.com/files/chatdata-example.json/"

    @Singleton
    @Provides
    fun provideLogger(): Logger = Logger()

    @Singleton
    @Provides
    fun provideMMKV(): SPref = SPref()

}