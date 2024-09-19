package com.example.whatsappreplica

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
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