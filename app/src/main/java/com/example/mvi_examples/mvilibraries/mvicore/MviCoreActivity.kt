package com.example.mvi_examples.mvilibraries.mvicore

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvi_examples.mvilibraries.Cat
import com.example.mvi_examples.mvilibraries.CatAdapter
import com.abocha.mvilibraries.mvicore.MviCoreWish
import com.example.mvi_examples.R
import io.reactivex.functions.Consumer
import kotlinx.android.synthetic.main.activity_experimental.*

class MviCoreActivity : AppCompatActivity(), Consumer<MviCoreState> {

    private val catAdapter = CatAdapter()
    private val feature = MviCoreFeature()
    private val activityBindings = MviCoreActivityBindings(
        view = this,
        feature = feature,
        newsListener = MviCoreNewsListener(this)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_experimental)
        recycler.adapter = catAdapter
        recycler.layoutManager = LinearLayoutManager(this)
        activityBindings.setup(this)
        title = "MviCore"
        if (savedInstanceState == null) {
            feature.accept((MviCoreWish.LoadCats))
        }
    }

    override fun accept(state: MviCoreState) {
        with(state) {
            when {
                isLoading -> renderLoadingState()
                else -> renderNotesState(cats)
            }
        }
    }

    private fun renderLoadingState() {
        progress.visibility = View.VISIBLE
    }

    private fun renderNotesState(cats: List<Cat>?) {
        progress.visibility = View.GONE
        if (cats != null) {
            emptyText.visibility = View.GONE
            catAdapter.submitList(cats)
            recycler.visibility = View.VISIBLE
        } else {
            emptyText.visibility = View.VISIBLE
            emptyText.text = getString(R.string.empty_text)
            recycler.visibility = View.INVISIBLE
        }
    }
}