package at.htl.neudorfer.books.di

import android.content.Context
import androidx.room.Room
import at.htl.neudorfer.books.data.LibraryDatabase
import at.htl.neudorfer.books.utils.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context,
    ) = Room.databaseBuilder(
        context,
        LibraryDatabase::class.java,
        DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideBookDao(database: LibraryDatabase) = database.bookDao()

    @Singleton
    @Provides
    fun provideAuthorDao(database: LibraryDatabase) = database.authorDao()


}


