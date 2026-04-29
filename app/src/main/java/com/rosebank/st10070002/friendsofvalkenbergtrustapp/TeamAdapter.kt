package com.rosebank.st10070002.friendsofvalkenbergtrustapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

// KEEP THIS HERE
data class TeamMember(val name: String, val role: String, val imageRes: Int)

class TeamAdapter(private val teamList: List<TeamMember>) :
    RecyclerView.Adapter<TeamAdapter.TeamViewHolder>() {

    class TeamViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivMember: ShapeableImageView = view.findViewById(R.id.ivMember)
        val tvName: TextView = view.findViewById(R.id.tvMemberName)
        val tvRole: TextView = view.findViewById(R.id.tvMemberRole)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_team, parent, false)
        return TeamViewHolder(view)
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        val member = teamList[position]
        holder.tvName.text = member.name
        holder.tvRole.text = member.role
        holder.ivMember.setImageResource(member.imageRes)
    }

    override fun getItemCount(): Int = teamList.size
}