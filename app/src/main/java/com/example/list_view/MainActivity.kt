package com.example.list_view

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import com.example.list_view.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val listView = binding.listView
        var listTech = arrayListOf<String>("Web Development","App Development","Artifical Intelligence","Machine Learning","Penetration Testing","BlockChain")
        var techAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,listTech)
        listView.adapter = techAdapter
        listView.setOnItemClickListener { parent, view, position, id ->
            var techName = (view as TextView).text.toString()
            val url = "https://www.google.com/search?q=${techName.replace(" ", "+")}"
            val browserIntent =  Intent(Intent.ACTION_VIEW)
            browserIntent.data = Uri.parse(url)
            startActivity(browserIntent)
            Toast.makeText(this,"Clicked Tech :- $url",Toast.LENGTH_SHORT).show()
        }
    }
}