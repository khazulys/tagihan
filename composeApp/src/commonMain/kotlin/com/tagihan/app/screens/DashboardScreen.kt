package com.tagihan.app.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.tagihan.app.design.LocalSpacing

@Composable
fun DashboardScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(LocalSpacing.current.lg),
        verticalArrangement = Arrangement.spacedBy(LocalSpacing.current.lg)
    ) {
        StatCard(title = "Invoices Terbuka", value = "12")
        StatCard(title = "Total Piutang", value = "Rp 124.500.000")
        StatCard(title = "Overdue", value = "3")
    }
}

@Composable
private fun StatCard(title: String, value: String) {
    Card(colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)) {
        Column(
            Modifier.padding(LocalSpacing.current.lg),
            verticalArrangement = Arrangement.spacedBy(LocalSpacing.current.sm)
        ) {
            Text(text = title, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
            Text(text = value, style = MaterialTheme.typography.headlineSmall)
        }
    }
}
