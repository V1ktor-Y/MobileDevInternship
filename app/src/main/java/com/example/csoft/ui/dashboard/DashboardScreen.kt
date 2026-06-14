package com.example.csoft.ui.dashboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.csoft.data.DummyData
import com.example.csoft.data.EmptyData
import com.example.csoft.domain.Category
import com.example.csoft.domain.DummyDataService
import com.example.csoft.domain.TransactionService
import com.example.csoft.ui.components.SectionLabel
import com.example.csoft.ui.components.TransactionCard

@Composable
fun DashboardScreen(dataService: TransactionService) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),

        ) {
        item(key = "Total") {
            SectionLabel("Total")
            TransactionCard(dataService.getTotalSpentTransaction())
        }

        item(key = "Largest") {
            SectionLabel("Largest Transaction")
            TransactionCard(dataService.getLargestTransaction())
        }

        item(key = "Recent") {
            SectionLabel("Recent Transactions")
        }

        items(
            items = dataService.getTransactions() ?: emptyList(),
            key = { transaction -> transaction.id }
        ) { transaction ->
            TransactionCard(transaction)
        }
        item(key = "Category") {
            SectionLabel("Category Overview")

            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                maxItemsInEachRow = 2,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Category.entries.forEach { c ->
                    CategoryPercentCard(dataService, c)
                }
            }
        }
        item(key = "BottomSpacer") { Spacer(Modifier.padding(16.dp)) }
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
