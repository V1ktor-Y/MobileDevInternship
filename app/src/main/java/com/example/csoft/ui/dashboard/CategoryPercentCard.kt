package com.example.csoft.ui.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.csoft.data.DummyData
import com.example.csoft.data.EmptyData
import com.example.csoft.domain.Category
import com.example.csoft.domain.DummyDataService
import com.example.csoft.domain.TransactionService

@Composable
fun CategoryPercentCard(service: TransactionService, category: Category) {
    Card(
        modifier = Modifier
            .padding(16.dp),
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Image(
                painter = painterResource(category.icon),
                contentDescription = null,
                Modifier.size(64.dp)
            )
            HorizontalDivider()
            Text(text = category.toString(), fontWeight = FontWeight.Bold)
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                val percent = service.getCategoryPercent(category)
                LinearProgressIndicator(
                    modifier = Modifier.weight(1f),
                    progress = { percent.toFloat() / 100f })
                Text(
                    "${String.format("%.1f", percent)}%",
                    style = MaterialTheme.typography.labelLarge
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCategoryPercentCard() {
    CategoryPercentCard(DummyDataService(DummyData()), Category.BILLS)
}

@Preview(showBackground = true)
@Composable
fun PreviewCategoryPercentCardNull() {
    CategoryPercentCard(DummyDataService(EmptyData()), Category.OTHER)
}
