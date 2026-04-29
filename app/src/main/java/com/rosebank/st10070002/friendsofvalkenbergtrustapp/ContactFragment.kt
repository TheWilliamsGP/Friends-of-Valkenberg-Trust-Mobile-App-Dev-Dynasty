package com.rosebank.st10070002.friendsofvalkenbergtrustapp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.rosebank.st10070002.friendsofvalkenbergtrustapp.databinding.FragmentContactBinding

class ContactFragment : Fragment(R.layout.fragment_contact) {

    private var _binding: FragmentContactBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentContactBinding.bind(view)

        val teamList = listOf(
            TeamMember("Soraya Soloman", "Director", R.drawable.soraya_1),
            TeamMember("Gail Henry", "Events Manager", R.drawable.gail2_4),
            TeamMember("Ridaa Manie", "Office Manager", R.drawable.ridaa2),
            TeamMember("Grisel Pretorius", "Project Manager", R.drawable.grisel_4),
            TeamMember("Elaine Smith", "Friendly Shop Manager", R.drawable.elaine2)
        )

        binding.rvTeam.layoutManager = LinearLayoutManager(requireContext())
        binding.rvTeam.adapter = TeamAdapter(teamList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}