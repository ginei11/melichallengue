package com.meli.shop.search.impl.presentation.pages

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.meli.shop.designsystem.atoms.DSLoader
import com.meli.shop.domains.search.api.models.SearchUIStates
import com.meli.shop.organism.SearchView
import com.meli.shop.search.impl.R
import com.meli.shop.search.impl.presentation.viewmodels.SearchViewModel
import com.meli.shop.search.impl.presentation.widgets.NoResultsView
import com.meli.shop.search.impl.presentation.widgets.ProductListScreen
import com.meli.shop.search.impl.presentation.widgets.RecentSearchScreen
import com.meli.shop.search.impl.presentation.widgets.SearchInfoAlertView

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun SearchPage(
    viewModel: SearchViewModel = hiltViewModel(),
    onProductClick: (productId: String) -> Unit
) {

    val keyboardController = LocalSoftwareKeyboardController.current
    val action by viewModel.action.collectAsState()
    val recentSearch by viewModel.recentSearches.collectAsState()

    Scaffold(
        topBar = {
            Column {
                val modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 20.dp)
                SearchView(
                    modifier = modifier
                        .fillMaxWidth(),
                    placeholder = stringResource(R.string.search_place_holder),
                    onValueChanged = {
                        viewModel.loadRecentSearch(it)
                    }
                ) {
                    keyboardController?.hide()
                    viewModel.search(it)
                }

                recentSearch.takeIf { it.isNotEmpty() }?.let { list ->
                    RecentSearchScreen(
                        modifier = modifier,
                        list = list,
                    ) {
                        keyboardController?.hide()
                        viewModel.search(it)
                    }
                }
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            when (action) {
                is SearchUIStates.Loading -> DSLoader(modifier = Modifier.align(Alignment.Center))
                is SearchUIStates.Error -> NoResultsView(modifier = Modifier.align(Alignment.Center))
                is SearchUIStates.Success -> {
                    ProductListScreen(
                        modifier = Modifier.fillMaxSize(),
                        products = (action as SearchUIStates.Success).items,
                        onProductClick = onProductClick
                    )
                }
                is SearchUIStates.DataZero -> {
                    SearchInfoAlertView(modifier = Modifier.align(Alignment.Center))
                }
            }
        }
    }
}
