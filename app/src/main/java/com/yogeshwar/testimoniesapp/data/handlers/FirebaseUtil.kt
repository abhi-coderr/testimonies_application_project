package com.yogeshwar.testimoniesapp.data.handlers

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.yogeshwar.testimoniesapp.core.network_helper.Resource
import com.yogeshwar.testimoniesapp.data.models.response.TestimonyListResponse
import com.yogeshwar.testimoniesapp.data.models.response.TestimonyUrlResponse
import com.yogeshwar.testimoniesapp.domain.handlers.FirebaseDataHandler
import kotlin.coroutines.suspendCoroutine

class FirebaseUtil : FirebaseDataHandler {

    private val database: FirebaseDatabase = FirebaseDatabase.getInstance()
    private val videoRef: DatabaseReference = database.getReference("Video")

    override suspend fun fetchVideosByCategory(
        category: String,
        callback: (List<String>?, Exception?) -> Unit
    ): Resource<TestimonyListResponse> {
        return suspendCoroutine {
            videoRef.orderByChild("testimonyCategory").equalTo(category)
                .addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        val videoUrls = mutableListOf<String>()
                        for (snapshot in dataSnapshot.children) {
                            val videoUrl =
                                snapshot.child("testimonyUrl").getValue(String::class.java)
                            videoUrl?.let {
                                videoUrls.add(it)
                            }
                        }
                        callback(videoUrls, null)
                    }

                    override fun onCancelled(databaseError: DatabaseError) {
                        // Create an exception with the error details
                        val exception = Exception(databaseError.message)
                        callback(null, exception)
                    }
                })
        }
    }

//    fun fetchVideosByCategory(category: String, callback: (List<String>?, Exception?) -> Unit) {
//        videoRef.orderByChild("testimonyCategory").equalTo(category)
//            .addListenerForSingleValueEvent(object : ValueEventListener {
//                override fun onDataChange(dataSnapshot: DataSnapshot) {
//                    val videoUrls = mutableListOf<String>()
//                    for (snapshot in dataSnapshot.children) {
//                        val videoUrl = snapshot.child("testimonyUrl").getValue(String::class.java)
//                        videoUrl?.let {
//                            videoUrls.add(it)
//                        }
//                    }
//                    callback(videoUrls, null)
//                }
//
//                override fun onCancelled(databaseError: DatabaseError) {
//                    // Create an exception with the error details
//                    val exception = Exception(databaseError.message)
//                    callback(null, exception)
//                }
//            })
//    }

}