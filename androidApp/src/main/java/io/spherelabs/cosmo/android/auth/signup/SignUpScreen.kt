package io.spherelabs.cosmo.android.auth.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import io.spherelabs.auth.signup.SignUpEffect
import io.spherelabs.auth.signup.SignUpState
import io.spherelabs.auth.signup.SignUpWish
import io.spherelabs.cosmo.auth.signup.SignUpViewModel
import io.spherelabs.milkyway.android.R
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

@Composable
fun SignUpRoute(
    viewModel: SignUpViewModel
) {
    SignUpScreen(
        signUpWish = { newWish ->
            viewModel.wish(newWish)
        },
        state = viewModel.state,
        effect = viewModel.effect
    )
}

@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
    signUpWish: (SignUpWish) -> Unit,
    state: StateFlow<SignUpState>,
    effect: Flow<SignUpEffect>,
) {
    val uiState = state.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.dark_gray)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = modifier.size(250.dp),
            painter = painterResource(id = R.drawable.vr_planet), contentDescription = null
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Column(
                modifier = modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = modifier.height(24.dp))

                Text(
                    text = stringResource(id = R.string.sign_up),
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.white)
                )

                Spacer(modifier = modifier.height(32.dp))
                EmailInput(
                    modifier = modifier,
                    name = uiState.value.email,
                    onEmailChanged = { newEmail ->
                        signUpWish.invoke(SignUpWish.OnEmailChanged(newEmail))
                    })

                Spacer(modifier = modifier.height(16.dp))
                NameInput(modifier, name = uiState.value.name, onNameChanged = { newName ->
                    signUpWish.invoke(SignUpWish.OnNameChanged(newName))
                })

                Spacer(modifier = modifier.height(16.dp))
                PasswordInput(
                    modifier,
                    password = uiState.value.password,
                    onPasswordChanged = { newPassword ->
                        signUpWish.invoke(SignUpWish.OnPasswordChanged(newPassword))
                    })

                Spacer(modifier = modifier.height(48.dp))

                SignUpButton(modifier = modifier) {
                    signUpWish.invoke(SignUpWish.OnSignUpClick)
                }
            }
        }

    }
}

@Composable
fun EmailInput(
    modifier: Modifier,
    name: String,
    onEmailChanged: (String) -> Unit
) {
    TextField(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 24.dp, end = 24.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(
                color = colorResource(
                    id = R.color.white
                )
            ),
        value = name,
        onValueChange = { newValue ->
            onEmailChanged.invoke(newValue)
        },
        label = {
            Text(
                text = stringResource(id = R.string.email),
                color = colorResource(id = R.color.dark_gray)
            )
        },
        singleLine = true,
        leadingIcon = {
            Image(
                painter = painterResource(id = R.drawable.ic_email),
                contentDescription = null
            )
        }
    )
}

@Composable
fun NameInput(
    modifier: Modifier,
    name: String,
    onNameChanged: (String) -> Unit
) {
    TextField(modifier = modifier
        .fillMaxWidth()
        .padding(start = 24.dp, end = 24.dp)
        .clip(RoundedCornerShape(12.dp))
        .background(
            color = colorResource(
                id = R.color.white
            )
        ),
        value = name,
        onValueChange = { newValue ->
            onNameChanged.invoke(newValue)
        },
        singleLine = true,
        leadingIcon = {
            Image(painter = painterResource(id = R.drawable.ic_name), contentDescription = null)
        },
        label = {
            Text(
                text = stringResource(id = R.string.your_name),
                color = colorResource(id = R.color.dark_gray)
            )
        }
    )
}

@Composable
fun PasswordInput(
    modifier: Modifier,
    password: String,
    onPasswordChanged: (String) -> Unit
) {
    TextField(modifier = modifier
        .fillMaxWidth()
        .padding(start = 24.dp, end = 24.dp)
        .clip(RoundedCornerShape(12.dp))
        .background(
            color = colorResource(
                id = R.color.white
            )
        ),
        value = password,
        onValueChange = { newValue ->
            onPasswordChanged.invoke(newValue)
        },
        singleLine = true,
        leadingIcon = {
            Image(painter = painterResource(id = R.drawable.ic_password), contentDescription = null)
        },
        label = {
            Text(
                text = stringResource(id = R.string.password),
                color = colorResource(id = R.color.dark_gray)
            )
        }
    )
}

@Composable
fun SignUpButton(
    modifier: Modifier,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(start = 24.dp, end = 24.dp),
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = colorResource(id = R.color.white),
            contentColor = colorResource(id = R.color.dark_gray)
        ),
        shape = RoundedCornerShape(12.dp)
    ) {
        Text(
            text = stringResource(id = R.string.sign_up),
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
    }
}

@Preview
@Composable
fun BackgroundPreview() {
    Surface {
        //SignUpScreen()
    }
}