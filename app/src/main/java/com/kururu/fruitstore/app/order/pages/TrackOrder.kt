package com.kururu.fruitstore.app.order.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Switch
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.*
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.kururu.fruitstore.R
import com.kururu.fruitstore.app.order.models.Status
import com.kururu.fruitstore.app.order.models.StausModel
import com.kururu.fruitstore.ui.theme.PrimaryColor

@Composable
fun TrackPage(navController: NavController){
    var  statusList
    = listOf(
        StausModel(
            isMap = false ,
            isDone = true ,
            status = "Order Taken" ,
statusIcon = Status.Done ,
            icon = R.drawable.order_start ,
            color = Color(0xFFFFFAEB)
        ),

        StausModel(
            isMap = false ,
            isDone = true ,
            status = "Order Is Being Prepared" ,
            statusIcon = Status.Done ,
            icon = R.drawable.order_prepared ,
            color = Color(0xFFF1EFF6)

        ),
        StausModel(
            isMap = false ,
            isDone = true ,
            status = "Order Is Being Delivered" ,
            statusIcon = Status.Call ,
            icon = R.drawable.order_delivering,
            color = Color(0xFFFEF0F0)
        ),
        StausModel(
            isMap = true ,
            icon = R.drawable.order_map
        ),
        StausModel(
            isMap = false ,
            isDone = true ,
            status = "Order Received" ,
            statusIcon = Status.Dot ,
            icon = R.drawable.order_prepared,
                    color = Color(0xFFF0FEF8)
        ),

    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(PrimaryColor)
    ) {
        Column(
            horizontalAlignment = Alignment.Start,

            ) {

            Spacer(modifier = Modifier.height(20.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment =
                Alignment.CenterVertically,

                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()

            ) {
                Box(modifier = Modifier

                    .height(32.dp)
                    .width(100.dp)
                    .background(Color.White, shape = RoundedCornerShape(50.dp))
                    .padding(5.dp)
                    .clickable {
                        navController.popBackStack()
                    }


                ) {
                    Row() {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_back_ios),
                            contentDescription = ""
                        )

                        androidx.compose.material.Text(
                            text = "Go back", style = TextStyle(
                                fontSize = 16.sp,
                                fontWeight = FontWeight.W300
                            )
                        )
                    }

                }
                androidx.compose.material.Text(
                    text = "Delivery Status", style = TextStyle(
                        fontSize = 24.sp,
                        fontWeight = FontWeight.W500,
                        color = Color.White
                    )
                )

                Box(modifier = Modifier.width(100.dp)) {


                }
            }

            Spacer(modifier = Modifier.height(20.dp))
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .background(
                        color = Color.White,
//                    shape = RoundedCornerShape(
//                        topStart = 20.dp,
//                        topEnd = 20.dp
//                    )


                    )
            ) {
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                ) {
//                    OrderTimeLine(
//content = {
//    OrderStatus(
//        Modifier
//            .fillMaxWidth()
//            .height(70.dp)
//        ,
//        StausModel(
//            isMap = false,
//            isDone = true,
//            status = "Order Is Being Delivered",
//            statusIcon = Status.Call,
//            icon = R.drawable.order_delivering,
//            color = Color(0xFFFEF0F0)
//        )
//    )
//},
//)
                    Spacer(modifier = Modifier.height(40.dp))
                    OrderStatus(
                        Modifier
                            .fillMaxWidth()
                            .height(70.dp)
                        ,
                        StausModel(
                            isMap = false,
                            isDone = true,
                            status = "Order Taken",
                            statusIcon = Status.Done,
                            icon = R.drawable.order_start,
                            color = Color(0xFFFFFAEB)
                        )
                    )
                    OrderStatus(
                        Modifier
                            .fillMaxWidth()
                            .height(70.dp)
                        ,
                        StausModel(
                            isMap = false,
                            isDone = true,
                            status = "Order Is Being Prepared",
                            statusIcon = Status.Done,
                            icon = R.drawable.order_prepared,
                            color = Color(0xFFF1EFF6)
                        )
                    )



                    OrderStatus(
                        Modifier
                            .fillMaxWidth()
                            .height(70.dp)
                        ,
                        StausModel(
                            isMap = false,
                            isDone = true,
                            status = "Order Is Being Delivered",
                            statusIcon = Status.Call,
                            icon = R.drawable.order_delivering,
                            color = Color(0xFFFEF0F0)
                        )
                    )

                    OrderStatus(
                        Modifier
                            .fillMaxWidth()
//                    .height(70.dp)
                        ,
                        StausModel(
                            isMap = true,
                            isDone = true,
                            status = "Order Is Being Delivered",
                            statusIcon = Status.Call,
                            icon = R.drawable.order_map,
                            color = Color(0xFFFEF0F0)
                        )
                    )

                    OrderStatus(
                        Modifier
                            .fillMaxWidth()
//                    .height(70.dp)
                        ,
                        StausModel(
                            isMap = false,
                            isDone = true,

                            status = "Order Received",
                            isLast = true,
                            statusIcon = Status.Dot,
                            icon = R.drawable.done,
                            color = Color(0xFFF0FEF8)
                        )
                    )

                }


            }
            }





        }










}

