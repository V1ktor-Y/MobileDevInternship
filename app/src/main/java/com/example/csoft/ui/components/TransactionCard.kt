package com.example.csoft.ui.components

import android.R.attr.label
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Label
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.csoft.domain.Category
import com.example.csoft.domain.Currency
import com.example.csoft.domain.Transaction

@Composable
fun TransactionCard(transaction: Transaction?): Unit {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = transaction?.recipient ?: "Unknown",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            HorizontalDivider()
            Text(
                text = "Transaction: ${transaction?.sum ?: 0.0} ${transaction?.currency ?: Currency.USD}",
            )
            Text(
                text = "Category: ${transaction?.category ?: Category.OTHER}",
                // is the example below too much logic for UI?
                //text = "Category: ${transaction.category.toString().lowercase().replaceFirstChar { it.uppercase() }}",
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewTransactionCard() {
    val t = Transaction(
        recipient = "Peter",
        sum = 299.0,
        currency = Currency.USD,
        category = Category.PEOPLE,
        id = 0
    )

    TransactionCard(t)
}
@Preview(showBackground = true)
@Composable
fun PreviewTransactionCardNull() {
    TransactionCard(null)
}
