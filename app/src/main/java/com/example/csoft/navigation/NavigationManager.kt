package com.example.csoft.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.csoft.R
import com.example.csoft.domain.DummyDataService
import com.example.csoft.ui.category.CategoryScreen
import com.example.csoft.ui.components.NavigationItemProps
import com.example.csoft.ui.dashboard.DashboardScreen
import com.example.csoft.ui.transaction.TransactionScreen

class NavigationManager {

    val navItems = listOf(
        NavigationItemProps(text = "Dashboard", image_id = R.drawable.ic_house),
        NavigationItemProps(text = "Transactions", R.drawable.ic_money_insert),
        NavigationItemProps(text = "Categories", R.drawable.ic_category)
    )

    val startDestination = "Dashboard"

    @Composable
    fun SetupNavGraph(navController: NavHostController, dummyDataService: DummyDataService) {
        NavHost(
            navController = navController,
            startDestination = startDestination
        ) {
            composable(route = "Dashboard") {
                DashboardScreen(dummyDataService)
            }
            composable(route = "Transactions") {
                TransactionScreen(dummyDataService)
            }
            composable(route = "Categories") {
                CategoryScreen(dummyDataService)
            }
        }
    }

}