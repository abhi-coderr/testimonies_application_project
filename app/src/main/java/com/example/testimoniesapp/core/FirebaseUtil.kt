package com.example.testimoniesapp.core

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class FirebaseUtil {

    private val database: FirebaseDatabase = FirebaseDatabase.getInstance()
    private val videoRef: DatabaseReference = database.getReference("videos")

    fun fetchVideosByCategory(category: String, callback: (List<String>) -> Unit) {
        videoRef.orderByChild("testimonyCategory").equalTo(category)
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    val videoUrls = mutableListOf<String>()
                    for (snapshot in dataSnapshot.children) {
                        val videoUrl = snapshot.child("url").getValue(String::class.java)
                        videoUrl?.let {
                            videoUrls.add(it)
                        }
                    }
                    callback(videoUrls)
                }

                override fun onCancelled(databaseError: DatabaseError) {
                    // Handle error if needed
                }
            })
    }

}