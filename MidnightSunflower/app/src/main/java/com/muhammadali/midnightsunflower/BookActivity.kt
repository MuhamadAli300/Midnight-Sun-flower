package com.muhammadali.midnightsunflower

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ScrollView
import android.widget.TextView
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_book.*
import java.io.BufferedReader
import java.io.InputStreamReader

class BookActivity : AppCompatActivity() {
    @SuppressLint("CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book)

        // initialize work
        val filesNames = listOf(
            "Foreword",
            "Poems dedicated to Nature",
            "Nostalgia",
            "I have perceived so many things",
            "Poems about love",
            "Stories"
        )
        val sharedPreference = getSharedPreferences("sharedPreference", Context.MODE_PRIVATE)
        val editor = sharedPreference.edit()
        var usrCurrentSection: Int = sharedPreference.getInt("usrCurrentSection", 0)
        val tvSectionName: TextView = findViewById(R.id.tvSectionName)
        val tvBody: TextView = findViewById(R.id.tvBody)
        val btnNext: ImageButton = findViewById(R.id.btnNext)
        val btnPrevious: ImageButton = findViewById(R.id.btnPrevious)
        val scrollView: ScrollView = findViewById(R.id.svScroller)
        val nightMode: Boolean = sharedPreference.getBoolean("nightMode", false)
        val fontSize: Int = sharedPreference.getInt("fontSize", 15)

        fun disableBtnNext(){
            btnNext.apply {
                visibility = View.INVISIBLE
                isEnabled = false
            }
        }
        fun enableBtnNext(){
            btnNext.apply {
                visibility = View.VISIBLE
                isEnabled = true
            }
        }
        fun disableBtnPrevious(){
            btnPrevious.apply {
                visibility = View.INVISIBLE
                isEnabled = false
            }
        }
        fun enableBtnPrevious(){
            btnPrevious.apply {
                visibility = View.VISIBLE
                isEnabled = true
            }
        }
        fun btnCases(){
            if (usrCurrentSection !in 0..4) {
                disableBtnNext()
            }

            if (usrCurrentSection !in 1..6) {
                disableBtnPrevious()
            }
            if (usrCurrentSection in 0..4) {
                enableBtnNext()
            }
            if (usrCurrentSection in 1..6) {
                enableBtnPrevious()
            }
        }
        fun applyNightMode() {
            svScroller.setBackgroundColor(Color.BLACK)
            tvBody.setTextColor(Color.WHITE)
        }

        fun removeNightMode() {
            when (usrCurrentSection) {
                0 -> { svScroller.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.dark))
                        tvSectionName.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.dark))
                }

                1 -> { svScroller.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.dark))
                        tvSectionName.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.dark))
                }

                2 -> { svScroller.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.nostalgia))
                        tvSectionName.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.nostalgia))
                }

                3 -> { svScroller.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.i_have_perceived_so_many_things))
                    tvSectionName.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.i_have_perceived_so_many_things))
                }

                4 -> { svScroller.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.love))
                    tvSectionName.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.love))
                }

                5 -> { svScroller.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.stories))
                    tvSectionName.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.stories))
                }
            }
            tvBody.setTextColor(Color.WHITE)
        }

        fun applyFontSize(fontSize: Int) {
            tvBody.textSize = fontSize.toFloat()
        }

        fun applyAppearance(){
            if (nightMode) {
                applyNightMode()
            }
            else {
                removeNightMode()
            }
            applyFontSize(fontSize)
        }

        fun moveToSection() {
            // read file and show it in TextView
            scrollView.scrollTo(0, 0)
            tvBody.text = readFiles("${filesNames[usrCurrentSection]}.txt")
            tvSectionName.text = filesNames[usrCurrentSection]
            editor.putInt("usrCurrentSection", usrCurrentSection)
                .apply()
            applyAppearance()
        }


        moveToSection()
        btnNext.setOnClickListener {
            if (usrCurrentSection in 0..4) {
                usrCurrentSection++
                moveToSection()
            }
            btnCases()
        }

        btnPrevious.setOnClickListener {
            if (usrCurrentSection in 1..6) {
                usrCurrentSection--
                moveToSection()
            }
            btnCases()
        }

        btnCatalog.setOnClickListener {
            val intent = Intent(this, IndexActivity::class.java)
            startActivity(intent)
            finish()
        }

        btnCases()
    }

    private fun readFiles(fileName: String) : String {
        // initialize
        val reader = BufferedReader(InputStreamReader(assets.open(fileName)))
        val content = reader.readLines().joinToString("\n")
        reader.close()
        return content
    }
}