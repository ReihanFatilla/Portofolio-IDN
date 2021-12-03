package com.reihan.portofolio

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.reihan.portofolio.databinding.ItemExperienceBinding

class RVExperienceAdapter: RecyclerView.Adapter<RVExperienceAdapter.ExperienceViewHolder>() {

    private val listData = ArrayList<Portofolio>()
    var onItemClicked: ((Portofolio) -> Unit)? = null

    fun setData(newsList : List<Portofolio>?) {
        if (newsList == null) return
        listData.clear()
        listData.addAll(newsList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ExperienceViewHolder = ExperienceViewHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.item_experience, parent, false)
    )

    override fun onBindViewHolder(holder: ExperienceViewHolder, position: Int) {
        val listData: Portofolio = listData [position]
        holder.bind(listData)
    }

    override fun getItemCount(): Int = listData.size

    inner class ExperienceViewHolder(itemViews: View) : RecyclerView.ViewHolder(itemViews) {
        private val binding = ItemExperienceBinding.bind(itemViews)

        fun bind(data: Portofolio){

            binding.experience = data
            binding.executePendingBindings()

        }

        init {
            binding.root.setOnClickListener{
                onItemClicked?.invoke(listData[adapterPosition])
            }
        }

    }

}