package com.example.imdmarket

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)


        findViewById<Button>(R.id.btn_cadastrar).setOnClickListener {
            startActivity(Intent(this, CadastroActivity::class.java))
        }


        findViewById<Button>(R.id.btn_alterar).setOnClickListener {
            startActivity(Intent(this, AlterarActivity::class.java))
        }


        findViewById<Button>(R.id.btn_deletar).setOnClickListener {
            startActivity(Intent(this, ExcluirActivity::class.java))
        }


        findViewById<Button>(R.id.btn_listar).setOnClickListener {
            startActivity(Intent(this, ListarActivity::class.java))
        }
    }
}
