package com.kururu.fruitstore.app.productDetails

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.kururu.fruitstore.ui.theme.PrimaryColor

@Composable
fun ProductDetails(navController: NavController){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(PrimaryColor)) {
        Column(
            horizontalAlignment = Alignment.Start , 

        ) {

            Spacer(modifier = Modifier.height(20.dp))

            Box( modifier = Modifier
                .padding(10.dp)
                .height(32.dp)
                .width(100.dp)
                .background(Color.White, shape = RoundedCornerShape(50.dp))
                .padding(5.dp)
                .clickable {
                    navController.popBackStack()
                }


            ) {
               Row( ) {
                   Icon(painter = painterResource(id =com.kururu.fruitstore.R.drawable.ic_back_ios ), contentDescription = "")

                   Text(text = "Go back" , style = TextStyle(
                       fontSize = 16.sp,
                       fontWeight = FontWeight.W300
                   ))
               }
                
                
            }
            Spacer(modifier = Modifier.height(20.dp))
Box(modifier = Modifier.fillMaxWidth() , contentAlignment = Alignment.Center) {

    Image(painter = painterResource(id = com.kururu.fruitstore.R.drawable.fruit5),
        contentDescription ="" ,
    modifier = Modifier
        .height(176.dp)
        .width(176.dp)

        )
}
            Spacer(modifier = Modifier.height(20.dp))
           Box( modifier = Modifier
               .fillMaxHeight()
               .fillMaxWidth()
               .background(
                   color = Color.White,
                   shape = RoundedCornerShape(
                       topStart = 20.dp,
                       topEnd = 20.dp
                   )


               )
             ) {

               Column(

                   verticalArrangement = Arrangement.SpaceBetween ,

                   horizontalAlignment = Alignment.Start
                   ) {

                   Text(text = "Quinoa Fruit Salad" , style = TextStyle(
                       fontSize = 32.sp , fontWeight = FontWeight.W500
                   ) ,
                       modifier = Modifier   .padding(15.dp)
                   )
                   Row(modifier = Modifier
                       .fillMaxWidth()
                       .padding(15.dp) , horizontalArrangement = Arrangement.SpaceBetween) {
                       
                       Row(verticalAlignment = Alignment.CenterVertically  ) {

                           Box(modifier = Modifier
                               .background(Color.White, shape = CircleShape,)
                               .border(
                                   border = BorderStroke(1.dp, Color.Black),
                                   shape = CircleShape
                               )
                               .padding(5.dp)

                               , contentAlignment = Alignment.Center
                           ) {

                               Icon(painter = painterResource(id = com.kururu.fruitstore.R.drawable.ic_remove),
                                   contentDescription ="" ,
                               
                               
                               )

                           }
                           Spacer(modifier = Modifier.width(5.dp))

Text(text = "1")
                           Spacer(modifier = Modifier.width(5.dp))

                           Box(modifier = Modifier
                               .background(Color(0xFFFFF2E7), shape = CircleShape)
                               .padding(5.dp)

                               , contentAlignment = Alignment.Center
                           ) {

                               Icon(painter = painterResource(id = com.kururu.fruitstore.R.drawable.ic_add),
                                   contentDescription ="" , tint = Color(0xFFFFA451) )

                           }  
                           
                       }
                       
                       
                       Row() {
                           Text(text = "$" , style = TextStyle(
                                 fontWeight = FontWeight.Bold ,
                               fontSize = 24.sp
                           ))
                           Spacer(modifier = Modifier.width(3.dp))
                           Text(text ="43.4", style = TextStyle(
                           fontWeight = FontWeight.Bold
                               ,
                               fontSize = 24.sp
                           )
                           )
                       }
                       
                       
                   }

                   Divider(modifier = Modifier.padding(0.dp))
                   Spacer(modifier = Modifier.height(10.dp))
Column(modifier = Modifier.padding(15.dp) , horizontalAlignment = Alignment.Start) {
    Text(text = "One Pack Contains:" , style = TextStyle(
        fontSize = 20.sp , fontWeight = FontWeight.W500
    ) ,

        )
Box(modifier = Modifier
    .width(150.dp)
    .height(1.dp)
    .background(Color(0xFFFFA451))) {

}

}
Text(text = "Red Quinoa, Lime, Honey, Blueberries, Strawberries, Mango, Fresh mint." , modifier = Modifier.padding(15.dp) ,
    style = TextStyle(fontSize = 16.sp , fontWeight = FontWeight.W500) ,
    maxLines = 2
    )




                   Spacer(modifier = Modifier.height(10.dp))


Divider(modifier = Modifier.padding(0.dp))
                   Spacer(modifier = Modifier.weight(1f))
                   Text(text = "If you are looking for a new fruit salad to eat today, quinoa is the perfect brunch for you. make" , modifier = Modifier.padding(15.dp) ,
                       style = TextStyle(fontSize = 14.sp , fontWeight = FontWeight.W300) ,
                       maxLines = 2
                   )
                   Spacer(modifier = Modifier.height(8.dp))

Row(modifier = Modifier.fillMaxWidth()       .padding(15.dp) ,
    horizontalArrangement = Arrangement.SpaceBetween) {
    Box(modifier = Modifier
        .background(Color(0xFFFFF2E7), shape = CircleShape)
        .padding(15.dp)

        , contentAlignment = Alignment.Center
    ) {

        Icon(painter = painterResource(id = com.kururu.fruitstore.R.drawable.ic_fav),
            contentDescription ="" , tint = Color(0xFFFFA451) )

    }

    Box( modifier = Modifier
        .height(60.dp)
        .width(220.dp)
//        .padding(start = 20.dp, end = 20.dp)
        .clip(

            shape = RoundedCornerShape(10.dp)
        )
        .background(PrimaryColor)

        .clickable {
navController.navigate("cart")
        }
        ,

        contentAlignment = Alignment.Center

    ) {
        Text(text = "Add to basket",    style = TextStyle(
            color = Color.White ,
            fontWeight = FontWeight.W500,
            fontSize = 16.sp
        ))

    }



}

                   Spacer(modifier = Modifier.height(8.dp))


               }




           }

        }


    }
}