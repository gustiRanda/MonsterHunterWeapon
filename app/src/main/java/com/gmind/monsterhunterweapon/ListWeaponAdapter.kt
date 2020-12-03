package com.gmind.monsterhunterweapon

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListWeaponAdapter(private val listWeapon: ArrayList<Weapon>) : RecyclerView.Adapter<ListWeaponAdapter.ListViewHolder>() {

    inner class ListViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.wp_name)
        var tvDetail: TextView = itemView.findViewById(R.id.wp_detail)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_wp_photo)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.list_weapon, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listWeapon.size
    }

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val weapon = listWeapon[position]
        Glide.with(holder.itemView.context)
            .load(weapon.photo)
            .apply(RequestOptions().override(200, 200))
            .into(holder.imgPhoto)
        holder.tvName.text = weapon.name
        holder.tvDetail.text = weapon.detail
        holder.itemView.setOnClickListener(object: View.OnClickListener {
            override fun onClick (view: View){
                onItemClickCallback.onItemClicked(listWeapon[holder.adapterPosition])
                val detailhalaman = Intent(view.context.applicationContext, DetailActivity::class.java)

                detailhalaman.putExtra(DetailActivity.NAMA, weapon.name)
                detailhalaman.putExtra(DetailActivity.DETAIL, weapon.detail)
                detailhalaman.putExtra(DetailActivity.PHOTO, weapon.photo)
                view.context.startActivity(detailhalaman)
            }
        })
    }


    interface OnItemClickCallback{
        fun onItemClicked(weapon: Weapon)
    }
}

