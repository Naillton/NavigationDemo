package com.example.navigationdemo.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.navigationdemo.routes.NavRoutes

/**
 * Criando classe HomeScreen que tera a tela Home como compose
 */

class HomeScreen {
    @Composable
    fun Home(navController: NavController) {
        var userName by rememberSaveable { mutableStateOf("") }
        val onUserNameChange = { text: String -> userName = text}
        val context = LocalContext.current

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                CustomTextField(
                    title = "Enter your name",
                    text = userName,
                    onTextChange = onUserNameChange
                )
                Spacer(modifier = Modifier.size(30.dp))
                // passando o userName como parametro na home
                Button(onClick = {
                    navController.navigate(NavRoutes.Welcome.route + "/${userName}") {
                    launchSingleTop = true
                } }) {
                    Text(text = "Register")
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun CustomTextField(
        title:String,
        text: String,
        onTextChange: (String) -> Unit
    ) {
        OutlinedTextField(
            value = text,
            onValueChange = { onTextChange(it) },
            singleLine = true,
            label = { Text(title)},
            modifier = Modifier.padding(10.dp),
            textStyle = TextStyle(fontWeight = FontWeight.Bold,
                fontSize = 30.sp)
        )

    }
}