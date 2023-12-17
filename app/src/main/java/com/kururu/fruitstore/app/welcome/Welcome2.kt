package com.kururu.fruitstore.app.welcome

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.drawable.toBitmap
import androidx.navigation.NavController
import com.kururu.fruitstore.R
import com.kururu.fruitstore.app.welcome.components.ContinueButton
import com.kururu.fruitstore.ui.theme.PrimaryColor

@Composable
fun WelcomeScreen2(navController: NavController) {
    val context = LocalContext.current
    val imageDrawable = remember(R.drawable.fruit3) {
        context.resources.getDrawable(R.drawable.fruit3, null)
    }
    var text by remember { mutableStateOf("") }

//    val vector = ImageBitmap.imageResource(id = R.drawable.fruit_logo)
    val vector = remember(imageDrawable) {
        imageDrawable.toBitmap(
            width = 500,
            height = 500
        )
    }.asImageBitmap()


//    val imageDrawable2 = remember(R.drawable.fruit2) {
//        context.resources.getDrawable(R.drawable.fruit2, null)
//    }
    val imageDrawable2 = ImageBitmap.imageResource(id = R.drawable.fruit2)
//    val vector2 = remember(imageDrawable) {
//        imageDrawable.toBitmap(
//            width = 500,
//            height = 500
//        )
//    }.asImageBitmap()


    Column(
        modifier = Modifier.fillMaxSize(),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Canvas(

            modifier = Modifier

                .height(470.dp)
                .fillMaxWidth()
                .background(PrimaryColor),
        ) {
            val canvasWidth = size.width
            val canvasHeight = size.height
            translate(left = (canvasWidth - 50), top = 340f,) {
                drawImage(
                    imageDrawable2,
                    topLeft = Offset(
                        x = (canvasWidth / 2) - 250,
                        y = 350f
                    )

                )
            }
            drawImage(
                vector,
                topLeft = Offset(
                    x = (canvasWidth / 2) - 250,
                    y = 350f
                )

            )


//    }


//    translate(left = (canvasWidth /2) -100, top = (canvasHeight - 100) / 1F,) {

            val ovalOffset = size;

            drawOval(
                color = Color(0xFFF08626),
                size = Size(width = 200.dp.toPx(), height = 15.dp.toPx()),

                topLeft = Offset(
                    x =
                    ovalOffset.width / 3 - 100

//            (canvasWidth / 2) - 125


//            (canvasWidth - 200/2f) / 2f
                    , y = (canvasHeight - 100) / 1f
                )
            )
//    }


        }

        Box(modifier = Modifier.height(20.dp)) {

        }
        Column(
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp)
                .fillMaxWidth(),


            horizontalAlignment = Alignment.Start,


        ) {

            Text(
                text = "What is your firstname?", style = TextStyle(
                    fontWeight = FontWeight.W500,
                    fontSize = 20.sp
                )
            )
            Box(modifier = Modifier.height(10.dp)) {

            }


            TextField(
                value = text,
                onValueChange = { text = it },
                colors = TextFieldDefaults.textFieldColors(

                focusedIndicatorColor =  Color(0xFFF3F1F1)//hid,,
                        ,
                    backgroundColor = Color(0xFFF3F1F1)//hide the indicator
             ,
unfocusedIndicatorColor =  Color(0xFFF3F1F1)
                    ),

                label = { Text("Your name" , style = TextStyle(
                    fontWeight = FontWeight.W300 ,
                    color = Color(0xFFC2BDBD)
                )) },

                placeholder = { Text("Your name" , style = TextStyle(
                    fontWeight = FontWeight.W300 ,
                    color = Color(0xFFC2BDBD)
                ),
                    modifier = Modifier.background(Color(0xFFF3F1F1))
                ) },
                modifier = Modifier.fillMaxWidth()
            )
        }
        Spacer(modifier = Modifier.height(50.dp))
        ContinueButton(title = "Start Ordering", onClick = {
navController.navigate("home")
        })
        Spacer(modifier = Modifier.height(20.dp))


    }


}
