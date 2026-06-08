package com.example.csoft.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.csoft.R

class NavigationItemProps(val text: String, val image_id: Int){}

@Composable
fun NavigationItem(props: NavigationItemProps){
    Column(verticalArrangement = Arrangement.SpaceAround, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = props.image_id),
            contentDescription = null,
            Modifier.size(64.dp))
        Text(text = props.text, fontSize = 16.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun NavigationItemPreview(){
    NavigationItem(NavigationItemProps(text = "Transactions", image_id = R.drawable.ic_bill))
}