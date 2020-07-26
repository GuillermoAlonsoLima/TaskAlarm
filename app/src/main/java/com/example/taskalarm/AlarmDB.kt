package com.example.taskalarm

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

import android.database.sqlite.SQLiteOpenHelper


class AlarmDB(val context: Context?) :
    SQLiteOpenHelper(context, NOME_BANCO, null, VERSAO) {
    override fun onCreate(db: SQLiteDatabase) {
        val sql = ("CREATE TABLE " + TABELA_ALARM + "("
                + ID + " integer primary key autoincrement,"
                + TITULO + " text,"
                + DESCRICAO + " text,"
                + SILENCIO + " boolean,"
                + DOMINGO + " boolean,"
                + SEGUNDA + " boolean,"
                + TERCA + " boolean,"
                + QUARTA + " boolean,"
                + QUINTA + " boolean,"
                + SEXTA + " boolean,"
                + SABADO + " boolean,"
                + DATA + " text,"
                + HORA + " text,"
                + ENDERECO + " text"
                + ")")
        db.execSQL(sql)
    }

    override fun onUpgrade(
        db: SQLiteDatabase,
        oldVersion: Int,
        newVersion: Int
    ) {
        db.execSQL("DROP TABLE IF EXISTS $TABELA_ALARM")
        onCreate(db)
    }

    fun execute(sql:String){
        val db = this.readableDatabase
        db.execSQL(sql)
    }

    fun select(sql:String):ArrayList<Alarm>{
        val db = this.readableDatabase
        val taskDb = TaskDB(context)
        val c: Cursor = db.rawQuery(sql, null)
        val alarmes = ArrayList<Alarm>()
        if (c.moveToFirst()) {
            do { // Passing values
                alarmes.add(Alarm(
                    c.getLong(0),
                    c.getString(1),
                    c.getString(2),
                    c.getInt(3) != 0,
                    getDias(c),
                    c.getString(11),
                    c.getString(12),
                    c.getString(13),
                    taskDb.getTasks(c.getLong(0)),
                    context
                ))
            } while (c.moveToNext())
        }
        return alarmes
        c.close()
        db.close()
    }

    private fun getDias(cursor:Cursor):ArrayList<String>{
        val diasNome = arrayListOf("domingo","segunda","terca","quarta","quinta","sexta","sabado")
        val dias = ArrayList<String>()
        for(i in 4..10){
            if(cursor.getInt(i) != 0){
                dias.add(diasNome[i-4])
            }
        }
        return dias
    }

    companion object {
        private const val NOME_BANCO = "banco.db"
        private const val TABELA_ALARM = "alarm"
        private const val ID = "_id"
        private const val TITULO = "titulo"
        private const val DESCRICAO = "descricao"
        private const val SILENCIO = "silencio"
        private const val DOMINGO = "domingo"
        private const val SEGUNDA = "segunda"
        private const val TERCA = "terca"
        private const val QUARTA = "quarta"
        private const val QUINTA = "quinta"
        private const val SEXTA = "sexta"
        private const val SABADO = "sabado"
        private const val DATA = "data"
        private const val HORA = "hora"
        private const val ENDERECO = "endereco"
        private const val VERSAO = 1
    }
}