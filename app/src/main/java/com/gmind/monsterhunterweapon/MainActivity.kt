package com.gmind.monsterhunterweapon

import android.app.Dialog
import android.media.MediaPlayer
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gmind.monsterhunterweapon.R.id.weapon

class MainActivity : AppCompatActivity() {

    internal lateinit var btn : Button
    internal lateinit var myDialog : Dialog
    internal lateinit var txt : TextView

    private lateinit var Weapon: RecyclerView
    private val list: ArrayList<Weapon> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Weapon = findViewById(weapon)
        Weapon.setHasFixedSize(true)

        list.addAll(WeaponData.listData)
        showRecyclerList()

        btn = findViewById<Button>(R.id.author)
        btn.setOnClickListener{
            ShowDialog()
        }

        mp = MediaPlayer.create(this, R.raw.open)
        mp?.setOnPreparedListener { }
    }


    fun ShowDialog(){
        myDialog = Dialog(this)
        myDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        myDialog.setContentView(R.layout.layout_popup)
        myDialog.setTitle("AUTHOR")

        txt = myDialog.findViewById(R.id.OK) as TextView
        txt.isEnabled = true
        txt.setOnClickListener{
            myDialog.cancel()
        }
        myDialog.show()
        myDialog.setCancelable(false)
    }

    private fun showRecyclerList() {
        Weapon.layoutManager = LinearLayoutManager(this)
        val listWeaponAdapter = ListWeaponAdapter(list)
        Weapon.adapter = listWeaponAdapter

        listWeaponAdapter.setOnItemClickCallback(object : ListWeaponAdapter.OnItemClickCallback {
            override fun onItemClicked(weapon: Weapon) {
                showSelectedWeapon()
            }
        })
    }

    private var mp : MediaPlayer? = null

    private fun showSelectedWeapon() {
        mp?.start()

    }

}

