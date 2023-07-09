package io.spherelabs.domain.auth


import io.spherelabs.firebaseauth.AuthResult
import io.spherelabs.firebaseauth.FirebaseAuthManager

interface SignInWithEmailAndPassword {
    suspend fun execute(email: String, password: String): Result<AuthResult>
}

class DefaultSignInWithEmailAndPassword(
    private val authManager: FirebaseAuthManager
) : SignInWithEmailAndPassword {
    override suspend fun execute(email: String, password: String): Result<AuthResult> {
        return authManager.signInWithEmailAndPassword(email, password)
    }
}