package screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.motivatonalquotes.models.Quote


@Composable
fun QuoteListItem(quote:Quote,onClick: (quote:Quote)-> Unit) {
    OutlinedCard(
        modifier = Modifier
            .padding(8.dp)
            .clickable { onClick(quote) }
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(10.dp),


    ){
        Row(modifier = Modifier.padding(10.dp)) {
            Image(
                imageVector = Icons.Filled.FavoriteBorder,
                contentDescription = "Heart Icon",
                colorFilter = ColorFilter.tint(Color(0xFFD7D7D7)),
                alignment = Alignment.TopStart,
                modifier = Modifier
                    .padding(0.dp, 0.dp, 0.dp, 10.dp)
                    .background(color = Color.Black, RoundedCornerShape(3.dp))
                    .size(30.dp)
            )

            Spacer(modifier = Modifier.width(10.dp))
            Column(modifier = Modifier.weight(1f)) {


                Text(text = quote.quote,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp))

                Box(
                    Modifier
                        .fillMaxWidth(.4f)
                        .background(color = Color.Black)
                        .size(1.dp))
                Text(text = quote.author,Modifier.padding(top = 5.dp))
            }

        }
    }
}


