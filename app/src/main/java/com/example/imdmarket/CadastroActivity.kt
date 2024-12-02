package com.example.imdmarket

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        findViewById<Button>(R.id.btnSalvar).setOnClickListener {
            Toast.makeText(this, "Produto salvo!", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, MenuActivity::class.java))
        }
    }
}
