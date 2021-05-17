package com.example.mvi_examples.mvilibraries.mvicore

import com.abocha.mvilibraries.mvicore.MviCoreWish
import com.badoo.mvicore.element.Bootstrapper
import io.reactivex.Observable
import io.reactivex.Observable.just

class MviCoreBootStrapperImpl : Bootstrapper<MviCoreWish> {
    override fun invoke(): Observable<MviCoreWish> = just(MviCoreWish.LoadCats)
}