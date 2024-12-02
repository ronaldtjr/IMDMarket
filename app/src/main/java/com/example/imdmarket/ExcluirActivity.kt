package com.example.imdmarket

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ExcluirActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_excluir)

        findViewById<Button>(R.id.btnExcluir).setOnClickListener {
            Toast.makeText(this, "Produto excluído com sucesso!", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, MenuActivity::class.java))
        }
    }
}
