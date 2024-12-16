package com.example.imdmarket

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CadastroActivity : AppCompatActivity() {

    private lateinit var dbHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        dbHelper = DatabaseHelper(this)

        val etCodigo = findViewById<EditText>(R.id.etCodigo)
        val etNome = findViewById<EditText>(R.id.etNome)
        val etDescricao = findViewById<EditText>(R.id.etDescricao)
        val etEstoque = findViewById<EditText>(R.id.etEstoque)
        val btnSalvar = findViewById<Button>(R.id.btnSalvar)

        btnSalvar.setOnClickListener {
            val codigo = etCodigo.text.toString().toIntOrNull()
            val nome = etNome.text.toString()
            val descricao = etDescricao.text.toString()
            val estoque = etEstoque.text.toString().toIntOrNull()

            if (codigo != null && estoque != null) {
                val success = dbHelper.addProduto(codigo, nome, descricao, estoque)
                if (success) {
                    Toast.makeText(this, "Produto cadastrado com sucesso!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Erro ao cadastrar produto!", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Preencha todos os campos obrigatórios!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
