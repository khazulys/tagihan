package com.tagihan.app.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.tagihan.app.design.LocalSpacing

data class CustomerPreview(val name: String, val email: String)

@Composable
fun CustomersScreen(modifier: Modifier = Modifier) {
    val customers = remember {
        listOf(
            CustomerPreview("PT Maju Bersama", "finance@maju.co.id"),
            CustomerPreview("CV Sukses Selalu", "admin@sukses.id"),
            CustomerPreview("PT Karya Jaya", "acc@karyajaya.com"),
        )
    }

    Column(modifier = modifier.fillMaxSize().padding(LocalSpacing.current.lg)) {
        LazyColumn(verticalArrangement = Arrangement.spacedBy(LocalSpacing.current.md)) {
            items(customers) { c ->
                Column(verticalArrangement = Arrangement.spacedBy(LocalSpacing.current.xs)) {
                    Text(c.name, style = MaterialTheme.typography.titleMedium)
                    Text(c.email, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
                }
            }
        }
    }
}
