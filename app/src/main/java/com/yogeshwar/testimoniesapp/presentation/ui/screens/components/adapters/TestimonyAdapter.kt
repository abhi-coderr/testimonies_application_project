package com.yogeshwar.testimoniesapp.presentation.ui.screens.components.adapters

import android.content.Context
import android.net.Uri
import android.view.View
import android.widget.MediaController
import com.yogeshwar.testimoniesapp.R
import com.yogeshwar.testimoniesapp.core.custom_views.CustomAdapter
import com.yogeshwar.testimoniesapp.data.models.response.TestimonyUrlResponse
import com.yogeshwar.testimoniesapp.databinding.TestimonyItemLayoutBinding

object TestimonyAdapter {

    fun getAdapter() = lazy {
        CustomAdapter<TestimonyUrlResponse, TestimonyItemLayoutBinding>(
            layoutResource = R.layout.testimony_item_layout,
            onBind = { binding, item, _ ->
                binding.apply {

                    val videoUri = Uri.parse(item.testimonyUrl)

                    val mediaController = MediaController(root.context)
                    mediaController.setAnchorView(testimonyVideoView)
                    testimonyVideoView.setMediaController(mediaController)
                    testimonyVideoView.setVideoURI(videoUri)
                    testimonyVideoView.requestFocus()
                    testimonyVideoView.pause()

                }
            },
            isSameItems = { oldItem, newItem -> oldItem.id == newItem.id },
            isSameItemContent = { oldItem, newItem -> oldItem == newItem },
            deepCopy = { item -> item.copy() }
        )
    }


}