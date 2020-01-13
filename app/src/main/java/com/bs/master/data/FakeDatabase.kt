package com.bs.master.data

class FakeDatabase private constructor(){

    var quoteDao = FakeQuoteDao()

    companion object{
        /** Ensure a single instance but in java way*/

        @Volatile private var instance:FakeDatabase? = null
        fun getInstance() =
            instance ?: synchronized(this){
                instance ?: FakeDatabase().also { instance = it }
            }
    }


    /**
     * Purpose of Repository:
     * Single point of control / single source of truth
     *
     * Which do all of the decision making regarding data
     * like- should you fetch data from server or is it enough to use local data
     * Do we need to keep 5 days data or 3 days data is enough
     */


}