package com.example.mvi_examples.mvilibraries.mosby

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvi_examples.mvilibraries.CatAdapter
import com.example.mvi_examples.R
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_experimental.*

class MosbyActivity : AppCompatActivity(), MosbyView {

    private val catAdapter = CatAdapter()
    private val presenter = MosbyPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_experimental)
        recycler.adapter = catAdapter
        recycler.layoutManager = LinearLayoutManager(this)
        title = "Mosby"
    }

    override fun loadCatsIntent(): Observable<Boolean> {
        return Observable.just(true)
    }

    override fun render(viewState: MosbyViewState) {
        catAdapter.submitList(viewState.catList)
        if (viewState.isLoading) {
            progress.visibility = View.VISIBLE
        } else {
            progress.visibility = View.GONE
        }
        if (viewState.error != null) {
            Toast.makeText(this, viewState.error.localizedMessage, Toast.LENGTH_LONG).show()
        }
    }

    override fun onResume() {
        super.onResume()
        presenter.attachView(this)
    }

    override fun onPause() {
        super.onPause()
        presenter.detachView()
    }
}
