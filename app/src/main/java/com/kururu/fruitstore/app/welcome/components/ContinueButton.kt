package com.kururu.fruitstore.app.welcome.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kururu.fruitstore.ui.theme.PrimaryColor

@Composable
fun ContinueButton(
     title:String ,
     onClick:()-> Unit
){

    Box( modifier = Modifier
        .height(60.dp)
        .fillMaxWidth()
        .padding(start = 20.dp, end = 20.dp)
        .clip(

            shape = RoundedCornerShape(10.dp)
        )
        .background(PrimaryColor)

        .clickable {
            onClick()
        }
        ,

    contentAlignment = Alignment.Center

    ) {
        Text(text = title,    style = TextStyle(
            color = Color.White ,
            fontFamily = FontFamily.Cursive ,
            fontSize = 16.sp
        ))

    }
}