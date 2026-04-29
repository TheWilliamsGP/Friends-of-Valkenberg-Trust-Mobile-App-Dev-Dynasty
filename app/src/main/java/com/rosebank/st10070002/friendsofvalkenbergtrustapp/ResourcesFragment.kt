package com.rosebank.st10070002.friendsofvalkenbergtrustapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.rosebank.st10070002.friendsofvalkenbergtrustapp.databinding.FragmentResourcesBinding

class ResourcesFragment : Fragment() {

    // These lines fix the "Return type mismatch" and "File.root" errors
    private var _binding: FragmentResourcesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResourcesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val helplineList = listOf(
            Helpline("Suicide Crises Helpline", "24-Hour Emergency", "0800 567 567"),
            Helpline("Substance Abuse Support", "DSD Support Line", "0800 12 13 14"),
            Helpline("Dr Reddy’s Mental Health", "8AM-8PM Toll-Free", "0800 21 22 23"),
            Helpline("Adcock Ingram Support", "Depression & Anxiety", "0800 70 80 90"),
            Helpline("SADAG Office", "Office Inquiries", "011 234 4837"),
            Helpline("Cipla Chat Line", "WhatsApp (8AM-5PM)", "076 882 2775"),
            Helpline("Healthcare Workers", "Care Network Line", "0800 21 21 21"),
            Helpline("ADHD Helpline", "SADAG Support", "0800 55 44 33"),
            Helpline("NPOwer Support", "NPO Help Line", "0800 515 515"),
            Helpline("Police and Trauma", "Pharma Dynamics", "0800 20 50 26")
        )

        // Fixes "rvHelplines" reference
        binding.rvHelplines.layoutManager = LinearLayoutManager(requireContext())
        binding.rvHelplines.adapter = HelplineAdapter(helplineList) { phone ->
            // Fixes "toUri" warning
            val intent = Intent(Intent.ACTION_DIAL, "tel:$phone".toUri())
            startActivity(intent)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}