@Composable
fun TimelineNode(
    content: @Composable BoxScope.(modifier: Modifier) -> Unit
) {
    Box(
        modifier = Modifier.wrapContentSize()
    ) {
        content(Modifier)
    }
}

@Composable
private fun OrderStatus(modifier: Modifier, orderStatus: StausModel) {


    if (orderStatus.isMap)

        Column( horizontalAlignment = Alignment.Start ,
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 10.dp)
//            modifier = Modifier.padding(
//            horizontal = 10.dp)
        ) {
            Image(
                painter = painterResource(id = orderStatus.icon!!),
                contentDescription = "map image",

                modifier = Modifier
                    .padding(0.dp)
                    .fillMaxWidth()
                    .height(128.dp)
                    .clip(RoundedCornerShape(10.dp))
//                        modifier = Modifier.fillMaxSize()
//                    .height(130.dp)

                ,
                alignment = Alignment.Center,
                contentScale = ContentScale.FillWidth
            )
            Box(modifier = Modifier.height(0.dp)) {

            }
            Box(  modifier= Modifier
                .wrapContentSize()
//           .padding(bottom = 30.dp)
                .padding(
                    horizontal = 10.dp
                )
                .paint(CustomPainter())) {

            }
        }
        else
        Column(  horizontalAlignment = Alignment.Start , modifier = Modifier.padding(
            horizontal = 10.dp
        )) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically

            ) {

                Row( verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .width(65.dp)
                            .height(65.dp)
                            .background(orderStatus.color!!, shape =
                            RoundedCornerShape(10.dp)),
                        contentAlignment = Alignment.Center

                    ) {

if(orderStatus.isLast)

    Box(modifier = Modifier
        .height(40.dp)
        .width(40.dp)
        .background(Color.Green, shape = CircleShape)
        ,
        contentAlignment = Alignment.Center
    ) {
        Icon(painter = painterResource(id = R.drawable.ic_check),

            contentDescription ="" ,
            tint = Color.White ,


        )

    }


    else
                        Image(
                            painter = painterResource(id = orderStatus.icon!!),
                            contentDescription = "",
                            modifier = Modifier
                                .width(43.dp)
                                .height(43.dp)
                        )


                    }

                    Box(modifier = Modifier.width(10.dp)) {

                    }
                    Text(
                        text = orderStatus.status!!, style = TextStyle(
                            fontSize = 18.sp, fontWeight = FontWeight.W500
                        )
                    )


                }



