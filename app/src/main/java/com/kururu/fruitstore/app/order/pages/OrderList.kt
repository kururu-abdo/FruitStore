package com.kururu.fruitstore.app.order.pages

import androidx.compose.animation.fadeIn
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.*

import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.kururu.fruitstore.R
import com.kururu.fruitstore.app.order.components.CartItemWidget
import com.kururu.fruitstore.app.order.models.CartItem
import com.kururu.fruitstore.ui.theme.PrimaryColor
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderList(navController: NavController) {
    var showSheet by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    var isBottomSheetVisible by rememberSaveable { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true ,
    )

    val scope2 = rememberCoroutineScope()
    var isBottomSheetVisible2 by rememberSaveable { mutableStateOf(false) }
    val sheetState2 = rememberModalBottomSheetState(
        skipPartiallyExpanded = true ,
    )


//    if (showSheet) {
//        BottomSheet() {
//            showSheet = false
//        }
//    }
    val list = listOf(
        CartItem(
            product = "Quinoa fruit salad",
            numOfPack = "2pack",
            currency = "SAR",

            amount = 2000.0,
            color = Color(0xFFFFFAEB),
            image = R.drawable.fruit5
        ),
        CartItem(
            product = "Melon fruit salad",
            numOfPack = "1pack",
            currency = "$",

            amount = 24000.0,
            color = Color(0xFFF1EFF6),
            image = R.drawable.fruit6
        ),
        CartItem(
            product = "Tropical fruit salad",
            numOfPack = "4pack",
            currency = "SDG",

            amount = 234000.0,
            color = Color(0xFFFEF0F0),
            image = R.drawable.fruit7
        ),
        CartItem(
            product = "Quinoa fruit salad",
            numOfPack = "2pack",
            currency = "SAR",

            amount = 2000.0,
            color = Color(0xFFFFFAEB),
            image = R.drawable.fruit5
        ),
        CartItem(
            product = "Melon fruit salad",
            numOfPack = "1pack",
            currency = "$",

            amount = 24000.0,
            color = Color(0xFFF1EFF6),
            image = R.drawable.fruit6
        ),
        CartItem(
            product = "Tropical fruit salad",
            numOfPack = "4pack",
            currency = "SDG",

            amount = 234000.0,
            color = Color(0xFFFEF0F0),
            image = R.drawable.fruit7
        ),
        CartItem(
            product = "Quinoa fruit salad",
            numOfPack = "2pack",
            currency = "SAR",

            amount = 2000.0,
            color = Color(0xFFFFFAEB),
            image = R.drawable.fruit5
        ),
        CartItem(
            product = "Melon fruit salad",
            numOfPack = "1pack",
            currency = "$",

            amount = 24000.0,
            color = Color(0xFFF1EFF6),
            image = R.drawable.fruit6
        ),
        CartItem(
            product = "Tropical fruit salad",
            numOfPack = "4pack",
            currency = "SDG",

            amount = 234000.0,
            color = Color(0xFFFEF0F0),
            image = R.drawable.fruit7
        )
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

                        Text(
                            text = "Go back", style = TextStyle(
                                fontSize = 16.sp,
                                fontWeight = FontWeight.W300
                            )
                        )
                    }

                }
                Text(
                    text = "My Basket", style = TextStyle(
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


                Column() {


                    LazyColumn(modifier = Modifier.weight(3f)) {
                        items(list.size, itemContent = { item ->


                            CartItemWidget(
                                cartItem = list[item],
                                lastItem = item == list.size - 1
                            )
                        }
                        )

                    }






                    Spacer(modifier = Modifier.weight(1f))


                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(15.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Column(horizontalAlignment = Alignment.Start) {
                            Text(
                                text = "Total", style = TextStyle(
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.W500
                                )
                            )
                            Row() {

                                Text(
                                    text = "$", style = TextStyle(
                                        fontSize = 24.sp,
                                        fontWeight = FontWeight.W500
                                    )
                                )
                                Box(modifier = Modifier.width(3.dp)) {

                                }


                                Text(
                                    text = "12.565", style = TextStyle(
                                        fontSize = 24.sp,
                                        fontWeight = FontWeight.W500
                                    )
                                )
                            }


                        }


                        Box(
                            modifier = Modifier
                                .height(60.dp)
                                .width(220.dp)
//        .padding(start = 20.dp, end = 20.dp)
                                .clip(

                                    shape = RoundedCornerShape(10.dp)
                                )
                                .background(PrimaryColor)

                                .clickable {
                                    scope.launch {
                                        isBottomSheetVisible = true
                                        sheetState.expand()

                                    }
//                                    showSheet = true

                                },

                            contentAlignment = Alignment.Center

                        ) {
                            Text(
                                text = "Checkout", style = TextStyle(
                                    color = Color.White,
                                    fontWeight = FontWeight.W500,
                                    fontSize = 16.sp
                                )
                            )

                        }


                    }

                }


            }
            BottomSheet2(
                isBottomSheetVisible = isBottomSheetVisible,
                sheetState = sheetState,
                onDismiss = {
                    scope.launch { sheetState.hide() }
                        .invokeOnCompletion { isBottomSheetVisible = false }
                },
                onPayWithCard = {it->
                        if (it){
                            scope2.launch {
                                sheetState.hide()
                                sheetState2.hide() }
                                .invokeOnCompletion {
                                    isBottomSheetVisible=false
                                    isBottomSheetVisible2 = true }
                        }

                }
            )
            BottomsheetCard(
                isBottomSheetVisible = isBottomSheetVisible2,
                sheetState = sheetState2,
                onDismiss = {
                    scope2.launch { sheetState2.hide() }
                        .invokeOnCompletion { isBottomSheetVisible2 = false }
                },
                onPayWithCash = {it->
                    if (it){
                        scope.launch { sheetState.hide() }
                            .invokeOnCompletion { isBottomSheetVisible = false }
                    }

                },

                navController
            )
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet(onDismiss: () -> Unit) {
    val modalBottomSheetState = rememberModalBottomSheetState()
BoxWithConstraints() {

}
    ModalBottomSheet(
        onDismissRequest = { onDismiss() },
        sheetState = modalBottomSheetState,
        dragHandle = { BottomSheetDefaults.DragHandle() },
        containerColor = Color.White , 
        
    ) {
        Box(modifier = Modifier
            .height(450.dp)
            .fillMaxWidth()
            .background(Color.White)) {
//Box(modifier = Modifier.offset(Modifier.fillMaxWidth() / 2f,
//    Modifier.fillMaxHeight() / 2)) {
//
//}
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet2(
    isBottomSheetVisible: Boolean,
    sheetState: SheetState,
    onDismiss: () -> Unit,
    onPayWithCard:(Boolean)->Unit
) {

    if (isBottomSheetVisible) {

        ModalBottomSheet(
            onDismissRequest = onDismiss,
            sheetState = sheetState,
            containerColor = Color.Transparent,
            contentColor = MaterialTheme.colorScheme.onSurface,
            shape = RectangleShape,
            dragHandle = null,
            scrimColor = Color.Black.copy(alpha = .5f),
            windowInsets = WindowInsets(0, 0, 0, 0)
        ) {

            Box(
                modifier = Modifier
                    .statusBarsPadding()
                    .fillMaxWidth(),
//                    .padding(8.dp),
                contentAlignment = Alignment.Center
            ) {

                FilledIconButton(
                    modifier = Modifier.size(48.dp),
                    onClick = onDismiss,
                    colors = IconButtonDefaults.filledIconButtonColors(
                        containerColor = MaterialTheme.colorScheme.background
                    )
                ) {

                    Icon(
                        imageVector = Icons.Rounded.Close,
                        contentDescription = "Hide the dialog."
                    )

                }

            }

            Column(
                modifier = Modifier
                    .navigationBarsPadding()
                    .padding(top = 12.dp) // Outer padding
                    .clip(
                        shape = RoundedCornerShape(
                            topEnd = 24.dp,
                            topStart = 24.dp

                        )
                    )
                    .background(color = MaterialTheme.colorScheme.background)
                    .fillMaxWidth()
                    .padding(24.dp) // Inner padding
            ) {

                Spacer(modifier = Modifier.height(16.dp))




                Column(horizontalAlignment = Alignment.Start) {
                    Text(text = "Delivery Address", style = TextStyle(fontSize = 20.sp ,
                        fontWeight = FontWeight.W500))

                    Box(modifier = Modifier.height(8.dp)) {

                    }
                    androidx.compose.material.TextField(
                        colors = TextFieldDefaults.textFieldColors(

                            focusedIndicatorColor = Color(0xFFF3F1F1)//hid,,
                            ,
                            backgroundColor = Color(0xFFF3F1F1)//hide the indicator
                            ,
                            unfocusedIndicatorColor = Color(0xFFF3F1F1)
                        ),
                        modifier = Modifier.fillMaxWidth(),
                        value = "10th avenue, Some, State",
                        textStyle = TextStyle(
                            fontWeight = FontWeight.W300 ,
                            fontSize = 20.sp ,
                            color = Color(0xFFC2BDBD)
                        ),
                        onValueChange = {},
//        label = { Text(text = "") },
                        readOnly = false,
                        shape = RoundedCornerShape(12.dp)
                    )
                }


                Spacer(modifier = Modifier.height(24.dp))



Column(horizontalAlignment = Alignment.Start) {
  Text(text = "Number we can call", style = TextStyle(fontSize = 20.sp ,
      fontWeight = FontWeight.W500))

Box(modifier = Modifier.height(8.dp)) {

}
    androidx.compose.material.TextField(
        colors = TextFieldDefaults.textFieldColors(

            focusedIndicatorColor = Color(0xFFF3F1F1)//hid,,
            ,
            backgroundColor = Color(0xFFF3F1F1)//hide the indicator
            ,
            unfocusedIndicatorColor = Color(0xFFF3F1F1)
        ),
        modifier = Modifier.fillMaxWidth(),
        value = "09090606000",
        textStyle = TextStyle(
            fontWeight = FontWeight.W300 ,
            fontSize = 20.sp ,
            color = Color(0xFFC2BDBD)
        ),
        onValueChange = {},
//        label = { Text(text = "") },
        readOnly = false,
        shape = RoundedCornerShape(12.dp)
    )
}



                Spacer(modifier = Modifier.height(48.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    OutlinedButton(  modifier= Modifier
//                        .width(125.dp)
                        .height(60.dp)
                        .clip(shape = RoundedCornerShape(1.dp)),



                        border = BorderStroke(
                            1.dp , color = Color(0xFFFFA451)
                        ),
                        shape=RoundedCornerShape(10.dp),
                        onClick = {},
                        content = { Text(text = "Pay on delivery" ,
                        style = TextStyle(
                            color = Color(0xFFFFA451),
                            fontSize = 16.sp ,
                            fontWeight = FontWeight.W500
                        )

                            ) }
                    )

                    OutlinedButton(
                        modifier= Modifier
//                            .width(125.dp)
                            .height(60.dp)
                        ,

                        border = BorderStroke(
                            1.dp , color = Color(0xFFFFA451)
                        ),
                        shape=RoundedCornerShape(10.dp),
                        onClick = {
                                  onPayWithCard(true)
                        },
                        content = { Text(text = "Pay with card"
                            ,
                            style = TextStyle(  fontSize = 16.sp ,
                                fontWeight = FontWeight.W500,
                                color = Color(0xFFFFA451)
                            )

                        ) }
                    )

                }

            }

        }

    }

}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomsheetCard(
    isBottomSheetVisible: Boolean,
    sheetState: SheetState,
    onDismiss: () -> Unit,
    onPayWithCash:(Boolean)->Unit ,
    navController: NavController
) {

    if (isBottomSheetVisible) {

        ModalBottomSheet(
            onDismissRequest = onDismiss,
            sheetState = sheetState,
            containerColor = Color.Transparent,
            contentColor = MaterialTheme.colorScheme.onSurface,
            shape = RectangleShape,
            dragHandle = null,
            scrimColor = Color.Black.copy(alpha = .5f),
            windowInsets = WindowInsets(0, 0, 0, 0)
        ) {

            Box(
                modifier = Modifier
                    .statusBarsPadding()
                    .fillMaxWidth(),
//                    .padding(8.dp),
                contentAlignment = Alignment.Center
            ) {

                FilledIconButton(
                    modifier = Modifier.size(48.dp),
                    onClick = onDismiss,
                    colors = IconButtonDefaults.filledIconButtonColors(
                        containerColor = MaterialTheme.colorScheme.background
                    )
                ) {

                    Icon(
                        imageVector = Icons.Rounded.Close,
                        contentDescription = "Hide the dialog."
                    )

                }

            }

            Column(
                modifier = Modifier
                    .navigationBarsPadding()
                    .padding(top = 12.dp) // Outer padding
                    .clip(
                        shape = RoundedCornerShape(
                            topEnd = 24.dp,
                            topStart = 24.dp

                        )
                    )
                    .background(color = MaterialTheme.colorScheme.background)
                    .fillMaxWidth()

            ) {

                Spacer(modifier = Modifier.height(16.dp))




                Column(
                    modifier=Modifier
                        .padding(
                            horizontal =
                            24.dp) ,

                    horizontalAlignment = Alignment.Start) {
                    Text(text = "Card Holders Name", style = TextStyle(fontSize = 20.sp ,
                        fontWeight = FontWeight.W500))

                    Box(modifier = Modifier.height(8.dp)) {

                    }
                    androidx.compose.material.TextField(
                        colors = TextFieldDefaults.textFieldColors(

                            focusedIndicatorColor = Color(0xFFF3F1F1)//hid,,
                            ,
                            backgroundColor = Color(0xFFF3F1F1)//hide the indicator
                            ,
                            unfocusedIndicatorColor = Color(0xFFF3F1F1)
                        ),
                        modifier = Modifier.fillMaxWidth(),
                        value = "Kururu",
                        textStyle = TextStyle(
                            fontWeight = FontWeight.W300 ,
                            fontSize = 20.sp ,
                            color = Color(0xFFC2BDBD)
                        ),
                        onValueChange = {},
//        label = { Text(text = "") },
                        readOnly = false,
                        shape = RoundedCornerShape(12.dp)
                    )
                }


                Spacer(modifier = Modifier.height(24.dp))



                Column(
                    modifier=Modifier
                        .padding(
                            horizontal =
                            24.dp) ,
                    horizontalAlignment = Alignment.Start) {
                    Text(text = "Card Number", style = TextStyle(fontSize = 20.sp ,
                        fontWeight = FontWeight.W500))

                    Box(modifier = Modifier.height(8.dp)) {

                    }
                    androidx.compose.material.TextField(
                        colors = TextFieldDefaults.textFieldColors(

                            focusedIndicatorColor = Color(0xFFF3F1F1)//hid,,
                            ,
                            backgroundColor = Color(0xFFF3F1F1)//hide the indicator
                            ,
                            unfocusedIndicatorColor = Color(0xFFF3F1F1)
                        ),
                        modifier = Modifier.fillMaxWidth(),
                        value = "1234 5678 9012 1314",
                        textStyle = TextStyle(
                            fontWeight = FontWeight.W300 ,
                            fontSize = 20.sp ,
                            color = Color(0xFFC2BDBD)
                        ),
                        onValueChange = {},
//        label = { Text(text = "") },
                        readOnly = false,
                        shape = RoundedCornerShape(12.dp)
                    )
                }


                Spacer(modifier = Modifier.height(24.dp))
                
                Row(modifier= Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal =
                        24.dp
                    ) ,
                    horizontalArrangement = Arrangement.SpaceBetween
                ){


                    Column(horizontalAlignment = Alignment.Start) {
                        Text(text = "Date", style = TextStyle(fontSize = 20.sp ,
                            fontWeight = FontWeight.W500))

                        Box(modifier = Modifier.height(8.dp)) {

                        }
                        androidx.compose.material.TextField(
                            colors = TextFieldDefaults.textFieldColors(

                                focusedIndicatorColor = Color(0xFFF3F1F1)//hid,,
                                ,
                                backgroundColor = Color(0xFFF3F1F1)//hide the indicator
                                ,
                                unfocusedIndicatorColor = Color(0xFFF3F1F1)
                            ),
                            modifier = Modifier.width(134.dp),
                            value = "10/30",
                            textStyle = TextStyle(
                                fontWeight = FontWeight.W300 ,
                                fontSize = 20.sp ,
                                color = Color(0xFFC2BDBD)
                            ),
                            onValueChange = {},
//        label = { Text(text = "") },
                            readOnly = false,
                            shape = RoundedCornerShape(12.dp)
                        )
                    }




                    Column(horizontalAlignment = Alignment.Start) {
                        Text(text = "CCV", style = TextStyle(fontSize = 20.sp ,
                            fontWeight = FontWeight.W500))

                        Box(modifier = Modifier.height(8.dp)) {

                        }
                        androidx.compose.material.TextField(
                            colors = TextFieldDefaults.textFieldColors(

                                focusedIndicatorColor = Color(0xFFF3F1F1)//hid,,
                                ,
                                backgroundColor = Color(0xFFF3F1F1)//hide the indicator
                                ,
                                unfocusedIndicatorColor = Color(0xFFF3F1F1)
                            ),
                            modifier  = Modifier.width(134.dp),
                            value = "123",
                            textStyle = TextStyle(
                                fontWeight = FontWeight.W300 ,
                                fontSize = 20.sp ,
                                color = Color(0xFFC2BDBD)
                            ),
                            onValueChange = {},
//        label = { Text(text = "") },
                            readOnly = false,
                            shape = RoundedCornerShape(12.dp)
                        )
                    }





                }
                Spacer(modifier = Modifier.height(24.dp))

                Box(modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth()
                    .background(
                        color = PrimaryColor,
                        shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
                    ) ,  contentAlignment = Alignment.Center) {

Box(
    modifier = Modifier
        .height(60.dp)
        .width(135.dp)
        .background(
            color = Color.White,
            shape = RoundedCornerShape(24.dp)
        )
        .clickable {


      navController.navigate("success")

        }
    ,

    contentAlignment = Alignment.Center) {

Text(text = "Complete Order", style = TextStyle(color = PrimaryColor ,
fontSize = 16.sp ,
    fontWeight = FontWeight.W500


    ))

}
                }

            }

        }

    }

}