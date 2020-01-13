package com.bs.master.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import com.bs.master.R
import com.bs.master.data.Quote
import com.bs.master.utilites.InjectorUtils
import kotlinx.android.synthetic.main.activity_main.*

class QuoteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUI()
    }

    private fun initUI() {
        val factory = InjectorUtils.provideQuotesViewModelFactory()
        val viewModel =
            ViewModelProviders.of(this, factory).get(QuotesViewModel::class.java)

        viewModel.getQuotes().observe(this, Observer {
            val stringBuilder = StringBuilder()
            it.forEach { quote->
                stringBuilder.append("$quote\n\n")
            }

            textView_quote.text = stringBuilder.toString()
        })

        button_add_quote.setOnClickListener{
            val quote = Quote(editText_quote.text.toString(), editText_author.text.toString())
            viewModel.addQuote(quote)
            editText_author.setText("")
            editText_quote.setText("")
        }
    }
}
