package com.example.mvi_examples.mvilibraries.mvicore

import android.content.Context
import android.widget.Toast
import io.reactivex.functions.Consumer

class MviCoreNewsListener(
    private val context: Context
) : Consumer<MviCoreNews> {

    override fun accept(news: MviCoreNews) {
        when (news) {
            is MviCoreNews.ErrorExecutingRequest -> errorHappened(news.throwable)
        }
    }

    private fun errorHappened(throwable: Throwable) {
        Toast.makeText(
            context,
            throwable.localizedMessage,
            Toast.LENGTH_SHORT
        ).show()
    }
}
