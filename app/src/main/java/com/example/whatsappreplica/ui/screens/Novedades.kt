package com.example.whatsappreplica.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.whatsappreplica.BottomNavBar
import com.example.whatsappreplica.R
import com.example.whatsappreplica.WHeader

@Composable
fun NovedadesScreen(navController: NavController){
    PreviewAppNovedades(navController)
}



@Composable
fun PreviewAppNovedades (navController: NavController){

    Scaffold(
        bottomBar = {
            BottomNavBar(1, navController) // Barra de navegación visual
        },
        /*floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/ },
                containerColor = colorResource(id = R.color.WhatsGreen),
                contentColor = Color.Black,
                //elevation = FloatingActionButtonDefaults.elevation(8.dp)
            ) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "Nuevo Chat")
            }
        }*/
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.WhatsBBackground))
                .padding(innerPadding)
            //.padding(5.dp, 10.dp, 0.dp, 5.dp)
        ) {
            WHeader("novedades")

            Text(text = "This is Novedades", color = Color.White)
//            LazyColumn(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(10.dp)
//            ) {
//                item { SearchBar() }
//                item { Spacer(modifier = Modifier.height(15.dp)) }
//                items(15) { index ->
//                    val inde = index + 1
//                    ChatRow("Chat $inde", navController)
//                }
//            }
        }
    }

}
/*
Column {
    Text(text = "This is novedades")
    Button(onClick = {/*navController.navigate("inicio")*/}) {
        Text(text = "Inicio")
    }
}*/