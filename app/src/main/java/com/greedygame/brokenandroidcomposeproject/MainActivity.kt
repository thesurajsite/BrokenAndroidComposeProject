package com.greedygame.brokenandroidcomposeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.greedygame.brokenandroidcomposeproject.navigation.NavGraph
import com.greedygame.brokenandroidcomposeproject.ui.NewsScreen
import com.greedygame.brokenandroidcomposeproject.viewmodel.MyViewModel

class MainActivity : ComponentActivity() {

    // removed the Companion Object and Activity static reference to prevent Leak

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()

            Surface(modifier = Modifier.fillMaxSize()) {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Box(modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center){
                                    Text("Broken News", fontSize = 28.sp, color = Color.Black)
                                }
                            }
                        )
                    }
                ) {
                    paddingValues ->
                    Box(modifier = Modifier.fillMaxSize().padding(paddingValues)){
                        NavGraph(navController)
                    }
                }
            }
        }
    }
}