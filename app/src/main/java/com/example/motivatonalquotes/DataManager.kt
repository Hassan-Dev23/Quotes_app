package com.example.motivatonalquotes

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import com.example.motivatonalquotes.DataManager.currentpage
import com.example.motivatonalquotes.models.Quote
import com.google.gson.Gson

object DataManager{
   internal var data = emptyArray<Quote>()
    var currentpage= mutableStateOf(Pages.Listing)
    var isDataLoaded= mutableStateOf(value = false)
    var currentQuote:Quote?=null
        fun loadDataFromAssets(
        context:Context
    ){

        val inputStream= context.assets.open(/* fileName = */ "Quotes.json")
        val size :Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer,Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(json,Array<Quote>::class.java)
        isDataLoaded.value=true
    }
    fun switchPages(quote: Quote?){
        if (currentpage.value==Pages.Listing){
            currentQuote=quote
            currentpage.value= Pages.Detail
        } else{
            currentpage.value= Pages.Listing
        }

    }
}

