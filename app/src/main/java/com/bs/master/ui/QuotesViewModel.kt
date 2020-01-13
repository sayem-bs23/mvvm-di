package com.bs.master.ui

import androidx.lifecycle.ViewModel
import com.bs.master.data.Quote
import com.bs.master.data.QuoteRepository

class QuotesViewModel(private val quoteRepository: QuoteRepository)
    : ViewModel(){

    fun getQuotes() = quoteRepository.getQuotes()

    fun addQuote(quote: Quote) = quoteRepository.addQuote(quote)
}


/**
 * Purpose of ViewModelFactory
 *
 * You cannot create viewmodel directly
 */