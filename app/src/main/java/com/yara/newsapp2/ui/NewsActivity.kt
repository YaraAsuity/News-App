package com.yara.newsapp2.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.yara.newsapp2.R
import com.yara.newsapp2.databinding.ActivityNewsBinding
import com.yara.newsapp2.db.ArticleDatabase
import com.yara.newsapp2.reprository.NewsRepository

class NewsActivity : AppCompatActivity() {
    lateinit var newsViewModel: NewsViewModel
    lateinit var binding: ActivityNewsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val newsRepository = NewsRepository(ArticleDatabase(this))
        val viewModelProviderFactory = NewsViewModelProviderFactory(application , newsRepository)

//        newsViewModel = ViewModelProvider(this,viewModelProviderFactory).get(NewsViewModel::class.java)
        // same as
        newsViewModel = ViewModelProvider(this,viewModelProviderFactory)[NewsViewModel::class.java]

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.newsNavHostFragment) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bottomNavigationView.setupWithNavController(navController)

    }
}