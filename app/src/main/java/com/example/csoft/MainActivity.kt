package com.example.csoft

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.csoft.data.DummyData
import com.example.csoft.domain.DummyDataService
import com.example.csoft.navigation.NavigationManager
import com.example.csoft.ui.components.NavBar
import com.example.csoft.ui.components.NavigationItemProps

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val navManager = remember { NavigationManager() }
            val dataService = DummyDataService(DummyData())

            Scaffold(
                bottomBar = {
                    NavBar(navController, navManager.navItems)
                }
            ) { paddingValues ->
                Box(modifier = Modifier.padding(paddingValues)) {
                    navManager.SetupNavGraph(
                        navController = navController,
                        dummyDataService = dataService
                    )
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainPreview() {
    val navController = rememberNavController()
    val navManager = remember { NavigationManager() }
    val dataService = DummyDataService(DummyData())

    Scaffold(
        bottomBar = {
            NavBar(navController, navManager.navItems)
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            navManager.SetupNavGraph(navController = navController, dummyDataService = dataService)
        }
    }
}