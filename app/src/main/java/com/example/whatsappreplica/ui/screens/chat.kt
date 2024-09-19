package com.example.whatsappreplica.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun ChatScreen(navController: NavController){
    Column {
        Text(text = "This is the chatScreen")
        Button(onClick = {navController.navigate("inicio")}) {
            Text(text = "Inicio")
        }
    }
}