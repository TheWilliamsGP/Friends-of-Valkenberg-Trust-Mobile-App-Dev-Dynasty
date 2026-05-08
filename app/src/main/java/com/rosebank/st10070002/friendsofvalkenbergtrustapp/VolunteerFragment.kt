package com.rosebank.st10070002.friendsofvalkenbergtrustapp

import android.os.Bundle
import android.view.View
import android.view.LayoutInflater
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import io.github.jan.supabase.postgrest.from
import kotlinx.coroutines.launch

class VolunteerFragment : Fragment(R.layout.fragment_volunteer) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // =========================
        // UI REFERENCES
        // =========================

        val container = view.findViewById<LinearLayout>(R.id.vol_list_container)

        val formContainer = view.findViewById<LinearLayout>(R.id.vol_form_container)

        val becomeBtn = view.findViewById<Button>(R.id.btn_become_volunteer)
        val addBtn = view.findViewById<Button>(R.id.btn_add_volunteer)

        val fnameInput = view.findViewById<EditText>(R.id.input_fname)
        val snameInput = view.findViewById<EditText>(R.id.input_sname)
        val emailInput = view.findViewById<EditText>(R.id.input_email)
        val phoneInput = view.findViewById<EditText>(R.id.input_phone)

        // =========================
        // LOAD VOLUNTEERS ON START
        // =========================
        loadVolunteers(container)

        // =========================
        // SHOW FORM WHEN BUTTON CLICKED
        // =========================
        becomeBtn.setOnClickListener {

            // Toggle visibility (show form)
            if (formContainer.visibility == View.GONE) {
                formContainer.visibility = View.VISIBLE
            }
        }

        // =========================
        // ADD VOLUNTEER TO SUPABASE
        // =========================
        addBtn.setOnClickListener {

            val volunteer = Volunteer(
                volunteerfname = fnameInput.text.toString().trim(),
                volunteersname = snameInput.text.toString().trim(),
                volunteeremail = emailInput.text.toString().trim(),
                volunteerpno = phoneInput.text.toString().trim()
            )

            lifecycleScope.launch {
                try {

                    // Insert into Supabase table
                    SupabaseClient.client
                        .from("volunteertable")
                        .insert(volunteer)

                    Toast.makeText(
                        requireContext(),
                        "Volunteer Added Successfully",
                        Toast.LENGTH_SHORT
                    ).show()

                    // =========================
                    // CLEAR FORM AFTER SUBMIT
                    // =========================
                    fnameInput.text.clear()
                    snameInput.text.clear()
                    emailInput.text.clear()
                    phoneInput.text.clear()

                    // Hide form again after submission (clean UX)
                    formContainer.visibility = View.GONE

                    // Reload list
                    loadVolunteers(container)

                } catch (e: Exception) {

                    Toast.makeText(
                        requireContext(),
                        e.message,
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }

    // =========================
    // LOAD VOLUNTEERS FROM SUPABASE
    // =========================
    private fun loadVolunteers(container: LinearLayout) {

        lifecycleScope.launch {

            try {

                val volunteers = SupabaseClient.client
                    .from("volunteertable")
                    .select()
                    .decodeList<Volunteer>()

                container.removeAllViews()

                val inflater = LayoutInflater.from(requireContext())

                // Create a card for each volunteer
                volunteers.forEach { v ->

                    val card = inflater.inflate(
                        R.layout.vol_card,
                        container,
                        false
                    )

                    val nameText =
                        card.findViewById<TextView>(R.id.volunteer_name)

                    // Display full name
                    nameText.text =
                        "${v.volunteerfname} ${v.volunteersname}"

                    // Click card shows details
                    card.setOnClickListener {

                        Toast.makeText(
                            requireContext(),
                            "Email: ${v.volunteeremail}\nPhone: ${v.volunteerpno}",
                            Toast.LENGTH_LONG
                        ).show()
                    }

                    container.addView(card)
                }

            } catch (e: Exception) {

                Toast.makeText(
                    requireContext(),
                    e.message,
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}