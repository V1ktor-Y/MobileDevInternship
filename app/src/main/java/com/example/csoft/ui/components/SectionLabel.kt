package com.example.csoft.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SectionLabel(text: String) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        HorizontalDivider(Modifier.weight(0.15f))
        Text(text = text, style = MaterialTheme.typography.titleLarge)
        HorizontalDivider(Modifier.weight(0.85f))
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSectionLabel() {
    SectionLabel("TEST TEXT")
}
