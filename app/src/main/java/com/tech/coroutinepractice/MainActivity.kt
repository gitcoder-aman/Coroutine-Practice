package com.tech.coroutinepractice

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.tech.coroutinepractice.ui.theme.CoroutinePracticeTheme
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoroutinePracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GlobalScope.launch {
                        Log.d("TAG_COROUTINES", "onCreate: GlobalScope : ${Thread.currentThread().name}")
                    }
                    lifecycleScope.launch {
                        Log.d("TAG_COROUTINES", "onCreate: lifecycleScope: ${Thread.currentThread().name}")
                    }
                    Log.d("TAG_COROUTINES", "onCreate : ${Thread.currentThread().name}")
                }
            }
        }
    }
}
