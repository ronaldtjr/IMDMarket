package com.example.imdmarket

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ExcluirActivity : AppCompatActivity() {

    private lateinit var dbHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_excluir)

        dbHelper = DatabaseHelper(this)

        val etCodigo = findViewById<EditText>(R.id.etCodigoExcluir)
        val btnExcluir = findViewById<Button>(R.id.btnExcluir)

        btnExcluir.setOnClickListener {
            val codigo = etCodigo.text.toString().toIntOrNull()
            if (codigo != null) {
                val success = dbHelper.deleteProduto(codigo)
                if (success) {
                    Toast.makeText(this, "Produto excluído com sucesso!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Erro ao excluir produto!", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Informe o código do produto!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
