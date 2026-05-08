package com.rosebank.st10070002.friendsofvalkenbergtrustapp

import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest

object SupabaseClient {

    val client = createSupabaseClient(
        supabaseUrl = "https://nsswjevvsholhpavuzih.supabase.co",
        supabaseKey = "sb_publishable_fzeqRlqRXe1Z6C6Ign2KrQ_o1lsoPO0"
    ) {
        install(Postgrest)
    }
}