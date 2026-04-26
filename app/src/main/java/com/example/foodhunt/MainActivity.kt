package com.example.foodhunt

import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var container: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        container = findViewById(R.id.containerList)

        tambahItem("Burger King", "⭐ 4.6 • 0.8 km", "Jl. Malioboro", R.drawable.burger)
        tambahItem("Ayam Geprek", "⭐ 4.4 • 1.2 km", "Jl. Kaliurang", R.drawable.ayam)
        tambahItem("Boba Time", "⭐ 4.7 • 0.5 km", "Jl. Seturan", R.drawable.boba)
    }

    private fun tambahItem(nama: String, rating: String, alamat: String, gambar: Int) {
        val view = layoutInflater.inflate(R.layout.item_tempat, null)

        val img = view.findViewById<ImageView>(R.id.imgTempat)
        val tvNama = view.findViewById<TextView>(R.id.tvNama)
        val tvRating = view.findViewById<TextView>(R.id.tvRating)
        val tvAlamat = view.findViewById<TextView>(R.id.tvAlamat)

        img.setImageResource(gambar)
        tvNama.text = nama
        tvRating.text = rating
        tvAlamat.text = alamat

        container.addView(view)
    }
}