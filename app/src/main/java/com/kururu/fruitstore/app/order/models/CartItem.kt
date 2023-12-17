package com.kururu.fruitstore.app.order.models

import androidx.compose.ui.graphics.Color

data class CartItem( val image:Int,  val currency:String , val amount:Double ,
val product:String , val numOfPack:String ,  val color:Color

                     )