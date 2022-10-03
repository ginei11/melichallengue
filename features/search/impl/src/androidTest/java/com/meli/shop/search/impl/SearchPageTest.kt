package com.meli.shop.search.impl

import androidx.compose.ui.test.assertContentDescriptionEquals
import androidx.compose.ui.test.assertIsFocused
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import com.meli.shop.designsystem.theme.MeliTheme
import com.meli.shop.domains.search.api.usecases.GetLocalSearchUC
import com.meli.shop.domains.search.api.usecases.GetRemoteSearchUC
import com.meli.shop.organism.SearchView
import com.meli.shop.search.impl.presentation.pages.SearchPage
import com.meli.shop.search.impl.presentation.viewmodels.SearchViewModel
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SearchPageTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @MockK
    lateinit var getRemoteSearchUC: GetRemoteSearchUC

    @MockK
    lateinit var getLocalSearchUC: GetLocalSearchUC

    @MockK
    lateinit var onValueChanged: (String) -> Unit

    @MockK
    lateinit var onSearch: (String) -> Unit

    @MockK
    lateinit var onProductClick: (String) -> Unit

    private lateinit var viewModel: SearchViewModel

    @Before
    fun init() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        every { onProductClick.invoke(String()) } returns Unit
        every { onValueChanged.invoke(String()) } returns Unit
        every { onSearch.invoke(String()) } returns Unit
        viewModel = SearchViewModel(getRemoteSearchUC, getLocalSearchUC)
    }


    @Test
    fun searchViewShouldHaveSearchInput() {
        composeTestRule.setContent {
            MeliTheme {
                SearchPage(
                    viewModel = viewModel,
                    onProductClick = onProductClick
                )
            }
        }
        composeTestRule
            .onNodeWithTag("search_input")
            .assertExists()
    }


    @Test
    fun searchViewWithoutPlaceholderShouldNotShow() {

        composeTestRule.setContent {
            MeliTheme {
                SearchView(onSearch = {}, onValueChanged = {})
            }
        }

        composeTestRule
            .onNodeWithTag("search_placeholder", useUnmergedTree = true)
            .assertDoesNotExist()
    }

    @Test
    fun searchViewShouldChangeValueWhenPerformInput() {

        composeTestRule.setContent {
            MeliTheme {
                SearchView(onSearch = {}, onValueChanged = {})
            }
        }

        composeTestRule
            .onNodeWithTag("search_input")
            .performClick()
            .assertIsFocused()
            .performTextInput("Text input")
        composeTestRule.waitForIdle()

    }

    @Test
    fun searchViewShouldHaveIcon() {

        composeTestRule.setContent {
            MeliTheme {
                SearchView(onSearch = {}, onValueChanged = {})
            }
        }

        composeTestRule
            .onNodeWithTag("search_icon", useUnmergedTree = true)
            .assertContentDescriptionEquals("Search")
            .assertExists()

    }
}
