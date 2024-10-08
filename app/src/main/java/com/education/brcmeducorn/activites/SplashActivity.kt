package com.education.brcmeducorn.activites

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import android.widget.TextView
<<<<<<< HEAD:app/src/main/java/com/education/brcmeducorn/SplashActivity.kt
import com.google.android.material.color.utilities.MaterialDynamicColors.background
=======
import com.education.brcmeducorn.R
>>>>>>> da2eb7dd8e1413e1a3b646cc909de43a4b874f37:app/src/main/java/com/education/brcmeducorn/activites/SplashActivity.kt

class SplashActivity : AppCompatActivity() {
    lateinit var imgUpper:ImageView
    lateinit var imglower:ImageView
    lateinit var background:ImageView
    private val textToDisplay = "BRCM Educorn"
    private val handler = Handler(Looper.getMainLooper())
    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        val splashText = findViewById<TextView>(R.id.autoText)
        splashText.text = ""

        // Delay before starting auto text generation
        handler.postDelayed({
            splashText.visibility = TextView.VISIBLE
            generateAutoText(splashText)
        }, 1000) // You can adjust the delay as needed

        background = findViewById(R.id.background)
        imglower = findViewById(R.id.imgLower)
        imgUpper = findViewById(R.id.imgUpper)
        background.alpha = 0.25f

    }

    private fun generateAutoText(textView: TextView) {
        if (currentIndex < textToDisplay.length) {
            val currentText = textToDisplay.substring(0, currentIndex + 1)
            textView.text = currentText
            currentIndex++

            // login_main_utils the delay and speed of text generation
            handler.postDelayed({ generateAutoText(textView) }, 100)
        } else {
            val intent  = Intent(this@SplashActivity, LoginMainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}