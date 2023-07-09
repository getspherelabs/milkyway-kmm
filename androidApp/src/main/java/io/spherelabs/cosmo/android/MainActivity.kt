package io.spherelabs.cosmo.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.spherelabs.cosmo.Greeting
import io.spherelabs.cosmo.android.auth.signup.SignUpRoute
import io.spherelabs.cosmo.android.onboarding.OnboardingRoute
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = "onboarding") {
                        composable("onboarding") {
                            OnboardingRoute(
                                viewModel = koinViewModel(),
                                navigateToSignIn = {

                                },
                                navigateToSignUp = {
                                    navController.navigate("sign_up")
                                }
                            )
                        }
                        composable("sign_in") {

                        }
                        composable("sign_up") {
                            SignUpRoute(viewModel = koinViewModel())
                        }
                    }
                }
            }
        }
    }
}
