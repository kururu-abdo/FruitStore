package com.kururu.fruitstore.app.home

import android.graphics.Bitmap
import android.graphics.Paint.Align
import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.createBitmap
import androidx.navigation.NavController
import com.kururu.fruitstore.R
import com.kururu.fruitstore.app.home.model.FriutModel
import com.kururu.fruitstore.app.home.model.Tabs
import com.kururu.fruitstore.app.home.widgets.ProductWidget
import com.kururu.fruitstore.app.home.widgets.ProductWidgetWithBackground
import com.kururu.fruitstore.ui.theme.PrimaryColor

@Composable
fun Home(navController: NavController){
    var selectedTab by remember {
        mutableStateOf(Tabs.Hottes)
    }
    var text by remember { mutableStateOf("") }
  var friuts = listOf(
      FriutModel(
          title ="Combo Mango 1" ,
          icon = R.drawable.ic_mango,
          price = 12.44,
          currency = "SAR",
          isFav = true ,
          color = Color(0xFFFFFAEB)
      ) ,

      FriutModel(
          title ="Combo honey 1" ,
          icon = R.drawable.ic_honey,
          price = 15.6,
          currency = "$",
          isFav = false
          ,
          color = Color(0xFFFEF0F0)
      )
  ,
      FriutModel(
          title ="Combo Mango 2" ,
          icon = R.drawable.ic_mango,
          price = 145.4,
          currency = "$",
          isFav = false
          ,
          color = Color(0xFFF1EFF6)
      )

  )
    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(20.dp))


        Row(
            modifier = Modifier

                .fillMaxWidth()
                .padding(10.dp),

            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_menu),
                    contentDescription = "",

                    modifier = Modifier.size(24.dp)
                )
            }

            CartIcon()

        }

        Spacer(modifier = Modifier.height(20.dp))


        Text(
            text = "Hello Tony, What fruit salad combo do you want today?",

            modifier = Modifier
                .padding(10.dp)
                .width(257.dp),

            maxLines = 2
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier

                .fillMaxWidth()
                .padding(10.dp),

            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            TextField(
                value = text,
                maxLines = 1,
                onValueChange = { text = it },
                colors = TextFieldDefaults.textFieldColors(

                    focusedIndicatorColor = Color(0xFFF3F1F1)//hid,,
                    ,
                    backgroundColor = Color(0xFFF3F1F1)//hide the indicator
                    ,
                    unfocusedIndicatorColor = Color(0xFFF3F1F1)
                ),

                label = {
                    Text(
                        "Search for fruit salad combos", style = TextStyle(
                            fontWeight = FontWeight.W300,
                            color = Color(0xFFC2BDBD)
                        )
                    )
                },
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_search),
                        contentDescription = "", tint = Color(0xFF86869E)
                    )
                },
                placeholder = {
                    Text(
                        "Search for fruit salad combos", style = TextStyle(
                            fontWeight = FontWeight.W300,
                            color = Color(0xFFC2BDBD)
                        ),
                        modifier = Modifier.background(Color(0xFFF3F1F1))
                    )
                },
                modifier = Modifier.width(288.dp),
                        shape = RoundedCornerShape(16.dp)
            )
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_filter),
                    contentDescription = "",

                    modifier = Modifier.size(24.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(15.dp))


        Text(
            "Recommended Combo",

            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.W500
            ),
            modifier = Modifier.padding(10.dp) ,

        )
        Spacer(modifier = Modifier.height(5.dp))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(4.dp),
        ) {
         items(friuts.size){index ->
             ProductWidget(
                 title =friuts.get(index).title, image = friuts.get(index).icon,
                 isFav = friuts.get(index).isFav, price = friuts.get(index).price, currency = friuts.get(index).currency
             ,
                 navController
             )
         }
        }
        Spacer(modifier = Modifier.height(10.dp))


        Row(
            Modifier
                .fillMaxWidth()
                .padding(5.dp) ,
        horizontalArrangement = Arrangement.SpaceBetween ,
            verticalAlignment = Alignment.Bottom


            ) {
            Tabs.values().forEach { tab ->
                if (selectedTab==tab)
                    Column(modifier = Modifier
                       .clickable {
                            selectedTab=tab
                        }

                        ,


                        horizontalAlignment = Alignment.Start
                        ){
                        Text(text = tab.title, style = TextStyle(
                            fontSize = 24.sp,
                            fontWeight = FontWeight.W500
                        ))
                        
                        Box(modifier = Modifier
                            .height(1.dp)
                            .width(22.dp)
                            .background(Color(0xFFFFA451))

                        ) {




                        }
                    }
                    else

                    Text(text = tab.title, style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W500 ,
                        color = Color(0xFF938DB5) ,

                    ) , modifier = Modifier.clickable {
                        selectedTab=tab
                    })
            }
        }


        Spacer(modifier = Modifier.height(5.dp))
        when (selectedTab) {
            Tabs.Hottes ->
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                ) {
                    items(friuts.size){index ->
                        ProductWidgetWithBackground(
                            title =friuts.get(index).title, image = friuts.get(index).icon,
                            isFav = friuts.get(index).isFav, price = friuts.get(index).price, currency = friuts.get(index).currency ,

                            color =friuts.get(index).color ,
                            navController
                        )
                    }
                }
            Tabs.Popular -> LazyRow(
                horizontalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                items(friuts.size){index ->
                    ProductWidgetWithBackground(
                        title =friuts.get(index).title, image = friuts.get(index).icon,
                        isFav = friuts.get(index).isFav, price = friuts.get(index).price, currency = friuts.get(index).currency
                               , color =friuts.get(index).color ,
                        navController


                    )
                }
            }
            Tabs.NewCombo -> LazyRow(
                horizontalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                items(friuts.size){index ->
                    ProductWidgetWithBackground(
                        title =friuts.get(index).title, image = friuts.get(index).icon,
                        isFav = friuts.get(index).isFav, price = friuts.get(index).price, currency = friuts.get(index).currency
                        , color =friuts.get(index).color ,
                        navController

                    )
                }
            }
            else -> LazyRow(
                horizontalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                items(friuts.size){index ->
                    ProductWidgetWithBackground(
                        title =friuts.get(index).title, image = friuts.get(index).icon,
                        isFav = friuts.get(index).isFav, price = friuts.get(index).price, currency = friuts.get(index).currency

                    ,                                color =friuts.get(index).color ,
                        navController

                    )
                }
            }
        }

    }



}


