package com.saydullin.dobugapp.screen.profile

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import coil.compose.AsyncImage
import com.saydullin.dobugapp.component.company.CompanyItem
import com.saydullin.dobugapp.model.company.CompanyUI
import com.saydullin.dobugapp.screen.profile.component.ProfileExperience

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProfileScreen() {

    val experienceList = listOf(
        CompanyUI(
            id = 1L,
            title = "Google",
            description = "Developed scalable Android apps, implemented MVVM architecture, and improved app performance by 30%",
            duration = "3 years 2 months",
            imageUrl = "https://t4.ftcdn.net/jpg/03/91/79/25/360_F_391792593_BYfEk8FhvfNvXC5ERCw166qRFb8mYWya.jpg",
            companyUrl = "https://www.google.com/"
        ),
        CompanyUI(
            id = 2L,
            title = "Facebook",
            description = "Collaborated on Android SDK development, optimized UI rendering, and reduced app load time by 25%",
            duration = "2 years 6 months",
            imageUrl = "https://t4.ftcdn.net/jpg/03/91/79/26/360_F_391792594_BYfEk8FhvfNvXC5ERCw166qRFb8mYWyb.jpg",
            companyUrl = "https://www.google.com/"
        ),
        CompanyUI(
            id = 3L,
            title = "Amazon",
            description = "Led the development of a new shopping feature in the Android app, increasing user engagement by 15%",
            duration = "1 year 11 months",
            imageUrl = "https://t4.ftcdn.net/jpg/03/91/79/27/360_F_391792595_BYfEk8FhvfNvXC5ERCw166qRFb8mYWyc.jpg",
            companyUrl = "https://www.google.com/"
        ),
        CompanyUI(
            id = 4L,
            title = "Netflix",
            description = "Implemented offline viewing functionality, enhancing user experience and boosting retention rates",
            duration = "1 year 3 months",
            imageUrl = "https://t4.ftcdn.net/jpg/03/91/79/28/360_F_391792596_BYfEk8FhvfNvXC5ERCw166qRFb8mYWyd.jpg",
            companyUrl = "https://www.google.com/"
        ),
        CompanyUI(
            id = 5L,
            title = "Spotify",
            description = "Optimized audio streaming on Android, reducing buffering times and improving playback stability",
            duration = "2 years 1 month",
            imageUrl = "https://t4.ftcdn.net/jpg/03/91/79/29/360_F_391792597_BYfEk8FhvfNvXC5ERCw166qRFb8mYWye.jpg",
            companyUrl = "https://www.google.com/"
        ),
        CompanyUI(
            id = 6L,
            title = "Uber",
            description = "Developed real-time tracking features in the driver app, enhancing navigation accuracy and user trust",
            duration = "1 year 8 months",
            imageUrl = "https://t4.ftcdn.net/jpg/03/91/79/30/360_F_391792598_BYfEk8FhvfNvXC5ERCw166qRFb8mYWyf.jpg",
            companyUrl = "https://www.google.com/"
        )
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(top = 50.dp)
    ) {
        stickyHeader {
            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .background(MaterialTheme.colorScheme.background),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "Сай",
                    style = MaterialTheme.typography.headlineMedium
                )
                Spacer(Modifier.weight(1f))
                IconButton(
                    onClick = {}
                ) {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = "settings"
                    )
                }
            }
        }
        item {
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                val shape = RoundedCornerShape(50.dp)

                Box(
                    modifier = Modifier
                        .size(80.dp)
                        .clip(shape)
                        .background(MaterialTheme.colorScheme.background)
                        .zIndex(1f)
                ) {
                    AsyncImage(
                        model = "https://thispersondoesnotexist.com/",
                        contentDescription = "My image",
                        contentScale = ContentScale.FillHeight,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(2.dp)
                            .clip(shape)
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier
                            .align(Alignment.CenterVertically),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(
                            text = "324",
                            style = MaterialTheme.typography.titleLarge
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            text = "subscribers",
                            style = MaterialTheme.typography.titleSmall
                        )
                    }
                    Column(
                        modifier = Modifier
                            .align(Alignment.CenterVertically),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(
                            text = "18",
                            style = MaterialTheme.typography.titleLarge
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            text = "likes",
                            style = MaterialTheme.typography.titleSmall
                        )
                    }
                    Column(
                        modifier = Modifier
                            .align(Alignment.CenterVertically),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(
                            text = "43",
                            style = MaterialTheme.typography.titleLarge
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            text = "subscriptions",
                            style = MaterialTheme.typography.titleSmall
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
            ) {
                Text(
                    text = "Android Developer",
                    style = MaterialTheme.typography.titleLarge
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable",
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(modifier = Modifier.height(32.dp))
                ProfileExperience(experienceList)
                Spacer(modifier = Modifier.height(32.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Education",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = "6 years",
                        style = MaterialTheme.typography.titleMedium
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
//                for (i in 1..2) {
//                    CompanyItem()
//                    Spacer(modifier = Modifier.height(8.dp))
//                }
            }
        }
    }


}