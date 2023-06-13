package com.yogeshwar.testimoniesapp.domain.usecase

import com.yogeshwar.testimoniesapp.domain.repository.TestimonyRepository

class GetTestimonyUseCase(private val repository: TestimonyRepository) {

    suspend fun execute(category: String, callback: (List<String>?, Exception?) -> Unit) =
        repository.fetchVideosByCategory(category, callback)

}