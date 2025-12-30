package com.greedygame.brokenandroidcomposeproject.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.greedygame.brokenandroidcomposeproject.data.Article
import com.greedygame.brokenandroidcomposeproject.data.BrokenRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onErrorResume
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MyViewModel: ViewModel() {

    private val _articles = MutableStateFlow<List<Article>>(emptyList())
    val article = _articles.asStateFlow()

    private val _loading = MutableStateFlow(false)
    val loading = _loading.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error = _error.asStateFlow()

    private val _selectedArticle = MutableStateFlow<Article?>(null)
    val selectedArticle = _selectedArticle

    fun setSelectedArticle(article: Article) {
        _selectedArticle.value = article
    }

    init {
        fetchNews()
    }

    fun fetchNews(){
        viewModelScope.launch {
            _loading.value = true
            _error.value = null

            try {
                val result = withContext(Dispatchers.IO) {
                    BrokenRepository.fetchArticlesBlocking()
                }
                _articles.value = result
            } catch (e: Exception){
                _error.value = "${e.message}"
            } finally {
                _loading.value = false
            }
        }
    }

}