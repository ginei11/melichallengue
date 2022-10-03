package com.meli.shop.search.impl.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.meli.shop.domains.search.api.models.SearchUIStates
import com.meli.shop.domains.search.api.usecases.GetLocalSearchUC
import com.meli.shop.domains.search.api.usecases.GetRemoteSearchUC
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val getRemoteSearchUC: GetRemoteSearchUC,
    private val getLocalSearchUC: GetLocalSearchUC
) : ViewModel() {

    private val _recentSearches = MutableStateFlow<List<String>>(emptyList())
    val recentSearches: StateFlow<List<String>> = _recentSearches

    private val _action = MutableStateFlow<SearchUIStates>(SearchUIStates.DataZero)
    val action: StateFlow<SearchUIStates> = _action

    fun search(value: String) {
        _recentSearches.value = emptyList()
        viewModelScope.launch {
            getRemoteSearchUC(value).collect {
                _action.value = it
            }
        }
    }

    fun loadRecentSearch(value: String) {
        if (value.isNotEmpty()) {
            viewModelScope.launch {
                getLocalSearchUC(value).collect {
                    _recentSearches.value = it

                }
            }
        } else {
            _recentSearches.value = emptyList()
        }
    }
}
