package com.kururu.fruitstore.app.success

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.kururu.fruitstore.R
import com.kururu.fruitstore.ui.theme.PrimaryColor

@Composable
fun SuccessPage(navController: NavController){

Box(modifier = Modifier
    .fillMaxSize()
    .padding(vertical = 50.dp)
) {

    Column(modifier = Modifier.fillMaxSize() , horizontalAlignment = Alignment.CenterHorizontally , verticalArrangement = Arrangement.SpaceBetween) {

        Box( modifier = Modifier
            .width(165.dp)
            .height(165.dp)
            .background(
                Color(0xFFE0FFE5), shape = CircleShape
            )
            .border(1.dp, Color.Green, shape = CircleShape)

            ,
            contentAlignment = Alignment.Center

        ) {

            Box(modifier = Modifier
                .height(100.dp)
                .width(100.dp)
                .background(Color.Green, shape = CircleShape)
                ,
                contentAlignment = Alignment.Center
            ) {
                Icon(painter = painterResource(id = R.drawable.ic_check),

                    contentDescription ="" ,
                    tint = Color.White ,
modifier = Modifier
    .width(42.dp)
    .height(42.dp)

                    )

            }

        }


        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Congratulations!!!" , style = TextStyle(
                fontSize = 32.sp ,
                fontWeight = FontWeight.W500
            ))
Box(modifier = Modifier.height(20.dp)) {

}

            Text("Your order have been taken and is being attended to"

                 , maxLines = 2,
                textAlign = TextAlign.Center
                , style = TextStyle(
                fontSize = 20.sp ,
                fontWeight = FontWeight.W300,
            ),
                modifier = Modifier.width(247.dp)


                )


        }



        Box( modifier = Modifier
            .height(60.dp)
            .width(135.dp)
            .padding(start = 20.dp, end = 20.dp)
            .clip(

                shape = RoundedCornerShape(10.dp)
            )
            .background(PrimaryColor)

            .clickable {
               navController.navigate("track")
            }
            ,

            contentAlignment = Alignment.Center

        ) {
            Text(text = "Track order",    style = TextStyle(
                color = Color.White ,
                fontWeight = FontWeight.W500,
                fontSize = 16.sp
            ))

        }




        Box( modifier = Modifier
            .height(60.dp)
            .width(180.dp)
//            .padding(start = 20.dp, end = 20.dp)
            .background(
                Color(0xFFE0FFE5), shape =  RoundedCornerShape(10.dp)
            )
            .border(1.dp, PrimaryColor, shape =  RoundedCornerShape(10.dp))
            .background(Color.White ,  shape = RoundedCornerShape(10.dp))

            .clickable {
                navController.navigate("home")
            }
            ,

            contentAlignment = Alignment.Center

        ) {
            Text(text = "Continue shopping",    style = TextStyle(
                color = PrimaryColor ,
                fontWeight = FontWeight.W500,
                fontSize = 16.sp
            ))

        }

    }


}
}