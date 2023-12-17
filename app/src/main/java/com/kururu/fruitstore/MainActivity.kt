package com.kururu.fruitstore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kururu.fruitstore.app.home.Home
import com.kururu.fruitstore.app.order.pages.OrderList
import com.kururu.fruitstore.app.order.pages.TrackPage
import com.kururu.fruitstore.app.productDetails.ProductDetails
import com.kururu.fruitstore.app.splash.SplashScreen
import com.kururu.fruitstore.app.success.SuccessPage
import com.kururu.fruitstore.app.welcome.WelcomeScreen
import com.kururu.fruitstore.app.welcome.WelcomeScreen2
import com.kururu.fruitstore.ui.theme.FruitStoreTheme
import com.kururu.fruitstore.ui.theme.PrimaryColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {


            FruitStoreTheme {
                val navController = rememberNavController()
window.statusBarColor = PrimaryColor.toArgb()


                // A surface container using the 'background' color from the theme




                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    NavHost(navController = navController, startDestination = "welcome") {
                        composable("welcome") { WelcomeScreen(navController = navController) }
                        composable("welcome2") { WelcomeScreen2(navController=navController) }
                        composable("home") { Home(navController = navController) }
                        composable("details") { ProductDetails(navController = navController) }

                        composable("cart") { OrderList(navController = navController) }
                        composable("track") { TrackPage(navController = navController) }
                        composable("success") { SuccessPage(navController = navController) }

                    }

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FruitStoreTheme {
        Greeting("Android")
    }
}