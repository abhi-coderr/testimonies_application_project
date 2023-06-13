package com.yogeshwar.testimoniesapp.domain.handlers

import com.yogeshwar.testimoniesapp.core.network_helper.Resource
import com.yogeshwar.testimoniesapp.data.models.response.TestimonyListResponse
import com.yogeshwar.testimoniesapp.data.models.response.TestimonyUrlResponse

interface FirebaseDataHandler {

    suspend fun fetchVideosByCategory(category: String, callback: (List<String>?, Exception?) -> Unit): Resource<TestimonyListResponse>

}