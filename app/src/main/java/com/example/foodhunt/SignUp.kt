package com.example.foodhunt

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2

class Signup : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup)

        val name = findViewById<EditText>(R.id.etName)
        val btnSignup = findViewById<Button>(R.id.btnSignup)

        btnSignup.setOnClickListener {

            val nameText = name.text.toString()

            if (nameText.isEmpty()) {
                name.error = "Nama wajib diisi"
                return@setOnClickListener
            }
            val pref = getSharedPreferences("USER", MODE_PRIVATE)
            val editor = pref.edit()

            editor.putString("name", nameText)
            editor.apply()

            Toast.makeText(this, "Sign Up Berhasil 🎉", Toast.LENGTH_SHORT).show()
           // startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}