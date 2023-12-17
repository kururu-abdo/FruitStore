package com.kururu.fruitstore.app.order.models

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


data class StausModel (  val status:String?=null , val color: Color?=null ,
   val isLast:Boolean=false,
                          val icon:Int?=null ,
                          val isDone:Boolean?=null ,
                         val statusIcon: Status=Status.Done,
                          val isMap :Boolean=false ,
                        val  trailing: Composable?=null

                          ) {
}

enum class Status{
    Done ,
    Call ,
    Dot
}