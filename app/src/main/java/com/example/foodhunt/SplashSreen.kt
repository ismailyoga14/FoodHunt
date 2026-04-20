package com.example.foodhunt

import android.annotation.SuppressLint
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.os.Handler
import android.os.Looper

class SplashSreen : AppCompatActivity() {

    private val splashTime: Long = 3000 // 3 detik

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splashscreen)

        var mediaPlayer = MediaPlayer.create(this, R.raw.suara_foodhunt)
        mediaPlayer.start()

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, Signup::class.java)
            startActivity(intent)
            finish() // supaya tidak bisa kembali ke splash
        }, splashTime)
    }
}