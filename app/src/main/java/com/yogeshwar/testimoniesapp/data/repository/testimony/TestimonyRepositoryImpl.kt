package com.yogeshwar.testimoniesapp.data.repository.testimony

import com.yogeshwar.testimoniesapp.core.network_helper.Resource
import com.yogeshwar.testimoniesapp.data.models.response.TestimonyListResponse
import com.yogeshwar.testimoniesapp.data.models.response.TestimonyUrlResponse
import com.yogeshwar.testimoniesapp.data.repository.testimony.datasource.TestimonyRemoteDataSource
import com.yogeshwar.testimoniesapp.domain.repository.TestimonyRepository

class TestimonyRepositoryImpl(
    private val testimonyRemoteDataSource: TestimonyRemoteDataSource
) : TestimonyRepository {

    override suspend fun fetchVideosByCategory(
        category: String,
        callback: (List<String>?, Exception?) -> Unit
    ): Resource<TestimonyListResponse> {
        return testimonyRemoteDataSource.fetchVideosByCategory(category, callback)
    }

}