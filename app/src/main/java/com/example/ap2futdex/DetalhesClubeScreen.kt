package com.example.ap2futdex

import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun DetalhesClubeScreen(clubeId: Int) {
    val clube = ClubeRepository.clubes.find { it.id == clubeId }

    val context = LocalContext.current
    val imageLoader = remember {
        FutDexImageLoader.criar(context)
    }

    if (clube != null) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(24.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            AsyncImage(
                model = clube.imagemUrl,
                imageLoader = imageLoader,
                contentDescription = "Escudo do ${clube.nome}",
                modifier = Modifier
                    .size(160.dp)
                    .align(Alignment.CenterHorizontally),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = clube.nome,
                style = MaterialTheme.typography.headlineLarge,
                color = Color(0xFF35D07F)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "País: ${clube.pais}",
                style = MaterialTheme.typography.titleMedium,
                color = Color.White
            )

            Text(
                text = "Fundação: ${clube.anoFundacao}",
                style = MaterialTheme.typography.titleMedium,
                color = Color.White
            )

            Text(
                text = "Estádio: ${clube.estadio}",
                style = MaterialTheme.typography.titleMedium,
                color = Color.White
            )

            Text(
                text = "Liga: ${clube.liga}",
                style = MaterialTheme.typography.titleMedium,
                color = Color.White
            )

            Text(
                text = "Categoria: ${clube.categoria}",
                style = MaterialTheme.typography.titleMedium,
                color = Color(0xFF35D07F)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Sobre o clube",
                style = MaterialTheme.typography.titleLarge,
                color = Color(0xFF35D07F)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = clube.descricao,
                style = MaterialTheme.typography.bodyLarge,
                color = Color.LightGray
            )
        }
    } else {
        Text(
            text = "Clube não encontrado.",
            color = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
        )
    }
}
