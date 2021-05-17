package com.example.mvi_examples.mvilibraries.mvicore

import com.abocha.mvilibraries.mvicore.MviCoreWish
import com.badoo.mvicore.element.NewsPublisher

class MviCoreNewsPublisher : NewsPublisher<MviCoreWish, MviCoreEffect, MviCoreState, MviCoreNews> {

    override fun invoke(
        action: MviCoreWish,
        effect: MviCoreEffect,
        state: MviCoreState
    ): MviCoreNews? {
        return when (effect) {
            is MviCoreEffect.ErrorLoading -> MviCoreNews.ErrorExecutingRequest(effect.throwable)
            else -> null
        }
    }
}