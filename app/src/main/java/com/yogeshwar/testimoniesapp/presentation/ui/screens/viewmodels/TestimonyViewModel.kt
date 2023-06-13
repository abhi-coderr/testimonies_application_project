package com.yogeshwar.testimoniesapp.presentation.ui.screens.viewmodels

import android.util.Log
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

    val adapter by TestimonyAdapter.getAdapter()

    fun getTestimonies() {
        viewModelScope.launch {
            val response = getTestimonyUseCase.execute("First Category") { videoUri, exception ->
                if (exception != null) {
                    // Handle the error
                    println("An error occurred: ${exception.message}")
                } else {
                    // Process the video URLs
                    var uniqueValue = 0
                    if (!videoUri.isNullOrEmpty()) {
                        for (url in videoUri) {
                            uniqueValue++
                            Log.i("abhiii->>>", url)
                            println(url) // or do something else with the URLs
                            videoUri.map { TestimonyUrlResponse(uniqueValue, url) }
                        }
                    } else {
                        // No videos found for the specified category
                        println("No videos found for the specified category.")
                    }
                }
            }

            Log.i("abhiii->>>", response.toString())

            when (response) {
                is Resource.Success -> adapter.submitList(response.data)

                is Resource.Failure -> {

                }
            }
        }
    }

}