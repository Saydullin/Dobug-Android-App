package com.saydullin.dobugapp.screen.profile

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.saydullin.dobugapp.model.company.CompanyUI
import com.saydullin.dobugapp.model.education.EducationUI
import com.saydullin.dobugapp.screen.profile.component.ProfileDescription
import com.saydullin.dobugapp.screen.profile.component.ProfileEducation
import com.saydullin.dobugapp.screen.profile.component.ProfileExperience
import com.saydullin.dobugapp.screen.profile.component.ProfileHeader
import com.saydullin.dobugapp.screen.profile.component.ProfileStatistics

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProfileScreen() {

    val experienceList = listOf(
        CompanyUI(
            id = 1L,
            title = "Google",
            description = "Developed scalable Android apps, implemented MVVM architecture, and improved app performance by 30%",
            duration = "3 years 2 months",
            startedAt = "",
            endedAt = "",
            imageUrl = "https://t4.ftcdn.net/jpg/03/91/79/25/360_F_391792593_BYfEk8FhvfNvXC5ERCw166qRFb8mYWya.jpg",
            url = "https://www.google.com/"
        ),
        CompanyUI(
            id = 2L,
            title = "Facebook",
            description = "Collaborated on Android SDK development, optimized UI rendering, and reduced app load time by 25%",
            duration = "2 years 6 months",
            startedAt = "",
            endedAt = "",
            imageUrl = "https://t4.ftcdn.net/jpg/03/91/79/26/360_F_391792594_BYfEk8FhvfNvXC5ERCw166qRFb8mYWyb.jpg",
            url = "https://www.google.com/"
        ),
        CompanyUI(
            id = 3L,
            title = "Amazon",
            description = "Led the development of a new shopping feature in the Android app, increasing user engagement by 15%",
            duration = "1 year 11 months",
            startedAt = "",
            endedAt = "",
            imageUrl = "https://t4.ftcdn.net/jpg/03/91/79/27/360_F_391792595_BYfEk8FhvfNvXC5ERCw166qRFb8mYWyc.jpg",
            url = "https://www.google.com/"
        ),
        CompanyUI(
            id = 4L,
            title = "Netflix",
            description = "Implemented offline viewing functionality, enhancing user experience and boosting retention rates",
            duration = "1 year 3 months",
            startedAt = "",
            endedAt = "",
            imageUrl = "https://t4.ftcdn.net/jpg/03/91/79/28/360_F_391792596_BYfEk8FhvfNvXC5ERCw166qRFb8mYWyd.jpg",
            url = "https://www.google.com/"
        ),
        CompanyUI(
            id = 5L,
            title = "Spotify",
            description = "Optimized audio streaming on Android, reducing buffering times and improving playback stability",
            duration = "2 years 1 month",
            startedAt = "",
            endedAt = "",
            imageUrl = "https://t4.ftcdn.net/jpg/03/91/79/29/360_F_391792597_BYfEk8FhvfNvXC5ERCw166qRFb8mYWye.jpg",
            url = "https://www.google.com/"
        ),
        CompanyUI(
            id = 6L,
            title = "Uber",
            description = "Developed real-time tracking features in the driver app, enhancing navigation accuracy and user trust",
            duration = "1 year 8 months",
            startedAt = "",
            endedAt = "",
            imageUrl = "https://t4.ftcdn.net/jpg/03/91/79/30/360_F_391792598_BYfEk8FhvfNvXC5ERCw166qRFb8mYWyf.jpg",
            url = "https://www.google.com/"
        )
    )

    val educationList = listOf(
        EducationUI(
            id = 1L,
            companyTitle = "Vilnius University",
            title = "Bachelor of Science in Computer Science – Vilnius University",
            description = "Comprehensive study covering algorithms, data structures, and software engineering principles.",
            startedAt = "2014-09",
            endedAt = "2018-06",
            duration = "4 years",
            imageUrl = "https://www.statybunaujienos.lt/images/naujienos/1200_900/13013d8b56b102005a7b584868e7fd1b.jpg",
            url = "https://www.vu.lt/en/",
            certificateImageUrl = "https://example.com/certificates/vu_bsc_cs.jpg"
        ),
        EducationUI(
            id = 2L,
            companyTitle = "Google",
            title = "Android Kotlin Fundamentals – Google Developers",
            description = "Learned the fundamentals of Android development and best practices using Kotlin.",
            startedAt = "2019-01",
            endedAt = "2019-03",
            duration = "2 months",
            imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQFIxhAKQFNdrSkqC_XeO6nkk5KoLEljiOCfQ&s",
            url = "https://developer.android.com/courses/kotlin-fundamentals/course",
            certificateImageUrl = "https://example.com/certificates/android_kotlin_fundamentals.jpg"
        ),
        EducationUI(
            id = 3L,
            companyTitle = "Udemy",
            title = "Advanced Android with Kotlin – Udacity",
            description = "Explored advanced Android features like custom views, animations, and testing.",
            startedAt = "2020-05",
            endedAt = "2020-07",
            duration = "2 months",
            imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR7zmzguRUdNPxg-5ixP9ICiFXXiKx1gBAIKQ&s",
            url = "https://www.udacity.com/course/advanced-android-with-kotlin--ud940",
            certificateImageUrl = "https://example.com/certificates/advanced_android_kotlin.jpg"
        ),
        EducationUI(
            id = 4L,
            companyTitle = "Udemy",
            title = "Developing Android Applications with Kotlin – Pluralsight",
            description = "Gained skills in building Android apps using Kotlin and Android Studio.",
            startedAt = "2021-02",
            endedAt = "2021-04",
            duration = "2 months",
            imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR7zmzguRUdNPxg-5ixP9ICiFXXiKx1gBAIKQ&s",
            url = "https://www.pluralsight.com/paths/android-development-with-kotlin-fundamentals",
            certificateImageUrl = "https://example.com/certificates/pluralsight_android_kotlin.jpg"
        ),
        EducationUI(
            id = 5L,
            companyTitle = "Codeacademy",
            title = "Kotlin for Android: Beginner to Advanced – Udemy",
            description = "Covered Kotlin programming and Android app development from basics to advanced topics.",
            startedAt = "2022-03",
            endedAt = "2022-05",
            duration = "2 months",
            imageUrl = "https://yt3.googleusercontent.com/OoIfYjblzMBPeV3kAHvaOYNgQmvJeVUB9q14pRuAhawNFRppUstvr_inYiBzdVB6EuWhK4li=s900-c-k-c0x00ffffff-no-rj",
            url = "https://www.udemy.com/course/devslopes-android-kotlin/",
            certificateImageUrl = "https://example.com/certificates/kotlin_android_udemy.jpg"
        ),
        EducationUI(
            id = 6L,
            companyTitle = "Udemy",
            title = "Advanced Programming in Kotlin – Coursera (Meta)",
            description = "Delved into advanced Kotlin programming concepts and Android application development.",
            startedAt = "2023-06",
            endedAt = "2023-08",
            duration = "2 months",
            imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR7zmzguRUdNPxg-5ixP9ICiFXXiKx1gBAIKQ&s",
            url = "https://www.coursera.org/learn/advanced-programming-in-kotlin/",
            certificateImageUrl = "https://example.com/certificates/advanced_kotlin_coursera.jpg"
        )
    )


    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(top = 50.dp),
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        stickyHeader {
            ProfileHeader()
        }
        item {
            ProfileStatistics()
        }
        item {
            ProfileDescription()
        }
        item {
            ProfileExperience(experienceList)
        }
        item {
            ProfileEducation(educationList)
        }
    }


}