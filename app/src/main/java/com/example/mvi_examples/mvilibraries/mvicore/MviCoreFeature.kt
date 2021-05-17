package com.example.mvi_examples.mvilibraries.mvicore

import com.abocha.mvilibraries.mvicore.*
import com.badoo.mvicore.feature.ActorReducerFeature

class MviCoreFeature : ActorReducerFeature<MviCoreWish, MviCoreEffect, MviCoreState, MviCoreNews>(
    initialState = MviCoreState(),
    actor = MviCoreActor(),
    reducer = MviCoreReducerImpl(),
    newsPublisher = MviCoreNewsPublisher()
)