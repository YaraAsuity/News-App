package com.yara.newsapp2.reprository

import com.yara.newsapp2.api.RetrofitInstance
import com.yara.newsapp2.db.ArticleDatabase
import com.yara.newsapp2.models.Article

class NewsRepository(val db: ArticleDatabase) {


    suspend fun getHeadlines(countryCode: String , pageNumber: Int)=
        RetrofitInstance.api.getHeadlines(countryCode, pageNumber)

    suspend fun search(query:String,pageNumber:Int)=
        RetrofitInstance.api.search(query,pageNumber)


    suspend fun insertDB(article: Article)=
        db.getArticleDao().insert(article)

    suspend fun deleteArticleDB(article: Article)=
        db.getArticleDao().deleteArticle(article)
    fun getFavouritesDB()=
        db.getArticleDao().getAllArticles()




}