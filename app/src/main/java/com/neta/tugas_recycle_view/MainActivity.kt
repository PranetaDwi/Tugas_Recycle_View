package com.neta.tugas_recycle_view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.neta.tugas_recycle_view.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapterHero = HeroAdapter(generateDummy()){ hero ->
            Toast.makeText(
                this@MainActivity, "${hero.heroTitle}", Toast.LENGTH_LONG
            ).show()
        }

        with(binding){
            rvHero.apply {
                adapter = adapterHero
                layoutManager = GridLayoutManager(this@MainActivity, 1)
            }
        }
    }

    private fun generateDummy() : List<Hero>{
        return listOf(
            Hero(heroImage = R.drawable.soekarno, heroTitle = "Ir.Soekarno", heroContent = "Indonesian statesman, orator, revolutionary, and nationalist who was the first president of Indonesia, serving from 1945 to 1967"),
            Hero(heroImage = R.drawable.hatta, heroTitle = "Muhammad Hatta", heroContent = "Indonesian statesman, nationalist, and independence activist who served as the country's first vice president. Known as The Proclamator"),
            Hero(heroImage = R.drawable.kartini, heroTitle = "R.A. Kartini", heroContent = "Prominent Indonesian activist who advocated for women's rights and female education."),
            Hero(heroImage = R.drawable.tiahahu, heroTitle = "Marta Christina Tiahahu", heroContent = "Moluccan freedom fighter and National Heroine of Indonesia. Born to a military captain. Joined the war led by Pattimura against the Dutch colonial government"),
        )
    }
}