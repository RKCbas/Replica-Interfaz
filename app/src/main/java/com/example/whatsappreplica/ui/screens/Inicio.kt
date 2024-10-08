package com.example.whatsappreplica.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.whatsappreplica.BottomNavBar
import com.example.whatsappreplica.R
import com.example.whatsappreplica.WHeader


@Composable
fun HomeScreen(navController: NavController) {
    PreviewAppInicio(navController)
}



@Preview
@Composable
fun SearchBar() {
    var searchText by remember { mutableStateOf("") }

    OutlinedTextField(
        value = searchText,
        onValueChange = { searchText = it },
        modifier = Modifier
            .fillMaxWidth()
            .height(55.dp)
            .padding(0.dp)
            .background(color = Color.DarkGray, shape = RoundedCornerShape(25.dp)),
        placeholder = {
            Text(
                text = "Preguntar a Meta Ai o buscar",
                fontSize = 14.sp,
                color = Color.LightGray
            )
        }, // Placeholder
        leadingIcon = { // Ícono de búsqueda
            Icon(
                modifier = Modifier.padding(start = 4.dp),
                imageVector = Icons.Filled.Search,
                contentDescription = "Buscar",
                tint = Color.LightGray
            )
        },
        singleLine = true, // Para que el texto esté en una sola línea
        shape = RoundedCornerShape(25.dp),
        textStyle = TextStyle(color = Color.White),
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(
            onSearch = {
                // Acción cuando se presiona "Buscar"
            }
        ),

    )
}

@Composable
fun ChatRow(chatName: String, chatMessage: String, chatHour: String, navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            //.padding(vertical = 8.dp)
            //.border(width = 2.dp, color = Color.Red)
            .height(65.dp)
            .clickable { navController.navigate("chat") },
        verticalAlignment = Alignment.CenterVertically

    ) {

        Image(
            painter = painterResource(id = R.drawable.perfil),
            contentDescription = "Imagen de perfil",
            modifier = Modifier
                .height(40.dp)
                .padding(end = 8.dp, start = 5.dp)
                .clip(RoundedCornerShape(50))
                .clickable { clickAction("Imagen") }
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp, end = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.padding(top = 5.dp)
            ) {
                Text(
                    text = chatName,
                    color = Color.White,
                    fontSize = 18.sp
                )
                Text(
                    modifier = Modifier.padding(top = 4.dp),
                    text = chatMessage,
                    color = Color.LightGray,
                    fontSize = 12.sp
                )
            }
            Box(modifier = Modifier.fillMaxHeight()) {
                Text(
                    modifier = Modifier.padding(top = 4.dp),
                    text = chatHour,
                    color = Color.LightGray
                )

            }
        }


    }
}

//@Preview


//@Preview(showBackground = true)
@Composable
fun PreviewAppInicio(navController: NavController) {
    Scaffold(
        bottomBar = {
            BottomNavBar(0, navController) // Barra de navegación visual
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/ },
                containerColor = colorResource(id = R.color.WhatsGreen),
                contentColor = Color.Black,
                //elevation = FloatingActionButtonDefaults.elevation(8.dp)
            ) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "Nuevo Chat")
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.WhatsBBackground))
                .padding(innerPadding)
            //.padding(5.dp, 10.dp, 0.dp, 5.dp)
        ) {
            WHeader()

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                item { SearchBar() }
                item { Spacer(modifier = Modifier.height(15.dp)) }
                val datos = arrayOf(
                    arrayOf("Cbas","Tú: Foto","Ayer"),
                    arrayOf("Tony Tics","hola","Ayer"),
                    arrayOf("Alex G","Sticker","Ayer"),
                    arrayOf("Pa","Reaccionó a \"Claro\"","Ayer"),
                    arrayOf("Graduación 20-24","Mich: Fiestop","Ayer"),
                    arrayOf("Smart Fit","¡Hola MARCO SEBASTIAN","Ayer"),
                    arrayOf("Vivi","Ya casi subo","Ayer"),
                    arrayOf("Asesorias R EMED","Estimados alumnos","Ayer"),
                    arrayOf("TDI 2 - Equipo 5","Fernando IND: Ahuevo","Ayer"),
                    arrayOf("Negocios Electronicos II","Tú: Okay","Ayer"),
                    arrayOf("Negocios II","Se elimino","Ayer"),
                    arrayOf("Hora libre","Ruben Tics: Sticker","17/09/24"),
                    arrayOf("Leo","Creo que si","16/09/24"),
                    arrayOf("Jared Tics","Vavava","16/09/24"),
                    arrayOf("Mike ITA","Okay","15/09/24")
                )
                items(datos.size) { index ->
                    ChatRow(datos[index][0],datos[index][1],datos[index][2], navController)
                }
            }
        }
    }
}

fun clickAction(element: String = "Elemento") {
    println("$element Clicked")
}
