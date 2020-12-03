package com.gmind.monsterhunterweapon

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        img_splash.alpha = 0f
        img_splash.animate().setDuration(1500).alpha(1f).withEndAction{
            val splash = Intent(this, MainActivity::class.java)
            startActivity(splash)
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
            finish()
        }
    }
}
