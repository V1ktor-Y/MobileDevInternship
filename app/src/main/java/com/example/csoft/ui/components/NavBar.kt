package com.example.csoft.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.csoft.R

data class NavigationItemProps(val text: String, val image_id: Int){}

@Composable
fun NavBar(navController: NavController, navItems: List<NavigationItemProps>) {
    var selectedItem by remember { mutableStateOf(0) }

    NavigationBar {
        navItems.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = { Image(painter = painterResource(item.image_id), contentDescription = null, modifier = Modifier.size(32.dp))},
                label = { Text(item.text) },
                selected = selectedItem == index,
                onClick = {
                    selectedItem = index
                    // Handle navigation here
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val navItems = listOf(NavigationItemProps(text = "Dashboard", image_id = R.drawable.ic_bill),
        NavigationItemProps(text = "Transactions", R.drawable.ic_money_insert),
        NavigationItemProps(text = "Categories", R.drawable.ic_check_write)
    )
    val navController = rememberNavController()
    NavBar(navController, navItems)
}
