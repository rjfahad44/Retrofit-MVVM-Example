package com.ft.retrofit_mvvm_example.ui

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ft.retrofit_mvvm_example.adapter.MovieAdapter
import com.ft.retrofit_mvvm_example.databinding.ActivityMainBinding
import com.ft.retrofit_mvvm_example.viewmodel.MovieViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MovieViewModel
    private lateinit var movieAdapter : MovieAdapter
    private lateinit var progressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initialize()
    }

    private fun initialize() {
        movieAdapter = MovieAdapter()
        binding.rvMovies.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = movieAdapter
        }

        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Please wait")
        progressDialog.setMessage("Loading...")
        progressDialog.show()
        viewModel = ViewModelProvider(this)[MovieViewModel::class.java]
        viewModel.getPopularMovies()
        viewModel.movieLiveData.observe(this){ movieList ->
            progressDialog.dismiss()
            movieAdapter.setMovieList(movieList)
        }
    }
}