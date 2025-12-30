package com.greedygame.brokenandroidcomposeproject.ui

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.greedygame.brokenandroidcomposeproject.data.Article
import com.greedygame.brokenandroidcomposeproject.data.BrokenRepository
import com.greedygame.brokenandroidcomposeproject.viewmodel.MyViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.greedygame.brokenandroidcomposeproject.navigation.Routes

@Composable
fun NewsScreen(
    navController: NavHostController,
    viewModel: MyViewModel
) {
    val articles by viewModel.article.collectAsState()
    val loading by viewModel.loading.collectAsState()
    val error by viewModel.error.collectAsState()

//    LaunchedEffect(Unit) {
//        // Removed GlobalScope because we dont want to run the process forever
//        try {
//            val result = BrokenRepository.fetchArticlesBlocking()
//            articles = result
//            loading = false
//        } catch (e: Exception) {
//            error = e.message
//            loading = false
//        }
//    }

    if (loading) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
        return
    } else if (error != null) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = "Error: $error")
        }
        return
    } else if (articles.isEmpty()) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = "No articles found")
        }
        return
    }

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(articles) { article ->

            Row(
                modifier = Modifier.fillMaxWidth()
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color(0xFFc6c6c6))
                    .padding(10.dp)
                    .clickable{
                        viewModel.setSelectedArticle(article)
                        navController.navigate(Routes.DetailScreen.route)
                    },
                verticalAlignment = Alignment.CenterVertically,

            ) {
                AsyncImage(
                    model = article.imageUrl.takeIf { !it.isNullOrBlank() },
                    contentDescription = null,
                    modifier = Modifier.size(50.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
                Spacer(Modifier.width(10.dp))
                Text(text = "${article.title}", fontSize = 18.sp, color = Color.Black)
            }

            Spacer(Modifier.height(5.dp))
        }
    }
}