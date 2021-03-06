package com.novoda.movies.mvi.search.api

import com.novoda.movies.mvi.search.SearchResults
import io.reactivex.Single

internal class SearchBackend(
    private val searchApi: SearchApi,
    private val searchConverter: ApiSearchResultsConverter
) {

    fun search(query: String): Single<SearchResults> {
        return searchApi
            .search(query)
            .map(searchConverter::convert)
    }
}
