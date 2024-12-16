package com.example.imdmarket

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AlterarActivity : AppCompatActivity() {

    private lateinit var dbHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alterar)

        dbHelper = DatabaseHelper(this)

        val etCodigo = findViewById<EditText>(R.id.etCodigoAlterar)
        val etNome = findViewById<EditText>(R.id.etNomeAlterar)
        val etDescricao = findViewById<EditText>(R.id.etDescricaoAlterar)
        val etEstoque = findViewById<EditText>(R.id.etEstoqueAlterar)
        val btnAlterar = findViewById<Button>(R.id.btnAlterarSalvar)

        btnAlterar.setOnClickListener {
            val codigo = etCodigo.text.toString().toIntOrNull()
            val nome = etNome.text.toString().ifEmpty { null }
            val descricao = etDescricao.text.toString().ifEmpty { null }
            val estoque = etEstoque.text.toString().toIntOrNull()

            if (codigo != null) {
                val success = dbHelper.updateProduto(codigo, nome, descricao, estoque)
                if (success) {
                    Toast.makeText(this, "Produto atualizado com sucesso!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Erro ao atualizar produto!", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Informe o código do produto!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
