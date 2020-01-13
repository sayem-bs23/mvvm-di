package com.bs.master.utilites

import com.bs.master.data.FakeDatabase
import com.bs.master.data.QuoteRepository
import com.bs.master.ui.QuoteViewModelFactory

object InjectorUtils {

    fun provideQuotesViewModelFactory(): QuoteViewModelFactory{

        val quoteRepository = QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return QuoteViewModelFactory(quoteRepository)
    }
}