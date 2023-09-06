package com.example.nortaltesttask.ui.movieCategories

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.nortaltesttask.data.models.Film
import com.example.nortaltesttask.data.models.MovieCategory
import com.example.nortaltesttask.ui.movieCategories.adapter.CategoryAdapter
import com.example.nortaltesttask.ui.movieCategories.adapter.FilmsAdapter
import com.example.nortaltesttask.ui.utils.HorizontalMarginItemDecoration
import com.example.nortaltesttask.NortalProjectApplication
import com.example.nortaltesttask.R
import kotlinx.android.synthetic.main.fragment_movies_list.*
import kotlinx.android.synthetic.main.search_widget.*
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.util.*

class MoviesListFragment : Fragment(R.layout.fragment_movies_list) {

    private lateinit var viewModel: MoviesListViewModel

    private lateinit var filmsAdapter: FilmsAdapter
    private lateinit var viewPager: ViewPager2

    private val viewPagerListener = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            updateMoviesList(viewModel.categoriesListState.value.movieCategories[position].films)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val appContainer = (requireActivity().application as NortalProjectApplication).appContainer
        viewModel = MoviesListViewModel(appContainer.categoriesUseCase)

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                observeCategoriesListUiState(viewModel.categoriesListState)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViewPager()
        initRecyclerView()
        setListeners()
    }

    override fun onResume() {
        super.onResume()

        viewPager.registerOnPageChangeCallback(viewPagerListener)
    }

    override fun onPause() {
        super.onPause()

        viewPager.unregisterOnPageChangeCallback(viewPagerListener)
    }

    private fun observeCategoriesListUiState(uiState: StateFlow<MovieCategoriesUiState>) {
        uiState.map { it.movieCategories }
            .distinctUntilChanged()
            .onEach(::updateCategoriesList)
            .launchIn(viewLifecycleOwner.lifecycleScope)

        uiState.map { it.filteredList }
            .distinctUntilChanged()
            .onEach(::showFilteredFilms)
            .launchIn(viewLifecycleOwner.lifecycleScope)
    }

    private fun updateCategoriesList(list: List<MovieCategory>) {
        val adapter = CategoryAdapter()
        adapter.submitList(list)
        viewPager.adapter = adapter
    }

    private fun showFilteredFilms(list: List<Film>) {
        filmsAdapter.submitList(list)
    }

    private fun initViewPager() {
        with(categoriesList) {
            viewPager = this
            offscreenPageLimit = 1

            val nextItemVisiblePx = resources.getDimension(R.dimen.viewPagerNextItemVisible)
            val currentItemHorizontalMarginPx =
                resources.getDimension(R.dimen.viewPagerCurrentItemHorizontalMargin)
            val pageTranslationX = nextItemVisiblePx + currentItemHorizontalMarginPx
            val pageTransformer = ViewPager2.PageTransformer { page: View, position: Float ->
                page.translationX = -pageTranslationX * position
            }
            viewPager.setPageTransformer(pageTransformer)

            val itemDecoration = HorizontalMarginItemDecoration(
                requireContext(), R.dimen.viewPagerCurrentItemHorizontalMargin
            )

            addItemDecoration(itemDecoration)
        }
    }

    private fun initRecyclerView() {
        with(filmsList) {
            adapter = getFilmsAdapter()
            addItemDecoration(getItemDecoration())
        }
    }

    private fun getFilmsAdapter(): FilmsAdapter {
        return FilmsAdapter().also {
            filmsAdapter = it
        }
    }

    private fun getItemDecoration(): RecyclerView.ItemDecoration {
        return DividerItemDecoration(
            requireContext(),
            DividerItemDecoration.VERTICAL
        ).apply {
            setDrawable(
                checkNotNull(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.list_divider
                    )
                )
            )
        }
    }

    private fun setListeners() {
        searchEditText.doOnTextChanged { text, _, _, _ ->
            val query = text.toString().lowercase(Locale.getDefault())
            viewModel.search(query)
        }
    }

    private fun updateMoviesList(list: List<Film>) {
        viewModel.updateNonFilterableFilmList(list)
        filmsAdapter.submitList(list)
    }
}