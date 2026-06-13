package com.example.csoft.ui.dashboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.csoft.data.DummyData
import com.example.csoft.data.EmptyData
import com.example.csoft.domain.DummyDataService
import com.example.csoft.ui.components.SectionLabel
import com.example.csoft.ui.components.TransactionCard

@Composable
fun DashboardScreen(dummyDataService: DummyDataService) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            SectionLabel("Total")
            TransactionCard(dummyDataService.getTotalSpentTransaction())
        }

        item {
            SectionLabel("Largest Transaction")
            TransactionCard(dummyDataService.getLargestTransaction())
        }

        item {
            SectionLabel("Recent Transactions")
        }

        items(
            items = dummyDataService.getTransactions() ?: emptyList(),
            key = { transaction -> transaction.id }
        ) { transaction ->
            TransactionCard(transaction)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDashboard() {
    val dataService = DummyDataService(DummyData())
    DashboardScreen(dataService)
}


@Preview(showBackground = true)
@Composable
fun PreviewDashboardNull() {
    val dataService = DummyDataService(EmptyData())
    DashboardScreen(dataService)
}
