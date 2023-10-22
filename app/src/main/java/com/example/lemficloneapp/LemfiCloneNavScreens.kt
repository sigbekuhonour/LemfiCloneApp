package com.example.lemficloneapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "PagerScreen"){
        composable("PagerScreen"){
            PagerWelcomeScreen(navController = navController)
        }
        composable("CreateAcct"){
            CreateAcctScreen(navController = navController)
        }
        composable("LoginAcct"){
            LoginAcctScreen(navController = navController)
        }
    }
}


@Composable
fun PagerWelcomeScreen(navController:NavController){
    PagerOfAppUi(navController)
}

@Composable
fun CreateAcctScreen(navController: NavController){
    CreateAccountPage(navController)
}

@Composable
fun LoginAcctScreen(navController: NavController){
    LoginIntoAccount(navController)
}