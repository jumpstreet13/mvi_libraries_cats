package com.example.mvi_examples.mvilibraries.mvvm

import android.util.Log
import androidx.lifecycle.*
import com.example.mvi_examples.mvilibraries.CatsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CatsViewModel(
    private val repository: CatsRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(CatsUiState())
    val uiState: StateFlow<CatsUiState> = _uiState.asStateFlow()

    private val _uiStateLiveIsLoading = MutableLiveData(false)
    val uiStateLiveIsLoading: LiveData<Boolean> = _uiStateLiveIsLoading

    private val _uiStateLive = MutableLiveData(CatsUiState())
    val uiStateLive: LiveData<CatsUiState> = _uiStateLive

    init {
        loadCats()
        Log.e("REQUEST IN VIEWMODEL: ", this.toString())
    }

    fun requestDogs(){

    }

    fun requestPopoog(){

    }

    private fun loadCats() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, cats = emptyList(), error = null) }
            _uiStateLive.value =
                uiStateLive.value?.copy(isLoading = true, cats = emptyList(), error = null)
            try {
                val cats = repository.loadCatsSuspend()
                _uiState.update { it.copy(cats = cats, isLoading = false) }
                /*  _uiStateLive.value = uiStateLive.value?.copy(cats = cats, isLoading = false)*/
            } catch (exception: Exception) {
                _uiState.update {
                    it.copy(
                        cats = emptyList(),
                        isLoading = false,
                        error = exception
                    )
                }
                /*   _uiStateLive.value =
                       uiStateLive.value?.copy(
                           cats = emptyList(),
                           isLoading = false,
                           error = exception
                       )*/
            }
        }
    }

    companion object {

        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.NewInstanceFactory() {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return CatsViewModel(CatsRepository()) as T
            }
        }
    }
}
