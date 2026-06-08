package com.example.csoft.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.csoft.R

@Composable
fun BottomNav (){
    // TODO: not this
    val navItems = listOf(NavigationItemProps(text = "Dashboard", image_id = R.drawable.ic_bill),
        NavigationItemProps(text = "Transactions", R.drawable.ic_money_insert),
        NavigationItemProps(text = "Categories", R.drawable.ic_check_write)
    )
    Column() {
        HorizontalDivider(thickness = 8.dp)

        Spacer(modifier = Modifier.height(8.dp))

        Row(horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
            navItems.forEach { props -> NavigationItem(props = props) }

        }

        Spacer(modifier = Modifier.height(8.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BottomNav()
}
