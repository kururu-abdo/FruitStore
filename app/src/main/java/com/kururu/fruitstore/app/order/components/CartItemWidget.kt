package com.kururu.fruitstore.app.order.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kururu.fruitstore.app.order.models.CartItem

@Composable
fun CartItemWidget(cartItem: CartItem, lastItem:Boolean ){
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(80.dp)
        .padding(12.dp)

    ) {
Row(modifier = Modifier.fillMaxSize()
 ,
    verticalAlignment = Alignment.CenterVertically ,
    horizontalArrangement = Arrangement.SpaceBetween

) {

Row( verticalAlignment = Alignment.CenterVertically ,) {
    Box(modifier = Modifier
        .height(65.dp)
        .width(65.dp)
        .background(cartItem.color, shape = RoundedCornerShape(5.dp))

        ,
        contentAlignment = Alignment.Center

    ) {
        Image(painter = painterResource(id = cartItem.image), contentDescription ="",

            modifier = Modifier
                .height(40.dp)
                .width(40.dp)

        )






    }
    Spacer(modifier = Modifier.width(5.dp))

    Column(horizontalAlignment = Alignment.Start) {
        Text(text = cartItem.product , style = TextStyle(
            fontSize = 16.sp ,
            fontWeight = FontWeight.W500
        ))
        Text(text = cartItem.numOfPack , style = TextStyle(
            fontSize = 14.sp ,
            fontWeight = FontWeight.W300
        ))

    }

}


    Row() {
        Text(text = cartItem.currency , style = TextStyle(
              fontWeight = FontWeight.Bold ,
            fontSize = 14.sp
        ))
        Spacer(modifier = Modifier.width(3.dp))
        Text(text = cartItem.amount.toString(), style = TextStyle(
           fontWeight = FontWeight.Bold
            ,
            fontSize = 14.sp
        )
        )
    }







}
    }
}