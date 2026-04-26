package com.example.foodhunt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class OnboardingAdapter(
    private val list: List<OnboardingItem>
) : RecyclerView.Adapter<OnboardingAdapter.ViewHolder>() {

    // ViewHolder: menghubungkan XML dengan Kotlin
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image = view.findViewById<ImageView>(R.id.imageSlide)
        val title = view.findViewById<TextView>(R.id.titleSlide)
        val desc = view.findViewById<TextView>(R.id.descSlide)
    }

    // Menghubungkan adapter ke layout XML
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_onboarding, parent, false)
        return ViewHolder(view)
    }

    // Jumlah slide
    override fun getItemCount(): Int = list.size

    // Mengisi data ke tiap slide
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.image.setImageResource(item.image)
        holder.title.text = item.title
        holder.desc.text = item.desc
    }
}