package at.htl.neudorfer.booksapp.model

import android.content.Context
import androidx.room.Room
import at.htl.neudorfer.booksapp.model.db.AppDatabase
import at.htl.neudorfer.booksapp.model.db.dao.AuthorDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideDatabase(@ApplicationContext context: Context) : AppDatabase{
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "booksapp_db"
        ).build()
    }

    @Provides
    fun provideAuthorDao(database: AppDatabase) : AuthorDao{
        return database.authorDao()
    }


    @Provides
    fun provideAuthorRepo(dao: AuthorDao) : AuthorsRepository{
        return AuthorsRepository(dao)
    }

}