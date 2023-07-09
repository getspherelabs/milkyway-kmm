package io.spherelabs.domain.auth

import io.spherelabs.firebaseauth.AuthResult
import io.spherelabs.firebaseauth.FirebaseAuthManager

interface CreateEmailAndPassword {
    suspend fun execute(email: String, password: String): Result<AuthResult>
}

class DefaultCreateEmailAndPassword(
    private val authManager: FirebaseAuthManager
) : CreateEmailAndPassword {
    override suspend fun execute(email: String, password: String): Result<AuthResult> {
        return authManager.createEmailAndPassword(email, password)
    }
}