//                if (!orderStatus.isMap)
//                    orderStatus.trailing else Box() {
//
//                }

                when (orderStatus.statusIcon) {
                     Status.Dot ->{
                        Image(painter = painterResource(id = R.drawable.dots),
                            contentDescription ="",
                                    modifier = Modifier
                                    .width(40.dp)
                                .height(15.dp)


                        )
                    } 
                    Status.Call ->{
                        Box(modifier = Modifier
                            .height(40.dp)
                            .width(40.dp)
                            .background(PrimaryColor, shape = CircleShape)
                            ,
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(painter = painterResource(id = R.drawable.ic_call),

                                contentDescription ="" ,
                                tint = Color.White ,


                            )

                        }
                    }
                    
                    // Do code
                    else -> {
                        Box(modifier = Modifier
                            .height(24.dp)
                            .width(24.dp)
                            .background(Color.Green, shape = CircleShape)
                         ,
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(painter = painterResource(id = R.drawable.ic_check),

                                contentDescription ="" ,
                            tint = Color.White ,
                                modifier = Modifier
                                    .width(10.dp)
                                    .height(10.dp)

                                )

                        }
                    }
                }
            }
            Box(modifier = Modifier.height(0.dp)) {
                
            }

            if (orderStatus.isLast)
                Box(modifier = Modifier.height(0.dp)) {

                }
                else
       Box(  modifier= Modifier
           .wrapContentSize()
//           .padding(bottom = 30.dp)

           .paint(CustomPainter())) {

       }



        }
}



@Composable
fun OrderTimeLine(

    content: @Composable() () -> Unit
) {

        Box(
            modifier = Modifier

                .wrapContentSize()
//                .padding(bottom = 30.dp)

//                .paint(CustomPainter())

//
//                .drawWithContent {
//                    drawLine(
//
//                        color = PrimaryColor,
//                        pathEffect = PathEffect.dashPathEffect(
//                            floatArrayOf(10f, 10f),
//                            0f
//                        ),
//
//                        start = Offset(
//                            x = 50.dp.toPx(),
//                            y = this.size.height + 10
//                                .toDp()
//                                .toPx() * 2
//                        ),
//                        end = Offset(
//                            x = 50.dp.toPx(),
//                            y = this.size.height + 70
//                                .toDp()
//                                .toPx() * 2
//                        ),
//                        strokeWidth = 2.dp.toPx()
//                    )
//                },

            ) {
            OrderStatus(
                Modifier
                    .fillMaxWidth()
//                    .height(70.dp)
                ,
                StausModel(
                    isMap = false,
                    isDone = true,
                    status = "Order Is Being Delivered",
                    statusIcon = Status.Call,
                    icon = R.drawable.order_delivering,
                    color = Color(0xFFFEF0F0)
                )
            )


            OrderStatus(
                Modifier
                    .fillMaxWidth()
//                    .height(70.dp)
                ,
                StausModel(
                    isMap = true,
                    isDone = true,
                    status = "Order Is Being Delivered",
                    statusIcon = Status.Call,
                    icon = R.drawable.order_map,
                    color = Color(0xFFFEF0F0)
                )
            )

            OrderStatus(
                Modifier
                    .fillMaxWidth()
//                    .height(70.dp)
                ,
                StausModel(
                    isMap = false,
                    isDone = true,
                    status = "Order Received",
                    statusIcon = Status.Dot,
                    icon = R.drawable.done,
                    color = Color(0xFFF0FEF8)
                )
            )
        }

}


class CustomPainter : Painter() {

    override val intrinsicSize: Size
        get() = Size(300.0f, (70).toFloat())

    override fun DrawScope.onDraw() {
        drawLine(

            color = PrimaryColor,
            pathEffect = PathEffect.dashPathEffect(
                floatArrayOf(10f, 10f),
                0f
            ),

            start = Offset(x = (65/2).dp.toPx(),
                y = 0
                    .toDp()
                    .toPx() * 2
            ),
            end = Offset(x = (65/2).dp.toPx(),
                y =  70
                    .toDp()
                    .toPx() * 2
            ),
            strokeWidth = 2.dp.toPx()
        )
    }
}
