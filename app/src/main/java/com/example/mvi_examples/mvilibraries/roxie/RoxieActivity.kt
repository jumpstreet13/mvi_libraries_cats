package com.example.mvi_examples.mvilibraries.roxie

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvi_examples.R
import com.example.mvi_examples.mvilibraries.Cat
import com.example.mvi_examples.mvilibraries.CatAdapter
import com.example.mvi_examples.mvilibraries.CatsRepository
import kotlinx.android.synthetic.main.activity_experimental.*

class RoxieActivity : AppCompatActivity() {

    private val catAdapter = CatAdapter()
    private lateinit var viewModel: RoxieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_experimental)
        recycler.adapter = catAdapter
        recycler.layoutManager = LinearLayoutManager(this)
        title = "Roxie"

        viewModel = ViewModelProvider(this, RoxieViewModelFactory(null, CatsRepository()))[RoxieViewModel::class.java]

        viewModel.observableState.observe(this, Observer { state ->
            renderState(state)
        })

        viewModel.dispatch(RoxieAction.LoadCats)
        //viewModel.dispatch(RoxieAction.LoadDogsAndCats)
    }

    private fun renderState(state: RoxieState) {
        with(state) {
            when {
                isLoading -> renderLoadingState()
                isLoadError && state.error != null -> renderErrorState(state.error)
                else -> renderNotesState(cats)
            }
        }
    }

    private fun renderLoadingState() {
        progress.visibility = View.VISIBLE
    }

    private fun renderErrorState(throwable: Throwable) {
        progress.visibility = View.GONE
        Toast.makeText(this, throwable.localizedMessage, Toast.LENGTH_LONG).show()
    }

    private fun renderNotesState(cats: List<Cat>) {
        progress.visibility = View.GONE
        catAdapter.submitList(cats)
        recycler.visibility = View.VISIBLE
    }
}