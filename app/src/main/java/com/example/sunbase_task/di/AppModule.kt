package com.example.sunbase_task.di

import android.content.Context
import androidx.room.Room
import com.example.sunbase_task.db.ImageDatabase
import com.example.sunbase_task.other.Constants.IMAGE_DATABASE_IMAGE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideImageDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        ImageDatabase::class.java,
        IMAGE_DATABASE_IMAGE
    ).build()

    @Singleton
    @Provides
    fun provideImageDao(db: ImageDatabase) = db.getImageDao()

}