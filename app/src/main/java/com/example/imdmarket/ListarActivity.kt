package com.example.imdmarket

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class ListarActivity : AppCompatActivity() {

    private lateinit var dbHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listar)

        dbHelper = DatabaseHelper(this)

        val listView = findViewById<ListView>(R.id.lvProdutos)
        val btnVoltar = findViewById<Button>(R.id.btnVoltar)


        val produtos = dbHelper.getAllProdutos()
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, produtos)
        listView.adapter = adapter


        btnVoltar.setOnClickListener {
            startActivity(Intent(this, MenuActivity::class.java))
            finish()
        }
    }
}
