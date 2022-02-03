package com.jayant.cpcalendar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import android.widget.TextView
import com.airbnb.lottie.LottieAnimationView

class SplashActivity : AppCompatActivity() {
    lateinit var appName : TextView
    lateinit var welcomeAnimation : LottieAnimationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        supportActionBar?.hide()

//        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

//        window.setFlags(
//            WindowManager.LayoutParams.FLAG_FULLSCREEN,
//            WindowManager.LayoutParams.FLAG_FULLSCREEN
//        )

        appName = findViewById(R.id.app_name)
        welcomeAnimation = findViewById(R.id.welcome_animation)

        appName.animate().translationY(-1400f).setDuration(2700).startDelay = 0
        welcomeAnimation.animate().translationX(2000f).setDuration(2000).startDelay = 2900

        // we used the postDelayed(Runnable, time) method
        // to send a message with a delayed time.
        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 4500)


    }
}