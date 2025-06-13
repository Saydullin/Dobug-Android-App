package com.saydullin.dobugapp.screen.auth

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.saydullin.dobugapp.model.auth.AuthState
import com.saydullin.dobugapp.util.NavScreen
import com.saydullin.dobugapp.viewmodel.AuthViewModel
import com.saydullin.domain.model.author.AuthorLogin

@Composable
fun SignInScreen(
    navController: NavController,
    authViewModel: AuthViewModel,
) {
    val usernameTextField = remember { mutableStateOf("") }
    val passwordTextField = remember { mutableStateOf("") }
    val passwordVisible = remember { mutableStateOf(false) }

    val error = authViewModel.error.collectAsState()
    val authState = authViewModel.authState.collectAsState()

    if (error.value != null) {
        Text(
            text = "Что-то пошло не так. ${error.value?.status}, ${error.value?.e}"
        )

        return
    }

    when(authState.value) {
        AuthState.LOADING -> {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .clip(RoundedCornerShape(16.dp)),
                contentAlignment = Alignment.Center,
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CircularProgressIndicator()

                    Spacer(Modifier.height(50.dp))

                    Text(
                        text = "Загрузка, проверка, авторизация ...",
                        textAlign = TextAlign.Center
                    )
                }
            }

            return
        }
        AuthState.SUCCESS_LOGIN -> {
            val context = LocalContext.current

            Toast.makeText(context, "Успешная авторизация", Toast.LENGTH_SHORT).show()

            authViewModel.resetState()

            navController.navigate(NavScreen.Home.route)
        }
        AuthState.SUCCESS_SIGNUP -> {
            val context = LocalContext.current

            Toast.makeText(context, "Успешная регистрация", Toast.LENGTH_SHORT).show()

            navController.navigate(NavScreen.Home.route)
        }
        else -> {

        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
       Column(
           modifier = Modifier
               .padding(16.dp)
               .clip(RoundedCornerShape(8.dp))
               .background(MaterialTheme.colorScheme.surface)
       ) {
           Column(
               modifier = Modifier
                   .padding(16.dp),
           ) {
               Text(
                   text = "Авторизация",
                   style = MaterialTheme.typography.headlineMedium
               )

               Spacer(modifier = Modifier.height(36.dp))
               TextField(
                   modifier = Modifier
                       .fillMaxWidth(),
                   value = usernameTextField.value,
                   onValueChange = { usernameTextField.value = it },
                   label = {
                       Text(
                           text = "Имя пользователя"
                       )
                   },
               )
               Spacer(modifier = Modifier.height(18.dp))
               TextField(
                   modifier = Modifier
                       .fillMaxWidth(),
                   value = passwordTextField.value,
                   onValueChange = { passwordTextField.value = it },
                   visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
                   keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                   label = {
                       Text(
                           text = "Пароль"
                       )
                   },
                   trailingIcon = {
                       val image = if (passwordVisible.value)
                           Icons.Filled.Done
                       else
                           Icons.Filled.Close

                       IconButton(
                           onClick = { passwordVisible.value = !passwordVisible.value }
                       ) {
                           Icon(
                               imageVector = image,
                               contentDescription = if (passwordVisible.value) {
                                   "Скрыть пароль"
                               } else {
                                   "Показать пароль"
                               }
                           )
                       }
                   }
               )
               Spacer(modifier = Modifier.height(16.dp))
               Row(
                   verticalAlignment = Alignment.CenterVertically
               ) {
                   Spacer(Modifier.weight(1f))
                   TextButton(
                       onClick = {navController.navigate(NavScreen.SignIn.route) }
                   ) {
                       Text(text = "Забыл пароль")
                   }
               }
               Row(
                   verticalAlignment = Alignment.CenterVertically
               ) {
                   Button(
                       onClick = {
                           val author = AuthorLogin(
                               username = usernameTextField.value,
                               password = passwordTextField.value,
                           )

                           authViewModel.login(author)
                       }
                   ) {
                       Text(
                           text = "Готово"
                       )
                   }
                   Spacer(Modifier.weight(1f))
                   TextButton(
                       onClick = { navController.navigate(NavScreen.SignUp.route) }
                   ) {
                       Text(text = "Еще нет аккаунта")
                   }
               }
           }
       }
    }

}