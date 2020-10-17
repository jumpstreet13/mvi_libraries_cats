package com.abocha.mvilibraries.mvicore

import com.badoo.mvicore.feature.ActorReducerFeature

class MviCoreFeature : ActorReducerFeature<MviCoreWish, MviCoreEffect, MviCoreState, MviCoreNews>(
    initialState = MviCoreState(),
    actor = MviCoreActor(),
    reducer = MviCoreReducerImpl(),
    newsPublisher = MviCoreNewsPublisher()
)