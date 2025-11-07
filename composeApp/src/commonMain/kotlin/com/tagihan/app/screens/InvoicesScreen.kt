package com.tagihan.app.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AssistChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.tagihan.app.design.LocalSpacing

data class InvoicePreview(
    val number: String,
    val customer: String,
    val amount: String,
    val status: String
)

@Composable
fun InvoicesScreen(modifier: Modifier = Modifier) {
    val data = remember {
        listOf(
            InvoicePreview("INV-2025-0001", "PT Maju", "Rp 12.500.000", "Sent"),
            InvoicePreview("INV-2025-0002", "CV Sukses", "Rp 7.000.000", "Draft"),
            InvoicePreview("INV-2025-0003", "PT Jaya", "Rp 24.000.000", "Overdue"),
        )
    }

    Column(modifier = modifier.fillMaxSize().padding(LocalSpacing.current.lg)) {
        LazyColumn(verticalArrangement = Arrangement.spacedBy(LocalSpacing.current.md)) {
            items(data) { inv -> InvoiceRow(inv) }
        }
    }
}

@Composable
private fun InvoiceRow(inv: InvoicePreview) {
    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        Text(inv.number, style = MaterialTheme.typography.titleMedium)
        Text(inv.customer, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
        Text(inv.amount, style = MaterialTheme.typography.titleSmall)
        AssistChip(onClick = {}, label = { Text(inv.status) })
    }
}
