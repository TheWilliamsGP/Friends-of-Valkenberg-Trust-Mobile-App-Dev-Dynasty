package com.rosebank.st10070002.friendsofvalkenbergtrustapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment

class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fb = view.findViewById<ImageView>(R.id.btnFacebook)
        val insta = view.findViewById<ImageView>(R.id.btnInstagram)
        val yt = view.findViewById<ImageView>(R.id.btnYoutube)

        fb.setOnClickListener {
            openLink("https://www.facebook.com/FriendsofValkenberg/")
        }

        insta.setOnClickListener {
            openLink("https://www.instagram.com/friendsofvalkenberg/?hl=en")
        }

        yt.setOnClickListener {
            openLink("https://www.youtube.com/@friendsofvalkenberg9091")
        }
    }

    private fun openLink(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
}