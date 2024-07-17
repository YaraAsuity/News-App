package com.yara.newsapp2.models

import com.yara.newsapp2.models.Article

data class NewsResponse(
    val articles: MutableList<Article>,
    val status: String,
    val totalResults: Int
)