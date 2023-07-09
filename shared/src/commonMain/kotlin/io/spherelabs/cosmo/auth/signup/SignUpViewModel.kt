package io.spherelabs.cosmo.auth.signup

import io.spherelabs.auth.signup.SignUpEffect
import io.spherelabs.auth.signup.SignUpMiddleware
import io.spherelabs.auth.signup.SignUpReducer
import io.spherelabs.auth.signup.SignUpState
import io.spherelabs.auth.signup.SignUpWish
import io.spherelabs.auth.signup.ValidateMiddleware
import io.spherelabs.meteor.configs.MeteorConfigs
import io.spherelabs.meteor.store.Store
import io.spherelabs.meteor.viewmodel.CommonViewModel
import io.spherelabs.meteor.viewmodel.createMeteor
import io.spherelabs.meteorviewmodel.commonflow.NonNullCommonFlow
import io.spherelabs.meteorviewmodel.commonflow.NonNullCommonStateFlow
import io.spherelabs.meteorviewmodel.commonflow.asCommonFlow
import io.spherelabs.meteorviewmodel.commonflow.asCommonStateFlow

class SignUpViewModel(
    private val signUpReducer: SignUpReducer,
    private val validateMiddleware: ValidateMiddleware,
    private val signUpMiddleware: SignUpMiddleware
) : CommonViewModel<SignUpState, SignUpWish, SignUpEffect>() {

    override val store: Store<SignUpState, SignUpWish, SignUpEffect> = createMeteor(
        configs = MeteorConfigs.build {
            initialState = SignUpState.Empty
            storeName = "SignUpViewModel"
            reducer = signUpReducer
            middlewares = listOf(validateMiddleware, signUpMiddleware)
        }
    )

    val effect: NonNullCommonFlow<SignUpEffect> = store.effect.asCommonFlow()
    val state: NonNullCommonStateFlow<SignUpState> = store.state.asCommonStateFlow()
}