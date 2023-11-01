package com.neta.tugas_recycle_view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.neta.tugas_recycle_view.databinding.ItemHeroBinding

typealias onClickHero = (Hero) -> Unit

class HeroAdapter (private val listHero: List<Hero>, private val
onClickHero: onClickHero): RecyclerView.Adapter<HeroAdapter.ItemHeroViewHolder>(){
    inner class ItemHeroViewHolder(private val binding: ItemHeroBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind (data:Hero){
            with(binding){
                txtImageHero.setImageResource(data.heroImage)
                txtNameHero.text = data.heroTitle
                txtContentHero.text = data.heroContent
                itemView.setOnClickListener{
                    onClickHero(data)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHeroViewHolder {
        val binding = ItemHeroBinding.inflate(LayoutInflater.from(
            parent.context), parent, false
        )
        return ItemHeroViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemHeroViewHolder, position: Int) {
        holder.bind(listHero[position])
    }

    override fun getItemCount(): Int = listHero.size

}