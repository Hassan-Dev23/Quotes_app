package screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.motivatonalquotes.DataManager
import com.example.motivatonalquotes.models.Quote


@Composable
fun QuoteDetailScreen(quote: Quote) {
    BackHandler { DataManager.switchPages(null) }
    Box(
        modifier = Modifier
            .fillMaxSize(1f)
            .background(
                Brush.sweepGradient(
                    listOf(Color.Black, Color.White)
                )
            ),
        contentAlignment = Alignment.Center,
        ) {

        OutlinedCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {

            Column(Modifier.padding(20.dp)) {

                Image(
                    imageVector = Icons.Filled.FavoriteBorder,
                    contentDescription = "Heart Icon",
                    colorFilter = ColorFilter.tint(Color(0xFFD7D7D7)),
                    alignment = Alignment.TopStart,
                    modifier = Modifier
                        .background(color = Color.Black, RoundedCornerShape(3.dp))
                        .size(100.dp)
                )
                Spacer(Modifier.padding(10.dp))
                Text(
                    text = quote.quote,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(Modifier.padding(10.dp))

                Text(text = quote.author, fontSize = 20.sp)
            }
        }
    }
}

