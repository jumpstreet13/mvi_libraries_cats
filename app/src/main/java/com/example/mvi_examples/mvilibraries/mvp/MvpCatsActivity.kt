package com.example.mvi_examples.mvilibraries.mvp

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvi_examples.R
import com.example.mvi_examples.mvilibraries.Cat
import com.example.mvi_examples.mvilibraries.CatAdapter
import com.example.mvi_examples.mvilibraries.CatsRepository
import com.example.mvi_examples.mvilibraries.mvvm.CatsPresenter
import com.example.mvi_examples.mvilibraries.mvvm.MyView
import kotlinx.android.synthetic.main.activity_mvvm_cats.*
import kotlinx.coroutines.launch

class MvpCatsActivity : AppCompatActivity(), MyView {

    private val presenter: CatsPresenter = CatsPresenter(CatsRepository())
    private val catAdapter = CatAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvvm_cats)
        catsRecycler.adapter = catAdapter
        catsRecycler.layoutManager = LinearLayoutManager(this)
        presenter.attach(this)
        lifecycleScope.launch {
            presenter.loadCats()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("MvvmCatsActivity ", "is destroyed")
    }

    override fun showProgress() {
        progress.isVisible = true
    }

    override fun hideProgress() {
        progress.isVisible = false
    }

    override fun showError() {
        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
    }

    override fun showResults(cats: List<Cat>) {
        catAdapter.submitList(cats)
    }
}