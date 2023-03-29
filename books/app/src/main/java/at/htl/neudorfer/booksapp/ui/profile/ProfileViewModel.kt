package at.htl.neudorfer.booksapp.ui.profile

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import at.htl.neudorfer.booksapp.data.User
import at.htl.neudorfer.booksapp.model.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val profileRepository: UserRepository
) : ViewModel() {

    var users by mutableStateOf(emptyList<User?>())

    init {
        viewModelScope.launch {
            setupAdminUser()
            getAdminUser()
        }
    }

    suspend fun getUsers() = viewModelScope.launch(Dispatchers.IO) {
        profileRepository.getAll().collect { r -> users = r }
    }

    fun addUser(usr: User) = viewModelScope.launch(Dispatchers.IO) {
        profileRepository.insertUser(usr);
    }

    suspend fun getAdminUser() {
        profileRepository.getByUsername("admin").collect { u -> users = listOf<User?>(u) }
    }

    suspend fun setupAdminUser() {
        getAdminUser()

        if (users.size <= 0) {
            profileRepository.insertUser(
                user = User(
                    profilePicture = "1",
                    name = "admin",
                    id = -1
                )
            )
        }
    }
}