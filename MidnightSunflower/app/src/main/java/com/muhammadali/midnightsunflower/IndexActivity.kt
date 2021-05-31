package com.muhammadali.midnightsunflower

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_index.*

class IndexActivity : AppCompatActivity(), View.OnClickListener {
    @SuppressLint("CommitPrefEdits")
    private lateinit var sharedPreference: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor
    @SuppressLint("CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_index)

        sharedPreference = getSharedPreferences("sharedPreference", Context.MODE_PRIVATE)
        editor = sharedPreference.edit()
        // initialize work
        var nightMode: Boolean = sharedPreference.getBoolean("nightMode", false)
        var fontSize: Int = sharedPreference.getInt("fontSize", 15)


        @SuppressLint("ResourceAsColor")
        fun applyNightMode() {
            tvForeword.setTextColor(Color.BLACK)
            conForeword.setBackgroundColor(Color.WHITE)

            tvPoemsDedicatedToNature.setTextColor(Color.BLACK)
            conPoemsDedicatedToNature.setBackgroundColor(Color.WHITE)

            conBackground.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.dark))

            editor.putBoolean("nightMode", true)
                .apply()
            nightMode = true
        }

        fun removeNightMode() {
            tvForeword.setTextColor(Color.WHITE)
            conForeword.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.dark))

            tvPoemsDedicatedToNature.setTextColor(Color.WHITE)
            conPoemsDedicatedToNature.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.dark))

            conBackground.setBackgroundColor(Color.WHITE)

            editor.putBoolean("nightMode", false)
                .apply()
            nightMode = false
        }

        fun applyFontSize(fontSize: Int) {
            editor.putInt("fontSize", fontSize)
                .apply()
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

        // change appearance
        applyAppearance()

        // catalog onClickListener
        tvForeword.setOnClickListener(this)
        conForeword.setOnClickListener(this)

        tvPoemsDedicatedToNature.setOnClickListener(this)
        conPoemsDedicatedToNature.setOnClickListener(this)

        tvNostalgia.setOnClickListener(this)
        conNostalgia.setOnClickListener(this)

        tvIHavePerceivedSoManyThings.setOnClickListener(this)
        conIHavePerceivedSoManyThings.setOnClickListener(this)

        tvPoemsAboutLove.setOnClickListener(this)
        conPoemsAboutLove.setOnClickListener(this)

        tvStories.setOnClickListener(this)
        conStories.setOnClickListener(this)

        // change appearance to saved data
        if (nightMode) {
            cbNightMode.isChecked = true
        }
        when (fontSize) {
            15 -> rbSize15.isChecked = true
            20 -> rbsize20.isChecked = true
            25 -> rbSize25.isChecked = true
        }

        // nightMode Activate
        cbNightMode.setOnClickListener {
            if (cbNightMode.isChecked) {
                editor.putBoolean("nightMode", true)
                    .apply()
                nightMode = true
                applyAppearance()
            }
            else{
                editor.putBoolean("nightMode", true)
                    .apply()
                nightMode = false
                applyAppearance()
            }
        }

        // font size Change
        rbGroub.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.rbSize15 -> {
                    fontSize = 15
                    applyFontSize(15)
                }
                R.id.rbsize20 -> {
                    fontSize = 20
                    applyFontSize(20)
                }
                R.id.rbSize25 -> {
                    fontSize = 25
                    applyFontSize(25)
                }
            }
            applyAppearance()
        }

        tvAbout.setOnClickListener {
            val intent = Intent(this@IndexActivity, AboutActivity::class.java )
            startActivity(intent)
            finish()
        }

        tvBackToBook.setOnClickListener {
            val intent = Intent(this@IndexActivity, BookActivity::class.java )
            startActivity(intent)
            finish()
        }
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when(v.id) {
                R.id.tvForeword -> {
                    editor.putInt("usrCurrentSection", 0)
                        .apply()
                    val intent = Intent(this@IndexActivity, BookActivity::class.java)
                    startActivity(intent)
                    finish()
                }

                R.id.conForeword -> {
                    editor.putInt("usrCurrentSection", 0)
                        .apply()
                    val intent = Intent(this@IndexActivity, BookActivity::class.java)
                    startActivity(intent)
                    finish()
                }

                R.id.tvPoemsDedicatedToNature -> {
                    editor.putInt("usrCurrentSection", 1)
                        .apply()
                    val intent = Intent(this@IndexActivity, BookActivity::class.java)
                    startActivity(intent)
                    finish()
                }

                R.id.conPoemsDedicatedToNature -> {
                    editor.putInt("usrCurrentSection", 1)
                        .apply()
                    val intent = Intent(this@IndexActivity, BookActivity::class.java)
                    startActivity(intent)
                    finish()
                }

                R.id.tvNostalgia -> {
                    editor.putInt("usrCurrentSection", 2)
                        .apply()
                    val intent = Intent(this@IndexActivity, BookActivity::class.java)
                    startActivity(intent)
                    finish()
                }

                R.id.conNostalgia-> {
                    editor.putInt("usrCurrentSection", 2)
                        .apply()
                    val intent = Intent(this@IndexActivity, BookActivity::class.java)
                    startActivity(intent)
                    finish()
                }

                R.id.tvIHavePerceivedSoManyThings -> {
                    editor.putInt("usrCurrentSection", 3)
                        .apply()
                    val intent = Intent(this@IndexActivity, BookActivity::class.java)
                    startActivity(intent)
                    finish()
                }

                R.id.conIHavePerceivedSoManyThings -> {
                    editor.putInt("usrCurrentSection", 3)
                        .apply()
                    val intent = Intent(this@IndexActivity, BookActivity::class.java)
                    startActivity(intent)
                    finish()
                }

                R.id.tvPoemsAboutLove -> {
                    editor.putInt("usrCurrentSection", 4)
                        .apply()
                    val intent = Intent(this@IndexActivity, BookActivity::class.java)
                    startActivity(intent)
                    finish()
                }

                R.id.conPoemsAboutLove -> {
                    editor.putInt("usrCurrentSection",4)
                        .apply()
                    val intent = Intent(this@IndexActivity, BookActivity::class.java)
                    startActivity(intent)
                    finish()
                }

                R.id.tvStories -> {
                    editor.putInt("usrCurrentSection",5)
                        .apply()
                    val intent = Intent(this@IndexActivity, BookActivity::class.java)
                    startActivity(intent)
                    finish()
                }

                R.id.conStories -> {
                    editor.putInt("usrCurrentSection", 5)
                        .apply()
                    val intent = Intent(this@IndexActivity, BookActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        }
    }
}