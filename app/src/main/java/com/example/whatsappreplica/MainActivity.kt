package com.example.whatsappreplica

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.whatsappreplica.ui.screens.ChatScreen
import com.example.whatsappreplica.ui.screens.HomeScreen
import com.example.whatsappreplica.ui.screens.NovedadesScreen
import com.example.whatsappreplica.ui.theme.WhatsAppReplicaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()

        setContent{
            ComposeMultiScreenApp()
        }


//        setContent {
//            WhatsAppReplicaTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
//            }
//        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

//@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WhatsAppReplicaTheme {
        Greeting("Android")
    }
}


@Preview(showBackground = true)
@Composable
fun ComposeMultiScreenApp(){
    val navController = rememberNavController()
    Surface (color = Color.White) {
        SetupNavGraph(navController = navController)
    }
}

@Composable
fun SetupNavGraph (navController: NavHostController){
    NavHost(navController = navController, startDestination = "inicio"){
        composable("inicio"){ HomeScreen(navController) }
        composable("chat"){ ChatScreen(navController) }
        composable("novedades"){ NovedadesScreen(navController) }
    }
}

@Preview(showBackground = false)
@Composable
fun WHeader(tipo:String = "inicio") {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            //.border(width = 2.dp, color = Color.Red)
            .padding(5.dp, 5.dp, 5.dp, 0.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = if(tipo == "novedades") "Novedades" else "WhatsApp",
            color = Color.White,
            fontSize = 24.sp
        )
        Column {
            Row {
                if (tipo=="novedades"){
                    Image(
                        painter = painterResource(id = R.drawable.ic_camera),
                        contentDescription = "Icono de cámara"
                    )
                    Icon(
                        Icons.Filled.Search,
                        contentDescription = "Buscar",
                        tint = Color.White,
                    )
                    Icon(
                        Icons.Filled.MoreVert,
                        contentDescription = "Opciones adicionales",
                        tint = Color.White,
                    )
                }else{
                    Image(
                        painter = painterResource(id = R.drawable.ic_camera),
                        contentDescription = "Icono de cámara"
                    )
                    Icon(
                        Icons.Filled.MoreVert,
                        contentDescription = "Opciones adicionales",
                        tint = Color.White,
                    )
                }


            }

        }

    }
}


@Composable
fun BottomNavBar(iniElem: Int = 0, navController: NavController) {
    var selectedItem by remember { mutableStateOf(iniElem) }

    NavigationBar(
        containerColor = colorResource(id = R.color.WhatsBBackground),
        contentColor = Color.White
    ) {
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Filled.MailOutline,
                    contentDescription = "Chats",
                    tint = Color.White
                )
            },
            label = {
                Text(
                    "Chats",
                    color = Color.White
                )
            },
            selected = selectedItem == 0,
            onClick = {
                selectedItem = 0
                navController.navigate("inicio")
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.White,  // Color del ícono seleccionado (verde)
                selectedTextColor = Color.White,  // Color del texto seleccionado (verde)
                indicatorColor = colorResource(id = R.color.WhatsDarkGreen),  // Color de fondo del ítem seleccionado (verde oscuro)
                unselectedIconColor = Color.White, // Color del ícono no seleccionado
                unselectedTextColor = Color.White // Color del texto no seleccionado
            )
        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Filled.CheckCircle,
                    contentDescription = "Novedades",
                    tint = Color.White
                )
            },
            label = {
                Text(
                    "Novedades",
                    color = Color.White
                )
            },
            selected = selectedItem == 1,
            onClick = {
                selectedItem = 1
                navController.navigate("novedades")
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.White,
                selectedTextColor = Color.White,
                indicatorColor = colorResource(id = R.color.WhatsDarkGreen),
                unselectedIconColor = Color.White,
                unselectedTextColor = Color.White
            )
        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = "Comunidades",
                    tint = Color.White
                )
            },
            label = {
                Text(
                    "Comunidades",
                    color = Color.White
                )
            },
            selected = selectedItem == 2,
            onClick = { selectedItem = 2 },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.White,
                selectedTextColor = Color.White,
                indicatorColor = colorResource(id = R.color.WhatsDarkGreen),
                unselectedIconColor = Color.White,
                unselectedTextColor = Color.White
            )
        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Filled.Call,
                    contentDescription = "Llamadas",
                    tint = Color.White
                )
            },
            label = {
                Text(
                    "Llamadas",
                    color = Color.White
                )
            },
            selected = selectedItem == 3,
            onClick = { selectedItem = 3 },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.White,
                selectedTextColor = Color.White,
                indicatorColor = colorResource(id = R.color.WhatsDarkGreen),
                unselectedIconColor = Color.White,
                unselectedTextColor = Color.White
            )
        )
    }
}
