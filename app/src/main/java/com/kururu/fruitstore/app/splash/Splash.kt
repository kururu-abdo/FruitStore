package com.kururu.fruitstore.app.splash

import android.window.SplashScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.kururu.fruitstore.R
import com.kururu.fruitstore.ui.theme.FruitStoreTheme
import com.kururu.fruitstore.ui.theme.PrimaryColor
import kotlinx.coroutines.delay

@Composable
fun  SplashScreen(navController: NavController= rememberNavController()){
    LaunchedEffect(key1 = Unit){
        delay(5000)
       navController.navigate("welcome")
    }
    FruitStoreTheme {

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {


            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {

                Image(
                    painter = painterResource(
                        id =
                        R.drawable.fruit_logo,


                        ),
                    modifier = Modifier.size(
                        height = 205.dp,
                        width = 184.dp
                    ),
                    contentDescription = ""
                )


            }
        }
    }


}