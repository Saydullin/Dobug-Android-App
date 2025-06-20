package com.saydullin.dobugapp.screen.profile

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.saydullin.dobugapp.model.company.CompanyUI
import com.saydullin.dobugapp.model.education.EducationUI
import com.saydullin.dobugapp.screen.profile.component.ProfileDescription
import com.saydullin.dobugapp.screen.profile.component.ProfileEducation
import com.saydullin.dobugapp.screen.profile.component.ProfileExperience
import com.saydullin.dobugapp.screen.profile.component.ProfileHeader
import com.saydullin.dobugapp.screen.profile.component.ProfileStatistics

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProfileScreen(
    navController: NavController,
) {

    val experienceList = listOf(
        CompanyUI(
            id = 1L,
            title = "Google",
            description = "Разрабатывал масштабируемые Android-приложения, внедрял архитектуру MVVM и повысил производительность приложений на 30%.\nИмею опыт работы с Kotlin, Jetpack Compose, сопрограммами и внедрением зависимостей с помощью Hilt.\nСнижал утечки памяти и количество сбоев через профилирование и рефакторинг кода. Работал в кросс-функциональных командах и своевременно выпускал новые функции",
            duration = "3 года 2 месяца",
            startedAt = "",
            endedAt = "",
            imageUrl = "https://t4.ftcdn.net/jpg/03/91/79/25/360_F_391792593_BYfEk8FhvfNvXC5ERCw166qRFb8mYWya.jpg",
            url = "https://www.google.com/"
        ),
        CompanyUI(
            id = 2L,
            title = "Facebook",
            description = "Участвовал в разработке Android SDK, оптимизировал отрисовку интерфейса и сократил время загрузки приложения на 25%. Создавал пользовательские UI-компоненты с использованием Jetpack Compose и повышал эффективность рендеринга на устройствах с низкой производительностью. Внёс вклад в модульную архитектуру проекта для улучшения масштабируемости и поддержки.",
            duration = "2 года 6 месяца",
            startedAt = "",
            endedAt = "",
            imageUrl = "https://t4.ftcdn.net/jpg/03/91/79/26/360_F_391792594_BYfEk8FhvfNvXC5ERCw166qRFb8mYWyb.jpg",
            url = "https://www.google.com/"
        ),
        CompanyUI(
            id = 3L,
            title = "Amazon",
            description = "Руководил разработкой новой функции покупок в Android-приложении, увеличив вовлечённость пользователей на 15%",
            duration = "1 год 11 месяцев",
            startedAt = "",
            endedAt = "",
            imageUrl = "https://t4.ftcdn.net/jpg/03/91/79/27/360_F_391792595_BYfEk8FhvfNvXC5ERCw166qRFb8mYWyc.jpg",
            url = "https://www.google.com/"
        ),
        CompanyUI(
            id = 4L,
            title = "Netflix",
            description = "Реализовал возможность офлайн-просмотра, улучшив пользовательский опыт и повысив показатели удержания",
            duration = "1 год 3 месяца",
            startedAt = "",
            endedAt = "",
            imageUrl = "https://t4.ftcdn.net/jpg/03/91/79/28/360_F_391792596_BYfEk8FhvfNvXC5ERCw166qRFb8mYWyd.jpg",
            url = "https://www.google.com/"
        ),
        CompanyUI(
            id = 5L,
            title = "Spotify",
            description = "Оптимизировал потоковое аудио на Android, сократив время буферизации и улучшив стабильность воспроизведения",
            duration = "2 года 1 месяц",
            startedAt = "",
            endedAt = "",
            imageUrl = "https://t4.ftcdn.net/jpg/03/91/79/29/360_F_391792597_BYfEk8FhvfNvXC5ERCw166qRFb8mYWye.jpg",
            url = "https://www.google.com/"
        ),
        CompanyUI(
            id = 6L,
            title = "Uber",
            description = "Разработал функции отслеживания в реальном времени в приложении для водителей, повысив точность навигации и доверие пользователей",
            duration = "1 год 8 месяцев",
            startedAt = "",
            endedAt = "",
            imageUrl = "https://t4.ftcdn.net/jpg/03/91/79/30/360_F_391792598_BYfEk8FhvfNvXC5ERCw166qRFb8mYWyf.jpg",
            url = "https://www.google.com/"
        )
    )

    val educationList = listOf(
        EducationUI(
            id = 1L,
            companyTitle = "Вильнюсский университет",
            title = "Бакалавр наук в области компьютерных наук – Вильнюсский университет",
            description = "Комплексное обучение, охватывающее алгоритмы, структуры данных и принципы разработки программного обеспечения.",
            startedAt = "2014-09",
            endedAt = "2018-06",
            duration = "4 года",
            imageUrl = "https://www.statybunaujienos.lt/images/naujienos/1200_900/13013d8b56b102005a7b584868e7fd1b.jpg",
            url = "https://www.vu.lt/en/",
            certificateImageUrl = "https://example.com/certificates/vu_bsc_cs.jpg"
        ),
        EducationUI(
            id = 2L,
            companyTitle = "Google",
            title = "Основы Android на Kotlin – Google Developers",
            description = "Изучил основы разработки Android и лучшие практики с использованием языка Kotlin.",
            startedAt = "2019-01",
            endedAt = "2019-03",
            duration = "2 месяца",
            imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQFIxhAKQFNdrSkqC_XeO6nkk5KoLEljiOCfQ&s",
            url = "https://developer.android.com/courses/kotlin-fundamentals/course",
            certificateImageUrl = "https://example.com/certificates/android_kotlin_fundamentals.jpg"
        ),
        EducationUI(
            id = 3L,
            companyTitle = "Udemy",
            title = "Продвинутый Android с Kotlin – Udacity",
            description = "Изучал продвинутые функции Android, такие как пользовательские представления, анимации и тестирование.",
            startedAt = "2020-05",
            endedAt = "2020-07",
            duration = "2 месяца",
            imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR7zmzguRUdNPxg-5ixP9ICiFXXiKx1gBAIKQ&s",
            url = "https://www.udacity.com/course/advanced-android-with-kotlin--ud940",
            certificateImageUrl = "https://example.com/certificates/advanced_android_kotlin.jpg"
        ),
        EducationUI(
            id = 4L,
            companyTitle = "Udemy",
            title = "Разработка Android-приложений на Kotlin – Pluralsight",
            description = "Освоил навыки создания Android-приложений с использованием Kotlin и Android Studio.",
            startedAt = "2021-02",
            endedAt = "2021-04",
            duration = "2 месяца",
            imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR7zmzguRUdNPxg-5ixP9ICiFXXiKx1gBAIKQ&s",
            url = "https://www.pluralsight.com/paths/android-development-with-kotlin-fundamentals",
            certificateImageUrl = "https://example.com/certificates/pluralsight_android_kotlin.jpg"
        ),
        EducationUI(
            id = 5L,
            companyTitle = "Codeacademy",
            title = "Kotlin для Android: от начинающего до продвинутого – Udemy",
            description = "Охватил программирование на Kotlin и разработку Android-приложений от основ до продвинутых тем.",
            startedAt = "2022-03",
            endedAt = "2022-05",
            duration = "2 месяца",
            imageUrl = "https://yt3.googleusercontent.com/OoIfYjblzMBPeV3kAHvaOYNgQmvJeVUB9q14pRuAhawNFRppUstvr_inYiBzdVB6EuWhK4li=s900-c-k-c0x00ffffff-no-rj",
            url = "https://www.udemy.com/course/devslopes-android-kotlin/",
            certificateImageUrl = "https://example.com/certificates/kotlin_android_udemy.jpg"
        ),
        EducationUI(
            id = 6L,
            companyTitle = "Udemy",
            title = "Продвинутое программирование на Kotlin – Coursera (Meta)",
            description = "Глубоко изучил продвинутые концепции программирования на Kotlin и разработку Android-приложений.",
            startedAt = "2023-06",
            endedAt = "2023-08",
            duration = "2 месяца",
            imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR7zmzguRUdNPxg-5ixP9ICiFXXiKx1gBAIKQ&s",
            url = "https://www.coursera.org/learn/advanced-programming-in-kotlin/",
            certificateImageUrl = "https://example.com/certificates/advanced_kotlin_coursera.jpg"
        )
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(top = 50.dp),
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        stickyHeader {
            ProfileHeader(navController = navController)
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


