package com.gmind.monsterhunterweapon

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailActivity : AppCompatActivity() {
    companion object{
        const val NAMA = "extra_name"
        const val DETAIL = "extra_detail"
        const val PHOTO = "extra_photo"
    }

   override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_detail)
       val weapon_photo = intent.getIntExtra(PHOTO, 0)
       val layoutweapon : ImageView = findViewById(R.id.detail_img)
       Glide.with(this)
           .load(weapon_photo)
           .apply(RequestOptions().override(500, 500))
           .into(layoutweapon)
       val dataDiterima = findViewById<TextView>(R.id.detail_name)
       val tulisan1 = intent.getStringExtra(NAMA)
       dataDiterima.text = tulisan1

       val dataDiterima1 = findViewById<TextView>(R.id.detail_desc)
       val tulisan2 = intent.getStringExtra(DETAIL)
       dataDiterima1.text = tulisan2

       val actionBar = supportActionBar
       if (actionBar != null) {
           actionBar.setDisplayHomeAsUpEnabled(true)
       }

       mp = MediaPlayer.create(this, R.raw.open)
       mp?.setOnPreparedListener { }
   }

    private var mp : MediaPlayer? = null

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        mp?.start()
        return true
    }
}
