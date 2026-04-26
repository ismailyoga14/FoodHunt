package com.example.foodhunt

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class SigninActivity : AppCompatActivity() {

    private lateinit var etEmail: TextInputEditText
    private lateinit var etPassword: TextInputEditText
    private lateinit var btnSignIn: MaterialButton
    private lateinit var tvSignUp: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        // 🔗 Hubungkan XML
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        btnSignIn = findViewById(R.id.btnSignIn)
        tvSignUp = findViewById(R.id.tvSignUp)

        // 🚀 Klik SIGN IN
        btnSignIn.setOnClickListener {

            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            // ✅ Validasi
            if (email.isEmpty()) {
                etEmail.error = "Email tidak boleh kosong"
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                etPassword.error = "Password tidak boleh kosong"
                return@setOnClickListener
            }

            // 🔐 Ambil data dari SharedPreferences
            val sharedPref = getSharedPreferences("user", MODE_PRIVATE)
            val savedEmail = sharedPref.getString("email", null)

            // 🎯 Cek login sederhana
            if (email == savedEmail) {

                Toast.makeText(this, "Login berhasil!", Toast.LENGTH_SHORT).show()

                // 👉 pindah ke MAIN PAGE
                startActivity(Intent(this, MainActivity::class.java))
                finish()

            } else {
                Toast.makeText(this, "Email tidak ditemukan!", Toast.LENGTH_SHORT).show()
            }
        }

        // 🔁 ke Signup
        tvSignUp.setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
            finish()
        }
        btnSignIn.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}