package com.bs.master.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData


/**
 * Purpose:
 *
 * To mimick the persistant data like Room library
 *
 */
class FakeQuoteDao {
    private val quoteList = mutableListOf<Quote>()
    private val quotes = MutableLiveData<List<Quote>>() /** Once we have repository, we will observe this through repository */


    init {
        quotes.value = quoteList /** immediately observe */
    }

    fun addQuote(quote:Quote){
        quoteList.add(quote)
        quotes.value = quoteList
    }

    fun getQuotes()  = quotes as LiveData<List<Quote>>

}