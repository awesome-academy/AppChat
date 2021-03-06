package com.sunasterisk.appchat.db.repository

import android.net.Uri
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.AuthResult
import com.sunasterisk.appchat.db.Result
import com.sunasterisk.appchat.db.entity.Chat
import com.sunasterisk.appchat.db.entity.Group
import com.sunasterisk.appchat.db.entity.User
import kotlinx.coroutines.flow.Flow

interface Repository {
    interface AuthRepository {
        fun logIn(username: String, password: String): Flow<Result<AuthResult>>
        fun firebaseSignInWithCredential(googleAuthCredential: AuthCredential): Flow<Result<User>>
        fun register(
            username: String,
            password: String,
            selectedPhotoUri: Uri
        ): Flow<Result<User>>
    }

    interface ClientRepository {
        fun getChats(userId: String): Flow<Result<List<Chat>>>
        fun getGroups(userId: String): Flow<Result<List<Group>>>
        fun getFriends(userId: String): Flow<Result<List<User>>>
        fun getAllUsers(): Flow<Result<List<User>>>
    }
}
