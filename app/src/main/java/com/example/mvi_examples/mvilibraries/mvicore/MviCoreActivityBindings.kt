package com.example.mvi_examples.mvilibraries.mvicore

import com.badoo.mvicore.android.AndroidBindings

class MviCoreActivityBindings(
    view: MviCoreActivity,
    private val feature: MviCoreFeature,
    private val newsListener: MviCoreNewsListener
) : AndroidBindings<MviCoreActivity>(view) {

    override fun setup(view: MviCoreActivity) {
        binder.bind(feature to view)
        binder.bind(feature.news to newsListener)
    }
}