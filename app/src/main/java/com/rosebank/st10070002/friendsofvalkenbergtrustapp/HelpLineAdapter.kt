package com.rosebank.st10070002.friendsofvalkenbergtrustapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// DATA MODEL
data class Helpline(val name: String, val desc: String, val phone: String)

class HelplineAdapter(
    private val items: List<Helpline>,
    private val onCallClick: (String) -> Unit
) : RecyclerView.Adapter<HelplineAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.tvName)
        val desc: TextView = view.findViewById(R.id.tvDescription)
        val phone: TextView = view.findViewById(R.id.tvNumber)
        val callBtn: View = view.findViewById(R.id.btnCall)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_helpline, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.name.text = item.name
        holder.desc.text = item.desc
        holder.phone.text = item.phone
        holder.callBtn.setOnClickListener { onCallClick(item.phone) }
    }

    override fun getItemCount() = items.size
}