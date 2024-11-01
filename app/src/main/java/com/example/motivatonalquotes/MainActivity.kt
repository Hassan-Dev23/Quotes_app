package com.example.motivatonalquotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentComposer
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.example.motivatonalquotes.DataManager.currentpage
import com.example.motivatonalquotes.models.Quote
import com.example.motivatonalquotes.ui.theme.MotivatonalQuotesTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import screens.QuoteDetailScreen
import screens.quoteListScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoroutineScope(Dispatchers.IO).launch {
            DataManager.loadDataFromAssets(applicationContext)
        }
        setContent {
            MotivatonalQuotesTheme {
                App()
            }
        }
    }
}

@Composable
fun App() {
    if (DataManager.isDataLoaded.value) {
        if (currentpage.value == Pages.Listing) {
            quoteListScreen(DataManager.data) {
                DataManager.switchPages(it)
            }
        } else {
            DataManager.currentQuote?.let { QuoteDetailScreen(quote = it) }
        }

    } else {
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(
                "Loading....",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

enum class Pages {
    Listing, Detail
}