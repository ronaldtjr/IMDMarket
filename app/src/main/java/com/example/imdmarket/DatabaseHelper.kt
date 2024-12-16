package com.example.imdmarket

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "IMDMarket.db"
        private const val DATABASE_VERSION = 1


        const val TABLE_PRODUTOS = "Produtos"
        const val COL_CODIGO = "codigo"
        const val COL_NOME = "nome"
        const val COL_DESCRICAO = "descricao"
        const val COL_ESTOQUE = "estoque"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTable = ("CREATE TABLE $TABLE_PRODUTOS ("
                + "$COL_CODIGO INTEGER PRIMARY KEY, "
                + "$COL_NOME TEXT, "
                + "$COL_DESCRICAO TEXT, "
                + "$COL_ESTOQUE INTEGER)")
        db.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_PRODUTOS")
        onCreate(db)
    }


    fun addProduto(codigo: Int, nome: String, descricao: String, estoque: Int): Boolean {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COL_CODIGO, codigo)
        values.put(COL_NOME, nome)
        values.put(COL_DESCRICAO, descricao)
        values.put(COL_ESTOQUE, estoque)
        val result = db.insert(TABLE_PRODUTOS, null, values)
        db.close()
        return result != -1L
    }


    fun getAllProdutos(): List<String> {
        val produtos = mutableListOf<String>()
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM $TABLE_PRODUTOS", null)
        if (cursor.moveToFirst()) {
            do {
                val produto = "Código: ${cursor.getInt(0)}, Nome: ${cursor.getString(1)}, Estoque: ${cursor.getInt(3)}"
                produtos.add(produto)
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return produtos
    }


    fun updateProduto(codigo: Int, nome: String?, descricao: String?, estoque: Int?): Boolean {
        val db = this.writableDatabase
        val values = ContentValues()
        if (nome != null) values.put(COL_NOME, nome)
        if (descricao != null) values.put(COL_DESCRICAO, descricao)
        if (estoque != null) values.put(COL_ESTOQUE, estoque)

        val result = db.update(TABLE_PRODUTOS, values, "$COL_CODIGO=?", arrayOf(codigo.toString()))
        db.close()
        return result > 0
    }


    fun deleteProduto(codigo: Int): Boolean {
        val db = this.writableDatabase
        val result = db.delete(TABLE_PRODUTOS, "$COL_CODIGO=?", arrayOf(codigo.toString()))
        db.close()
        return result > 0
    }
}
