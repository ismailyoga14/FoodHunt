package com.example.foodhunt

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import kotlin.jvm.java

class SignupActivity : AppCompatActivity() {

    private lateinit var etName: TextInputEditText
    private lateinit var etEmail: TextInputEditText
    private lateinit var etPassword: TextInputEditText
    private lateinit var etConfirmPassword: TextInputEditText
    private lateinit var btnSignUp: MaterialButton
    private lateinit var tvSignIn: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup)

        // 🔗 Hubungkan ke XML
        etName = findViewById(R.id.etName)
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        etConfirmPassword = findViewById(R.id.etConfirmPassword)
        btnSignUp = findViewById(R.id.btnSignUp)
        tvSignIn = findViewById(R.id.tvSignIn)

        // 🚀 Klik tombol SIGN UP
        btnSignUp.setOnClickListener {

            val name = etName.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()
            val confirmPassword = etConfirmPassword.text.toString().trim()

            // ✅ Validasi
            if (name.isEmpty()) {
                etName.error = "Nama tidak boleh kosong"
                return@setOnClickListener
            }

            if (email.isEmpty()) {
                etEmail.error = "Email tidak boleh kosong"
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                etPassword.error = "Password tidak boleh kosong"
                return@setOnClickListener
            }

            if (password != confirmPassword) {
                etConfirmPassword.error = "Password tidak sama"
                return@setOnClickListener
            }

            // 🎉 Berhasil daftar (sementara)
            Toast.makeText(this, "Akun berhasil dibuat!", Toast.LENGTH_SHORT).show()

            // 👉 pindah ke Sign In
            startActivity(Intent(this, SigninActivity::class.java))
            finish()
        }

        // 🔁 Pindah ke Sign In
        tvSignIn.setOnClickListener {
            startActivity(Intent(this, SigninActivity::class.java))
            finish()
        }
    }
}