@Composable
fun CartIcon(){
//    val context =LocalContext.current

        Column(
            modifier= Modifier
//                .height(45.dp)
                .width(45.dp),

horizontalAlignment = Alignment.CenterHorizontally
            ) {
            Icon(painter = painterResource(id = R.drawable.ic_basket2),
                contentDescription ="", tint = PrimaryColor ,
                modifier= Modifier
                .height(24.dp)
                    .width(24.dp),
                )
//Image(painter = painterResource(id = R.drawable.ic_basket),
//    contentDescription ="",
////               modifier= Modifier
////                   .height(40.dp)
////                   .width(24.dp)
//    )
//            Image(painter = painterResource(id = R.drawable.ic_basket),
//               contentDescription = "",
//               modifier= Modifier
//                   .height(24.dp)
//                   .width(24.dp)
//               )


//            Icon(painter = painterResource(id = R.drawable.ic_basket),
//                contentDescription ="" ,   modifier = Modifier.size(40.dp))
            Text(text = "My basket",
style = TextStyle(
    color = Color(0xFF27214D) ,

    fontSize = 10.sp,
    fontWeight = FontWeight.W300
)
                )
        }

//        Box(contentAlignment = Alignment.Center ,
//
//            modifier = Modifier
//                .size(20.dp)
//                .background(
//                    Color.Red,
//
//                    shape = CircleShape
//                )
//
//        ) {
//Text(text = "5" ,  style = TextStyle(color=Color.White))
//
//        }

}









//Tabs


//@Composable
//fun CustomTabs() {
//    var selectedIndex by remember { mutableStateOf(0) }
//
//    val list = listOf("Active", "Completed")
//
//    TabRow(selectedTabIndex = selectedIndex,
//        backgroundColor = Color(0xff1E76DA),
//        modifier = Modifier
//            .padding(vertical = 4.dp, horizontal = 8.dp)
//            .clip(RoundedCornerShape(50))
//            .padding(1.dp),
//        indicator = { tabPositions: List<TabPosition> ->
//            Box {}
//        }
//    ) {
//        list.forEachIndexed { index, text ->
//            val selected = selectedIndex == index
//            Tab(
//                modifier = if (selected) Modifier
//                    .clip(RoundedCornerShape(50))
//                    .background(
//                        Color.White
//                    )
//                else Modifier
//                    .clip(RoundedCornerShape(50))
//                    .background(
//                        Color(
//                            0xff1E76DA
//                        )
//                    ),
//                selected = selected,
//                onClick = { selectedIndex = index },
//                text = { Text(text = text, color = Color(0xff6FAAEE)) }
//            )
//        }
//    }
//}