package com.android.practice


import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            MyUi()
        }
    }

    @Composable
    fun Dashboard(){
        Column(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(color = Color(android.graphics.Color.parseColor("#ede7f8")))
                .padding(top = 16.dp, start = 16.dp, end = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row(modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = null,
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp)
                        .clickable { }
                )
                Column(modifier = Modifier
                    .height(100.dp)
                    .padding(start = 14.dp)
                    .weight(0.7f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "Kim",
                        color = Color.Black,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "kim.taeryong@kodawari-japan.co.jp",
                        color = Color.Black,
                        fontSize = 15.sp,
                        modifier = Modifier.padding(top = 14.dp)
                    )
                }
            }
            var text by rememberSaveable { mutableStateOf("") }

            TextField(value = text, onValueChange = {
                text = it
            },
                label = { Text ( text = "Searching for...")},
                trailingIcon = {
                    Box(modifier = Modifier
                        .padding(end = 6.dp)
                        .height(45.dp)
                        .width(45.dp)
                        .background(
                            color = Color(android.graphics.Color.parseColor("#fe5b52"))
                        )
                    )
                    Image(painter = painterResource(id = R.drawable.search),
                        contentDescription = null,
                        modifier = Modifier
                            .size(35.dp)
                            .padding(end=6.dp)
                    )
                },
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    focusedContainerColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedTextColor = Color(android.graphics.Color.parseColor("#5e5e5e")),
                    unfocusedContainerColor = Color.White,
                    unfocusedIndicatorColor = Color.Transparent,
                    unfocusedLabelColor = Color(android.graphics.Color.parseColor("#5e5e5e"))
                    ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp)
                    .background(Color.White, CircleShape)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp)
            ) {
                Column(
                    Modifier
                        .weight(0.5f)
                        .padding(end = 12.dp)
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(20.dp)
                        )
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .height(65.dp)
                            .width(75.dp)
                            .background(
                                color = Color(android.graphics.Color.parseColor("#7868e5")),
                                shape = RoundedCornerShape(20.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_1),
                            contentDescription = null
                        )
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp)
                            .height(40.dp)
                            .background(
                                color = Color(android.graphics.Color.parseColor("#Dad8ff")),
                                shape = RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp)
                            ), contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Messenger",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(android.graphics.Color.parseColor("#7868e5"))
                        )
                    }
                }
                Column(
                    Modifier
                        .weight(0.5f)
                        .padding(start = 12.dp)
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(20.dp)
                        )
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .height(65.dp)
                            .width(75.dp)
                            .background(
                                color = Color(android.graphics.Color.parseColor("#7868e5")),
                                shape = RoundedCornerShape(20.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_2),
                            contentDescription = null
                        )
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp)
                            .height(40.dp)
                            .background(
                                color = Color(android.graphics.Color.parseColor("#Dad8ff")),
                                shape = RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp)
                            ), contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Routing",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(android.graphics.Color.parseColor("#7868e5"))
                        )
                    }
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp)
            ) {
                Column(
                    Modifier
                        .weight(0.5f)
                        .padding(end = 12.dp)
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(20.dp)
                        )
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .height(65.dp)
                            .width(75.dp)
                            .background(
                                color = Color(android.graphics.Color.parseColor("#7868e5")),
                                shape = RoundedCornerShape(20.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_3),
                            contentDescription = null
                        )
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp)
                            .height(40.dp)
                            .background(
                                color = Color(android.graphics.Color.parseColor("#Dad8ff")),
                                shape = RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp)
                            ), contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Report",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(android.graphics.Color.parseColor("#7868e5"))
                        )
                    }
                }
                Column(
                    Modifier
                        .weight(0.5f)
                        .padding(start = 12.dp)
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(20.dp)
                        )
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .height(65.dp)
                            .width(75.dp)
                            .background(
                                color = Color(android.graphics.Color.parseColor("#7868e5")),
                                shape = RoundedCornerShape(20.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_4),
                            contentDescription = null
                        )
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp)
                            .height(40.dp)
                            .background(
                                color = Color(android.graphics.Color.parseColor("#Dad8ff")),
                                shape = RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp)
                            ), contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Inbox",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(android.graphics.Color.parseColor("#7868e5"))
                        )
                    }
                }
            }

            ConstraintLayout(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
                    .height(120.dp)
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                Color(android.graphics.Color.parseColor("#BFA3EF")),
                                Color(android.graphics.Color.parseColor("#7E57c2"))
                            )
                        ), shape = RoundedCornerShape(25.dp)
                    )
            ) {
                val (img, text1, text2) = createRefs()
                Image(
                    modifier = Modifier.constrainAs(img) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    },
                    painter = painterResource(id = R.drawable.arc),
                    contentDescription = ""
                )
                Text(text = "To Get Unlimited",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .constrainAs(text1) {
                            top.linkTo(parent.top)
                            start.linkTo(img.end)
                            end.linkTo(parent.end)
                        }
                )
                Text(text = "Upgrade Your Account",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier
                        .constrainAs(text2) {
                            top.linkTo(text1.bottom)
                            start.linkTo(text1.start)
                            end.linkTo(text1.end)
                            bottom.linkTo(parent.bottom)
                        }
                )
            }
        }
    }

    data class BottomMenuItem(val label: String, val icon: Painter)

    @Composable
    private fun prepareBottomMenu() : List<BottomMenuItem> {
        val bottomMenuItemList = arrayListOf<BottomMenuItem>()
        bottomMenuItemList.add(
            BottomMenuItem(
                label = "Home",
                icon = painterResource(id = R.drawable.bottom_btn1)
            )
        )
        bottomMenuItemList.add(
            BottomMenuItem(
                label = "Profile",
                icon = painterResource(id = R.drawable.bottom_btn2)
            )
        )
        bottomMenuItemList.add(
            BottomMenuItem(
                label = "Support",
                icon = painterResource(id = R.drawable.bottom_btn3)
            )
        )
        bottomMenuItemList.add(
            BottomMenuItem(
                label = "Settings",
                icon = painterResource(id = R.drawable.bottom_btn4)
            )
        )
        return bottomMenuItemList
    }

    @Composable
    fun MyBottomBar(){
        val bottomMenuItemList = prepareBottomMenu()
        val contextForToast= LocalContext.current.applicationContext
        var selectedItem by remember {
            mutableStateOf("Profile")
        }

        Scaffold(
            bottomBar = {
                BottomAppBar(
                    containerColor = Color.White,
                    tonalElevation = 3.dp
                ) {
                    bottomMenuItemList.forEachIndexed { index, bottomMenuItem ->
                        if (index == 2) {
                            NavigationBarItem(
                                selected = false,
                                onClick = {/*TODO*/ },
                                icon = {/*TODO*/ },
                                enabled = false
                            )
                        }

                        NavigationBarItem(
                            selected = (selectedItem == bottomMenuItem.label),
                            onClick = {
                                selectedItem = bottomMenuItem.label
                                Toast.makeText(
                                    contextForToast,
                                    bottomMenuItem.label,
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                            },
                            icon = {
                                Icon(
                                    painter = bottomMenuItem.icon,
                                    contentDescription = bottomMenuItem.label,
                                    modifier = Modifier
                                        .height(20.dp)
                                        .width(20.dp)
                                )
                            },
                            label = {
                                Text(
                                    text = bottomMenuItem.label,
                                    modifier = Modifier.padding(top = 14.dp)
                                )
                            },
                            alwaysShowLabel = true,
                            enabled = true
                        )
                    }
                }
            },
            content = {
                Row(modifier = Modifier.padding(it)) {
                    Dashboard()
                }
            }
        )
    }

    @Preview
    @Composable
    fun MyUi() {
//        val snackHostState = remember { SnackbarHostState() }

        Scaffold(
            bottomBar = { MyBottomBar() }
//            floatingActionButton = {
//                FloatingActionButton(
//                    onClick = { /*TODO*/ }, contentColor = Color.White,
//                    containerColor = Color(android.graphics.Color.parseColor("#Fe5b52"))
//                ) {
//                    Icon(
//                        painter = painterResource(id = R.drawable.shopping_cart),
//                        contentDescription = "add",
//                        modifier = Modifier
//                            .height(30.dp)
//                            .width(30.dp)
//                    )
//                }
//            },
//            snackbarHost = { SnackbarHost(snackHostState) },
//            floatingActionButtonPosition = FabPosition.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues = it),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
//                Dashboard()
            }
        }
    }
}


