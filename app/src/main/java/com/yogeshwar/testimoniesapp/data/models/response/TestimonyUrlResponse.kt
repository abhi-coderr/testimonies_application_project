package com.yogeshwar.testimoniesapp.data.models.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class TestimonyListResponse : ArrayList<TestimonyUrlResponse>(), Parcelable

@Parcelize
data class TestimonyUrlResponse(

    val id: Int,
    val testimonyUrl: String

) : Parcelable
