package com.saydullin.dobugapp.screen.auth

import androidx.compose.foundation.background
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
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.saydullin.dobugapp.util.NavScreen

@Composable
fun SignUpScreen(
    navController: NavController
) {
    val usernameTextField = remember { mutableStateOf("") }
    val emailTextField = remember { mutableStateOf("") }
    val passwordTextField = remember { mutableStateOf("") }
    val passwordVisible = remember { mutableStateOf(false) }

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
                   text = "Регистрация",
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
                   value = emailTextField.value,
                   onValueChange = { emailTextField.value = it },
                   label = {
                       Text(
                           text = "Почта"
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
               Spacer(modifier = Modifier.height(36.dp))
               Row {
                   Button(
                       onClick = { navController.navigate(NavScreen.Home.route) }
                   ) {
                       Text(
                           text = "Готово"
                       )
                   }
                   Spacer(Modifier.weight(1f))
                   TextButton(
                       onClick = { navController.navigate(NavScreen.SignIn.route) }
                   ) {
                       Text(text = "Уже есть аккаунт")
                   }
               }
           }
       }
    }

}