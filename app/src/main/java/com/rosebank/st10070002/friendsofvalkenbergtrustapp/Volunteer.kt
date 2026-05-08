package com.rosebank.st10070002.friendsofvalkenbergtrustapp

import kotlinx.serialization.Serializable

@Serializable
data class Volunteer(

    val volunteerid: String? = null,

    val volunteerfname: String,

    val volunteersname: String,

    val volunteerpno: String? = null,

    val volunteeremail: String? = null,

    val volunteerpassword: String? = null
)