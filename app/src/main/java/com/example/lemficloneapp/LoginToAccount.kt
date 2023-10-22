package com.example.lemficloneapp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginIntoAccount(navController: NavController) {
    var valueInTextField by remember { mutableStateOf("") }
    var isButtonClicked by remember { mutableStateOf(false) }
    var textToDisplay = if (isButtonClicked) {
        "Show"
    } else {
        "Hide"
    }
    Scaffold { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Spacer(modifier = Modifier.padding(vertical = 30.dp))
            Text(
                text = "Log in to LemFi",
                modifier = Modifier.padding(horizontal = 20.dp),
                fontWeight = FontWeight.Bold,
                fontFamily = lemfiFont,
                fontSize = 25.sp
            )
            Spacer(modifier = Modifier.padding(vertical = 16.dp))
            Text(
                text = "Enter your phone number",
                fontFamily = lemfiFont,
                modifier = Modifier.padding(horizontal = 20.dp)
            )

            OutlinedCCP()
            Spacer(modifier = Modifier.padding(vertical = 8.dp))
            Text(
                text = "Enter password",
                fontFamily = lemfiFont,
                modifier = Modifier.padding(horizontal = 20.dp)
            )

            OutlinedTextField(
                value = valueInTextField,
                modifier = Modifier
                    .width(500.dp)
                    .padding(horizontal = 20.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(
                        0xDA22A029
                    )
                ),
                onValueChange = { valueInTextField = it },
                trailingIcon = {
                    Text(text = textToDisplay,
                        fontFamily = lemfiFont,
                        color = Color(0xDA22A029),
                        modifier = Modifier
                            .padding(horizontal = 5.dp)
                            .clickable { isButtonClicked = !isButtonClicked })
                })
            TextWithUnderlinedText(
                text1 = "Trouble logging in?",
                text2 = "Recover your account",
                padding = 20,
                onClick = "",
                nav = navController
            )
            Spacer(modifier = Modifier.padding(vertical = 26.dp))
            TextWithUnderlinedText(
                text1 = "Don't have an account?",
                text2 = "Sign Up",
                padding = 65,
                onClick = "CreateAcct",
                nav = navController
            )
            Spacer(modifier = Modifier.padding(vertical = 115.dp))
            Button(
                onClick = { /*TODO*/ },
                contentPadding = PaddingValues(horizontal = 15.dp),
                colors = ButtonDefaults.buttonColors(
                    Color(
                        0xDA22A029
                    )
                ),
                modifier = Modifier
                    .width(380.dp)
                    .padding(horizontal = 25.dp)
            ) {
                Text(text = "Log into account", fontFamily = lemfiFont, color = Color.White)
            }
        }
    }
}

/// constructs texts with other underlined texts in a row (onclick value to be implemented later)
@Composable
fun TextWithUnderlinedText(text1: String, text2: String, padding: Int,onClick:String,nav: NavController) {
    Row(
        modifier = Modifier.padding(start = padding.dp),
        horizontalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        Text(text = text1, fontFamily = lemfiFont)
        Text(
            text = text2,
            textDecoration = TextDecoration.Underline,
            fontFamily = lemfiFont,
            color = Color(0xDA22A029),
            modifier = Modifier.clickable(onClick = {nav.navigate(onClick)})
        )
    }
}




