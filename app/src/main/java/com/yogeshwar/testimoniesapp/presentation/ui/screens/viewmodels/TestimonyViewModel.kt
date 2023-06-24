package com.yogeshwar.testimoniesapp.presentation.ui.screens.viewmodels

import android.net.Uri
import android.util.Log
import android.widget.MediaController
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yogeshwar.testimoniesapp.core.network_helper.Resource
import com.yogeshwar.testimoniesapp.core.utils.Event
import com.yogeshwar.testimoniesapp.data.models.response.TestimonyUrlResponse
import com.yogeshwar.testimoniesapp.domain.usecase.GetTestimonyUseCase
import com.yogeshwar.testimoniesapp.presentation.ui.screens.components.adapters.TestimonyAdapter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TestimonyViewModel @Inject constructor(
    private val getTestimonyUseCase: GetTestimonyUseCase
) : ViewModel() {

//    val adapter by TestimonyAdapter.getAdapter(onVideoView = {})

//    fun getTestimonies() {
//        viewModelScope.launch {
//          getTestimonyUseCase.execute("First Category") { videoUri, exception ->
//                if (exception != null) {
//                    // Handle the error
//                    println("An error occurred: ${exception.message}")
//                } else {
//                    // Process the video URLs
//
//                    if (!videoUri.isNullOrEmpty()) {
//
//                        var uniqueValue = 0
//
//                        for (url in videoUri) {
//                            println(url) // or do something else with the URLs
//                            adapter.submitList(
//                                videoUri.map {
//                                    TestimonyUrlResponse(uniqueValue++, it)
//                                }
//                            )
//                        }
//                    } else {
//                        // No videos found for the specified category
//                        println("No videos found for the specified category.")
//                    }
//                }
//            }
//        }
//    }

}