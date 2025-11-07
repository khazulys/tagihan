package com.tagihan.app.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.tagihan.app.design.LocalSpacing

@Composable
fun SettingsScreen(modifier: Modifier = Modifier) {
    var company by remember { mutableStateOf("") }
    var numbering by remember { mutableStateOf("INV-YYYY-####") }
    var currency by remember { mutableStateOf("IDR") }

    Column(modifier = modifier.padding(LocalSpacing.current.lg), verticalArrangement = Arrangement.spacedBy(LocalSpacing.current.md)) {
        OutlinedTextField(value = company, onValueChange = { company = it }, label = { Text("Nama Perusahaan") }, modifier = Modifier.fillMaxWidth())
        OutlinedTextField(value = numbering, onValueChange = { numbering = it }, label = { Text("Format Penomoran") }, modifier = Modifier.fillMaxWidth())
        OutlinedTextField(value = currency, onValueChange = { currency = it }, label = { Text("Mata Uang") }, modifier = Modifier.fillMaxWidth())
        Button(onClick = { /* TODO persist */ }) { Text("Simpan") }
    }
}
