package com.example.lemficloneapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

///create acct page
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateAccountPage(navController: NavController) {
    Scaffold(topBar = {
        TopAppBar(title = { /*TODO*/ }, navigationIcon = {
            IconButton(onClick = { navController.navigate("PagerScreen") }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "back-arrow",
                    tint = Color.Black
                )
            }
        }, colors = TopAppBarDefaults.smallTopAppBarColors(Color(0xF2ECE8E8)), actions = {
            Button(
                onClick = { /*TODO*/ },
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 8.dp),
                modifier = Modifier.padding(horizontal = 8.dp),
                colors = ButtonDefaults.buttonColors(Color.White)
            ) {
                Text(text = "Get Help", color = Color(0xDA22A029), fontFamily = lemfiFont)
            }
        })
    }) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(color = Color(0xF2ECE8E8)),
            verticalArrangement = Arrangement.spacedBy(15.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Spacer(modifier = Modifier.padding(vertical = 5.dp))
            Text(
                text = "Get started",
                modifier = Modifier.padding(horizontal = 20.dp),
                color = Color.Black,
                fontFamily = lemfiFont,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
            )

            Text(
                text = "Enter your phone number",
                color = Color.Black,
                modifier = Modifier.padding(horizontal = 20.dp),
                fontFamily = lemfiFont
            )

            OutlinedCCP()
            Acknowledge(
                text = "We'd like to keep you up to date with similar LemFi product" +
                        " and services by email and other means, untick here if you don't want to and" +
                        " receive these communications."
            )
            Acknowledge(
                text = "By checking this box, you agree to the Terms of service and Privacy" +
                        " Policy including verification of your identity with your mobile provider/third party."
            )
            Spacer(modifier = Modifier.padding(vertical = 80.dp))
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .width(380.dp)
                    .padding(horizontal = 10.dp),
                contentPadding = PaddingValues(horizontal = 4.dp),
                colors = ButtonDefaults.buttonColors(Color(0xDA22A029))
            ) {
                Text(
                    text = "Continue",
                    fontFamily = lemfiFont,
                    color = Color.White,
                    fontSize = 20.sp
                )
            }
            Row(
                modifier = Modifier.padding(start = 80.dp),
                horizontalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                Text(text = "Have an account?", fontFamily = lemfiFont)
                Text(
                    text = "Sign in",
                    textDecoration = TextDecoration.Underline,
                    fontFamily = lemfiFont,
                    color = Color(0xDA22A029),
                    modifier = Modifier.clickable(onClick = { navController.navigate("LoginAcct") })
                )
            }
        }

    }
}


///composable of terms and agreements
@Composable
fun Acknowledge(text: String, onClick: Nothing? = null, nav: Nothing? = null) {
    var isCheckBoxClicked by remember { mutableStateOf(false) }
    var iconDisplayed = if (isCheckBoxClicked) {
        R.drawable.check_box_clicked
    } else {
        R.drawable.check_box_unclicked
    }
    var iconColor = if (isCheckBoxClicked) {
        Color(0xDA22A029)
    } else {
        Color(0xFF0F0E0E)
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        IconButton(onClick = { isCheckBoxClicked = !isCheckBoxClicked }) {
            Icon(
                painter = painterResource(id = iconDisplayed),
                tint = iconColor,
                contentDescription = "checkBox"
            )
        }
        Text(
            text = text,
            fontSize = 15.sp,
            color = Color.Black,
            fontFamily = lemfiFont,
            maxLines = 4,
            fontWeight = FontWeight.Normal
        )
    }
}

//// composable of the country box and outlined textfield
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutlinedCCP() {
    var defaultNumber by remember { mutableStateOf("") }
    //var numb
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.Bottom
    ) {
        OutlinedButton(
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(2.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                disabledContainerColor = Color.White
            ),
            modifier = Modifier
                .height(55.dp),
            contentPadding = PaddingValues(vertical = 2.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.flag),
                    contentDescription = "country flag",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(25.dp)

                )
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = "arrow_drop_down",
                    tint = Color.Black
                )
            }

        }
        OutlinedTextField(
            value = defaultNumber,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                containerColor = Color.White,
                focusedBorderColor = Color(0xDA22A029)
            ),
            placeholder = {
                Text(
                    text = "7777777777",
                    fontSize = 15.sp,
                    fontFamily = lemfiFont,
                    textAlign = TextAlign.Start,
                    color = Color(0xA89B9898)
                )
            },
            label = {
                Text(
                    text = "+1",
                    fontFamily = lemfiFont,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp, color = Color.Black
                )
            },
            textStyle = TextStyle(
                fontWeight = FontWeight.Bold,
                fontFamily = lemfiFont,
                fontSize = 18.sp,
                textAlign = TextAlign.Start
            ),
            onValueChange = {
                defaultNumber = it
            },
            shape = RoundedCornerShape(2.dp),
            //colors = TextFieldDefaults.textFieldColors(Color(0xDA22A029)),
            modifier = Modifier
                .width(300.dp)
                .height(65.dp)
        )
    }
}

