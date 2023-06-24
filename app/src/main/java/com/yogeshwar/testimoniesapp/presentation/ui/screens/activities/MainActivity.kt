package com.yogeshwar.testimoniesapp.presentation.ui.screens.activities


import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.yogeshwar.testimoniesapp.R
import com.yogeshwar.testimoniesapp.core.utils.VideoFetcher
import com.yogeshwar.testimoniesapp.data.models.response.TestimonyUrlResponse
import com.yogeshwar.testimoniesapp.databinding.ActivityMainBinding
import com.yogeshwar.testimoniesapp.presentation.ui.screens.components.adapters.TestimonyAdapter
import com.yogeshwar.testimoniesapp.presentation.ui.screens.viewmodels.TestimonyViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: TestimonyViewModel

    val videoFetcher = VideoFetcher()

    private val adapter by TestimonyAdapter.getAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this)[TestimonyViewModel::class.java]
        setUpRecyclerView()
//        setUpBinding()
        setUpViewModel()
    }

    private fun setUpViewModel() {
//        viewModel.getTestimonies()
    }

    fun setUpRecyclerView() = binding.apply {

        testimonyVideoRV.adapter = adapter

        videoFetcher.fetchVideosByCategory("UP to The 30") { videoUri, exception ->
            if (exception != null) {
                // Handle the error
                println("An error occurred: ${exception.message}")
            } else {
                // Process the video URLs

                if (!videoUri.isNullOrEmpty()) {

                    var uniqueValue = 0

                    for (url in videoUri) {
                        println(url) // or do something else with the URLs
                        adapter.submitList(
                            videoUri.map {
                                TestimonyUrlResponse(uniqueValue++, it)
                            }
                        )
                    }
                } else {
                    // No videos found for the specified category
                    println("No videos found for the specified category.")
                }
            }
        }
    }

    private fun setUpBinding() = binding.apply {

        var urlStirng = String()

        videoFetcher.fetchVideosByCategory("First Category") { videoUrls, exception ->
            if (exception != null) {
                // Handle the error
                println("An error occurred: ${exception.message}")
            } else {
                // Process the video URLs
                if (videoUrls != null && videoUrls.isNotEmpty()) {
                    for (url in videoUrls) {
//                        println(url) // or do something else with the URLs

                        val videoUri = Uri.parse(url)

                        val mediaController = MediaController(this@MainActivity)
                        mediaController.setAnchorView(theVideView)
                        theVideView.setMediaController(mediaController)
                        theVideView.setVideoURI(videoUri)
                        theVideView.requestFocus()
                        theVideView.start()
                    }
                } else {
                    // No videos found for the specified category
                    println("No videos found for the specified category.")
                }
            }
        }

    }
}