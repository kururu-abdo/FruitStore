package com.kururu.fruitstore.app.home.model

import androidx.compose.ui.graphics.Color

data class FriutModel(
    val title:String,  val icon:Int, val isFav:Boolean ,
    val price:Double , val currency:String , val color: Color=Color.White
)