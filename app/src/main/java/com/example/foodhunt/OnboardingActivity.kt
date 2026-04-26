package com.example.foodhunt

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlin.jvm.java

class OnboardingActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var btnNext: Button
    private lateinit var tvSkip: TextView
    private lateinit var tabIndicator: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        // Hubungkan ke XML
        viewPager = findViewById(R.id.viewPager)
        btnNext = findViewById(R.id.btnNext)
        tvSkip = findViewById(R.id.tvSkip)
        tabIndicator = findViewById(R.id.tabIndicator)

        val list = listOf(
            OnboardingItem(
                R.drawable.slide1,
                "Temukan Makanan Favoritmu",
                "Cari makanan sesuai selera dan mood kamu"
            ),
            OnboardingItem(
                R.drawable.slide2,
                "Makanan Viral",
                "Temukan makanan yang sedang trending"
            ),
            OnboardingItem(
                R.drawable.slide3,
                "Tempat Terdekat",
                "Arahkan ke lokasi makanan viral di sekitarmu"
            )
        )
        val adapter = OnboardingAdapter(list)
        viewPager.adapter = adapter

        TabLayoutMediator(tabIndicator, viewPager) { _, _ -> }.attach()

        btnNext.setOnClickListener {
            if (viewPager.currentItem < list.size - 1) {
                viewPager.currentItem += 1
            } else {
                startActivity(Intent(this, SignupActivity::class.java))
                finish()
            }
        }
        tvSkip.setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
            finish()
        }
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {

                // Ubah text button
                btnNext.text = if (position == list.size - 1) "Get Started!" else "Next ->"

                // Hide skip di slide terakhir
                tvSkip.visibility = if (position == list.size - 1) View.GONE else View.VISIBLE
            }
        })
        viewPager.setPageTransformer { page, position ->
            page.alpha = 0.25f + (1 - kotlin.math.abs(position))
            page.scaleY = 0.85f + (1 - kotlin.math.abs(position)) * 0.15f
        }
    }
}