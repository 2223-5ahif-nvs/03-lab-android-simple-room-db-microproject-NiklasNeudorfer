package at.htl.neudorfer.booksapp.model.db

import android.content.Context
import androidx.room.Room
import at.htl.neudorfer.booksapp.data.User
import at.htl.neudorfer.booksapp.model.AuthorsRepository
import at.htl.neudorfer.booksapp.model.UserRepository
import at.htl.neudorfer.booksapp.model.db.dao.AuthorDao
import at.htl.neudorfer.booksapp.model.db.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "booksapp_db"
        )
            .fallbackToDestructiveMigration()
            .build()
    }


    // ----------------------------------------------------
    //      Author
    // ----------------------------------------------------

    @Provides
    fun provideAuthorDao(database: AppDatabase): AuthorDao {
        return database.authorDao()
    }


    @Provides
    fun provideAuthorRepo(dao: AuthorDao): AuthorsRepository {
        return AuthorsRepository(dao)
    }


    // ----------------------------------------------------
    //      User
    // ----------------------------------------------------

    @Provides
    fun provideUserDao(database: AppDatabase): UserDao {
        return database.userDao()
    }

    @Provides
    fun provideUserRepo(dao: UserDao): UserRepository {
        return UserRepository(dao)
    }
}