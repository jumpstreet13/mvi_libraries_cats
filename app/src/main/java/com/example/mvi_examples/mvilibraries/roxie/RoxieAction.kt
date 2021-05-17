package com.example.mvi_examples.mvilibraries.roxie

import com.ww.roxie.BaseAction

sealed class RoxieAction : BaseAction {
    object LoadCats : RoxieAction()
}