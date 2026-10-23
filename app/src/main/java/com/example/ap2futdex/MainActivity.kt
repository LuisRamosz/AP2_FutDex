package com.example.ap2futdex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.ap2futdex.ui.theme.AP2FutDexTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AP2FutDexTheme {
                FutDexApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FutDexApp() {
    val navController = rememberNavController()
    val backStackEntry = navController.currentBackStackEntryAsState()
    val rotaAtual = backStackEntry.value?.destination?.route

    val fundo = Color(0xFF101820)
    val destaque = Color(0xFF35D07F)

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = fundo,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "FUTDEX",
                        color = destaque
                    )
                },
                navigationIcon = {
                    if (rotaAtual?.contains("DetalhesClube") == true) {
                        IconButton(
                            onClick = {
                                navController.popBackStack()
                            }
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Voltar",
                                tint = destaque
                            )
                        }
                    }
                }
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = ListaClubes,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            composable<ListaClubes> {
                ListaClubesScreen(
                    aoSelecionarClube = { id ->
                        navController.navigate(DetalhesClube(clubeId = id))
                    }
                )
            }

            composable<DetalhesClube> { entrada ->
                val rota = entrada.toRoute<DetalhesClube>()
                DetalhesClubeScreen(clubeId = rota.clubeId)
            }
        }
    }
}
