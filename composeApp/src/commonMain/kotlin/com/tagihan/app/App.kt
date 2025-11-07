package com.tagihan.app

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Assessment
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.ReceiptLong
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.Modifier
import com.tagihan.app.design.TagihanTheme
import com.tagihan.app.screens.CustomersScreen
import com.tagihan.app.screens.DashboardScreen
import com.tagihan.app.screens.InvoicesScreen
import com.tagihan.app.screens.SettingsScreen

private enum class Tab(val label: String, val icon: ImageVector) {
    Dashboard("Dashboard", Icons.Default.Assessment),
    Invoices("Invoices", Icons.Default.ReceiptLong),
    Customers("Customers", Icons.Default.Groups),
    Settings("Settings", Icons.Default.Settings)
}

@Composable
fun TagihanApp() {
    TagihanTheme {
        var currentTab by remember { mutableStateOf(Tab.Dashboard) }

        Scaffold(
            topBar = {
                LargeTopAppBar(title = { Text(currentTab.label) })
            },
            bottomBar = {
                NavigationBar {
                    Tab.entries.forEach { tab ->
                        NavigationBarItem(
                            selected = currentTab == tab,
                            onClick = { currentTab = tab },
                            icon = { Icon(tab.icon, contentDescription = tab.label) },
                            label = { Text(tab.label) }
                        )
                    }
                }
            }
        ) { inner ->
            TabContent(currentTab, inner)
        }
    }
}

@Composable
private fun TabContent(current: Tab, inner: PaddingValues) {
    val modifier = Modifier.fillMaxSize().padding(inner)
    when (current) {
        Tab.Dashboard -> DashboardScreen(modifier)
        Tab.Invoices -> InvoicesScreen(modifier)
        Tab.Customers -> CustomersScreen(modifier)
        Tab.Settings -> SettingsScreen(modifier)
    }
}
