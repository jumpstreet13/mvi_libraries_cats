package com.example.mvi_examples.mvilibraries.mvicore

import com.badoo.mvicore.feature.ActorReducerFeature

class MviCoreFeature : ActorReducerFeature<MviCoreWish, MviCoreEffect, MviCoreState, MviCoreNews>(
    initialState = MviCoreState(),
    actor = MviCoreActor(),
    reducer = MviCoreReducerImpl(),
    newsPublisher = MviCoreNewsPublisher()
)







































/*
class View: Consumer<ViewModel> {

    private val button: Button = ...

    // Specify the fields to observe and actions to execute
    private val watcher = modelWatcher<ViewModel> {
        watch(ViewModel::buttonText) {
            button.text = it
        }
        watch(ViewModel::buttonAction, diff = byRef()) {
            button.setOnClickListener { it() }
        }
    }

    override fun accept(model) {
        // Pass the model
        watcher.invoke(model)
    }
}*/
