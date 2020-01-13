package com.bs.master.data

class QuoteRepository (private val quoteDao: FakeQuoteDao){

    fun addQuote(quote: Quote){
        quoteDao.addQuote(quote)
    }

    fun getQuotes() = quoteDao.getQuotes()


    companion object {
        @Volatile
        var instance: QuoteRepository? = null

        fun getInstance(quoteDao: FakeQuoteDao) =
            instance ?: synchronized(this) {
                instance ?: QuoteRepository(quoteDao).also { instance = it }
            }
    }
}