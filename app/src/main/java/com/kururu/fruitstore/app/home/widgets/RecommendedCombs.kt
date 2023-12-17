package com.kururu.fruitstore.app.home.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ProductWidgetWithBackground(title:String ,
                  image:Int, isFav:Boolean ,
                  price:Double
                  , currency:String , color:Color

, navController: NavController
){
    Box(modifier = Modifier
        .padding(10.dp)
        .shadow(
            elevation = 5.dp,
            spotColor = Color(0xFF202020).copy(alpha = .05f),
            shape = RoundedCornerShape(16.dp)
        ).background(color)

        .height(183.dp)
        .width(
            170.dp
        )
        .padding(10.dp)
        .clickable {
            navController.navigate("details")
        }


    ) {
        Icon(painter = painterResource(id =
        if
                (isFav)
            com.kururu.fruitstore.R.drawable.ic_fav_filled
        else

            com.kururu.fruitstore.R.drawable.ic_fav),
            contentDescription ="",


            modifier = Modifier.align(Alignment.TopEnd),

            tint = Color(0xFFFFA451)
        )

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.height(10.dp))

            Image(painter = painterResource(id = image), contentDescription ="",

                modifier = Modifier
                    .height(80.dp)
                    .width(80.dp)


            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(title , style = TextStyle(fontSize = 16.sp , fontWeight = FontWeight.W500))


            Spacer(modifier = Modifier.height(10.dp))

            Row( horizontalArrangement = Arrangement.SpaceBetween ,

                modifier = Modifier.fillMaxWidth()
            ) {
                Row() {
                    Text(text = currency , style = TextStyle(
                        color = Color(0xFFF08626) ,  fontWeight = FontWeight.Bold ,
                        fontSize = 14.sp
                    ))
                    Spacer(modifier = Modifier.width(3.dp))
                    Text(text = price.toString(), style = TextStyle(
                        color = Color(0xFFF08626) ,  fontWeight = FontWeight.W300
                        ,
                        fontSize = 14.sp
                    )
                    )
                }


                Box(modifier = Modifier
                    .background(Color(0xFFFFF2E7), shape = CircleShape)
                    .padding(5.dp)

                    , contentAlignment = Alignment.Center
                ) {

                    Icon(painter = painterResource(id = com.kururu.fruitstore.R.drawable.ic_add),
                        contentDescription ="" , tint = Color(0xFFFFA451) )

                }


            }
        }


    }

}
@Composable
fun ProductWidget(title:String ,
image:Int, isFav:Boolean ,
                   price:Double
, currency:String ,  navController: NavController
                   ){
    Box(modifier = Modifier
        .padding(10.dp)
        .shadow(
            elevation = 5.dp,
            spotColor = Color(0xFF202020).copy(alpha = .05f),
            shape = RoundedCornerShape(16.dp)
        ).background(Color.White)

        .height(183.dp)
        .width(
            170.dp
        )
        .padding(10.dp)
        .clickable {
            navController.navigate("details")
        }

    ) {
Icon(painter = painterResource(id =
if
(isFav)
    com.kururu.fruitstore.R.drawable.ic_fav_filled
    else

com.kururu.fruitstore.R.drawable.ic_fav),
    contentDescription ="",


    modifier = Modifier.align(Alignment.TopEnd),

    tint = Color(0xFFFFA451)
    )

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.height(10.dp))

            Image(painter = painterResource(id = image), contentDescription ="",

modifier = Modifier
    .height(80.dp)
    .width(80.dp)


                )
            Spacer(modifier = Modifier.height(5.dp))
Text(title , style = TextStyle(fontSize = 16.sp , fontWeight = FontWeight.W500))


            Spacer(modifier = Modifier.height(10.dp))

            Row( horizontalArrangement = Arrangement.SpaceBetween ,

                modifier = Modifier.fillMaxWidth()
                ) {


                Row() {
Text(text = currency , style = TextStyle(
    color = Color(0xFFF08626) ,  fontWeight = FontWeight.Bold ,
    fontSize = 14.sp
))
                    Spacer(modifier = Modifier.width(3.dp))
Text(text = price.toString(), style = TextStyle(
    color = Color(0xFFF08626) ,  fontWeight = FontWeight.W300
    ,
    fontSize = 14.sp
)
)
                }


Box(modifier = Modifier
    .background(Color(0xFFFFF2E7), shape = CircleShape)
    .padding(5.dp)

, contentAlignment = Alignment.Center
) {

    Icon(painter = painterResource(id = com.kururu.fruitstore.R.drawable.ic_add),
        contentDescription ="" , tint = Color(0xFFFFA451) )

}

                
            }
        }


    }

}