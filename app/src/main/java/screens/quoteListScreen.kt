package screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.motivatonalquotes.models.Quote

@Composable
fun quoteListScreen(data:Array<Quote>,onClick:(quote:Quote)-> Unit ) {

    Column {
        Text(text = "Motivational Quotes",
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 35.sp,
            textDecoration = TextDecoration.Underline,
            modifier = Modifier.fillMaxWidth().padding(8.dp,24.dp)
        )
        QuoteList(data,onClick)
    }
}