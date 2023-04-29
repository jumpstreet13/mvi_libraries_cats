package com.example.mvi_examples.mvilibraries.mvvm

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvi_examples.R
import com.example.mvi_examples.mvilibraries.CatAdapter
import kotlinx.android.synthetic.main.activity_mvvm_cats.*
import kotlinx.coroutines.launch

class MvvmCatsActivity : AppCompatActivity() {

    private val viewModel: CatsViewModel by viewModels { CatsViewModel.Factory }
    private val catAdapter = CatAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvvm_cats)
        catsRecycler.adapter = catAdapter
        catsRecycler.layoutManager = LinearLayoutManager(this)
        /* lifecycleScope.launchWhenStarted {
             viewModel.uiState.collect { renderState(it) }
         }*/
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { renderState(it) }
            }
        }
        viewModel.requestDogs()
        viewModel.requestPopoog()
        /*  viewModel.uiStateLive.observe(this) {
              renderState(it)
          }*/
    }

    private fun renderState(state: CatsUiState) {
        progress.isVisible = state.isLoading
        catAdapter.submitList(state.cats)
        if (state.error != null) {
            emptyText.text = state.error.localizedMessage
            emptyText.isVisible = true
        } else {
            emptyText.text = ""
            emptyText.isVisible = false
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("MvvmCatsActivity ", "is destroyed")
    }
}