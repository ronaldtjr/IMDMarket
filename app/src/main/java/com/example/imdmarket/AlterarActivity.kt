package com.example.imdmarket

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AlterarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alterar)

        findViewById<Button>(R.id.btnAlterarSalvar).setOnClickListener {
            Toast.makeText(this, "Produto alterado com sucesso!", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, MenuActivity::class.java))
        }
    }
}
