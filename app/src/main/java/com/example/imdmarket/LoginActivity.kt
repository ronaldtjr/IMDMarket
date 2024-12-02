package com.example.imdmarket

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        val etLogin = findViewById<EditText>(R.id.etLogin)
        val etSenha = findViewById<EditText>(R.id.etSenha)
        val btnEntrar = findViewById<Button>(R.id.btnEntrar)
        val tvEsqueciSenha = findViewById<TextView>(R.id.tvEsqueciSenha)


        btnEntrar.setOnClickListener {
            val login = etLogin.text.toString()
            val senha = etSenha.text.toString()

            if (login.isNotEmpty() && senha.isNotEmpty()) {
                Log.d("LoginActivity", "Login: $login | Senha: $senha")
                Toast.makeText(this, "Bem-vindo, $login!", Toast.LENGTH_SHORT).show()


                val intent = Intent(this, MenuActivity::class.java)
                startActivity(intent)
            } else {

                Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show()
            }
        }


        tvEsqueciSenha.setOnClickListener {
            Toast.makeText(this, "Funcionalidade ainda não implementada!", Toast.LENGTH_SHORT).show()

        }
    }
}

