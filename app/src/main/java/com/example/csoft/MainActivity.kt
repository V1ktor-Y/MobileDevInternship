package com.example.csoft

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.csoft.ui.components.NavBar
import com.example.csoft.ui.components.NavigationItemProps

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navItems = listOf(NavigationItemProps(text = "Dashboard", image_id = R.drawable.ic_bill),
                NavigationItemProps(text = "Transactions", R.drawable.ic_money_insert),
                NavigationItemProps(text = "Categories", R.drawable.ic_check_write)
            )
            val navController = rememberNavController()
            Scaffold(modifier = Modifier.fillMaxSize(), bottomBar = { NavBar(navController = navController, navItems = navItems) } ) { innerPadding ->
                Text(text = "Hello world")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainPreview() {
    val navItems = listOf(NavigationItemProps(text = "Dashboard", image_id = R.drawable.ic_bill),
        NavigationItemProps(text = "Transactions", R.drawable.ic_money_insert),
        NavigationItemProps(text = "Categories", R.drawable.ic_check_write)
    )
    val navController = rememberNavController()
    Scaffold(modifier = Modifier.fillMaxSize(), bottomBar = { NavBar(navController = navController, navItems = navItems) } ) { innerPadding ->
        Text(text = "Hello world")
    }
}