package com.android.practice


import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class CoroutineActivity : ComponentActivity() {
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }

//        val job = lifecycleScope.launch(Dispatchers.IO) {
//            repeat(5)
//            {
//                delay(1000)
//                Log.d(TAG, "Coroutine : ${Thread.currentThread().name}")
//            }
//        }
//        lifecycleScope.launch {
//            delay(2000)
//            job.cancel()
//        }

//        GlobalScope.launch {
//            launch {
//                delay(300)
//                println("scope1")
//            }
//            launch {
//                println("scope2")
//            }
//        }

        GlobalScope.launch {
            println("start")
            val a = async {
                delay(300)
                1
            }
            val b = async {
                delay(100)
                2
            }

            println("a + b = ${a.await() + b.await()}")
        }

        CoroutineScope(Dispatchers.IO).launch {
            val a = async {
                "abc"
            }
            val b = async {
                "def"
            }

            val text = a.await() + b.await()

            withContext(Dispatchers.Main) {
                println("Text : $text")
            }

        }

        suspend fun exampleSuspend() {
            withContext(Dispatchers.IO) {
                delay(1000)
            }

            withContext(Dispatchers.IO) {
                delay(1000)
            }

            withContext(Dispatchers.IO) {
                delay(1000)
            }
        }

        suspend fun test() {
            CoroutineScope(Dispatchers.IO).async {
                delay(1000)
            }

            CoroutineScope(Dispatchers.IO).async {
                delay(1000)
            }

            CoroutineScope(Dispatchers.IO).async {
                delay(1000)
            }
        }
    }

}


