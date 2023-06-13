package com.yogeshwar.testimoniesapp.data.repository.testimony.datasourceimpl

import com.yogeshwar.testimoniesapp.core.network_helper.Resource
import com.yogeshwar.testimoniesapp.data.models.response.TestimonyListResponse
import com.yogeshwar.testimoniesapp.data.models.response.TestimonyUrlResponse
import com.yogeshwar.testimoniesapp.data.repository.testimony.datasource.TestimonyRemoteDataSource
import com.yogeshwar.testimoniesapp.domain.handlers.FirebaseDataHandler

class TestimonyRemoteDataSourceImpl(
    private val firebaseDataHandler: FirebaseDataHandler
) : TestimonyRemoteDataSource {
    override suspend fun fetchVideosByCategory(
        category: String,
        callback: (List<String>?, Exception?) -> Unit
    ): Resource<TestimonyListResponse> {
        return firebaseDataHandler.fetchVideosByCategory(category, callback)
    }
}