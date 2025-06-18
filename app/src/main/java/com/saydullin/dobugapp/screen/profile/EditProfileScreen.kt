package com.saydullin.dobugapp.screen.profile

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.saydullin.dobugapp.component.header.ScreenHeader
import com.saydullin.dobugapp.screen.profile.component.ProfileEditForm
import com.saydullin.dobugapp.screen.profile.component.ProfileImageEditor

@Composable
fun EditProfileScreen(
    navController: NavController,
) {
    val context = LocalContext.current

    Column {
        ScreenHeader(
            Icons.AutoMirrored.Filled.ArrowBack,
            "Edit profile",
            Icons.Default.Done,
            onClickLeftIcon = {
                navController.popBackStack()
            },
            onClickRightIcon = {
                navController.popBackStack()
            },
        )
        LazyColumn {
            item {
                Spacer(Modifier.height(32.dp))
                ProfileImageEditor(
                    onClick = {
                        Toast.makeText(context, "Changing", Toast.LENGTH_SHORT).show()
                    }
                )
                Spacer(Modifier.height(32.dp))
            }
            item {
                ProfileEditForm()
            }
        }

    }

}