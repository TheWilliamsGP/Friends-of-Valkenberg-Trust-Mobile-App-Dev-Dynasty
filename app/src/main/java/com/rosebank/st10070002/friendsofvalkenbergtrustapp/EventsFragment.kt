package com.rosebank.st10070002.friendsofvalkenbergtrustapp

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide

class EventsFragment : Fragment(R.layout.fragment_events) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageView = view.findViewById<ImageView>(R.id.eventImage)

        val imageUrl = "https://nsswjevvsholhpavuzih.supabase.co/storage/v1/object/public/event-image/events/friendlymarket.webp"

        Glide.with(this)
            .load(imageUrl)
            .into(imageView)

        val imageView1 = view.findViewById<ImageView>(R.id.eventImage1)

        val imageUrl1 = "https://nsswjevvsholhpavuzih.supabase.co/storage/v1/object/public/event-image/events/donated-2.webp"

        Glide.with(this)
            .load(imageUrl1)
            .into(imageView1)
    }
}