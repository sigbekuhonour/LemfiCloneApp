package com.example.lemficloneapp

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

//
@Composable
fun BoxColours(boxWithColour: Int) {
    Row(
        modifier = Modifier
            .height(40.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(4) { iteration ->
            val color =
                if (iteration == boxWithColour) Color.White else Color.Transparent
            val widthOfCurrentBox = if (iteration == boxWithColour) 18.dp else 10.dp
            Box(
////fix up the width and height of the circles
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .animateContentSize()
                    .width(widthOfCurrentBox)
                    .clip(RoundedCornerShape(10.dp))
                    .size(10.dp)
                    .background(color)
                    .border(color = Color.White, width = 1.dp, shape = CircleShape)
            )
        }
    }
}

//app ui (background and texts)
@Composable
fun AppUi(
    image: Int,
    contentDescription: String,
    text1: String,
    text2: String,
    boxColour: Int,
    nav: NavController
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = image),
            contentDescription = contentDescription,
            contentScale = ContentScale.FillHeight
        )
        ////
        Column(
            verticalArrangement = Arrangement.spacedBy(6.dp),
            horizontalAlignment = Alignment.Start
        ) {

            Text(
                text = text1,
                fontWeight = FontWeight.Bold,
                fontFamily = lemfiFont,
                fontSize = 45.sp,
                color = Color.White,
                modifier = Modifier.padding(start = 20.dp, end = 20.dp, top = 20.dp)
            )

            Text(
                text = text2,
                modifier = Modifier.padding(horizontal = 20.dp),
                fontFamily = lemfiFont,
                fontSize = 17.sp
            )
            Spacer(modifier = Modifier.padding(vertical = 180.dp))
            BoxColours(boxWithColour = boxColour)

            Button(
                onClick = { nav.navigate("CreateAcct") },
                modifier = Modifier
                    .width(330.dp)
                    .padding(start = 60.dp),
                contentPadding = PaddingValues(horizontal = 4.dp),
                colors = ButtonDefaults.buttonColors(Color(0xDA22A029))
            ) {
                Text(text = "Create account", fontFamily = lemfiFont)

            }
            Button(
                onClick = { nav.navigate("LoginAcct") },
                modifier = Modifier
                    .width(380.dp)
                    .padding(horizontal = 10.dp),
                colors = ButtonDefaults.buttonColors(Color.Transparent)
            ) {
                Text(text = "Login", color = Color.White, fontFamily = lemfiFont)
            }


        }
    }

}


@Composable
@OptIn(ExperimentalFoundationApi::class)
fun PagerOfAppUi(navController: NavController) {

    HorizontalPager(state = rememberPagerState(initialPage = 0, pageCount = { 4 }), pageContent = {
        when (it) {
            0 -> {
                AppUi(
                    image = R.drawable.image_1,
                    contentDescription = "background_image1",
                    text1 = "International \n\npayments for \n\neveryone",
                    text2 = "Say goodbye to limitations and \nembrace a world without borders",
                    boxColour = 0,
                    nav = navController
                )

            }

            1 -> {
                AppUi(
                    image = R.drawable.image_2,
                    contentDescription = "background_image2",
                    text1 = "Never worry \n\nabout hidden \n\ncharges",
                    text2 = "We guarantee competitive \nexchange rates always",
                    boxColour = 1,
                    nav = navController
                )
            }

            2 -> {
                AppUi(
                    image = R.drawable.image_3,
                    contentDescription = "background_image3",
                    text1 = "Customer \n\nsupport around \n\nthe clock",
                    text2 = "We take your money seriously and \nresolve all issues FAST!",
                    boxColour = 2,
                    nav = navController
                )
            }

            3 -> {
                AppUi(
                    image = R.drawable.image_4,
                    contentDescription = "background_image4",
                    text1 = "Open foreign \n\ncurrency \n\naccount",
                    text2 = "Open accounts in foreign currencies to receive money and send money",
                    boxColour = 3,
                    nav = navController
                )
            }
        }
    })
}








