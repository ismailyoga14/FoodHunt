package com.example.foodhunt

import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    val tvNama = findViewById<TextView>(R.id.tvNama)
    val pref = getSharedPreferences("USER", MODE_PRIVATE)
    val name = pref.getString("name", "")

    private fun getString(string: String, string2: String) {
        TODO("Not yet implemented")

        tvNama.text = "Halo $name, Welcome to FoodHunt Enjoyyy 👋"
    }
}